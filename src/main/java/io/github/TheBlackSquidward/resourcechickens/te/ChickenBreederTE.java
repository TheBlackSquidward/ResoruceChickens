package io.github.TheBlackSquidward.resourcechickens.te;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.api.utils.NBTConstants;
import io.github.TheBlackSquidward.resourcechickens.items.ChickenItem;
import io.github.TheBlackSquidward.resourcechickens.init.ItemInit;
import io.github.TheBlackSquidward.resourcechickens.init.TileEntityInit;
import io.github.TheBlackSquidward.resourcechickens.network.GUISyncMessage;
import io.github.TheBlackSquidward.resourcechickens.network.ResourceChickensPacketHandler;
import io.netty.buffer.Unpooled;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
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
import java.util.Random;

public class ChickenBreederTE extends TileEntity implements ITickableTileEntity {

    private final ItemStackHandler itemStackHandler = createHandler();

    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemStackHandler);

    //2 Min in ticks
    private final double totalBreedTime = 2400;
    private double progress = 0;
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
        handler.invalidate();
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
        if (hasSeeds()) {
            if (hasChickens()) {
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

    private ItemStackHandler createHandler() {
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

    @Override
    public CompoundNBT save(CompoundNBT tag) {
        super.save(tag);
        return saveToNBT(tag);
    }

    protected CompoundNBT saveToNBT(CompoundNBT tag) {
        tag.put(NBTConstants.NBT_INVENTORY, itemStackHandler.serializeNBT());
        tag.putDouble("breedTime", breedTime);
        tag.putBoolean("isBreeding", isBreeding);
        return tag;
    }

    protected void loadFromNBT(CompoundNBT tag) {
        itemStackHandler.deserializeNBT(tag.getCompound(NBTConstants.NBT_INVENTORY));
        breedTime = tag.getDouble("breedTime");
        isBreeding = tag.getBoolean("isBreeding");
    }

    @Override
    public void load(BlockState state, CompoundNBT tag) {
        this.loadFromNBT(tag);
        super.load(state, tag);
    }

    @Nonnull
    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT nbtTagCompound = new CompoundNBT();
        save(nbtTagCompound);
        return nbtTagCompound;
    }

    @Override
    public void handleUpdateTag(@Nonnull BlockState state, CompoundNBT tag) {
        this.load(state, tag);
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(getBlockPos(), 0, saveToNBT(new CompoundNBT()));
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        CompoundNBT nbt = pkt.getTag();
        loadFromNBT(nbt);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
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


