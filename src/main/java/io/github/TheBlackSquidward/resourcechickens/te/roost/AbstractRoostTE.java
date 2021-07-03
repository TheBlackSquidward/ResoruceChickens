package io.github.TheBlackSquidward.resourcechickens.te.roost;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.utils.Constants;
import io.github.TheBlackSquidward.resourcechickens.api2.CustomChickenData;
import io.github.TheBlackSquidward.resourcechickens.init.ModItems;
import io.github.TheBlackSquidward.resourcechickens.init.ModRecipes;
import io.github.TheBlackSquidward.resourcechickens.items.ChickenItem;
import io.github.TheBlackSquidward.resourcechickens.items.ResourceChickenItem;
import io.github.TheBlackSquidward.resourcechickens.network.GUISyncMessage;
import io.github.TheBlackSquidward.resourcechickens.network.ResourceChickensPacketHandler;
import io.github.TheBlackSquidward.resourcechickens.recipes.recipe.RoostRecipe;
import io.github.TheBlackSquidward.resourcechickens.te.AbstractTileEntity;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public abstract class AbstractRoostTE  extends AbstractTileEntity<RoostRecipe> {

    private double roostTime = 0;
    private boolean isRoosting;

    public AbstractRoostTE(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
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
                    this.roostTime = recipe.getTotalRoostTime();
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
        return level.getRecipeManager().getRecipeFor(ModRecipes.ROOST_RECIPE_TYPE,
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
        int gain = nbt.getInt(Constants.NBT.GAIN);
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
                    if (stack.getItem() == ModItems.vanillaChickenItem.get()) {
                        return true;
                    }
                    return stack.getItem() instanceof ChickenItem;
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

    public CustomChickenData getRoostingChickenData() {
        ItemStack roostingChicken = itemStackHandler.getStackInSlot(0);
        Item item = roostingChicken.getItem();
        if(item instanceof ResourceChickenItem) {
            return ((ResourceChickenItem) item).getChickenData();
        }
        return null;
    }

    public boolean hasChicken() {
        return !itemStackHandler.getStackInSlot(0).isEmpty();
    }
}
