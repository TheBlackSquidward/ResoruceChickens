package io.github.TheBlackSquidward.resourcefulchickens.common.te;

import io.github.TheBlackSquidward.resourcefulchickens.ResourcefulChickens;
import io.github.TheBlackSquidward.resourcefulchickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcefulchickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcefulchickens.common.items.ChickenItem;
import io.github.TheBlackSquidward.resourcefulchickens.registries.TileEntityRegistry;
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

public class ChickenBreederTE extends TileEntity implements ITickableTileEntity {

    /*
    - Slots start at 0!
    - Slot 1 = Seeds
    - Slot 2 = Chicken (Parent 1)
    - Slot 3 = Chicken (Parent 2)
    - Slot 4 = Output Chicken
    - Slot 5 = Output Chicken
    - Slot 6 = Output Chicken

    Base time should be a minute for it to breed. Sped up by nbt data.
     */

    private ItemStackHandler itemStackHandler = createHandler();

    private LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemStackHandler);

    public ChickenBreederTE() {
        super(TileEntityRegistry.CHICKEN_BREEDER_TE.get());
    }

    @Override
    public void tick() {
        if(itemStackHandler.getStackInSlot(0).getCount() >= 2) {
            if(itemStackHandler.getStackInSlot(1).getItem() instanceof ChickenItem) {
                ItemStack itemSlot1 = itemStackHandler.getStackInSlot(1);
                ChickenRegistryObject parent1 = ChickenRegistry.getChickenRegistryObjectbyChickenItem(itemSlot1.getItem());
                if(itemStackHandler.getStackInSlot(2).getItem() instanceof ChickenItem) {
                    ItemStack itemSlot2 = itemStackHandler.getStackInSlot(2);
                    ChickenRegistryObject parent2 = ChickenRegistry.getChickenRegistryObjectbyChickenItem(itemSlot2.getItem());
                    if(itemSlot1.getItem() == itemSlot2.getItem()) {
                        ResourcefulChickens.LOGGER.debug("Contains 2 Chicken Items of the same type and 2 seeds");
                        //TODO cross breed
                    }
                    if(ChickenRegistry.canBeBred(parent1, parent2)) {
                        ResourcefulChickens.LOGGER.debug("Contains 2 Chicken Items that can be bred and 2 seeds");
                        //TODO breed
                    }
                }
            }
        }
    }

    @Override
    public void remove() {
        super.remove();
        handler.invalidate();
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
                    return stack.getItem() instanceof ChickenItem;
                }
                return false;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                ResourcefulChickens.LOGGER.debug("inserting item to slot " + slot);
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        itemStackHandler.deserializeNBT(nbt.getCompound("inv"));
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT nbt) {
        nbt.put("inv", itemStackHandler.serializeNBT());
        return super.write(nbt);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }
}
