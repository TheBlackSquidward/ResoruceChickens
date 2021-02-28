package io.github.TheBlackSquidward.resourcechickens.common.te;

import io.github.TheBlackSquidward.resourcechickens.common.items.ChickenItem;
import io.github.TheBlackSquidward.resourcechickens.init.TileEntityInit;
import net.minecraft.item.ItemStack;
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

    @Override
    public void tick() {

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
