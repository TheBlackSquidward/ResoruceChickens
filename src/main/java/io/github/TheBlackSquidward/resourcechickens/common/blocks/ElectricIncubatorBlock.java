package io.github.TheBlackSquidward.resourcechickens.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ElectricIncubatorBlock extends Block {

    public ElectricIncubatorBlock() {
        super(Properties.create(Material.IRON).harvestTool(ToolType.PICKAXE));
    }

}
