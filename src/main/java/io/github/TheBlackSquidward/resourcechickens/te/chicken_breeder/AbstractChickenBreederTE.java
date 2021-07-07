package io.github.TheBlackSquidward.resourcechickens.te.chicken_breeder;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.init.ModItems;
import io.github.TheBlackSquidward.resourcechickens.items.ChickenItem;
import io.github.TheBlackSquidward.resourcechickens.network.GUISyncMessage;
import io.github.TheBlackSquidward.resourcechickens.network.ResourceChickensPacketHandler;
import io.github.TheBlackSquidward.resourcechickens.te.AbstractTileEntity;
import io.github.TheBlackSquidward.resourcechickens.utils.Constants;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public abstract class AbstractChickenBreederTE extends AbstractTileEntity {

    //2 Min in ticks
    private final double totalBreedTime = 2400;
    private double breedTime = 0;
    private boolean isBreeding;

    public AbstractChickenBreederTE(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
    }

    @Override
    public void tick() {
        if (!this.level.isClientSide) {
            if (canBreed()) {
                if (isBreeding) {
                    if (!(hasChickens() && hasSeeds())) {
                        this.breedTime = 0;
                        this.isBreeding = false;
                        this.progress = 0;
                    }
                    if (breedTime > 0) {
                        breedTime--;
                    } else {
                        spawnChickenIfNeeded();
                        this.breedTime = 0;
                        this.isBreeding = false;
                        this.progress = 0;
                    }
                }
                if (!isBreeding) {
                    if (hasChickens() && hasSeeds()) {
                        this.isBreeding = true;
                        this.breedTime = totalBreedTime;
                    }
                }
                updateProgress();
                setChanged();
            }
        }
    }

    @Override
    protected void invalidateCaps() {
        super.invalidateCaps();
        itemHandlerLazyOptional.invalidate();
    }

    private boolean canBreed() {
        return false;
    }

    private void updateProgress() {
        double calculatedProgress = (this.totalBreedTime - this.breedTime) / this.totalBreedTime;
        if (calculatedProgress == 1) {
            calculatedProgress = 0;
        }
        this.progress = calculatedProgress;
    }

    public double getTotalBreedTime() {
        return totalBreedTime;
    }

    public double getBreedTime() {
        return breedTime;
    }

    public double getProgress() {
        return progress;
    }


    private void spawnChickenIfNeeded() {
        //TODO
    }

    private boolean sameChicken(ItemStack chicken1, ItemStack chicken2) {
        return chicken1.getItem() == chicken2.getItem();
    }

    private boolean hasChickens() {
        if (itemStackHandler.getStackInSlot(1).getItem() instanceof ChickenItem && itemStackHandler.getStackInSlot(1).getItem() != ModItems.vanillaChickenItem.get()) {
            return itemStackHandler.getStackInSlot(2).getItem() instanceof ChickenItem && itemStackHandler.getStackInSlot(2).getItem() != ModItems.vanillaChickenItem.get();
        } else {
            return false;
        }
    }

    private boolean hasSeeds() {
        return itemStackHandler.getStackInSlot(0).getCount() >= 2;
    }

    //TODO borcken
    /*
    private ItemStack mixChickens(ItemStack parent1Item, ItemStack parent2Item, ChickenRegistryObject parent1, ChickenRegistryObject parent2, ChickenRegistryObject newChicken) {
        ItemStack result = new ItemStack(newChicken.getChickenItemRegistryObject().get());
        CompoundNBT nbt = result.getOrCreateTag();

        nbt.putInt(ResourceChickens.MOD_ID + "_chicken_gain", 1);
        nbt.putInt(ResourceChickens.MOD_ID + "_chicken_growth", 1);
        nbt.putInt(ResourceChickens.MOD_ID + "_chicken_strength", 1);
        result.save(nbt);
        result.setTag(nbt);
        return result;
    }

    private ItemStack crossBreed(ItemStack parent1Item, ItemStack parent2Item, ChickenRegistryObject parent1, ChickenRegistryObject parent2) {
        ItemStack result = new ItemStack(parent1.getChickenItemRegistryObject().get());
        CompoundNBT nbt = result.getOrCreateTag();

        int parent1Gain = parent1Item.getOrCreateTag().getInt(ResourceChickens.MOD_ID + "_chicken_gain");
        int parent1Growth = parent1Item.getOrCreateTag().getInt(ResourceChickens.MOD_ID + "_chicken_growth");
        int parent1Strength = parent1Item.getOrCreateTag().getInt(ResourceChickens.MOD_ID + "_chicken_strength");

        int parent2Gain = parent2Item.getOrCreateTag().getInt(ResourceChickens.MOD_ID + "_chicken_gain");
        int parent2Growth = parent2Item.getOrCreateTag().getInt(ResourceChickens.MOD_ID + "_chicken_growth");
        int parent2Strength = parent2Item.getOrCreateTag().getInt(ResourceChickens.MOD_ID + "_chicken_strength");


        if (parent1Gain == 0) {
            parent1Gain = 1;
        }
        if (parent1Growth == 0) {
            parent1Growth = 1;
        }
        if (parent1Strength == 0) {
            parent1Strength = 1;
        }
        if (parent2Gain == 0) {
            parent2Gain = 1;
        }
        if (parent2Growth == 0) {
            parent2Growth = 1;
        }
        if (parent2Strength == 0) {
            parent2Strength = 1;
        }

        int newGain = calculateNewStat(parent1Strength, parent2Strength, parent1Gain, parent2Gain, level.random);
        int newGrowth = calculateNewStat(parent1Strength, parent2Strength, parent1Growth, parent2Growth, level.random);
        int newStrength = calculateNewStat(parent1Strength, parent2Strength, parent1Strength, parent2Strength, level.random);

        nbt.putInt(ResourceChickens.MOD_ID + "_chicken_gain", newGain);
        nbt.putInt(ResourceChickens.MOD_ID + "_chicken_growth", newGrowth);
        nbt.putInt(ResourceChickens.MOD_ID + "_chicken_strength", newStrength);
        result.save(nbt);
        result.setTag(nbt);
        return result;
    }

    private int calculateNewStat(int parent1Strength, int parent2Strength, int parent1Stat, int parent2Stat, Random rand) {
        int mutation = rand.nextInt(2) + 1;
        int newStatValue = (parent1Stat * parent1Strength + parent2Stat * parent2Strength) / (parent1Strength + parent2Strength) + mutation;
        if (newStatValue <= 1)
            return 1;
        return Math.min(newStatValue, 10);
    }
     */

    public ItemStackHandler createItemStackHandler() {
        return new ItemStackHandler(6) {

            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                if (slot == 0) {
                    return stack.getItem() == Items.WHEAT_SEEDS;
                }
                if (slot == 1 || slot == 2) {
                    if (stack.getItem() instanceof ChickenItem) {
                        return stack.getItem() != ModItems.vanillaChickenItem.get();
                    }
                }
                return false;
            }
        };
    }

    private int getOverallGrowth(ItemStack parent1Item, ItemStack parent2Item) {
        if (hasChickens()) {
            int parent1Growth = parent1Item.getOrCreateTag().getInt(ResourceChickens.MOD_ID + "_chicken_growth");
            int parent2Growth = parent2Item.getOrCreateTag().getInt(ResourceChickens.MOD_ID + "_chicken_growth");
            if (parent1Growth == 0) {
                parent1Growth = 1;
            }
            if (parent2Growth == 0) {
                parent2Growth = 1;
            }
            int overallGrowth = (parent1Growth + parent2Growth) / 2;
            return overallGrowth;
        } else {
            return 0;
        }
    }

    protected CompoundNBT saveToNBT(CompoundNBT tag) {
        tag.put(Constants.NBT.INVENTORY, itemStackHandler.serializeNBT());
        tag.putDouble("breedTime", breedTime);
        tag.putBoolean("isBreeding", isBreeding);
        return tag;
    }

    protected void loadFromNBT(CompoundNBT tag) {
        itemStackHandler.deserializeNBT(tag.getCompound(Constants.NBT.INVENTORY));
        breedTime = tag.getDouble("breedTime");
        isBreeding = tag.getBoolean("isBreeding");
    }

    public void handleGUINetworkPacket(PacketBuffer packetBuffer) {
        this.progress = packetBuffer.readDouble();
    }

    public void sendGUINetworkPacket(PlayerEntity playerEntity) {
        PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());
        packetBuffer.writeDouble(getProgress());
        ResourceChickensPacketHandler.sendToPlayer(new GUISyncMessage(getBlockPos(), packetBuffer), (ServerPlayerEntity) playerEntity);
    }

    public ItemStack getChicken1() {
        return itemStackHandler.getStackInSlot(1);
    }

    public ItemStack getChicken2() {
        return itemStackHandler.getStackInSlot(2);
    }

}


