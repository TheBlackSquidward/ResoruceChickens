package io.github.TheBlackSquidward.resourcefulchickens.init;

import io.github.TheBlackSquidward.resourcefulchickens.ResourcefulChickens;
import io.github.TheBlackSquidward.resourcefulchickens.common.items.ChickenCatcherItem;
import io.github.TheBlackSquidward.resourcefulchickens.common.items.ChickenItem;
import io.github.TheBlackSquidward.resourcefulchickens.common.items.CustomSpawnEggItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ResourcefulChickens.MODID);

    //Chickens - Vanilla
    public static final RegistryObject<ChickenItem> VANILLA_CHICKEN = ITEMS.register("vanilla_chicken", () -> new ChickenItem(new Item.Properties().maxStackSize(16)));

    /*
    //Spawn Eggs
    public static final RegistryObject<CustomSpawnEggItem> BLACK_CHICKEN_SPAWN_EGG = ITEMS.register("black_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> BLAZE_CHICKEN_SPAWN_EGG = ITEMS.register("blaze_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> BLUE_CHICKEN_SPAWN_EGG = ITEMS.register("blue_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> BROWN_CHICKEN_SPAWN_EGG = ITEMS.register("brown_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> CLAY_CHICKEN_SPAWN_EGG = ITEMS.register("clay_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> COAL_CHICKEN_SPAWN_EGG = ITEMS.register("coal_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> COW_CHICKEN_SPAWN_EGG = ITEMS.register("cow_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> CYAN_CHICKEN_SPAWN_EGG = ITEMS.register("cyan_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> DIAMOND_CHICKEN_SPAWN_EGG = ITEMS.register("diamond_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> EMERALD_CHICKEN_SPAWN_EGG = ITEMS.register("emerald_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> ENDER_DRAGON_CHICKEN_SPAWN_EGG = ITEMS.register("ender_dragon_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> EXPERIENCE_CHICKEN_SPAWN_EGG = ITEMS.register("experience_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> FLINT_CHICKEN_SPAWN_EGG = ITEMS.register("flint_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> GHAST_CHICKEN_SPAWN_EGG = ITEMS.register("ghast_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> GLASS_CHICKEN_SPAWN_EGG = ITEMS.register("glass_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> GLOWSTONE_CHICKEN_SPAWN_EGG = ITEMS.register("glowstone_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> GOLD_CHICKEN_SPAWN_EGG = ITEMS.register("gold_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> GRAY_CHICKEN_SPAWN_EGG = ITEMS.register("gray_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> GREEN_CHICKEN_SPAWN_EGG = ITEMS.register("green_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> GUNPOWDER_CHICKEN_SPAWN_EGG = ITEMS.register("gunpowder_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> HONEY_CHICKEN_SPAWN_EGG = ITEMS.register("honey_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> IRON_CHICKEN_SPAWN_EGG = ITEMS.register("iron_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> LAVA_CHICKEN_SPAWN_EGG = ITEMS.register("lava_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> LIGHT_BLUE_CHICKEN_SPAWN_EGG = ITEMS.register("light_blue_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> LIME_CHICKEN_SPAWN_EGG = ITEMS.register("lime_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> MAGENTA_CHICKEN_SPAWN_EGG = ITEMS.register("magenta_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> MAGMA_SLIME_CHICKEN_SPAWN_EGG = ITEMS.register("magma_slime_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> NETHER_WART_CHICKEN_SPAWN_EGG = ITEMS.register("nether_wart_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> NETHERITE_CHICKEN_SPAWN_EGG = ITEMS.register("netherite_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> OAK_LOG_CHICKEN_SPAWN_EGG = ITEMS.register("oak_log_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> OBSIDIAN_CHICKEN_SPAWN_EGG = ITEMS.register("obsidian_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> PINK_CHICKEN_SPAWN_EGG = ITEMS.register("pink_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> PURPLE_CHICKEN_SPAWN_EGG = ITEMS.register("purple_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> QUARTZ_CHICKEN_SPAWN_EGG = ITEMS.register("quartz_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> RED_CHICKEN_SPAWN_EGG = ITEMS.register("red_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> REDSTONE_CHICKEN_SPAWN_EGG = ITEMS.register("redstone_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> SAND_CHICKEN_SPAWN_EGG = ITEMS.register("sand_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> SLIME_CHICKEN_SPAWN_EGG = ITEMS.register("slime_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> SNOWBALL_CHICKEN_SPAWN_EGG = ITEMS.register("snowball_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> SOUL_SAND_CHICKEN_SPAWN_EGG = ITEMS.register("soul_sand_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> SPIDER_CHICKEN_SPAWN_EGG = ITEMS.register("spider_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> SUGAR_CANE_CHICKEN_SPAWN_EGG = ITEMS.register("suagr_cane_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> VANILLA_CHICKEN_SPAWN_EGG = ITEMS.register("vanilla_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> WATER_CHICKEN_SPAWN_EGG = ITEMS.register("water_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> WHITE_CHICKEN_SPAWN_EGG = ITEMS.register("white_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> WITHER_CHICKEN_SPAWN_EGG = ITEMS.register("wither_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> WITHER_SKELETON_CHICKEN_SPAWN_EGG = ITEMS.register("wither_skeleton_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
    public static final RegistryObject<CustomSpawnEggItem> YELLOW_CHICKEN_SPAWN_EGG = ITEMS.register("yellow_chicken_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties().maxStackSize(16)));
     */

    //Misc
    public static final RegistryObject<Item> CHICKEN_STICK = ITEMS.register("chicken_stick", () -> new Item(new Item.Properties().maxStackSize(1)));
    public static final RegistryObject<ChickenCatcherItem> CHICKEN_CATCHER = ITEMS.register("chicken_catcher", () -> new ChickenCatcherItem(new Item.Properties().maxStackSize(1)));

}
