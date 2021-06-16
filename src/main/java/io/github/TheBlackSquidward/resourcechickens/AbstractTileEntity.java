package io.github.TheBlackSquidward.resourcechickens;

import net.minecraft.block.BlockState;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AbstractTileEntity<R extends IRecipe<?>> extends TileEntity implements IInventory, ITickableTileEntity {

    public AbstractTileEntity(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public ItemStackHandler itemStackHandler = createItemStackHandler();
    public LazyOptional<IItemHandler> itemHandlerLazyOptional = LazyOptional.of(() -> itemStackHandler);

    public double progress;

    public abstract R getRecipe();
    public abstract ItemStackHandler createItemStackHandler();

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return itemHandlerLazyOptional.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    protected void invalidateCaps() {
        super.invalidateCaps();
        itemHandlerLazyOptional.invalidate();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
    @Override
    public ItemStack getItem(int index) {
        if(index > getContainerSize()) {
            return ItemStack.EMPTY;
        }
        return null;
    }

    @Override
    public void load(BlockState blockState, CompoundNBT tag) {
        this.loadFromNBT(tag);
        super.load(blockState, tag);
    }
    protected abstract void loadFromNBT(CompoundNBT tag);

    @Override
    public CompoundNBT save(CompoundNBT tag) {
        super.save(tag);
        return saveToNBT(tag);
    }
    protected abstract CompoundNBT saveToNBT(CompoundNBT tag);

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
    @Override
    public CompoundNBT getUpdateTag() {
        return this.serializeNBT();
    }
    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT tag) {
        this.deserializeNBT(tag);
    }

    public double getProgress() {
        return progress;
    }
}
