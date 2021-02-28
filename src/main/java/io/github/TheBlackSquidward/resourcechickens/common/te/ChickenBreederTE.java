package io.github.TheBlackSquidward.resourcechickens.common.te;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.common.items.ChickenItem;
import io.github.TheBlackSquidward.resourcechickens.init.ItemInit;
import io.github.TheBlackSquidward.resourcechickens.init.TileEntityInit;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.text.DecimalFormat;
import java.util.Random;

public class ChickenBreederTE extends TileEntity implements ITickableTileEntity {

    private static final DecimalFormat FORMATTER = new DecimalFormat("0.0%");

    private final ItemStackHandler itemStackHandler = createHandler();

    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemStackHandler);

    //1 Min in ticks
    private final int totalBreedTime = 1200;
    private int progress = 0;
    private int breedTime;
    private boolean isBreeding;

    public ChickenBreederTE() {
        super(TileEntityInit.CHICKEN_BREEDER_TE.get());
    }

    @Override
    public void tick() {
        if (!this.world.isRemote) {
            ResourceChickens.LOGGER.debug(progress);
            if(isBreeding) {
                if(!(hasChickens() && hasSeeds())) {
                    this.breedTime = 0;
                    this.isBreeding = false;
                    this.progress = 0;
                }
                if(breedTime > 0) {
                    breedTime--;
                    updateProgress();
                }else{
                    spawnChickenIfNeeded();
                    this.breedTime = 0;
                    this.isBreeding = false;
                    this.progress = 0;
                }
            }
            if(!isBreeding) {
                if(hasChickens() && hasSeeds()) {
                    this.isBreeding = true;
                    this.breedTime = totalBreedTime;
                }
            }
        }
    }

    @Override
    public void remove() {
        super.remove();
        handler.invalidate();
    }

    private void updateProgress() {
        this.progress = this.breedTime / this.totalBreedTime;
    }


    public String getFormattedProgress() {
        return formatProgress(this.progress);
    }

    public String formatProgress(double progress) {
        return FORMATTER.format(progress);
    }


    private void spawnChickenIfNeeded() {
        if(hasSeeds()) {
            if(hasChickens()) {
                ItemStack itemSlot1 = itemStackHandler.getStackInSlot(1);
                ChickenRegistryObject parent1 = ChickenRegistry.getChickenRegistryObjectbyChickenItem(itemSlot1.getItem());
                ItemStack itemSlot2 = itemStackHandler.getStackInSlot(2);
                ChickenRegistryObject parent2 = ChickenRegistry.getChickenRegistryObjectbyChickenItem(itemSlot2.getItem());
                if (sameChicken(itemSlot1, itemSlot2)) {
                    ItemStack result = crossBreed(itemSlot1, itemSlot2, parent1, parent2);
                    addResult(result);
                }
                if (ChickenRegistry.canBeBred(parent1, parent2)) {
                    ChickenRegistryObject newChicken = ChickenRegistry.getChild(parent1, parent2);
                    //TODO add a chance
                    //TODO add just inherited stats
                    ItemStack result = mixChickens(itemSlot1, itemSlot2, parent1, parent2, newChicken);
                    addResult(result);
                }
            }
        }
    }

    private boolean sameChicken(ItemStack chicken1, ItemStack chicken2){
        return chicken1.getItem() == chicken2.getItem();
    }

    private boolean hasChickens() {
        if(itemStackHandler.getStackInSlot(1).getItem() instanceof ChickenItem && itemStackHandler.getStackInSlot(1).getItem() != ItemInit.VANILLA_CHICKEN.get()) {
            return itemStackHandler.getStackInSlot(2).getItem() instanceof ChickenItem && itemStackHandler.getStackInSlot(2).getItem() != ItemInit.VANILLA_CHICKEN.get();
        }else{
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
        if(item3.isEmpty()) {
            itemStackHandler.setStackInSlot(3, result);
            itemStackHandler.getStackInSlot(0).shrink(2);
        }else if(item3.getOrCreateTag().equals(result.getOrCreateTag()) && item3.getCount() < 16){
            int amount = item3.getCount() + 1;
            result.setCount(amount);
            itemStackHandler.setStackInSlot(3, result);
            itemStackHandler.getStackInSlot(0).shrink(2);
        }else if(item4.isEmpty()) {
            itemStackHandler.setStackInSlot(4, result);
            itemStackHandler.getStackInSlot(0).shrink(2);
        }else if(item4.getOrCreateTag().equals(result.getOrCreateTag()) && item4.getCount() < 16) {
            int amount = item4.getCount() + 1;
            result.setCount(amount);
            itemStackHandler.setStackInSlot(4, result);
            itemStackHandler.getStackInSlot(0).shrink(2);
        }else if(item5.isEmpty()) {
            itemStackHandler.setStackInSlot(5, result);
            itemStackHandler.getStackInSlot(0).shrink(2);
        }else if(item5.getOrCreateTag().equals(result.getOrCreateTag()) && item5.getCount() < 16) {
            int amount = item5.getCount() + 1;
            result.setCount(amount);
            itemStackHandler.setStackInSlot(5, result);
            itemStackHandler.getStackInSlot(0).shrink(2);
        }
    }

    private ItemStack mixChickens(ItemStack parent1Item, ItemStack parent2Item, ChickenRegistryObject parent1, ChickenRegistryObject parent2, ChickenRegistryObject newChicken) {
        ItemStack result = new ItemStack(newChicken.getChickenItemRegistryObject().get());
        CompoundNBT nbt = result.getOrCreateTag();

        int parent1Gain = parent1Item.getOrCreateTag().getInt(ResourceChickens.MODID + "_chicken_gain");
        int parent1Growth = parent1Item.getOrCreateTag().getInt(ResourceChickens.MODID + "_chicken_growth");
        int parent1Strength = parent1Item.getOrCreateTag().getInt(ResourceChickens.MODID + "_chicken_strength");

        int parent2Gain = parent2Item.getOrCreateTag().getInt(ResourceChickens.MODID + "_chicken_gain");
        int parent2Growth = parent2Item.getOrCreateTag().getInt(ResourceChickens.MODID + "_chicken_growth");
        int parent2Strength = parent2Item.getOrCreateTag().getInt(ResourceChickens.MODID + "_chicken_strength");


        if(parent1Gain == 0) {
            parent1Gain = 1;
        }
        if(parent1Growth == 0) {
            parent1Growth = 1;
        }
        if(parent1Strength == 0) {
            parent1Strength = 1;
        }
        if(parent2Gain == 0) {
            parent2Gain = 1;
        }
        if(parent2Growth == 0) {
            parent2Growth = 1;
        }
        if(parent2Strength == 0) {
            parent2Strength = 1;
        }

        int newGain = calculateNewStat(parent1Strength, parent2Strength, parent1Gain, parent2Gain, world.rand);
        int newGrowth = calculateNewStat(parent1Strength, parent2Strength, parent1Growth, parent2Growth, world.rand);
        int newStrength = calculateNewStat(parent1Strength, parent2Strength, parent1Strength, parent2Strength, world.rand);

        nbt.putInt(ResourceChickens.MODID + "_chicken_gain", newGain);
        nbt.putInt(ResourceChickens.MODID + "_chicken_growth", newGrowth);
        nbt.putInt(ResourceChickens.MODID + "_chicken_strength", newStrength);
        result.write(nbt);
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


        if(parent1Gain == 0) {
            parent1Gain = 1;
        }
        if(parent1Growth == 0) {
            parent1Growth = 1;
        }
        if(parent1Strength == 0) {
            parent1Strength = 1;
        }
        if(parent2Gain == 0) {
            parent2Gain = 1;
        }
        if(parent2Growth == 0) {
            parent2Growth = 1;
        }
        if(parent2Strength == 0) {
            parent2Strength = 1;
        }

        int newGain = calculateNewStat(parent1Strength, parent2Strength, parent1Gain, parent2Gain, world.rand);
        int newGrowth = calculateNewStat(parent1Strength, parent2Strength, parent1Growth, parent2Growth, world.rand);
        int newStrength = calculateNewStat(parent1Strength, parent2Strength, parent1Strength, parent2Strength, world.rand);

        nbt.putInt(ResourceChickens.MODID + "_chicken_gain", newGain);
        nbt.putInt(ResourceChickens.MODID + "_chicken_growth", newGrowth);
        nbt.putInt(ResourceChickens.MODID + "_chicken_strength", newStrength);
        result.write(nbt);
        result.setTag(nbt);
        return result;
    }

    private static int calculateNewStat(int parent1Strength, int parent2Strength, int parent1Stat, int parent2Stat, Random rand) {
        int mutation = rand.nextInt(2) + 1;
        int newStatValue = (parent1Stat * parent1Strength + parent2Stat * parent2Strength) / (parent1Strength + parent2Strength) + mutation;
        if (newStatValue <= 1)
            return 1;
        if (newStatValue >= 10)
            return 10;
        return newStatValue;
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(6) {

            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                if(slot == 0) {
                    return stack.getItem() == Items.WHEAT_SEEDS;
                }
                if(slot == 1 || slot == 2) {
                    if(stack.getItem() instanceof ChickenItem) {
                        if(stack.getItem() == ItemInit.VANILLA_CHICKEN.get()) {
                            return false;
                        }else{
                            return true;
                        }
                    }
                }
                return false;
            }
        };
    }

    //TODO nbt

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }
}
