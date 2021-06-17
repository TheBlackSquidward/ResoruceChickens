package io.github.TheBlackSquidward.resourcechickens.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class HenhouseBlock extends Block {

    public HenhouseBlock() {
        super(Properties.of(Material.WOOD).harvestTool(ToolType.AXE));
    }

}
