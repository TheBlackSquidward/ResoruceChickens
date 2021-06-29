package io.github.TheBlackSquidward.resourcechickens.te;

import io.github.TheBlackSquidward.resourcechickens.items.CustomEggItem;
import io.github.TheBlackSquidward.resourcechickens.init.ModTileEntities;
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

public class IncubatorTE extends TileEntity implements ITickableTileEntity {

    private final ItemStackHandler itemStackHandler = createHandler();

    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemStackHandler);

    public IncubatorTE() {
        super(ModTileEntities.incuabtor.get());
    }

    @Override
    public void tick() {
        //TODO
    }

    @Override
    protected void invalidateCaps() {
        super.invalidateCaps();
        handler.invalidate();
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
                    return stack.getItem() instanceof CustomEggItem;
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
