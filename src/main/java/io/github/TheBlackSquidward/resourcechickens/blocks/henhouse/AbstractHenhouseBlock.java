package io.github.TheBlackSquidward.resourcechickens.blocks.henhouse;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public abstract class AbstractHenhouseBlock extends Block {

    public AbstractHenhouseBlock() {
        super(Properties.of(Material.WOOD).harvestTool(ToolType.AXE));
    }

}
