package io.github.TheBlackSquidward.resourcechickens.blocks.roost;

import io.github.TheBlackSquidward.resourcechickens.te.roost.CrimsonRoostTE;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class CrimsonRoostBlock extends AbstractRoostBlock{

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new CrimsonRoostTE();
    }

}
