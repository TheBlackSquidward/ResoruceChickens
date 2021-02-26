package io.github.TheBlackSquidward.resourcechickens.api;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.common.entities.CustomChickenEntity;
import io.github.TheBlackSquidward.resourcechickens.common.items.ChickenItem;
import io.github.TheBlackSquidward.resourcechickens.common.items.CustomSpawnEggItem;
import io.github.TheBlackSquidward.resourcechickens.registries.EntityRegistry;
import io.github.TheBlackSquidward.resourcechickens.registries.ItemRegistry;
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

    private static void initVanillaChickens() {
        ChickenRegistryObject greenChicken = new ChickenRegistryObject("green_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.GREEN_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(greenChicken.getEntityName(), greenChicken);
        ChickenRegistryObject yellowChicken = new ChickenRegistryObject("yellow_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.YELLOW_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(yellowChicken.getEntityName(), yellowChicken);
        ChickenRegistryObject redChicken = new ChickenRegistryObject("red_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.RED_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(redChicken.getEntityName(), redChicken);
        ChickenRegistryObject blueChicken = new ChickenRegistryObject("blue_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.BLUE_DYE   , 1, 2))), null, null, false);
        getChickenRegistry().put(blueChicken.getEntityName(), blueChicken);
        ChickenRegistryObject pinkChicken = new ChickenRegistryObject("pink_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.PINK_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(pinkChicken.getEntityName(), pinkChicken);
        ChickenRegistryObject lightBlueChicken = new ChickenRegistryObject("light_blue_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.LIGHT_BLUE_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(lightBlueChicken.getEntityName(), lightBlueChicken);
        ChickenRegistryObject limeChicken = new ChickenRegistryObject("lime_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.LIME_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(limeChicken.getEntityName(), limeChicken);
        ChickenRegistryObject blackChicken = new ChickenRegistryObject("black_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.BLACK_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(blackChicken.getEntityName(), blackChicken);
        ChickenRegistryObject whiteChicken = new ChickenRegistryObject("white_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.WHITE_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(whiteChicken.getEntityName(), whiteChicken);
        ChickenRegistryObject magentaChicken = new ChickenRegistryObject("magenta_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.MAGENTA_DYE  , 1, 2))), null, null, false);
        getChickenRegistry().put(magentaChicken.getEntityName(), magentaChicken);
        ChickenRegistryObject lightGrayChicken = new ChickenRegistryObject("light_gray_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.LIGHT_GRAY_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(lightGrayChicken.getEntityName(), lightGrayChicken);
        ChickenRegistryObject grayChicken = new ChickenRegistryObject("gray_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.GRAY_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(grayChicken.getEntityName(), grayChicken);
        ChickenRegistryObject cyanChicken = new ChickenRegistryObject("cyan_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.CYAN_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(cyanChicken.getEntityName(), cyanChicken);
        ChickenRegistryObject purpleChicken = new ChickenRegistryObject("purple_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.PURPLE_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(purpleChicken.getEntityName(), purpleChicken);
        ChickenRegistryObject brownChicken = new ChickenRegistryObject("brown_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.BROWN_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(brownChicken.getEntityName(), brownChicken);
        ChickenRegistryObject orangeChicken = new ChickenRegistryObject("orange_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.ORANGE_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(orangeChicken.getEntityName(), orangeChicken);
        ChickenRegistryObject flintChicken = new ChickenRegistryObject("flint_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.FLINT, 1, 3))), null, null, false);
        getChickenRegistry().put(flintChicken.getEntityName(), flintChicken);
        ChickenRegistryObject glassChicken = new ChickenRegistryObject("glass_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.GREEN_DYE, 1, 2))), null, null, false);
        getChickenRegistry().put(glassChicken.getEntityName(), glassChicken);
        ChickenRegistryObject sandChicken = new ChickenRegistryObject("sand_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.SAND, 1, 3))), null, null, false);
        getChickenRegistry().put(sandChicken.getEntityName(), sandChicken);
        ChickenRegistryObject ironChicken = new ChickenRegistryObject("iron_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.IRON_INGOT, 1, 3))),  flintChicken, whiteChicken, true);
        getChickenRegistry().put(ironChicken.getEntityName(), ironChicken);
        ChickenRegistryObject goldChicken = new ChickenRegistryObject("gold_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.GOLD_INGOT, 1, 3))), yellowChicken, ironChicken, true);
        getChickenRegistry().put(goldChicken.getEntityName(), goldChicken);
        ChickenRegistryObject diamondChicken = new ChickenRegistryObject("diamond_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.DIAMOND, 1, 2))), glassChicken, goldChicken, false);
        getChickenRegistry().put(diamondChicken.getEntityName(), diamondChicken);
        ChickenRegistryObject emeraldChicken = new ChickenRegistryObject("emerald_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.EMERALD, 1, 2))), diamondChicken, greenChicken, false);
        getChickenRegistry().put(emeraldChicken.getEntityName(), emeraldChicken);
        ChickenRegistryObject redstoneChicken = new ChickenRegistryObject("redstone_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.REDSTONE, 1, 3))), redChicken, sandChicken, false);
        getChickenRegistry().put(redstoneChicken.getEntityName(), redstoneChicken);
        ChickenRegistryObject lapisChicken = new ChickenRegistryObject("lapis_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.LAPIS_LAZULI, 1, 3))), null, null, false);
        getChickenRegistry().put(lapisChicken.getEntityName(), lapisChicken);
        ChickenRegistryObject blazeChicken = new ChickenRegistryObject("blaze_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.BLAZE_ROD, 1, 2))), goldChicken, null, false);
        getChickenRegistry().put(blazeChicken.getEntityName(), blazeChicken);
        ChickenRegistryObject clayChicken = new ChickenRegistryObject("clay_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.CLAY_BALL, 1, 3))), null, null, false);
        getChickenRegistry().put(clayChicken.getEntityName(), clayChicken);
        ChickenRegistryObject coalChicken = new ChickenRegistryObject("coal_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.COAL, 1, 3))), null, null, false);
        getChickenRegistry().put(coalChicken.getEntityName(), coalChicken);
        ChickenRegistryObject cowChicken = new ChickenRegistryObject("cow_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.LEATHER, 1, 2))), null, null, false);
        getChickenRegistry().put(cowChicken.getEntityName(), cowChicken);
        ChickenRegistryObject enderChicken = new ChickenRegistryObject("ender_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.ENDER_PEARL, 1, 2))), null, null, false);
        getChickenRegistry().put(enderChicken.getEntityName(), enderChicken);
        ChickenRegistryObject experienceChicken = new ChickenRegistryObject("experience_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(ItemRegistry.SOLIDIFIED_EXPERIENCE, 1, 2))), null, null, false);
        getChickenRegistry().put(experienceChicken.getEntityName(), experienceChicken);
        ChickenRegistryObject ghastChicken = new ChickenRegistryObject("ghast_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.GHAST_TEAR, 1, 2))), null, null, false);
        getChickenRegistry().put(ghastChicken.getEntityName(), ghastChicken);
        ChickenRegistryObject glowstoneChicken = new ChickenRegistryObject("glowstone_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.GLOWSTONE_DUST, 1, 2))), null, null, false);
        getChickenRegistry().put(glowstoneChicken.getEntityName(), glowstoneChicken);
        ChickenRegistryObject gunpowderChicken = new ChickenRegistryObject("gunpowder_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.GUNPOWDER, 1, 2))), null, null, false);
        getChickenRegistry().put(gunpowderChicken.getEntityName(), gunpowderChicken);
        ChickenRegistryObject lavaChicken = new ChickenRegistryObject("lava_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(ItemRegistry.LAVA_INFUSED_EGG, 1, 2))), null, null, false);
        getChickenRegistry().put(lavaChicken.getEntityName(), lavaChicken);
        ChickenRegistryObject magamaSlimeChicken = new ChickenRegistryObject("magma_slime_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.MAGMA_CREAM, 1, 2))), null, null, false);
        getChickenRegistry().put(magamaSlimeChicken.getEntityName(), magamaSlimeChicken);
        ChickenRegistryObject netherWartChicken = new ChickenRegistryObject("nether_wart_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.NETHER_WART, 1, 2))), null, null, false);
        getChickenRegistry().put(netherWartChicken.getEntityName(), netherWartChicken);
        ChickenRegistryObject oakLogChicken = new ChickenRegistryObject("oak_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.OAK_LOG, 1, 2), new ChickenDrop(Items.APPLE, 1, 1))), null, null, false);
        getChickenRegistry().put(oakLogChicken.getEntityName(), oakLogChicken);
        ChickenRegistryObject spruceChicken = new ChickenRegistryObject("spruce_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.SPRUCE_LOG, 1, 2))), null, null, false);
        getChickenRegistry().put(spruceChicken.getEntityName(), spruceChicken);
        ChickenRegistryObject birchChicken = new ChickenRegistryObject("birch_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.BIRCH_LOG, 1, 2))), null, null, false);
        getChickenRegistry().put(birchChicken.getEntityName(), birchChicken);
        ChickenRegistryObject jungleChicken = new ChickenRegistryObject("jungle_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.JUNGLE_LOG, 1, 2))), null, null, false);
        getChickenRegistry().put(jungleChicken.getEntityName(), jungleChicken);
        ChickenRegistryObject acaciaChicken = new ChickenRegistryObject("acacia_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.ACACIA_LOG, 1, 2))), null, null, false);
        getChickenRegistry().put(acaciaChicken.getEntityName(), acaciaChicken);
        ChickenRegistryObject darkOakChicken = new ChickenRegistryObject("dark_oak_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.DARK_OAK_LOG, 1, 2))), null, null, false);
        getChickenRegistry().put(darkOakChicken.getEntityName(), darkOakChicken);
        ChickenRegistryObject obsidianChicken = new ChickenRegistryObject("obsidian_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.OBSIDIAN, 1, 2))), null, null, false);
        getChickenRegistry().put(obsidianChicken.getEntityName(), obsidianChicken);
        ChickenRegistryObject quartzChicken = new ChickenRegistryObject("quartz_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.QUARTZ, 1, 3))), null, null, false);
        getChickenRegistry().put(quartzChicken.getEntityName(), quartzChicken);
        ChickenRegistryObject slimeChicken = new ChickenRegistryObject("slime_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.SLIME_BALL, 1, 2))), null, null, false);
        getChickenRegistry().put(slimeChicken.getEntityName(), slimeChicken);
        ChickenRegistryObject snowballChicken = new ChickenRegistryObject("snowball_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.SNOWBALL, 1, 3))), null, null, false);
        getChickenRegistry().put(snowballChicken.getEntityName(), snowballChicken);
        ChickenRegistryObject soulSandChicken = new ChickenRegistryObject("soul_sand_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.SOUL_SAND, 1, 3))), null, null, false);
        getChickenRegistry().put(soulSandChicken.getEntityName(), soulSandChicken);
        ChickenRegistryObject spiderChicken = new ChickenRegistryObject("spider_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.STRING, 1, 2))), null, null, false);
        getChickenRegistry().put(spiderChicken.getEntityName(), spiderChicken);
        ChickenRegistryObject waterChicken = new ChickenRegistryObject("water_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(ItemRegistry.WATER_INFUSED_EGG, 1, 1))), null, null, false);
        getChickenRegistry().put(waterChicken.getEntityName(), waterChicken);
        ChickenRegistryObject netheriteChicken = new ChickenRegistryObject("netherite_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.NETHERITE_INGOT, 1, 2))), null, null, false);
        getChickenRegistry().put(netheriteChicken.getEntityName(), netheriteChicken);
        ChickenRegistryObject honeyChicken = new ChickenRegistryObject("honey_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.HONEYCOMB, 1, 3))), null, null, false);
        getChickenRegistry().put(honeyChicken.getEntityName(), honeyChicken);
        ChickenRegistryObject enderDragonChicken = new ChickenRegistryObject("ender_dragon_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.DRAGON_EGG, 1, 1))), null, null, false);
        getChickenRegistry().put(enderDragonChicken.getEntityName(), enderDragonChicken);
        ChickenRegistryObject witherChicken = new ChickenRegistryObject("wither_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.NETHER_STAR, 1, 1))), null, null, false);
        getChickenRegistry().put(witherChicken.getEntityName(), witherChicken);
        ChickenRegistryObject witherSkeletonChicken = new ChickenRegistryObject("wither_skeleton_chicken", new ArrayList<ChickenDrop>(Arrays.asList(new ChickenDrop(Items.WITHER_SKELETON_SKULL, 1, 1))), null, null, false);
        getChickenRegistry().put(witherSkeletonChicken.getEntityName(), witherSkeletonChicken);
            }

    private static void initModChickens() {

    }

    public static void registerChickens() {
        for(ChickenRegistryObject chickenRegistryObject : chickenRegistry.values()) {
            registerChicken(chickenRegistryObject);
        }
    }

    public static HashMap<String, ChickenRegistryObject> getChickenRegistry() {
        return chickenRegistry;
    }

    public static void registerChicken(ChickenRegistryObject chicken) {
        RegistryObject<EntityType<CustomChickenEntity>> customChickenEntity = EntityRegistry.ENTITY_TYPES.register(chicken.getEntityName() + "",
                () -> EntityType.Builder.create(CustomChickenEntity::new, EntityClassification.CREATURE)
                        .size(1.0f, 1.0f)
                        .build(new ResourceLocation(ResourceChickens.MODID, chicken.getEntityName()).toString()));
        RegistryObject<Item> customChickenItem = ItemRegistry.ITEMS.register(chicken.getEntityName() + "_item", () -> new ChickenItem(new Item.Properties().maxStackSize(16)));
        RegistryObject<Item> customChickenSpawnEgg = ItemRegistry.ITEMS.register(chicken.getEntityName() + "_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties()));
        if(chicken.isHasFeather()) {
            RegistryObject<Item> customChickenFeather = ItemRegistry.ITEMS.register(chicken.getEntityName() + "_feather", () -> new Item(new Item.Properties()));
        }

        chicken.setChickenEntityRegistryObject(customChickenEntity);
        chicken.setChickenItemRegistryObject(customChickenItem);
        chicken.setChickenSpawnEggRegistryObject(customChickenSpawnEgg);
        chicken.setRegistryID(customChickenEntity.getId());
    }

    public static ChickenRegistryObject getChickenRegistryObjectbyEntity(CustomChickenEntity entity) {
        for(ChickenRegistryObject chickenRegistryObject : chickenRegistry.values()) {
            if(chickenRegistryObject.getChickenEntityRegisryObject().get() == (EntityType) entity.getType()) {
                return chickenRegistryObject;
            }
        }
        return null;
    }

    public static ChickenRegistryObject getChickenRegistryObjectbyChickenItem(Item item) {
        for(ChickenRegistryObject chickenRegistryObject : chickenRegistry.values()) {
            if(chickenRegistryObject.getChickenItemRegistryObject().get() == item) {
                return chickenRegistryObject;
            }
        }
        return null;
    }

    public static ChickenRegistryObject getChickenRegistryObjectbyChickenSpawnEggItem(Item item) {
        for(ChickenRegistryObject chickenRegistryObject : chickenRegistry.values()) {
            if(chickenRegistryObject.getChickenSpawnEggRegistryObject().get() == item) {
                return chickenRegistryObject;
            }
        }
        return null;
    }

    public static boolean canBeBred(ChickenRegistryObject parent1, ChickenRegistryObject parent2) {
        for(ChickenRegistryObject chickenRegistryObject : chickenRegistry.values()) {
            if(chickenRegistryObject.isBreedable()) {
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
        for(ChickenRegistryObject chickenRegistryObject : chickenRegistry.values()) {
            if(chickenRegistryObject.isBreedable()) {
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
