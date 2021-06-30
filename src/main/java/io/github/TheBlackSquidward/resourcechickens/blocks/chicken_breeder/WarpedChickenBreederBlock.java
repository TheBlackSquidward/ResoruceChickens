package io.github.TheBlackSquidward.resourcechickens.blocks.chicken_breeder;

import io.github.TheBlackSquidward.resourcechickens.te.chicken_breeder.WarpedChickenBreederTE;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class WarpedChickenBreederBlock extends AbstractChickenBreederBlock{

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new WarpedChickenBreederTE();
    }
}
