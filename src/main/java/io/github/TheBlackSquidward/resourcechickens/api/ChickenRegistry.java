package io.github.TheBlackSquidward.resourcechickens.api;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.common.entities.CustomChickenEntity;
import io.github.TheBlackSquidward.resourcechickens.common.items.ChickenItem;
import io.github.TheBlackSquidward.resourcechickens.common.items.CustomSpawnEggItem;
import io.github.TheBlackSquidward.resourcechickens.init.EntityInit;
import io.github.TheBlackSquidward.resourcechickens.init.ItemInit;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ChickenRegistry {

    private final static HashMap<String, ChickenRegistryObject> chickenRegistry = new HashMap<>();

    public static void initChickens() {
        initVanillaChickens();
        initModChickens();
    }

    //Dye Chickens
    private static ChickenRegistryObject greenChicken;
    private static ChickenRegistryObject yellowChicken;
    private static ChickenRegistryObject redChicken;
    private static ChickenRegistryObject blueChicken;
    private static ChickenRegistryObject pinkChicken;
    private static ChickenRegistryObject lightBlueChicken;
    private static ChickenRegistryObject limeChicken;
    private static ChickenRegistryObject blackChicken;
    private static ChickenRegistryObject whiteChicken;
    private static ChickenRegistryObject magentaChicken;
    private static ChickenRegistryObject lightGrayChicken;
    private static ChickenRegistryObject grayChicken;
    private static ChickenRegistryObject cyanChicken;
    private static ChickenRegistryObject purpleChicken;
    private static ChickenRegistryObject brownChicken;
    private static ChickenRegistryObject orangeChicken;

    //Base Chickens
    private static ChickenRegistryObject clayChicken;
    private static ChickenRegistryObject flintChicken;
    private static ChickenRegistryObject glassChicken;
    private static ChickenRegistryObject sandChicken;
    private static ChickenRegistryObject oakLogChicken;
    private static ChickenRegistryObject spruceChicken;
    private static ChickenRegistryObject jungleChicken;
    private static ChickenRegistryObject acaciaChicken;
    private static ChickenRegistryObject darkOakChicken;
    private static ChickenRegistryObject birchChicken;

    //Vanilla Chickens
    private static ChickenRegistryObject ironChicken;
    private static ChickenRegistryObject goldChicken;
    private static ChickenRegistryObject diamondChicken;
    private static ChickenRegistryObject emeraldChicken;
    private static ChickenRegistryObject redstoneChicken;
    private static ChickenRegistryObject lapisChicken;
    private static ChickenRegistryObject blazeChicken;
    private static ChickenRegistryObject coalChicken;
    private static ChickenRegistryObject cowChicken;
    private static ChickenRegistryObject enderChicken;
    private static ChickenRegistryObject experienceChicken;
    private static ChickenRegistryObject ghastChicken;
    private static ChickenRegistryObject glowstoneChicken;
    private static ChickenRegistryObject gunpowderChicken;
    private static ChickenRegistryObject lavaChicken;
    private static ChickenRegistryObject magmaSlimeChicken;
    private static ChickenRegistryObject netherWartChicken;
    private static ChickenRegistryObject obsidianChicken;
    private static ChickenRegistryObject quartzChicken;
    private static ChickenRegistryObject slimeChicken;
    private static ChickenRegistryObject snowballChicken;
    private static ChickenRegistryObject waterChicken;
    private static ChickenRegistryObject netheriteChicken;
    private static ChickenRegistryObject spiderChicken;
    private static ChickenRegistryObject soulSandChicken;
    private static ChickenRegistryObject enderDragonChicken;
    private static ChickenRegistryObject honeyChicken;
    private static ChickenRegistryObject witherChicken;
    private static ChickenRegistryObject witherSkeletonChicken;

    private static void initDyeChickens() {
        greenChicken = new ChickenRegistryObject("green_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.GREEN_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(greenChicken.getEntityName(), greenChicken);
        yellowChicken = new ChickenRegistryObject("yellow_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.YELLOW_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(yellowChicken.getEntityName(), yellowChicken);
        redChicken = new ChickenRegistryObject("red_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.RED_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(redChicken.getEntityName(), redChicken);
        blueChicken = new ChickenRegistryObject("blue_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.BLUE_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(blueChicken.getEntityName(), blueChicken);
        pinkChicken = new ChickenRegistryObject("pink_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.PINK_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(pinkChicken.getEntityName(), pinkChicken);
        lightBlueChicken = new ChickenRegistryObject("light_blue_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.LIGHT_BLUE_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(lightBlueChicken.getEntityName(), lightBlueChicken);
        limeChicken = new ChickenRegistryObject("lime_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.LIME_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(limeChicken.getEntityName(), limeChicken);
        blackChicken = new ChickenRegistryObject("black_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.BLACK_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(blackChicken.getEntityName(), blackChicken);
        whiteChicken = new ChickenRegistryObject("white_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.WHITE_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(whiteChicken.getEntityName(), whiteChicken);
        magentaChicken = new ChickenRegistryObject("magenta_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.MAGENTA_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(magentaChicken.getEntityName(), magentaChicken);
        lightGrayChicken = new ChickenRegistryObject("light_gray_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.LIGHT_GRAY_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(lightGrayChicken.getEntityName(), lightGrayChicken);
        grayChicken = new ChickenRegistryObject("gray_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.GRAY_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(grayChicken.getEntityName(), grayChicken);
        cyanChicken = new ChickenRegistryObject("cyan_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.CYAN_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(cyanChicken.getEntityName(), cyanChicken);
        purpleChicken = new ChickenRegistryObject("purple_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.PURPLE_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(purpleChicken.getEntityName(), purpleChicken);
        brownChicken = new ChickenRegistryObject("brown_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.BROWN_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(brownChicken.getEntityName(), brownChicken);
        orangeChicken = new ChickenRegistryObject("orange_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.ORANGE_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(orangeChicken.getEntityName(), orangeChicken);
    }
    private static void initBaseChickens() {
        clayChicken = new ChickenRegistryObject("clay_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.CLAY_BALL, 1, 3))), null, null, false);
        getChickenRegistry().put(clayChicken.getEntityName(), clayChicken);
        flintChicken = new ChickenRegistryObject("flint_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.FLINT, 1, 3))), null, null, false);
        getChickenRegistry().put(flintChicken.getEntityName(), flintChicken);
        glassChicken = new ChickenRegistryObject("glass_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.GREEN_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(glassChicken.getEntityName(), glassChicken);
        sandChicken = new ChickenRegistryObject("sand_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.SAND, 1, 3))), null, null, false);
        getChickenRegistry().put(sandChicken.getEntityName(), sandChicken);
        oakLogChicken = new ChickenRegistryObject("oak_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.OAK_LOG, 1, 2), new ChickenDrop(Items.APPLE, 1, 1))), null, null, false);
        getChickenRegistry().put(oakLogChicken.getEntityName(), oakLogChicken);
        spruceChicken = new ChickenRegistryObject("spruce_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.SPRUCE_LOG, 1, 2))), null, null, false);
        getChickenRegistry().put(spruceChicken.getEntityName(), spruceChicken);
        birchChicken = new ChickenRegistryObject("birch_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.BIRCH_LOG, 1, 2))), null, null, false);
        getChickenRegistry().put(birchChicken.getEntityName(), birchChicken);
        jungleChicken = new ChickenRegistryObject("jungle_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.JUNGLE_LOG, 1, 2))), null, null, false);
        getChickenRegistry().put(jungleChicken.getEntityName(), jungleChicken);
        acaciaChicken = new ChickenRegistryObject("acacia_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.ACACIA_LOG, 1, 2))), null, null, false);
        getChickenRegistry().put(acaciaChicken.getEntityName(), acaciaChicken);
        darkOakChicken = new ChickenRegistryObject("dark_oak_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.DARK_OAK_LOG, 1, 2))), null, null, false);
        getChickenRegistry().put(darkOakChicken.getEntityName(), darkOakChicken);
    }

    private static void initVanillaChickens() {
        initDyeChickens();
        initBaseChickens();
        ironChicken = new ChickenRegistryObject("iron_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.IRON_INGOT, 1, 3))), flintChicken, whiteChicken, true);
        getChickenRegistry().put(ironChicken.getEntityName(), ironChicken);
        goldChicken = new ChickenRegistryObject("gold_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.GOLD_INGOT, 1, 3))), yellowChicken, ironChicken, true);
        getChickenRegistry().put(goldChicken.getEntityName(), goldChicken);
        diamondChicken = new ChickenRegistryObject("diamond_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.DIAMOND, 1, 2))), glassChicken, goldChicken, false);
        getChickenRegistry().put(diamondChicken.getEntityName(), diamondChicken);
        emeraldChicken = new ChickenRegistryObject("emerald_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.EMERALD, 1, 2))), diamondChicken, greenChicken, false);
        getChickenRegistry().put(emeraldChicken.getEntityName(), emeraldChicken);
        redstoneChicken = new ChickenRegistryObject("redstone_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.REDSTONE, 1, 3))), redChicken, sandChicken, false);
        getChickenRegistry().put(redstoneChicken.getEntityName(), redstoneChicken);
        lapisChicken = new ChickenRegistryObject("lapis_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.LAPIS_LAZULI, 1, 3))), null, null, false);
        getChickenRegistry().put(lapisChicken.getEntityName(), lapisChicken);
        blazeChicken = new ChickenRegistryObject("blaze_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.BLAZE_ROD, 1, 2))), goldChicken, lavaChicken, false);
        getChickenRegistry().put(blazeChicken.getEntityName(), blazeChicken);
        coalChicken = new ChickenRegistryObject("coal_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.COAL, 1, 3))), flintChicken, oakLogChicken, false);
        getChickenRegistry().put(coalChicken.getEntityName(), coalChicken);
        cowChicken = new ChickenRegistryObject("cow_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.LEATHER, 1, 2))), null, null, false);
        getChickenRegistry().put(cowChicken.getEntityName(), cowChicken);
        enderChicken = new ChickenRegistryObject("ender_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.ENDER_PEARL, 1, 2))), null, null, false);
        getChickenRegistry().put(enderChicken.getEntityName(), enderChicken);
        experienceChicken = new ChickenRegistryObject("experience_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(ItemInit.EXPERIENCE_IMBUED_EGG, 1, 2))), null, null, false);
        getChickenRegistry().put(experienceChicken.getEntityName(), experienceChicken);
        ghastChicken = new ChickenRegistryObject("ghast_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.GHAST_TEAR, 1, 2))), null, null, false);
        getChickenRegistry().put(ghastChicken.getEntityName(), ghastChicken);
        glowstoneChicken = new ChickenRegistryObject("glowstone_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.GLOWSTONE_DUST, 1, 2))), quartzChicken, yellowChicken, false);
        getChickenRegistry().put(glowstoneChicken.getEntityName(), glowstoneChicken);
        gunpowderChicken = new ChickenRegistryObject("gunpowder_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.GUNPOWDER, 1, 2))), sandChicken, flintChicken, false);
        getChickenRegistry().put(gunpowderChicken.getEntityName(), gunpowderChicken);
        lavaChicken = new ChickenRegistryObject("lava_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(ItemInit.LAVA_INFUSED_EGG, 1, 2))), null, null, false);
        getChickenRegistry().put(lavaChicken.getEntityName(), lavaChicken);
        magmaSlimeChicken = new ChickenRegistryObject("magma_slime_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.MAGMA_CREAM, 1, 2))), null, null, false);
        getChickenRegistry().put(magmaSlimeChicken.getEntityName(), magmaSlimeChicken);
        netherWartChicken = new ChickenRegistryObject("nether_wart_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.NETHER_WART, 1, 2))), null, null, false);
        getChickenRegistry().put(netherWartChicken.getEntityName(), netherWartChicken);
        obsidianChicken = new ChickenRegistryObject("obsidian_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.OBSIDIAN, 1, 2))), null, null, false);
        getChickenRegistry().put(obsidianChicken.getEntityName(), obsidianChicken);
        quartzChicken = new ChickenRegistryObject("quartz_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.QUARTZ, 1, 3))), null, null, false);
        getChickenRegistry().put(quartzChicken.getEntityName(), quartzChicken);
        slimeChicken = new ChickenRegistryObject("slime_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.SLIME_BALL, 1, 2))), clayChicken, greenChicken, false);
        getChickenRegistry().put(slimeChicken.getEntityName(), slimeChicken);
        snowballChicken = new ChickenRegistryObject("snowball_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.SNOWBALL, 1, 3))), null, null, false);
        getChickenRegistry().put(snowballChicken.getEntityName(), snowballChicken);
        soulSandChicken = new ChickenRegistryObject("soul_sand_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.SOUL_SAND, 1, 3))), null, null, false);
        getChickenRegistry().put(soulSandChicken.getEntityName(), soulSandChicken);
        spiderChicken = new ChickenRegistryObject("spider_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.STRING, 1, 2))), oakLogChicken, blackChicken, false);
        getChickenRegistry().put(spiderChicken.getEntityName(), spiderChicken);
        waterChicken = new ChickenRegistryObject("water_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(ItemInit.WATER_INFUSED_EGG, 1, 1))), gunpowderChicken, snowballChicken, false);
        getChickenRegistry().put(waterChicken.getEntityName(), waterChicken);
        netheriteChicken = new ChickenRegistryObject("netherite_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.NETHERITE_INGOT, 1, 2))), null, null, false);
        getChickenRegistry().put(netheriteChicken.getEntityName(), netheriteChicken);
        honeyChicken = new ChickenRegistryObject("honey_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.HONEYCOMB, 1, 3))), null, null, false);
        getChickenRegistry().put(honeyChicken.getEntityName(), honeyChicken);
        enderDragonChicken = new ChickenRegistryObject("ender_dragon_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.DRAGON_EGG, 1, 1))), null, null, false);
        getChickenRegistry().put(enderDragonChicken.getEntityName(), enderDragonChicken);
        witherChicken = new ChickenRegistryObject("wither_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.NETHER_STAR, 1, 1))), null, null, false);
        getChickenRegistry().put(witherChicken.getEntityName(), witherChicken);
        witherSkeletonChicken = new ChickenRegistryObject("wither_skeleton_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.WITHER_SKELETON_SKULL, 1, 1))), null, null, false);
        getChickenRegistry().put(witherSkeletonChicken.getEntityName(), witherSkeletonChicken);
    }

    private static void initModChickens() {

    }

    public static void registerChickens() {
        for (ChickenRegistryObject chickenRegistryObject : chickenRegistry.values()) {
            registerChicken(chickenRegistryObject);
        }
    }

    public static HashMap<String, ChickenRegistryObject> getChickenRegistry() {
        return chickenRegistry;
    }

    public static void registerChicken(ChickenRegistryObject chicken) {
        RegistryObject<EntityType<CustomChickenEntity>> customChickenEntity = EntityInit.ENTITY_TYPES.register(chicken.getEntityName() + "",
                () -> EntityType.Builder.create(CustomChickenEntity::new, EntityClassification.CREATURE)
                        .size(1.0f, 1.0f)
                        .build(new ResourceLocation(ResourceChickens.MODID, chicken.getEntityName()).toString()));
        RegistryObject<Item> customChickenItem = ItemInit.ITEMS.register(chicken.getEntityName() + "_item", () -> new ChickenItem(new Item.Properties().maxStackSize(16)));
        RegistryObject<Item> customChickenSpawnEgg = ItemInit.ITEMS.register(chicken.getEntityName() + "_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties()));
        if (chicken.isHasFeather()) {
            RegistryObject<Item> customChickenFeather = ItemInit.ITEMS.register(chicken.getEntityName() + "_feather", () -> new Item(new Item.Properties()));
        }

        chicken.setChickenEntityRegistryObject(customChickenEntity);
        chicken.setChickenItemRegistryObject(customChickenItem);
        chicken.setChickenSpawnEggRegistryObject(customChickenSpawnEgg);
        chicken.setRegistryID(customChickenEntity.getId());
    }

    public static ChickenRegistryObject getChickenRegistryObjectbyEntity(CustomChickenEntity entity) {
        for (ChickenRegistryObject chickenRegistryObject : chickenRegistry.values()) {
            if (chickenRegistryObject.getChickenEntityRegisryObject().get() == (EntityType) entity.getType()) {
                return chickenRegistryObject;
            }
        }
        return null;
    }

    public static ChickenRegistryObject getChickenRegistryObjectbyChickenItem(Item item) {
        for (ChickenRegistryObject chickenRegistryObject : chickenRegistry.values()) {
            if (chickenRegistryObject.getChickenItemRegistryObject().get() == item) {
                return chickenRegistryObject;
            }
        }
        return null;
    }

    public static ChickenRegistryObject getChickenRegistryObjectbyChickenSpawnEggItem(Item item) {
        for (ChickenRegistryObject chickenRegistryObject : chickenRegistry.values()) {
            if (chickenRegistryObject.getChickenSpawnEggRegistryObject().get() == item) {
                return chickenRegistryObject;
            }
        }
        return null;
    }

    public static boolean canBeBred(ChickenRegistryObject parent1, ChickenRegistryObject parent2) {
        for (ChickenRegistryObject chickenRegistryObject : chickenRegistry.values()) {
            if (chickenRegistryObject.isBreedable()) {
                if (chickenRegistryObject.getParent1() == parent1 && chickenRegistryObject.getParent2() == parent2) {
                    return true;
                }
                if (chickenRegistryObject.getParent1() == parent2 && chickenRegistryObject.getParent2() == parent1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static ChickenRegistryObject getChild(ChickenRegistryObject parent1, ChickenRegistryObject parent2) {
        for (ChickenRegistryObject chickenRegistryObject : chickenRegistry.values()) {
            if (chickenRegistryObject.isBreedable()) {
                if (chickenRegistryObject.getParent1() == parent1 && chickenRegistryObject.getParent2() == parent2) {
                    return chickenRegistryObject;
                }
                if (chickenRegistryObject.getParent1() == parent2 && chickenRegistryObject.getParent2() == parent1) {
                    return chickenRegistryObject;
                }
            }
        }
        return null;
    }

}
