
package io.github.TheBlackSquidward.resourcechickens.te;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.text.DecimalFormat;

public abstract class AbstractTileEntity extends TileEntity implements ITickableTileEntity {

    public AbstractTileEntity(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    private static final DecimalFormat FORMATTER = new DecimalFormat("0.0%");

    public ItemStackHandler itemStackHandler = createItemStackHandler();
    public LazyOptional<IItemHandler> itemHandlerLazyOptional = LazyOptional.of(() -> itemStackHandler);

    public double progress;

    public abstract ItemStackHandler createItemStackHandler();

    public World getWorld() {
        return this.level;
    }

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
    public void load(@NotNull BlockState blockState, @NotNull CompoundNBT tag) {
        this.loadFromNBT(tag);
        super.load(blockState, tag);
    }
    protected abstract void loadFromNBT(CompoundNBT tag);

    //NBT
    @Override
    public @NotNull CompoundNBT save(@NotNull CompoundNBT tag) {
        super.save(tag);
        return saveToNBT(tag);
    }
    protected abstract CompoundNBT saveToNBT(CompoundNBT tag);

    //Updating the tile entity
    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(getBlockPos(), -1, saveToNBT(new CompoundNBT()));
    }
    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        CompoundNBT nbt = pkt.getTag();
        loadFromNBT(nbt);
    }
    @Override
    public @NotNull CompoundNBT getUpdateTag() {
        return this.serializeNBT();
    }
    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT tag) {
        this.deserializeNBT(tag);
    }

    //Custom Methods For Handling Progress
    public double getProgress() {
        return progress;
    }
    public String getFormattedProgress(double progress) {
        return formatProgress(progress);
    }
    public String formatProgress(double progress) {
        return FORMATTER.format(progress);
    }

}