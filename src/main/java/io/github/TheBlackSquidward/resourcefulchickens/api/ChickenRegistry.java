package io.github.TheBlackSquidward.resourcefulchickens.api;

import io.github.TheBlackSquidward.resourcefulchickens.ResourcefulChickens;
import io.github.TheBlackSquidward.resourcefulchickens.common.entities.CustomChickenEntity;
import io.github.TheBlackSquidward.resourcefulchickens.common.items.ChickenItem;
import io.github.TheBlackSquidward.resourcefulchickens.common.items.CustomSpawnEggItem;
import io.github.TheBlackSquidward.resourcefulchickens.init.EntityInit;
import io.github.TheBlackSquidward.resourcefulchickens.init.ItemInit;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import java.awt.*;
import java.util.HashMap;

public class ChickenRegistry {

    private final static HashMap<String, ChickenRegistryObject> chickenRegistry = new HashMap<>();

    public static void initChickens() {
        initVanillaChickens();
        initModChickens();
    }

    private static void initVanillaChickens() {
        ChickenRegistryObject greenChicken = new ChickenRegistryObject("green_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/green_chicken_item.png"), new ItemStack(Items.GREEN_DYE), null, null, false);
        getChickenRegistry().put(greenChicken.getEntityName(), greenChicken);
        ChickenRegistryObject yellowChicken = new ChickenRegistryObject("yellow_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/yellow_chicken_item.png"), new ItemStack(Items.YELLOW_DYE), null, null, false);
        getChickenRegistry().put(yellowChicken.getEntityName(), yellowChicken);
        ChickenRegistryObject redChicken = new ChickenRegistryObject("red_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/red_chicken_item.png"), new ItemStack(Items.RED_DYE), null, null, false);
        getChickenRegistry().put(redChicken.getEntityName(), redChicken);
        ChickenRegistryObject blueChicken = new ChickenRegistryObject("blue_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/blue_chicken_item.png"), new ItemStack(Items.BLUE_DYE), null, null, false);
        getChickenRegistry().put(blueChicken.getEntityName(), blueChicken);
        ChickenRegistryObject pinkChicken = new ChickenRegistryObject("pink_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/pink_chicken_item.png"), new ItemStack(Items.PINK_DYE), null, null, false);
        getChickenRegistry().put(pinkChicken.getEntityName(), pinkChicken);
        ChickenRegistryObject lightBlueChicken = new ChickenRegistryObject("light_blue_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/light_blue_chicken_item.png"), new ItemStack(Items.LIGHT_BLUE_DYE), null, null, false);
        getChickenRegistry().put(lightBlueChicken.getEntityName(), lightBlueChicken);
        ChickenRegistryObject limeChicken = new ChickenRegistryObject("lime_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/lime_chicken_item.png"), new ItemStack(Items.LIME_DYE), null, null, false);
        getChickenRegistry().put(limeChicken.getEntityName(), limeChicken);
        ChickenRegistryObject blackChicken = new ChickenRegistryObject("black_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/black_chicken_item.png"), new ItemStack(Items.BLACK_DYE), null, null, false);
        getChickenRegistry().put(blackChicken.getEntityName(), blackChicken);
        ChickenRegistryObject whiteChicken = new ChickenRegistryObject("white_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/white_chicken_item.png"), new ItemStack(Items.WHITE_DYE), null, null, false);
        getChickenRegistry().put(whiteChicken.getEntityName(), whiteChicken);
        ChickenRegistryObject magentaChicken = new ChickenRegistryObject("magenta_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/magenta_chicken_item.png"), new ItemStack(Items.MAGENTA_DYE), null, null, false);
        getChickenRegistry().put(magentaChicken.getEntityName(), magentaChicken);
        ChickenRegistryObject lightGrayChicken = new ChickenRegistryObject("light_gray_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/light_gray_chicken_item.png"), new ItemStack(Items.LIGHT_GRAY_DYE), null, null, false);
        getChickenRegistry().put(lightGrayChicken.getEntityName(), lightGrayChicken);
        ChickenRegistryObject grayChicken = new ChickenRegistryObject("gray_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/gray_chicken_item.png"), new ItemStack(Items.GRAY_DYE), null, null, false);
        getChickenRegistry().put(grayChicken.getEntityName(), grayChicken);
        ChickenRegistryObject cyanChicken = new ChickenRegistryObject("cyan_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/cyan_chicken_item.png"), new ItemStack(Items.CYAN_DYE), null, null, false);
        getChickenRegistry().put(cyanChicken.getEntityName(), cyanChicken);
        ChickenRegistryObject purpleChicken = new ChickenRegistryObject("purple_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/purple_chicken_item.png"), new ItemStack(Items.PURPLE_DYE), null, null, false);
        getChickenRegistry().put(purpleChicken.getEntityName(), purpleChicken);
        ChickenRegistryObject brownChicken = new ChickenRegistryObject("brown_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/brown_chicken_item.png"), new ItemStack(Items.BROWN_DYE), null, null, false);
        getChickenRegistry().put(brownChicken.getEntityName(), brownChicken);
        ChickenRegistryObject orangeChicken = new ChickenRegistryObject("orange_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/orange_chicken_item.png"), new ItemStack(Items.ORANGE_DYE), null, null, false);
        getChickenRegistry().put(orangeChicken.getEntityName(), orangeChicken);
        ChickenRegistryObject flintChicken = new ChickenRegistryObject("flint_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/flint_chicken_item.png"), new ItemStack(Items.FLINT), null, null, false);
        getChickenRegistry().put(flintChicken.getEntityName(), flintChicken);
        ChickenRegistryObject ironChicken = new ChickenRegistryObject("iron_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/iron_chicken_item.png"), new ItemStack(Items.IRON_INGOT),  null, null, true);
        getChickenRegistry().put(ironChicken.getEntityName(), ironChicken);
        ChickenRegistryObject goldChicken = new ChickenRegistryObject("gold_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/gold_chicken_item.png"), new ItemStack(Items.GOLD_INGOT), null, null, true);
        getChickenRegistry().put(goldChicken.getEntityName(), goldChicken);
        ChickenRegistryObject diamondChicken = new ChickenRegistryObject("diamond_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/diamond_chicken_item.png"), new ItemStack(Items.DIAMOND), null, null, false);
        getChickenRegistry().put(diamondChicken.getEntityName(), diamondChicken);
        ChickenRegistryObject emeraldChicken = new ChickenRegistryObject("emerald_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/emerald_chicken_item.png"), new ItemStack(Items.EMERALD), null, null, false);
        getChickenRegistry().put(emeraldChicken.getEntityName(), emeraldChicken);
        ChickenRegistryObject redstoneChicken = new ChickenRegistryObject("redstone_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/redstone_chicken_item.png"), new ItemStack(Items.REDSTONE), null, null, false);
        getChickenRegistry().put(redstoneChicken.getEntityName(), redstoneChicken);
        ChickenRegistryObject lapisChicken = new ChickenRegistryObject("lapis_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/lapis_chicken_item.png"), new ItemStack(Items.LAPIS_LAZULI), null, null, false);
        getChickenRegistry().put(lapisChicken.getEntityName(), lapisChicken);
        ChickenRegistryObject blazeChicken = new ChickenRegistryObject("blaze_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/blaze_chicken_item.png"), new ItemStack(Items.BLAZE_ROD), null, null, false);
        getChickenRegistry().put(blazeChicken.getEntityName(), blazeChicken);
        ChickenRegistryObject clayChicken = new ChickenRegistryObject("clay_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/clay_chicken_item.png"), new ItemStack(Items.CLAY_BALL), null, null, false);
        getChickenRegistry().put(clayChicken.getEntityName(), clayChicken);
        ChickenRegistryObject coalChicken = new ChickenRegistryObject("coal_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/coal_chicken_item.png"), new ItemStack(Items.COAL), null, null, false);
        getChickenRegistry().put(coalChicken.getEntityName(), coalChicken);
        ChickenRegistryObject cowChicken = new ChickenRegistryObject("cow_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/cow_chicken_item.png"), new ItemStack(Items.LEATHER), null, null, false);
        getChickenRegistry().put(cowChicken.getEntityName(), cowChicken);
        ChickenRegistryObject enderChicken = new ChickenRegistryObject("ender_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/ender_chicken_item.png"), new ItemStack(Items.ENDER_PEARL), null, null, false);
        getChickenRegistry().put(enderChicken.getEntityName(), enderChicken);
        ChickenRegistryObject experienceChicken = new ChickenRegistryObject("experience_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/experience_chicken_item.png"), new ChickenDrop(ItemInit.SOLIDIFIED_EXPERIENCE, 1, 3), null, null, false);
        getChickenRegistry().put(experienceChicken.getEntityName(), experienceChicken);
        ChickenRegistryObject ghastChicken = new ChickenRegistryObject("ghast_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/ghast_chicken_item.png"), new ItemStack(Items.GHAST_TEAR), null, null, false);
        getChickenRegistry().put(ghastChicken.getEntityName(), ghastChicken);
        ChickenRegistryObject glassChicken = new ChickenRegistryObject("glass_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/glass_chicken_item.png"), new ItemStack(Items.GLASS), null, null, false);
        getChickenRegistry().put(glassChicken.getEntityName(), glassChicken);
        ChickenRegistryObject glowstoneChicken = new ChickenRegistryObject("glowstone_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/glowstone_chicken_item.png"), new ItemStack(Items.GLOWSTONE_DUST), null, null, false);
        getChickenRegistry().put(glowstoneChicken.getEntityName(), glowstoneChicken);
        ChickenRegistryObject gunpowderChicken = new ChickenRegistryObject("gunpowder_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/gunpowder_chicken_item.png"), new ItemStack(Items.GUNPOWDER), null, null, false);
        getChickenRegistry().put(gunpowderChicken.getEntityName(), gunpowderChicken);
        ChickenRegistryObject lavaChicken = new ChickenRegistryObject("lava_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/lava_chicken_item.png"), new ChickenDrop(ItemInit.LAVA_INFUSED_EGG, 1,1), null, null, false);
        getChickenRegistry().put(lavaChicken.getEntityName(), lavaChicken);
        ChickenRegistryObject magamaSlimeChicken = new ChickenRegistryObject("magma_slime_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/magma_slime_chicken_item.png"), new ItemStack(Items.MAGMA_CREAM), null, null, false);
        getChickenRegistry().put(magamaSlimeChicken.getEntityName(), magamaSlimeChicken);
        ChickenRegistryObject netherWartChicken = new ChickenRegistryObject("nether_wart_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/nether_wart_chicken_item.png"), new ItemStack(Items.NETHER_WART), null, null, false);
        getChickenRegistry().put(netherWartChicken.getEntityName(), netherWartChicken);
        ChickenRegistryObject oakLogChicken = new ChickenRegistryObject("oak_log_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/oak_log_chicken_item.png"), new ItemStack(Items.OAK_LOG), null, null, false);
        getChickenRegistry().put(oakLogChicken.getEntityName(), oakLogChicken);
        ChickenRegistryObject obsidianChicken = new ChickenRegistryObject("obsidian_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/obsidian_chicken_item.png"), new ItemStack(Items.OBSIDIAN), null, null, false);
        getChickenRegistry().put(obsidianChicken.getEntityName(), obsidianChicken);
        ChickenRegistryObject quartzChicken = new ChickenRegistryObject("quartz_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/quartz_chicken_item.png"), new ItemStack(Items.QUARTZ), null, null, false);
        getChickenRegistry().put(quartzChicken.getEntityName(), quartzChicken);
        ChickenRegistryObject sandChicken = new ChickenRegistryObject("sand_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/sand_chicken_item.png"), new ItemStack(Items.SAND), null, null, false);
        getChickenRegistry().put(sandChicken.getEntityName(), sandChicken);
        ChickenRegistryObject slimeChicken = new ChickenRegistryObject("slime_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/slime_chicken_item.png"), new ItemStack(Items.SLIME_BALL), null, null, false);
        getChickenRegistry().put(slimeChicken.getEntityName(), slimeChicken);
        ChickenRegistryObject snowballChicken = new ChickenRegistryObject("snowball_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/snowball_chicken_item.png"), new ItemStack(Items.SNOWBALL), null, null, false);
        getChickenRegistry().put(snowballChicken.getEntityName(), snowballChicken);
        ChickenRegistryObject soulSandChicken = new ChickenRegistryObject("soul_sand_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/soul_sand_chicken_item.png"), new ItemStack(Items.SOUL_SAND), null, null, false);
        getChickenRegistry().put(soulSandChicken.getEntityName(), soulSandChicken);
        ChickenRegistryObject spiderChicken = new ChickenRegistryObject("spider_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/spider_chicken_item.png"), new ItemStack(Items.STRING), null, null, false);
        getChickenRegistry().put(spiderChicken.getEntityName(), spiderChicken);
        ChickenRegistryObject waterChicken = new ChickenRegistryObject("water_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/water_chicken_item.png"), new ChickenDrop(ItemInit.WATER_INFUSED_EGG, 1,1), null, null, false);
        getChickenRegistry().put(waterChicken.getEntityName(), waterChicken);

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
        RegistryObject<EntityType<CustomChickenEntity>> customChickenEntity = EntityInit.ENTITY_TYPES.register(chicken.getEntityName() + "",
                () -> EntityType.Builder.create(CustomChickenEntity::new, EntityClassification.CREATURE)
                        .size(1.0f, 1.0f)
                        .build(new ResourceLocation(ResourcefulChickens.MODID, chicken.getEntityName()).toString()));
        RegistryObject<Item> customChickenItem = ItemInit.ITEMS.register(chicken.getEntityName() + "_item", () -> new ChickenItem(new Item.Properties().maxStackSize(16)));
        RegistryObject<Item> customChickenSpawnEgg = ItemInit.ITEMS.register(chicken.getEntityName() + "_spawn_egg", () -> new CustomSpawnEggItem(new Item.Properties()));
        if(chicken.isHasFeather()) {
            RegistryObject<Item> customChickenFeather = ItemInit.ITEMS.register(chicken.getEntityName() + "_feather", () -> new Item(new Item.Properties()));
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

}
