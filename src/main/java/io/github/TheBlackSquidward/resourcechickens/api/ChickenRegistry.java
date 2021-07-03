package io.github.TheBlackSquidward.resourcechickens.api;

import io.github.TheBlackSquidward.resourcechickens.entities.CustomChickenEntity;
import io.github.TheBlackSquidward.resourcechickens.init.ModItems;
import io.github.TheBlackSquidward.resourcechickens.items.ChickenItem;
import io.github.TheBlackSquidward.resourcechickens.items.CustomSpawnEggItem;
import io.github.TheBlackSquidward.resourcechickens.items.FeatherItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import java.util.ArrayList;

public class ChickenRegistry {

    public static ArrayList<ChickenRegistryObject> chickenRegistry;

    public static void initializeChickenRegistry() {
        chickenRegistry = new ArrayList<>();
        initVanillaChickens();
        initModChickens();
        initOtherChickens();
    }

    private static void initDyeChickens() {
        Chickens.greenChicken = new ChickenRegistryObject("green_chicken", ChickenType.DYE, false, false);
        getChickenRegistry().add(Chickens.greenChicken);
        Chickens.yellowChicken = new ChickenRegistryObject("yellow_chicken", ChickenType.DYE, false, false);
        getChickenRegistry().add(Chickens.yellowChicken);
        Chickens.redChicken = new ChickenRegistryObject("red_chicken", ChickenType.DYE, false, false);
        getChickenRegistry().add(Chickens.redChicken);
        Chickens.blueChicken = new ChickenRegistryObject("blue_chicken", ChickenType.DYE, false, false);
        getChickenRegistry().add(Chickens.blueChicken);
        Chickens.pinkChicken = new ChickenRegistryObject("pink_chicken", ChickenType.DYE, false, false);
        getChickenRegistry().add(Chickens.pinkChicken);
        Chickens.lightBlueChicken = new ChickenRegistryObject("light_blue_chicken", ChickenType.DYE, false, false);
        getChickenRegistry().add(Chickens.lightBlueChicken);
        Chickens.limeChicken = new ChickenRegistryObject("lime_chicken", ChickenType.DYE, false, false);
        getChickenRegistry().add(Chickens.limeChicken);
        Chickens.blackChicken = new ChickenRegistryObject("black_chicken", ChickenType.DYE, false, false);
        getChickenRegistry().add(Chickens.blackChicken);
        Chickens.whiteChicken = new ChickenRegistryObject("white_chicken", ChickenType.DYE,false, false);
        getChickenRegistry().add(Chickens.whiteChicken);
        Chickens.magentaChicken = new ChickenRegistryObject("magenta_chicken", ChickenType.DYE, false, false);
        getChickenRegistry().add(Chickens.magentaChicken);
        Chickens.lightGrayChicken = new ChickenRegistryObject("light_gray_chicken", ChickenType.DYE, false, false);
        getChickenRegistry().add(Chickens.lightGrayChicken);
        Chickens.grayChicken = new ChickenRegistryObject("gray_chicken", ChickenType.DYE, false, false);
        getChickenRegistry().add(Chickens.grayChicken);
        Chickens.cyanChicken = new ChickenRegistryObject("cyan_chicken", ChickenType.DYE, false, false);
        getChickenRegistry().add(Chickens.cyanChicken);
        Chickens.purpleChicken = new ChickenRegistryObject("purple_chicken", ChickenType.DYE, false, false);
        getChickenRegistry().add(Chickens.purpleChicken);
        Chickens.brownChicken = new ChickenRegistryObject("brown_chicken", ChickenType.DYE, false, false);
        getChickenRegistry().add(Chickens.brownChicken);
        Chickens.orangeChicken = new ChickenRegistryObject("orange_chicken", ChickenType.DYE, false, false);
        getChickenRegistry().add(Chickens.orangeChicken);
    }

