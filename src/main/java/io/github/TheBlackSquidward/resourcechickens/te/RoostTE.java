package io.github.TheBlackSquidward.resourcechickens.te;

import io.github.TheBlackSquidward.resourcechickens.AbstractTileEntity;
import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.api.utils.Constants;
import io.github.TheBlackSquidward.resourcechickens.init.ItemInit;
import io.github.TheBlackSquidward.resourcechickens.init.RecipeInit;
import io.github.TheBlackSquidward.resourcechickens.items.ChickenItem;
import io.github.TheBlackSquidward.resourcechickens.init.TileEntityInit;
import io.github.TheBlackSquidward.resourcechickens.network.GUISyncMessage;
import io.github.TheBlackSquidward.resourcechickens.network.ResourceChickensPacketHandler;
import io.github.TheBlackSquidward.resourcechickens.recipes.recipe.RoostRecipe;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class RoostTE extends AbstractTileEntity<RoostRecipe> {

    private double roostTime = 0;
    private boolean isRoosting;

    public RoostTE() {
        super(TileEntityInit.ROOST_TE.get());
    }

    @Override
    public void tick() {
        if (!getWorld().isClientSide()) {
            if (getRecipe() != null) {
                RoostRecipe recipe = getRecipe();
                if (isRoosting) {
                    if (roostTime > 0) {
                        roostTime--;
                    } else {
                        ResourceChickens.LOGGER.debug("outputting");
                        //Output neccessary things
                        recipe.getOutputs().dissolve().forEach(this::addResult);
                        reset();
                    }
                } else {
                    this.isRoosting = true;
                    this.roostTime = (double) recipe.getTotalRoostTime();
                }
            } else {
                if (isRoosting) {
                    reset();
                }
            }
            setChanged();
            updateProgress();
        }
    }

    public void reset() {
        this.roostTime = 0;
        this.isRoosting = false;
    }

    public RoostRecipe getRecipe() {
        ItemStack input = itemStackHandler.getStackInSlot(0);
        if (this.level == null || input.isEmpty()) {
            return null;
        }
        return level.getRecipeManager().getRecipeFor(RecipeInit.ROOST_RECIPE_TYPE,
                new Inventory(itemStackHandler.getStackInSlot(0)), this.level).orElse(null);
    }

    private void updateProgress() {
        if(isRoosting) {
            double calculatedProgress = (getTotalRoostTime() - this.roostTime) / getTotalRoostTime();
            if (calculatedProgress == 1) {
                calculatedProgress = 0;
            }
            this.progress = calculatedProgress;
        }else{
            this.progress = 0;
        }
    }

    public void addResult(ItemStack result) {
        //TODO rewrite
    }

    private int getGain() {
        CompoundNBT nbt = itemStackHandler.getStackInSlot(0).getOrCreateTag();
        int gain = nbt.getInt(ResourceChickens.MODID + "_chicken_gain");
        if (gain == 0) {
            gain = 1;
        }
        return gain;
    }

    public int getTotalRoostTime() {
        if(isRoosting) {
            return getRecipe().getTotalRoostTime();
        }else{
            return 0;
        }
    }

    @Override
    public ItemStackHandler createItemStackHandler() {
        return new ItemStackHandler(6) {

            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                if(slot == 0) {
                    if (stack.getItem() == ItemInit.VANILLA_CHICKEN.get()) {
                        return true;
                    }
                    if (stack.getItem() instanceof ChickenItem) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    protected CompoundNBT saveToNBT(CompoundNBT tag) {
        tag.put(Constants.NBT.INVENTORY, itemStackHandler.serializeNBT());
        tag.putDouble("roostTime", roostTime);
        tag.putBoolean("isRoosting", isRoosting);
        return tag;
    }
    protected void loadFromNBT(CompoundNBT tag) {
        itemStackHandler.deserializeNBT(tag.getCompound(Constants.NBT.INVENTORY));
        this.roostTime = tag.getDouble("roostTime");
        this.isRoosting = tag.getBoolean("isRoosting");
    }

    public void handleGUINetworkPacket(PacketBuffer packetBuffer) {
        this.progress = packetBuffer.readDouble();
    }
    public void sendGUINetworkPacket(PlayerEntity playerEntity) {
        if(!level.isClientSide()) {
            PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());
            packetBuffer.writeDouble(getProgress());
            ResourceChickensPacketHandler.sendToPlayer(new GUISyncMessage(getBlockPos(), packetBuffer), (ServerPlayerEntity) playerEntity);
        }
    }

    public ChickenRegistryObject getRoostingChicken() {
        return ChickenRegistry.getChickenRegistryObjectbyChickenItem(itemStackHandler.getStackInSlot(0).getItem());
    }

    public boolean hasChicken() {
        return !itemStackHandler.getStackInSlot(0).isEmpty();
    }

    public Entity getChickenEntity() {
        return getRoostingChicken().getChickenEntityRegistryObject().get().create(getWorld());
    }
}
