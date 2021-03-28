package io.github.TheBlackSquidward.resourcechickens.init;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.common.items.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
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

    //Misc
    public static final RegistryObject<Item> CHICKEN_STICK = ITEMS.register("chicken_stick", () -> new ChickenStickItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> CHICKEN_CATCHER = ITEMS.register("chicken_catcher", ChickenCatcherItem::new);
    public static final RegistryObject<Item> CHICKEN_MANURE = ITEMS.register("chicken_manure", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FERTILIZER = ITEMS.register("fertilizer", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_NUGGET = ITEMS.register("diamond_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_NUGGET = ITEMS.register("emerald_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_NUGGET = ITEMS.register("netherite_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> REDSTONE_PILE = ITEMS.register("redstone_pile", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_DUST = ITEMS.register("lapis_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COAL_CHUNK = ITEMS.register("coal_chunk", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENDER_FRAGMENT = ITEMS.register("ender_fragment", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHER_STAR_SHARD = ITEMS.register("nether_star_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WITHER_SKULL_FRAGMENT = ITEMS.register("wither_skull_fragment", () -> new Item(new Item.Properties()));

    //Food
    public static final RegistryObject<CustomFoodItem> CHICKEN_SANDWICH = ITEMS.register("chicken_sandwich", () -> new CustomFoodItem(9, 0.8F));
    public static final RegistryObject<CustomFoodItem> FRIED_CHICKEN = ITEMS.register("fried_chicken", () -> new CustomFoodItem(8, 0.7F));
    public static final RegistryObject<CustomFoodItem> RAW_CHICKEN_NUGGETS = ITEMS.register("raw_chicken_nuggets", () -> new CustomFoodItem(new Item.Properties().food(new Food.Builder().nutrition(1).saturationMod(0.6F).effect(new EffectInstance(Effects.HUNGER, 200, 0), 0.3F).fast().meat().build())));
    public static final RegistryObject<CustomFoodItem> CHICKEN_NUGGETS = ITEMS.register("chicken_nuggets", () -> new CustomFoodItem(new Item.Properties().food(new Food.Builder().nutrition(4).saturationMod(0.7F).fast().meat().build())));
    public static final RegistryObject<CustomFoodItem> CHICKEN_AND_CHIPS = ITEMS.register("chicken_and_chips", () -> new CustomFoodItem(14, 1F));

    //Upgrades
    public static final RegistryObject<Item> UPGRADE_BASE = ITEMS.register("upgrade_base", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ELECTRIC_UPGRADE = ITEMS.register("electric_upgrade", () -> new ElectricUpgradeItem(new Item.Properties()));
    public static final RegistryObject<Item> LUCK_UPGRADE = ITEMS.register("luck_upgrade", () -> new UpgradeItem(new Item.Properties()));
    public static final RegistryObject<Item> SPEED_UPGRADE = ITEMS.register("speed_upgrade", () -> new UpgradeItem(new Item.Properties()));
    public static final RegistryObject<Item> ENERGY_UPGRADE = ITEMS.register("energy_upgrade", () -> new UpgradeItem(new Item.Properties()));

    //Chickens - Vanilla
    public static final RegistryObject<ChickenItem> VANILLA_CHICKEN = ITEMS.register("vanilla_chicken_item", () -> new ChickenItem(new Item.Properties().stacksTo(16)));

    //Eggs
    public static final RegistryObject<Item> EXPERIENCE_IMBUED_EGG = ITEMS.register("experience_imbued_egg", () -> new CustomEggItem(new Item.Properties()));
    public static final RegistryObject<Item> LAVA_INFUSED_EGG = ITEMS.register("lava_infused_egg", () -> new CustomEggItem(new Item.Properties()));
    public static final RegistryObject<Item> WATER_INFUSED_EGG = ITEMS.register("water_infused_egg", () -> new CustomEggItem(new Item.Properties()));

}
