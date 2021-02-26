package io.github.TheBlackSquidward.resourcechickens.common.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ElectricRoostBlock extends Block {

    public ElectricRoostBlock() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE));
    }

}
