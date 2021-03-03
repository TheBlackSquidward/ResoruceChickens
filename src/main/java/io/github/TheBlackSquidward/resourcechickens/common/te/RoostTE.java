package io.github.TheBlackSquidward.resourcechickens.common.te;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenDrop;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.common.items.ChickenItem;
import io.github.TheBlackSquidward.resourcechickens.init.ItemInit;
import io.github.TheBlackSquidward.resourcechickens.init.TileEntityInit;
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
import java.util.Random;

public class RoostTE extends TileEntity implements ITickableTileEntity {

    private final ItemStackHandler itemStackHandler = createHandler();

    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemStackHandler);

    public RoostTE() {
        super(TileEntityInit.ROOST_TE.get());
    }

    //TODO add timer
    @Override
    public void tick() {
        if(!this.world.isRemote) {
            if (hasChicken()) {
                ChickenRegistryObject chickenRegistryObject = ChickenRegistry.getChickenRegistryObjectbyChickenItem(itemStackHandler.getStackInSlot(0).getItem());
                addResult(new ItemStack(chickenRegistryObject.getChickenDrop(), getDropAmount(getGain())));
                markDirty();
            }
        }
    }

    public void addResult(ItemStack result) {
        ItemStack item1 = itemStackHandler.getStackInSlot(1);
        ItemStack item2 = itemStackHandler.getStackInSlot(2);
        ItemStack item3 = itemStackHandler.getStackInSlot(3);
        ItemStack item4 = itemStackHandler.getStackInSlot(4);
        if (item1.isEmpty()) {
            itemStackHandler.setStackInSlot(1, result);
        } else if (item1.isItemEqual(result) && item1.getCount() < 64) {
            int amount = item1.getCount() + 1;
            result.setCount(amount);
            itemStackHandler.setStackInSlot(1, result);
        } else if (item2.isEmpty() ) {
            itemStackHandler.setStackInSlot(2, result);
        } else if (item2.isItemEqual(result) && item2.getCount() < 64) {
            int amount = item2.getCount() + 1;
            result.setCount(amount);
            itemStackHandler.setStackInSlot(2, result);
        } else if (item3.isEmpty()) {
            itemStackHandler.setStackInSlot(3, result);
        } else if (item3.isItemEqual(result) && item3.getCount() < 64) {
            int amount = item3.getCount() + 1;
            result.setCount(amount);
            itemStackHandler.setStackInSlot(3, result);
        } else if (item4.isEmpty()) {
            itemStackHandler.setStackInSlot(4, result);
        } else if (item4.isItemEqual(result) && item4.getCount() < 64) {
            int amount = item4.getCount() + 1;
            result.setCount(amount);
            itemStackHandler.setStackInSlot(4, result);
        }
    }

    private int getDropAmount(int gain) {
        return (gain >= 10) ? 3 : ((gain >= 5) ? 2 : 1);
    }

    private boolean isDrop(ChickenDrop chickenDrop) {
        return chickenDrop.getItem() != Items.CHICKEN && chickenDrop.getItem().getItem() != Items.FEATHER;
    }

    private boolean hasChicken() {
        return itemStackHandler.getStackInSlot(0).getItem() instanceof ChickenItem && itemStackHandler.getStackInSlot(0).getItem() != ItemInit.VANILLA_CHICKEN.get();
    }

    private int getGain() {
        CompoundNBT nbt = itemStackHandler.getStackInSlot(0).getOrCreateTag();
        int gain =  nbt.getInt(ResourceChickens.MODID + "_chicken_gain");
        if(gain == 0) {
            gain = 1;
        }
        return gain;
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
                if (slot == 0) {
                    if (stack.getItem() instanceof ChickenItem) {
                        return true;
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
