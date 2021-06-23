package io.github.TheBlackSquidward.resourcechickens.te;

import io.github.TheBlackSquidward.resourcechickens.AbstractTileEntity;
import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.api.utils.Constants;
import io.github.TheBlackSquidward.resourcechickens.containers.ChickenBreederContainer;
import io.github.TheBlackSquidward.resourcechickens.items.ChickenItem;
import io.github.TheBlackSquidward.resourcechickens.init.ItemInit;
import io.github.TheBlackSquidward.resourcechickens.init.TileEntityInit;
import io.github.TheBlackSquidward.resourcechickens.network.GUISyncMessage;
import io.github.TheBlackSquidward.resourcechickens.network.ResourceChickensPacketHandler;
import io.github.TheBlackSquidward.resourcechickens.recipes.recipe.ChickenBreedingRecipe;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class ChickenBreederTE extends AbstractTileEntity<ChickenBreedingRecipe> {

    //2 Min in ticks
    private final double totalBreedTime = 2400;
    private double breedTime = 0;
    private boolean isBreeding;

    public ChickenBreederTE() {
        super(TileEntityInit.CHICKEN_BREEDER_TE.get());
    }

    @Override
    public void tick() {
        if (!this.level.isClientSide) {
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

    @Override
    protected void invalidateCaps() {
        super.invalidateCaps();
        itemHandlerLazyOptional.invalidate();
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
        if (itemStackHandler.getStackInSlot(1).getItem() instanceof ChickenItem && itemStackHandler.getStackInSlot(1).getItem() != ItemInit.VANILLA_CHICKEN.get()) {
            return itemStackHandler.getStackInSlot(2).getItem() instanceof ChickenItem && itemStackHandler.getStackInSlot(2).getItem() != ItemInit.VANILLA_CHICKEN.get();
        } else {
            return false;
        }
    }

    private boolean hasSeeds() {
        return itemStackHandler.getStackInSlot(0).getCount() >= 2;
    }

    public void addResult(ItemStack result) {
        ItemStack item3 = itemStackHandler.getStackInSlot(3);
        ItemStack item4 = itemStackHandler.getStackInSlot(4);
        ItemStack item5 = itemStackHandler.getStackInSlot(5);
        if (item3.isEmpty()) {
            itemStackHandler.setStackInSlot(3, result);
            itemStackHandler.getStackInSlot(0).shrink(2);
        } else if (item3.getOrCreateTag().equals(result.getOrCreateTag()) && item3.getCount() < 16) {
            int amount = item3.getCount() + 1;
            result.setCount(amount);
            itemStackHandler.setStackInSlot(3, result);
            itemStackHandler.getStackInSlot(0).shrink(2);
        } else if (item4.isEmpty()) {
            itemStackHandler.setStackInSlot(4, result);
            itemStackHandler.getStackInSlot(0).shrink(2);
        } else if (item4.getOrCreateTag().equals(result.getOrCreateTag()) && item4.getCount() < 16) {
            int amount = item4.getCount() + 1;
            result.setCount(amount);
            itemStackHandler.setStackInSlot(4, result);
            itemStackHandler.getStackInSlot(0).shrink(2);
        } else if (item5.isEmpty()) {
            itemStackHandler.setStackInSlot(5, result);
            itemStackHandler.getStackInSlot(0).shrink(2);
        } else if (item5.getOrCreateTag().equals(result.getOrCreateTag()) && item5.getCount() < 16) {
            int amount = item5.getCount() + 1;
            result.setCount(amount);
            itemStackHandler.setStackInSlot(5, result);
            itemStackHandler.getStackInSlot(0).shrink(2);
        }
    }

    private ItemStack mixChickens(ItemStack parent1Item, ItemStack parent2Item, ChickenRegistryObject parent1, ChickenRegistryObject parent2, ChickenRegistryObject newChicken) {
        ItemStack result = new ItemStack(newChicken.getChickenItemRegistryObject().get());
        CompoundNBT nbt = result.getOrCreateTag();

        nbt.putInt(ResourceChickens.MODID + "_chicken_gain", 1);
        nbt.putInt(ResourceChickens.MODID + "_chicken_growth", 1);
        nbt.putInt(ResourceChickens.MODID + "_chicken_strength", 1);
        result.save(nbt);
        result.setTag(nbt);
        return result;
    }

    private ItemStack crossBreed(ItemStack parent1Item, ItemStack parent2Item, ChickenRegistryObject parent1, ChickenRegistryObject parent2) {
        ItemStack result = new ItemStack(parent1.getChickenItemRegistryObject().get());
        CompoundNBT nbt = result.getOrCreateTag();

        int parent1Gain = parent1Item.getOrCreateTag().getInt(ResourceChickens.MODID + "_chicken_gain");
        int parent1Growth = parent1Item.getOrCreateTag().getInt(ResourceChickens.MODID + "_chicken_growth");
        int parent1Strength = parent1Item.getOrCreateTag().getInt(ResourceChickens.MODID + "_chicken_strength");

        int parent2Gain = parent2Item.getOrCreateTag().getInt(ResourceChickens.MODID + "_chicken_gain");
        int parent2Growth = parent2Item.getOrCreateTag().getInt(ResourceChickens.MODID + "_chicken_growth");
        int parent2Strength = parent2Item.getOrCreateTag().getInt(ResourceChickens.MODID + "_chicken_strength");


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

        nbt.putInt(ResourceChickens.MODID + "_chicken_gain", newGain);
        nbt.putInt(ResourceChickens.MODID + "_chicken_growth", newGrowth);
        nbt.putInt(ResourceChickens.MODID + "_chicken_strength", newStrength);
        result.save(nbt);
        result.setTag(nbt);
        return result;
    }

    private int calculateNewStat(int parent1Strength, int parent2Strength, int parent1Stat, int parent2Stat, Random rand) {
        int mutation = rand.nextInt(2) + 1;
        int newStatValue = (parent1Stat * parent1Strength + parent2Stat * parent2Strength) / (parent1Strength + parent2Strength) + mutation;
        if (newStatValue <= 1)
            return 1;
        if (newStatValue >= 10)
            return 10;
        return newStatValue;
    }

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
                        return stack.getItem() != ItemInit.VANILLA_CHICKEN.get();
                    }
                }
                return false;
            }
        };
    }

    private int getOverallGrowth(ItemStack parent1Item, ItemStack parent2Item) {
        if (hasChickens()) {
            int parent1Growth = parent1Item.getOrCreateTag().getInt(ResourceChickens.MODID + "_chicken_growth");
            int parent2Growth = parent2Item.getOrCreateTag().getInt(ResourceChickens.MODID + "_chicken_growth");
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

    @Override
    public ChickenBreedingRecipe getRecipe() {
        //TODO
        return null;
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


