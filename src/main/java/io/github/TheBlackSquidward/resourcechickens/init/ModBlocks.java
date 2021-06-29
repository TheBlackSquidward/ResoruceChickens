package io.github.TheBlackSquidward.resourcechickens.init;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.blocks.*;
import io.github.TheBlackSquidward.resourcechickens.blocks.roost.*;
import io.github.TheBlackSquidward.resourcechickens.multiblocks.roost.RoostControllerBlock;
import io.github.TheBlackSquidward.resourcechickens.multiblocks.roost.RoostCasingBlock;
import io.github.TheBlackSquidward.resourcechickens.te.roost.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ResourceChickens.MODID);

    public static final RegistryObject<Block> oakRoost = BLOCKS.register("oak_roost", OakRoostBlock::new);
    public static final RegistryObject<Block> darkOakRoost = BLOCKS.register("dark_oak_roost", DarkOakRoostBlock::new);
    public static final RegistryObject<Block> birchRoost = BLOCKS.register("birch_roost", BirchRoostBlock::new);
    public static final RegistryObject<Block> spruceRoost = BLOCKS.register("spruce_roost", SpurceRoostBlock::new);
    public static final RegistryObject<Block> acaciaRoost = BLOCKS.register("acacia_roost", AcaciaRoostBlock::new);
    public static final RegistryObject<Block> jungleRoost = BLOCKS.register("jungle_roost", JungleRoostBlock::new);
    public static final RegistryObject<Block> poweredRoost = BLOCKS.register("powered_roost", PoweredRoostBlock::new);

    public static final RegistryObject<Block> oakHenhouse = BLOCKS.register("oak_henhouse", HenhouseBlock::new);
    public static final RegistryObject<Block> darkOakHenhouse = BLOCKS.register("dark_oak_henhouse", HenhouseBlock::new);
    public static final RegistryObject<Block> birchHenhouse = BLOCKS.register("birch_henhouse", HenhouseBlock::new);
    public static final RegistryObject<Block> spruceHenhouse = BLOCKS.register("spruce_henhouse", HenhouseBlock::new);
    public static final RegistryObject<Block> acaciaHenhouse = BLOCKS.register("acacia_henhouse", HenhouseBlock::new);
    public static final RegistryObject<Block> jungleHenhouse = BLOCKS.register("jungle_henhouse", HenhouseBlock::new);

    public static final RegistryObject<Block> INCUBATOR = BLOCKS.register("incubator", IncubatorBlock::new);
    public static final RegistryObject<Block> ELECTRIC_INCUBATOR = BLOCKS.register("electric_incubator", ElectricIncubatorBlock::new);
    public static final RegistryObject<Block> CHICKEN_BREEDER = BLOCKS.register("chicken_breeder", ChickenBreederBlock::new);
    public static final RegistryObject<Block> ELECTRIC_CHICKEN_BREEDER = BLOCKS.register("electric_chicken_breeder", ElectricChickenBreederBlock::new);
    public static final RegistryObject<Block> ROOST_CONTROLLER = BLOCKS.register("roost_controller", RoostControllerBlock::new);
    public static final RegistryObject<Block> ROOST_CASING = BLOCKS.register("roost_casing", RoostCasingBlock::new);

}
