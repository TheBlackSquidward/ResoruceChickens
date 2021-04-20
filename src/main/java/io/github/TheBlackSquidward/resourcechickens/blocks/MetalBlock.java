package io.github.TheBlackSquidward.resourcechickens.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MetalBlock extends Block {


    public MetalBlock()  {
        super(Properties.of(Material.METAL).harvestTool(ToolType.PICKAXE));
    }
}
