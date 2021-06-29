package io.github.TheBlackSquidward.resourcechickens.multiblocks.chicken_breeder;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class ChickenBreederControllerBlock extends Block {

    public ChickenBreederControllerBlock() {
        super(Properties.of(Material.METAL).harvestTool(ToolType.PICKAXE));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        //TODO
        return null;
    }

}
