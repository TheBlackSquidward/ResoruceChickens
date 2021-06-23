package io.github.TheBlackSquidward.resourcechickens.init;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.items.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ResourceChickens.MODID);

    //Blocks
    public static final RegistryObject<BlockItem> ELECTRIC_ROOST = ITEMS.register("electric_roost", () -> new BaseBlockItem(ModBlocks.ELECTRIC_ROOST.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ROOST = ITEMS.register("roost", () -> new BaseBlockItem(ModBlocks.ROOST.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ELECTRIC_INCUBATOR = ITEMS.register("electric_incubator", () -> new BaseBlockItem(ModBlocks.ELECTRIC_INCUBATOR.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> INCUBATOR = ITEMS.register("incubator", () -> new BaseBlockItem(ModBlocks.INCUBATOR.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> CHICKEN_BREEDER = ITEMS.register("chicken_breeder", () -> new BaseBlockItem(ModBlocks.CHICKEN_BREEDER.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ELECTRIC_CHICKEN_BREEDER = ITEMS.register("electric_chicken_breeder", () -> new BaseBlockItem(ModBlocks.ELECTRIC_CHICKEN_BREEDER.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ROOST_CONTROLLER = ITEMS.register("roost_controller", () -> new BaseBlockItem(ModBlocks.ROOST_CONTROLLER.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ROOST_CASING = ITEMS.register("roost_casing", () -> new BaseBlockItem(ModBlocks.ROOST_CASING.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> HENHOUSE = ITEMS.register("henhouse", () -> new BaseBlockItem(ModBlocks.HENHOUSE.get(), new Item.Properties()));

    //Misc
    public static final RegistryObject<ChickenStickItem> CHICKEN_STICK = ITEMS.register("chicken_stick", ChickenStickItem::new);
    public static final RegistryObject<ChickenCatcherItem> CHICKEN_CATCHER = ITEMS.register("chicken_catcher", ChickenCatcherItem::new);
    public static final RegistryObject<ChickenAnalyzerItem> CHICKEN_ANALYSER = ITEMS.register("chicken_analyser", ChickenAnalyzerItem::new);
    public static final RegistryObject<Item> CHICKEN_MANURE = ITEMS.register("chicken_manure", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> CHICKEN_FEED = ITEMS.register("chicken_feed", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> FERTILIZER = ITEMS.register("fertilizer", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_CORE = ITEMS.register("machine_core", () -> new BaseItem(new Item.Properties()));

    //Upgrades
    public static final RegistryObject<Item> UPGRADE_BASE = ITEMS.register("upgrade_base", () -> new BaseItem(new Item.Properties()));
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
    public static final RegistryObject<Item> DIAMOND_NUGGET = ITEMS.register("diamond_nugget", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_NUGGET = ITEMS.register("emerald_nugget", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_NUGGET = ITEMS.register("netherite_nugget", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> REDSTONE_PILE = ITEMS.register("redstone_pile", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_DUST = ITEMS.register("lapis_dust", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> COAL_CHUNK = ITEMS.register("coal_chunk", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> ENDER_FRAGMENT = ITEMS.register("ender_fragment", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> NETHER_STAR_SHARD = ITEMS.register("nether_star_shard", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> WITHER_SKULL_FRAGMENT = ITEMS.register("wither_skull_fragment", () -> new BaseItem(new Item.Properties()));

}
