package io.github.TheBlackSquidward.resourcechickens.te;

import io.github.TheBlackSquidward.resourcechickens.AbstractTileEntity;
import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenDrop;
import io.github.TheBlackSquidward.resourcechickens.api.utils.Constants;
import io.github.TheBlackSquidward.resourcechickens.init.RecipeInit;
import io.github.TheBlackSquidward.resourcechickens.items.ChickenItem;
import io.github.TheBlackSquidward.resourcechickens.init.TileEntityInit;
import io.github.TheBlackSquidward.resourcechickens.network.GUISyncMessage;
import io.github.TheBlackSquidward.resourcechickens.network.ResourceChickensPacketHandler;
import io.github.TheBlackSquidward.resourcechickens.recipes.recipe.RoostRecipe;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
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

    //TODO add timer
    @Override
    public void tick() {
        if (!this.level.isClientSide()) {
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
        this.progress = 0;
    }

    public RoostRecipe getRecipe() {
        ItemStack input = itemStackHandler.getStackInSlot(0);
        if (this.level == null || input.isEmpty()) {
            return null;
        }
        return level.getRecipeManager().getRecipeFor(RecipeInit.ROOST_RECIPE_TYPE, this, this.level).orElse(null);
    }

    private void updateProgress() {
        double calculatedProgress = (getTotalRoostTime() - this.roostTime) / getTotalRoostTime();
        if (calculatedProgress == 1) {
            calculatedProgress = 0;
        }
        this.progress = calculatedProgress;
    }

    public void addResult(ItemStack result) {
        //TODO rewrite
        ItemStack item1 = itemStackHandler.getStackInSlot(1);
        ItemStack item2 = itemStackHandler.getStackInSlot(2);
        ItemStack item3 = itemStackHandler.getStackInSlot(3);
        ItemStack item4 = itemStackHandler.getStackInSlot(4);
        if (item1.isEmpty()) {
            itemStackHandler.setStackInSlot(1, result);
        } else if (item1.sameItemStackIgnoreDurability(result) && item1.getCount() < 64) {
            int amount = item1.getCount() + 1;
            result.setCount(amount);
            itemStackHandler.setStackInSlot(1, result);
        } else if (item2.isEmpty()) {
            itemStackHandler.setStackInSlot(2, result);
        } else if (item2.sameItemStackIgnoreDurability(result) && item2.getCount() < 64) {
            int amount = item2.getCount() + 1;
            result.setCount(amount);
            itemStackHandler.setStackInSlot(2, result);
        } else if (item3.isEmpty()) {
            itemStackHandler.setStackInSlot(3, result);
        } else if (item3.sameItemStackIgnoreDurability(result) && item3.getCount() < 64) {
            int amount = item3.getCount() + 1;
            result.setCount(amount);
            itemStackHandler.setStackInSlot(3, result);
        } else if (item4.isEmpty()) {
            itemStackHandler.setStackInSlot(4, result);
        } else if (item4.sameItemStackIgnoreDurability(result) && item4.getCount() < 64) {
            int amount = item4.getCount() + 1;
            result.setCount(amount);
            itemStackHandler.setStackInSlot(4, result);
        }
    }

    private int getDropAmount(ChickenDrop chickenDrop, int gain) {
        int preDropAmount = (gain >= 10) ? 3 : ((gain >= 5) ? 2 : 1);
        if (preDropAmount > chickenDrop.getMaxAmount()) {
            chickenDrop.getMaxAmount();
        } else {
            return preDropAmount;
        }
        return (gain >= 10) ? 3 : ((gain >= 5) ? 2 : 1);
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
                if (slot == 0) {
                    return stack.getItem() instanceof ChickenItem;
                }
                return false;
            }
        };
    }

    @Override
    public int getContainerSize() {
        return 6;
    }

    @Override
    public ItemStack getItem(int itemSlot) {
        return itemStackHandler.getStackInSlot(itemSlot);
    }

    @Override
    public ItemStack removeItem(int p_70298_1_, int p_70298_2_) {
        return null;
    }

    @Override
    public ItemStack removeItemNoUpdate(int p_70304_1_) {
        return null;
    }

    @Override
    public void setItem(int itemSlot, ItemStack itemStack) {
        itemStackHandler.setStackInSlot(itemSlot, itemStack);
    }

    @Override
    public boolean stillValid(PlayerEntity p_70300_1_) {
        return true;
    }

    @Override
    public void clearContent() {

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
        PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());
        packetBuffer.writeDouble(getProgress());
        ResourceChickensPacketHandler.sendToPlayer(new GUISyncMessage(getBlockPos(), packetBuffer), (ServerPlayerEntity) playerEntity);
    }
}
