package io.github.TheBlackSquidward.resourcefulchickens.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraftforge.common.ToolType;

public class ChickenBreederBlock extends Block {
    public ChickenBreederBlock() {
        super(Properties.create(Material.WOOD).harvestTool(ToolType.AXE));
    }
}
