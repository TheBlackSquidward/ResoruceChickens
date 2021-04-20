package io.github.TheBlackSquidward.resourcechickens.init;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.items.*;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ResourceChickens.MODID);

    //Blocks
    public static final RegistryObject<BlockItem> ELECTRIC_ROOST = ITEMS.register("electric_roost", () -> new BlockItem(BlockInit.ELECTRIC_ROOST.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ROOST = ITEMS.register("roost", () -> new BlockItem(BlockInit.ROOST.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ELECTRIC_INCUBATOR = ITEMS.register("electric_incubator", () -> new BlockItem(BlockInit.ELECTRIC_INCUBATOR.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> INCUBATOR = ITEMS.register("incubator", () -> new BlockItem(BlockInit.INCUBATOR.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> CHICKEN_BREEDER = ITEMS.register("chicken_breeder", () -> new BlockItem(BlockInit.CHICKEN_BREEDER.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ELECTRIC_CHICKEN_BREEDER = ITEMS.register("electric_chicken_breeder", () -> new BlockItem(BlockInit.ELECTRIC_CHICKEN_BREEDER.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ROOST_CONTROLLER = ITEMS.register("roost_controller", () -> new BlockItem(BlockInit.ROOST_CONTROLLER.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ROOST_CASING = ITEMS.register("roost_casing", () -> new BlockItem(BlockInit.ROOST_CASING.get(), new Item.Properties()));

    //Misc
    public static final RegistryObject<ChickenStickItem> CHICKEN_STICK = ITEMS.register("chicken_stick", ChickenStickItem::new);
    public static final RegistryObject<ChickenCatcherItem> CHICKEN_CATCHER = ITEMS.register("chicken_catcher", ChickenCatcherItem::new);
    public static final RegistryObject<ChickenAnalyserItem> CHICKEN_ANALYSER = ITEMS.register("chicken_analyser", ChickenAnalyserItem::new);
    public static final RegistryObject<Item> CHICKEN_MANURE = ITEMS.register("chicken_manure", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FERTILIZER = ITEMS.register("fertilizer", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_CORE = ITEMS.register("machine_core", () -> new Item(new Item.Properties()));

    //Upgrades
    public static final RegistryObject<Item> UPGRADE_BASE = ITEMS.register("upgrade_base", () -> new Item(new Item.Properties()));
    public static final RegistryObject<UpgradeItem> ELECTRIC_UPGRADE = ITEMS.register("electric_upgrade", () -> new ElectricUpgradeItem(new Item.Properties()));
    public static final RegistryObject<UpgradeItem> LUCK_UPGRADE = ITEMS.register("luck_upgrade", () -> new UpgradeItem(new Item.Properties()));
    public static final RegistryObject<UpgradeItem> SPEED_UPGRADE = ITEMS.register("speed_upgrade", () -> new UpgradeItem(new Item.Properties()));
    public static final RegistryObject<UpgradeItem> ENERGY_UPGRADE = ITEMS.register("energy_upgrade", () -> new UpgradeItem(new Item.Properties()));

    //Chickens - Vanilla
    public static final RegistryObject<ChickenItem> VANILLA_CHICKEN = ITEMS.register("vanilla_chicken_item", () -> new ChickenItem(new Item.Properties().stacksTo(16)));

    //Eggs
    public static final RegistryObject<Item> EXPERIENCE_IMBUED_EGG = ITEMS.register("experience_imbued_egg", () -> new CustomEggItem(new Item.Properties()));
    public static final RegistryObject<Item> LAVA_INFUSED_EGG = ITEMS.register("lava_infused_egg", () -> new CustomEggItem(new Item.Properties()));
    public static final RegistryObject<Item> WATER_INFUSED_EGG = ITEMS.register("water_infused_egg", () -> new CustomEggItem(new Item.Properties()));

    //Resources
    public static final RegistryObject<Item> DIAMOND_NUGGET = ITEMS.register("diamond_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_NUGGET = ITEMS.register("emerald_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_NUGGET = ITEMS.register("netherite_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> REDSTONE_PILE = ITEMS.register("redstone_pile", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_DUST = ITEMS.register("lapis_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COAL_CHUNK = ITEMS.register("coal_chunk", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENDER_FRAGMENT = ITEMS.register("ender_fragment", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHER_STAR_SHARD = ITEMS.register("nether_star_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WITHER_SKULL_FRAGMENT = ITEMS.register("wither_skull_fragment", () -> new Item(new Item.Properties()));

    //Metals
    /*
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<BlockItem> COPPER_BLOCK = ITEMS.register("copper_block", () -> new BlockItem(BlockInit.COPPER_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<BlockItem> SILVER_BLOCK = ITEMS.register("silver_block", () -> new BlockItem(BlockInit.SILVER_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRONZE_NUGGET = ITEMS.register("bronze_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<BlockItem> BRONZE_BLOCK = ITEMS.register("bronze_block", () -> new BlockItem(BlockInit.BRONZE_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> URANIUM_NUGGET = ITEMS.register("uranium_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<BlockItem> URANIUM_BLOCK = ITEMS.register("uranium_block", () -> new BlockItem(BlockInit.URANIUM_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIN_NUGGET = ITEMS.register("tin_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<BlockItem> TIN_BLOCK = ITEMS.register("tin_block", () -> new BlockItem(BlockInit.TIN_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("lead_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<BlockItem> LEAD_BLOCK = ITEMS.register("lead_block", () -> new BlockItem(BlockInit.LEAD_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<BlockItem> STEEL_BLOCK = ITEMS.register("steel_block", () -> new BlockItem(BlockInit.STEEL_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> ALUMINIUM_INGOT = ITEMS.register("aluminium_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALUMINIUM_NUGGET = ITEMS.register("aluminium_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<BlockItem> ALUMINIUM_BLOCK = ITEMS.register("aluminium_block", () -> new BlockItem(BlockInit.ALUMINIUM_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NICKEL_NUGGET = ITEMS.register("nickel_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<BlockItem> NICKEL_BLOCK = ITEMS.register("nickel_block", () -> new BlockItem(BlockInit.NICKEL_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> ELECTRUM_INGOT = ITEMS.register("electrum_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ELECTRUM_NUGGET = ITEMS.register("electrum_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<BlockItem> ELECTRUM_BLOCK = ITEMS.register("electrum_block", () -> new BlockItem(BlockInit.ELECTRUM_BLOCK.get(), new Item.Properties()));
     */
}
