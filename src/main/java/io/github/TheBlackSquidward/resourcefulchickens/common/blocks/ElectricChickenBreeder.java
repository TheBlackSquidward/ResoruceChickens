package io.github.TheBlackSquidward.resourcefulchickens.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ElectricChickenBreeder extends Block {

    public ElectricChickenBreeder() {
        super(Properties.create(Material.IRON).harvestTool(ToolType.PICKAXE));
    }

}