    private static void initBaseChickens() {
        Chickens.clayChicken = new ChickenRegistryObject("clay_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.clayChicken);
        Chickens.flintChicken = new ChickenRegistryObject("flint_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.flintChicken);
        Chickens.glassChicken = new ChickenRegistryObject("glass_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.glassChicken);
        Chickens.sandChicken = new ChickenRegistryObject("sand_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.sandChicken);
        Chickens.oakLogChicken = new ChickenRegistryObject("oak_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.oakLogChicken);
        Chickens.spruceChicken = new ChickenRegistryObject("spruce_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.spruceChicken);
        Chickens.birchChicken = new ChickenRegistryObject("birch_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.birchChicken);
        Chickens.jungleChicken = new ChickenRegistryObject("jungle_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.jungleChicken);
        Chickens.acaciaChicken = new ChickenRegistryObject("acacia_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.acaciaChicken);
        Chickens.darkOakChicken = new ChickenRegistryObject("dark_oak_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.darkOakChicken);
    }

    private static void initVanillaChickens() {
        initDyeChickens();
        initBaseChickens();
        Chickens.ironChicken = new ChickenRegistryObject("iron_chicken", ChickenType.VANILLA, true, false);
        getChickenRegistry().add(Chickens.ironChicken);
        Chickens.goldChicken = new ChickenRegistryObject("gold_chicken", ChickenType.VANILLA, true, false);
        getChickenRegistry().add(Chickens.goldChicken);
        Chickens.diamondChicken = new ChickenRegistryObject("diamond_chicken", ChickenType.VANILLA, true, false);
        getChickenRegistry().add(Chickens.diamondChicken);
        Chickens.emeraldChicken = new ChickenRegistryObject("emerald_chicken", ChickenType.VANILLA, true, false);
        getChickenRegistry().add(Chickens.emeraldChicken);
        Chickens.redstoneChicken = new ChickenRegistryObject("redstone_chicken", ChickenType.VANILLA, true, false);
        getChickenRegistry().add(Chickens.redstoneChicken);
        Chickens.lapisChicken = new ChickenRegistryObject("lapis_chicken", ChickenType.VANILLA, true, false);
        getChickenRegistry().add(Chickens.lapisChicken);
        Chickens.blazeChicken = new ChickenRegistryObject("blaze_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.blazeChicken);
        Chickens.coalChicken = new ChickenRegistryObject("coal_chicken", ChickenType.VANILLA, true, false);
        getChickenRegistry().add(Chickens.coalChicken);
        Chickens.cowChicken = new ChickenRegistryObject("cow_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.cowChicken);
        Chickens.experienceChicken = new ChickenRegistryObject("experience_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.experienceChicken);
        Chickens.ghastChicken = new ChickenRegistryObject("ghast_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.ghastChicken);
        Chickens.glowstoneChicken = new ChickenRegistryObject("glowstone_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.glowstoneChicken);
        Chickens.gunpowderChicken = new ChickenRegistryObject("gunpowder_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.gunpowderChicken);
        Chickens.enderChicken = new ChickenRegistryObject("ender_chicken", ChickenType.VANILLA, true, false);
        getChickenRegistry().add(Chickens.enderChicken);
        Chickens.lavaChicken = new ChickenRegistryObject("lava_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.lavaChicken);
        Chickens.magmaSlimeChicken = new ChickenRegistryObject("magma_slime_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.magmaSlimeChicken);
        Chickens.netherWartChicken = new ChickenRegistryObject("nether_wart_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.netherWartChicken);
        Chickens.obsidianChicken = new ChickenRegistryObject("obsidian_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.obsidianChicken);
        Chickens.quartzChicken = new ChickenRegistryObject("quartz_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.quartzChicken);
        Chickens.slimeChicken = new ChickenRegistryObject("slime_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.slimeChicken);
        Chickens.snowballChicken = new ChickenRegistryObject("snowball_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.snowballChicken);
        Chickens.soulSandChicken = new ChickenRegistryObject("soul_sand_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.soulSandChicken);
        Chickens.spiderChicken = new ChickenRegistryObject("spider_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.spiderChicken);
        Chickens.waterChicken = new ChickenRegistryObject("water_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.waterChicken);
        Chickens.netheriteChicken = new ChickenRegistryObject("netherite_chicken", ChickenType.VANILLA, true, false);
        getChickenRegistry().add(Chickens.netheriteChicken);
        Chickens.honeyChicken = new ChickenRegistryObject("honey_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.honeyChicken);
        Chickens.enderDragonChicken = new ChickenRegistryObject("ender_dragon_chicken", ChickenType.VANILLA, true, false);
        getChickenRegistry().add(Chickens.enderDragonChicken);
        Chickens.witherChicken = new ChickenRegistryObject("wither_chicken", ChickenType.VANILLA, true, false);
        getChickenRegistry().add(Chickens.witherChicken);
        Chickens.witherSkeletonChicken = new ChickenRegistryObject("wither_skeleton_chicken", ChickenType.VANILLA, true, false);
        getChickenRegistry().add(Chickens.witherSkeletonChicken);
        Chickens.prismarineChicken = new ChickenRegistryObject("prismarine_chicken", ChickenType.VANILLA, false, false);
        getChickenRegistry().add(Chickens.prismarineChicken);
    }

    private static void initModChickens() {

    }

    private static void initBaseMetalChickens() {

    }

    private static void initOtherChickens() {
        Chickens.donkeyChicken = new ChickenRegistryObject("donkey_chicken", ChickenType.SPECIAL, false, false);
        getChickenRegistry().add(Chickens.donkeyChicken);
        Chickens.godChicken = new ChickenRegistryObject("god_chicken", ChickenType.SPECIAL, false, false);
        getChickenRegistry().add(Chickens.godChicken);
        Chickens.squidwardChicken = new ChickenRegistryObject("squidward_chicken", ChickenType.SPECIAL, false, false);
        getChickenRegistry().add(Chickens.squidwardChicken);
        Chickens.quantumChicken = new ChickenRegistryObject("quantum_chicken", ChickenType.SPECIAL, false, false);
        getChickenRegistry().add(Chickens.quantumChicken);
        Chickens.rainbowChicken = new ChickenRegistryObject("rainbow_chicken", ChickenType.SPECIAL, false, false);
        getChickenRegistry().add(Chickens.rainbowChicken);
    }

    public static void registerChickens() {
        for (ChickenRegistryObject chickenRegistryObject : chickenRegistry) {
            registerChicken(chickenRegistryObject);
        }
    }

    public static ArrayList<ChickenRegistryObject> getChickenRegistry() {
        return chickenRegistry;
    }


    public static void registerChicken(ChickenRegistryObject chicken) {
        /*
        RegistryObject<EntityType<? extends CustomChickenEntity>> customChickenEntity = ModEntities.ENTITY_TYPES.register(chicken.getEntityName() + "",
                () -> EntityType.Builder.<ResourceChicken>of((type, world) -> new ResourceChicken(type, world, chicken.getEntityName()), EntityClassification.CREATURE)
                        .sized(1.0f, 1.0f)
                        .build(new ResourceLocation(ResourceChickens.MOD_ID, chicken.getEntityName()).toString()));

         */
        RegistryObject<Item> customChickenItem = ModItems.ITEMS.register(chicken.getEntityName() + "_item", () -> new ChickenItem(new Item.Properties().stacksTo(16)));
        RegistryObject<Item> customChickenSpawnEgg = ModItems.ITEMS.register(chicken.getEntityName() + "_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties()));
        if (chicken.isHasFeather()) {
            RegistryObject<Item> customChickenFeather = ModItems.ITEMS.register(chicken.getEntityName() + "_feather", () -> new FeatherItem(new Item.Properties()));
            chicken.setChickenFeatherRegistryObject(customChickenFeather);
        }

        chicken.setChickenItemRegistryObject(customChickenItem);
        chicken.setChickenSpawnEggRegistryObject(customChickenSpawnEgg);
    }

    public static ChickenRegistryObject getChickenRegistryObjectbyEntity(CustomChickenEntity entity) {
        for (ChickenRegistryObject chickenRegistryObject : chickenRegistry) {
            if (chickenRegistryObject.getChickenEntityRegistryObject().get() == entity.getType()) {
                return chickenRegistryObject;
            }
        }
        return null;
    }

    public static ChickenRegistryObject getChickenRegistryObjectbyChickenItem(Item item) {
        for (ChickenRegistryObject chickenRegistryObject : chickenRegistry) {
            if (chickenRegistryObject.getChickenItemRegistryObject().get() == item) {
                return chickenRegistryObject;
            }
        }
        return null;
    }

    public static ChickenRegistryObject getChickenRegistryObjectbyChickenSpawnEggItem(Item item) {
        for (ChickenRegistryObject chickenRegistryObject : chickenRegistry) {
            if (chickenRegistryObject.getChickenSpawnEggRegistryObject().get() == item) {
                return chickenRegistryObject;
            }
        }
        return null;
    }

}
