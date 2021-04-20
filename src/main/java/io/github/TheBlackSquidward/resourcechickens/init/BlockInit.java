package io.github.TheBlackSquidward.resourcechickens.init;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.blocks.*;
import io.github.TheBlackSquidward.resourcechickens.multiblocks.roost.RoostControllerBlock;
import io.github.TheBlackSquidward.resourcechickens.multiblocks.roost.RoostCasingBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ResourceChickens.MODID);

    public static final RegistryObject<Block> ELECTRIC_ROOST = BLOCKS.register("electric_roost", ElectricRoostBlock::new);
    public static final RegistryObject<Block> ROOST = BLOCKS.register("roost", RoostBlock::new);
    public static final RegistryObject<Block> INCUBATOR = BLOCKS.register("incubator", IncubatorBlock::new);
    public static final RegistryObject<Block> ELECTRIC_INCUBATOR = BLOCKS.register("electric_incubator", ElectricIncubatorBlock::new);
    public static final RegistryObject<Block> CHICKEN_BREEDER = BLOCKS.register("chicken_breeder", ChickenBreederBlock::new);
    public static final RegistryObject<Block> ELECTRIC_CHICKEN_BREEDER = BLOCKS.register("electric_chicken_breeder", ElectricChickenBreederBlock::new);
    public static final RegistryObject<Block> ROOST_CONTROLLER = BLOCKS.register("roost_controller", RoostControllerBlock::new);
    public static final RegistryObject<Block> ROOST_CASING = BLOCKS.register("roost_casing", RoostCasingBlock::new);
    //public static final RegistryObject<Block> HENHOUSE = BLOCKS.register("henhouse", HenhouseBlock::new);

    /*
    public static final RegistryObject<Block> COPPER_BLOCK = BLOCKS.register("copper_block", MetalBlock::new);
    public static final RegistryObject<Block> SILVER_BLOCK = BLOCKS.register("silver_block", MetalBlock::new);
    public static final RegistryObject<Block> BRONZE_BLOCK = BLOCKS.register("bronze_block", MetalBlock::new);
    public static final RegistryObject<Block> URANIUM_BLOCK = BLOCKS.register("uranium_block", MetalBlock::new);
    public static final RegistryObject<Block> TIN_BLOCK = BLOCKS.register("tin_block", MetalBlock::new);
    public static final RegistryObject<Block> LEAD_BLOCK = BLOCKS.register("lead_block", MetalBlock::new);
    public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", MetalBlock::new);
    public static final RegistryObject<Block> ALUMINIUM_BLOCK = BLOCKS.register("aluminium_block", MetalBlock::new);
    public static final RegistryObject<Block> NICKEL_BLOCK = BLOCKS.register("nickel_block", MetalBlock::new);
    public static final RegistryObject<Block> ELECTRUM_BLOCK = BLOCKS.register("electrum_block", MetalBlock::new);
     */

}
