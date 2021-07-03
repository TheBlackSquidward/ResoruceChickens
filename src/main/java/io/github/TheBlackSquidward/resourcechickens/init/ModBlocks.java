package io.github.TheBlackSquidward.resourcechickens.init;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.blocks.*;
import io.github.TheBlackSquidward.resourcechickens.blocks.henhouse.*;
import io.github.TheBlackSquidward.resourcechickens.blocks.roost.*;
import io.github.TheBlackSquidward.resourcechickens.blocks.chicken_breeder.*;
import io.github.TheBlackSquidward.resourcechickens.multiblocks.IndustrialCasingBlock;
import io.github.TheBlackSquidward.resourcechickens.multiblocks.IndustrialGlassBlock;
import io.github.TheBlackSquidward.resourcechickens.multiblocks.chicken_breeder.ChickenBreederControllerBlock;
import io.github.TheBlackSquidward.resourcechickens.multiblocks.roost.RoostControllerBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ResourceChickens.MOD_ID);

    //Roosts
    public static final RegistryObject<Block> oakRoost = BLOCKS.register("oak_roost", OakRoostBlock::new);
    public static final RegistryObject<Block> darkOakRoost = BLOCKS.register("dark_oak_roost", DarkOakRoostBlock::new);
    public static final RegistryObject<Block> birchRoost = BLOCKS.register("birch_roost", BirchRoostBlock::new);
    public static final RegistryObject<Block> spruceRoost = BLOCKS.register("spruce_roost", SpurceRoostBlock::new);
    public static final RegistryObject<Block> acaciaRoost = BLOCKS.register("acacia_roost", AcaciaRoostBlock::new);
    public static final RegistryObject<Block> jungleRoost = BLOCKS.register("jungle_roost", JungleRoostBlock::new);
    public static final RegistryObject<Block> warpedRoost = BLOCKS.register("warped_roost", WarpedRoostBlock::new);
    public static final RegistryObject<Block> crimsonRoost = BLOCKS.register("crimson_roost", CrimsonRoostBlock::new);
    public static final RegistryObject<Block> poweredRoost = BLOCKS.register("powered_roost", PoweredRoostBlock::new);

    //Henhouses
    public static final RegistryObject<Block> oakHenhouse = BLOCKS.register("oak_henhouse", OakHenhouseBlock::new);
    public static final RegistryObject<Block> darkOakHenhouse = BLOCKS.register("dark_oak_henhouse", DarkOakHenhouseBlock::new);
    public static final RegistryObject<Block> birchHenhouse = BLOCKS.register("birch_henhouse", BirchHenhouseBlock::new);
    public static final RegistryObject<Block> spruceHenhouse = BLOCKS.register("spruce_henhouse", SpurceHenhouseBlock::new);
    public static final RegistryObject<Block> acaciaHenhouse = BLOCKS.register("acacia_henhouse", AcaciaHenhouseBlock::new);
    public static final RegistryObject<Block> jungleHenhouse = BLOCKS.register("jungle_henhouse", JungleHenhouseBlock::new);
    public static final RegistryObject<Block> warpedHenhouse = BLOCKS.register("warped_henhouse", WarpedHenhouseBlock::new);
    public static final RegistryObject<Block> crimsonHenhouse = BLOCKS.register("crimson_henhouse", CrimsonHenhouseBlock::new);

    //Chicken Breeders
    public static final RegistryObject<Block> oakChickenBreeder = BLOCKS.register("oak_chicken_breeder", OakChickenBreederBlock::new);
    public static final RegistryObject<Block> darkOakChickenBreeder = BLOCKS.register("dark_oak_chicken_breeder", DarkOakChickenBreederBlock::new);
    public static final RegistryObject<Block> birchChickenBreeder = BLOCKS.register("birch_chicken_breeder", BirchChickenBreederBlock::new);
    public static final RegistryObject<Block> spruceChickenBreeder = BLOCKS.register("spruce_chicken_breeder", SpruceChickenBreederBlock::new);
    public static final RegistryObject<Block> acaciaChickenBreeder = BLOCKS.register("acacia_chicken_breeder", AcaciaChickenBreederBlock::new);
    public static final RegistryObject<Block> jungleChickenBreeder = BLOCKS.register("jungle_chicken_breeder", JungleChickenBreederBlock::new);
    public static final RegistryObject<Block> warpedChickenBreeder = BLOCKS.register("warped_chicken_breeder", WarpedChickenBreederBlock::new);
    public static final RegistryObject<Block> crimsonChickenBreeder = BLOCKS.register("crimson_chicken_breeder", CrimsonChickenBreederBlock::new);
    public static final RegistryObject<Block> poweredChickenBreeder = BLOCKS.register("powered_chicken_breeder", PoweredChickenBreederBlock::new);

    //Mutliblock
    public static final RegistryObject<Block> roostController = BLOCKS.register("roost_controller", RoostControllerBlock::new);
    public static final RegistryObject<Block> chickenBreederController = BLOCKS.register("chicken_breeder_controller", ChickenBreederControllerBlock::new);
    public static final RegistryObject<Block> industrialCasing = BLOCKS.register("industrial_casing", IndustrialCasingBlock::new);
    public static final RegistryObject<Block> industrialGlass = BLOCKS.register("industrial_glass", IndustrialGlassBlock::new);

    //Misc
    public static final RegistryObject<Block> poweredIncubator = BLOCKS.register("powered_incubator", PoweredIncubatorBlock::new);

}
