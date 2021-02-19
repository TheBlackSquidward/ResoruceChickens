package io.github.TheBlackSquidward.resourcefulchickens.init;

import io.github.TheBlackSquidward.resourcefulchickens.ResourcefulChickens;
import io.github.TheBlackSquidward.resourcefulchickens.common.blocks.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ResourcefulChickens.MODID);

    public static final RegistryObject<Block> ELECTRIC_ROOST = BLOCKS.register("electric_roost", ElectricRoostBlock::new);
    public static final RegistryObject<Block> ROOST = BLOCKS.register("roost", RoostBlock::new);
    public static final RegistryObject<Block> INCUBATOR = BLOCKS.register("incubator", IncubatorBlock::new);
    public static final RegistryObject<Block> ELECTRIC_NCUBATOR = BLOCKS.register("electric_incubator", ElectricIncubatorBlock::new);
    public static final RegistryObject<Block> CHICKEN_BREEDER = BLOCKS.register("chicken_breeder", ChickenBreeder::new);
    public static final RegistryObject<Block> ELECTRIC_CHICKEN_BREEDER = BLOCKS.register("electric_chicken_breeder", ElectricChickenBreeder::new);


}
