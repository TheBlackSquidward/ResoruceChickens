package io.github.TheBlackSquidward.resourcechickens.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class RoostBlock extends Block {

    public RoostBlock() {
        super(Properties.create(Material.WOOD).harvestTool(ToolType.AXE));
    }

}
