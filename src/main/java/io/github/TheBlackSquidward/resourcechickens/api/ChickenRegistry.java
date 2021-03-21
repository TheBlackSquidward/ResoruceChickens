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

import java.util.HashMap;

public class ChickenRegistry {

    private final static HashMap<String, ChickenRegistryObject> chickenRegistry = new HashMap<>();

    public static void initChickens() {
        initVanillaChickens();
        initModChickens();
        initOtherChickens();
    }

    //ModChickens
    private static ChickenRegistryObject copperChicken;

    //Other Chickens
    private static ChickenRegistryObject donkeyChicken;
    private static ChickenRegistryObject godChicken;
    private static ChickenRegistryObject squidwardChicken;
    private static ChickenRegistryObject quantumChicken;

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
        greenChicken = new ChickenRegistryObject("green_chicken", Items.GREEN_DYE, null, null);
        getChickenRegistry().put(greenChicken.getEntityName(), greenChicken);
        yellowChicken = new ChickenRegistryObject("yellow_chicken", Items.YELLOW_DYE, null, null);
        getChickenRegistry().put(yellowChicken.getEntityName(), yellowChicken);
        redChicken = new ChickenRegistryObject("red_chicken", Items.RED_DYE, null, null);
        getChickenRegistry().put(redChicken.getEntityName(), redChicken);
        blueChicken = new ChickenRegistryObject("blue_chicken", Items.BLUE_DYE, null, null);
        getChickenRegistry().put(blueChicken.getEntityName(), blueChicken);
        pinkChicken = new ChickenRegistryObject("pink_chicken", Items.PINK_DYE, null, null);
        getChickenRegistry().put(pinkChicken.getEntityName(), pinkChicken);
        lightBlueChicken = new ChickenRegistryObject("light_blue_chicken", Items.LIGHT_BLUE_DYE, null, null);
        getChickenRegistry().put(lightBlueChicken.getEntityName(), lightBlueChicken);
        limeChicken = new ChickenRegistryObject("lime_chicken", Items.LIME_DYE, null, null);
        getChickenRegistry().put(limeChicken.getEntityName(), limeChicken);
        blackChicken = new ChickenRegistryObject("black_chicken", Items.BLACK_DYE, null, null);
        getChickenRegistry().put(blackChicken.getEntityName(), blackChicken);
        whiteChicken = new ChickenRegistryObject("white_chicken", Items.WHITE_DYE, null, null);
        getChickenRegistry().put(whiteChicken.getEntityName(), whiteChicken);
        magentaChicken = new ChickenRegistryObject("magenta_chicken", Items.MAGENTA_DYE, null, null);
        getChickenRegistry().put(magentaChicken.getEntityName(), magentaChicken);
        lightGrayChicken = new ChickenRegistryObject("light_gray_chicken", Items.LIGHT_GRAY_DYE, null, null);
        getChickenRegistry().put(lightGrayChicken.getEntityName(), lightGrayChicken);
        grayChicken = new ChickenRegistryObject("gray_chicken", Items.GRAY_DYE, null, null);
        getChickenRegistry().put(grayChicken.getEntityName(), grayChicken);
        cyanChicken = new ChickenRegistryObject("cyan_chicken", Items.CYAN_DYE, null, null);
        getChickenRegistry().put(cyanChicken.getEntityName(), cyanChicken);
        purpleChicken = new ChickenRegistryObject("purple_chicken", Items.PURPLE_DYE, null, null);
        getChickenRegistry().put(purpleChicken.getEntityName(), purpleChicken);
        brownChicken = new ChickenRegistryObject("brown_chicken", Items.BROWN_DYE, null, null);
        getChickenRegistry().put(brownChicken.getEntityName(), brownChicken);
        orangeChicken = new ChickenRegistryObject("orange_chicken", Items.ORANGE_DYE, null, null);
        getChickenRegistry().put(orangeChicken.getEntityName(), orangeChicken);
    }

    private static void initBaseChickens() {
        clayChicken = new ChickenRegistryObject("clay_chicken", Items.CLAY_BALL, null, null);
        getChickenRegistry().put(clayChicken.getEntityName(), clayChicken);
        flintChicken = new ChickenRegistryObject("flint_chicken", Items.FLINT, null, null);
        getChickenRegistry().put(flintChicken.getEntityName(), flintChicken);
        glassChicken = new ChickenRegistryObject("glass_chicken", Items.GLASS, null, null);
        getChickenRegistry().put(glassChicken.getEntityName(), glassChicken);
        sandChicken = new ChickenRegistryObject("sand_chicken", Items.SAND, null, null);
        getChickenRegistry().put(sandChicken.getEntityName(), sandChicken);
        oakLogChicken = new ChickenRegistryObject("oak_chicken", Items.OAK_LOG, null, null);
        getChickenRegistry().put(oakLogChicken.getEntityName(), oakLogChicken);
        spruceChicken = new ChickenRegistryObject("spruce_chicken", Items.SPRUCE_LOG, null, null);
        getChickenRegistry().put(spruceChicken.getEntityName(), spruceChicken);
        birchChicken = new ChickenRegistryObject("birch_chicken", Items.BIRCH_LOG, null, null);
        getChickenRegistry().put(birchChicken.getEntityName(), birchChicken);
        jungleChicken = new ChickenRegistryObject("jungle_chicken", Items.JUNGLE_LOG, null, null);
        getChickenRegistry().put(jungleChicken.getEntityName(), jungleChicken);
        acaciaChicken = new ChickenRegistryObject("acacia_chicken", Items.ACACIA_LOG, null, null);
        getChickenRegistry().put(acaciaChicken.getEntityName(), acaciaChicken);
        darkOakChicken = new ChickenRegistryObject("dark_oak_chicken", Items.DARK_OAK_LOG, null, null);
        getChickenRegistry().put(darkOakChicken.getEntityName(), darkOakChicken);
    }

    private static void initVanillaChickens() {
        initDyeChickens();
        initBaseChickens();
        ironChicken = new ChickenRegistryObject("iron_chicken", Items.IRON_INGOT, flintChicken, whiteChicken, true);
        getChickenRegistry().put(ironChicken.getEntityName(), ironChicken);
        goldChicken = new ChickenRegistryObject("gold_chicken", Items.GOLD_INGOT, yellowChicken, ironChicken, true);
        getChickenRegistry().put(goldChicken.getEntityName(), goldChicken);
        diamondChicken = new ChickenRegistryObject("diamond_chicken", Items.DIAMOND, glassChicken, goldChicken);
        getChickenRegistry().put(diamondChicken.getEntityName(), diamondChicken);
        emeraldChicken = new ChickenRegistryObject("emerald_chicken", Items.EMERALD, diamondChicken, greenChicken);
        getChickenRegistry().put(emeraldChicken.getEntityName(), emeraldChicken);
        redstoneChicken = new ChickenRegistryObject("redstone_chicken", Items.REDSTONE, redChicken, sandChicken);
        getChickenRegistry().put(redstoneChicken.getEntityName(), redstoneChicken);
        lapisChicken = new ChickenRegistryObject("lapis_chicken", Items.LAPIS_LAZULI, null, null);
        getChickenRegistry().put(lapisChicken.getEntityName(), lapisChicken);
        blazeChicken = new ChickenRegistryObject("blaze_chicken", Items.BLAZE_ROD, goldChicken, lavaChicken);
        getChickenRegistry().put(blazeChicken.getEntityName(), blazeChicken);
        coalChicken = new ChickenRegistryObject("coal_chicken", Items.COAL, flintChicken, oakLogChicken);
        getChickenRegistry().put(coalChicken.getEntityName(), coalChicken);
        cowChicken = new ChickenRegistryObject("cow_chicken", Items.LEATHER, null, null);
        getChickenRegistry().put(cowChicken.getEntityName(), cowChicken);
        enderChicken = new ChickenRegistryObject("ender_chicken", Items.ENDER_PEARL, null, null);
        getChickenRegistry().put(enderChicken.getEntityName(), enderChicken);
        experienceChicken = new ChickenRegistryObject("experience_chicken", new ChickenEggObject(ItemInit.EXPERIENCE_IMBUED_EGG, Items.EXPERIENCE_BOTTLE), null, null);
        getChickenRegistry().put(experienceChicken.getEntityName(), experienceChicken);
        ghastChicken = new ChickenRegistryObject("ghast_chicken", Items.GHAST_TEAR, null, null);
        getChickenRegistry().put(ghastChicken.getEntityName(), ghastChicken);
        glowstoneChicken = new ChickenRegistryObject("glowstone_chicken", Items.GLOWSTONE_DUST, quartzChicken, yellowChicken);
        getChickenRegistry().put(glowstoneChicken.getEntityName(), glowstoneChicken);
        gunpowderChicken = new ChickenRegistryObject("gunpowder_chicken", Items.GUNPOWDER, sandChicken, flintChicken);
        getChickenRegistry().put(gunpowderChicken.getEntityName(), gunpowderChicken);
        lavaChicken = new ChickenRegistryObject("lava_chicken", new ChickenEggObject(ItemInit.LAVA_INFUSED_EGG, Items.LAVA_BUCKET), null, null);
        getChickenRegistry().put(lavaChicken.getEntityName(), lavaChicken);
        magmaSlimeChicken = new ChickenRegistryObject("magma_slime_chicken", Items.MAGMA_CREAM, null, null);
        getChickenRegistry().put(magmaSlimeChicken.getEntityName(), magmaSlimeChicken);
        netherWartChicken = new ChickenRegistryObject("nether_wart_chicken", Items.NETHER_WART, null, null);
        getChickenRegistry().put(netherWartChicken.getEntityName(), netherWartChicken);
        obsidianChicken = new ChickenRegistryObject("obsidian_chicken", Items.OBSIDIAN, null, null);
        getChickenRegistry().put(obsidianChicken.getEntityName(), obsidianChicken);
        quartzChicken = new ChickenRegistryObject("quartz_chicken", Items.QUARTZ, null, null);
        getChickenRegistry().put(quartzChicken.getEntityName(), quartzChicken);
        slimeChicken = new ChickenRegistryObject("slime_chicken", Items.SLIME_BALL, clayChicken, greenChicken);
        getChickenRegistry().put(slimeChicken.getEntityName(), slimeChicken);
        snowballChicken = new ChickenRegistryObject("snowball_chicken", Items.SNOWBALL, null, null);
        getChickenRegistry().put(snowballChicken.getEntityName(), snowballChicken);
        soulSandChicken = new ChickenRegistryObject("soul_sand_chicken", Items.SOUL_SAND, null, null);
        getChickenRegistry().put(soulSandChicken.getEntityName(), soulSandChicken);
        spiderChicken = new ChickenRegistryObject("spider_chicken", Items.STRING, oakLogChicken, blackChicken);
        getChickenRegistry().put(spiderChicken.getEntityName(), spiderChicken);
        waterChicken = new ChickenRegistryObject("water_chicken", new ChickenEggObject(ItemInit.WATER_INFUSED_EGG, Items.WATER_BUCKET), gunpowderChicken, snowballChicken);
        getChickenRegistry().put(waterChicken.getEntityName(), waterChicken);
        netheriteChicken = new ChickenRegistryObject("netherite_chicken", Items.NETHERITE_INGOT, null, null, true);
        getChickenRegistry().put(netheriteChicken.getEntityName(), netheriteChicken);
        honeyChicken = new ChickenRegistryObject("honey_chicken", Items.HONEYCOMB, null, null);
        getChickenRegistry().put(honeyChicken.getEntityName(), honeyChicken);
        enderDragonChicken = new ChickenRegistryObject("ender_dragon_chicken", Items.DRAGON_EGG, null, null);
        getChickenRegistry().put(enderDragonChicken.getEntityName(), enderDragonChicken);
        witherChicken = new ChickenRegistryObject("wither_chicken", Items.NETHER_STAR, null, null);
        getChickenRegistry().put(witherChicken.getEntityName(), witherChicken);
        witherSkeletonChicken = new ChickenRegistryObject("wither_skeleton_chicken", Items.WITHER_SKELETON_SKULL, null, null);
        getChickenRegistry().put(witherSkeletonChicken.getEntityName(), witherSkeletonChicken);
    }

    private static void initModChickens() {

    }

    private static void initOtherChickens() {
        donkeyChicken = new ChickenRegistryObject("donkey_chicken", Items.COMMAND_BLOCK, null, null);
        getChickenRegistry().put(donkeyChicken.getEntityName(), donkeyChicken);
        godChicken = new ChickenRegistryObject("god_chicken", Items.BARRIER, null, null);
        getChickenRegistry().put(godChicken.getEntityName(), godChicken);
        squidwardChicken = new ChickenRegistryObject("squidward_chicken", Items.SQUID_SPAWN_EGG, null, null);
        getChickenRegistry().put("squidward_chicken", squidwardChicken);
        quantumChicken = new ChickenRegistryObject("quantum_chicken", Items.END_PORTAL_FRAME, null, null);
        getChickenRegistry().put("quantum_chicken", quantumChicken);
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
            chicken.setChickenFeatherRegistryObject(customChickenFeather);
        }

        chicken.setChickenEntityRegistryObject(customChickenEntity);
        chicken.setChickenItemRegistryObject(customChickenItem);
        chicken.setChickenSpawnEggRegistryObject(customChickenSpawnEgg);
        chicken.setRegistryID(customChickenEntity.getId());
    }

    public static ChickenRegistryObject getChickenRegistryObjectbyEntity(CustomChickenEntity entity) {
        for (ChickenRegistryObject chickenRegistryObject : chickenRegistry.values()) {
            if (chickenRegistryObject.getChickenEntityRegisryObject().get() == entity.getType()) {
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
