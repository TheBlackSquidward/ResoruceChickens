package io.github.TheBlackSquidward.resourcefulchickens.init;

import io.github.TheBlackSquidward.resourcefulchickens.ResourcefulChickens;
import io.github.TheBlackSquidward.resourcefulchickens.common.blocks.rfRoostBlock;
import io.github.TheBlackSquidward.resourcefulchickens.common.blocks.roostBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ResourcefulChickens.MODID);

    public static final RegistryObject<Block> RF_ROOST = BLOCKS.register("rf_roost", () -> new rfRoostBlock());
    public static final RegistryObject<Block> ROOST = BLOCKS.register("roost", () -> new roostBlock());


}
