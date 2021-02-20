package io.github.TheBlackSquidward.resourcefulchickens.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ElectricChickenBreederBlock extends Block {

    public ElectricChickenBreederBlock() {
        super(Properties.create(Material.IRON).harvestTool(ToolType.PICKAXE));
    }

}
