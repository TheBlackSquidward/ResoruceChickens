package io.github.TheBlackSquidward.resourcefulchickens.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ChickenBreeder extends Block {
    public ChickenBreeder() {
        super(Properties.create(Material.WOOD).harvestTool(ToolType.AXE));
    }
}
