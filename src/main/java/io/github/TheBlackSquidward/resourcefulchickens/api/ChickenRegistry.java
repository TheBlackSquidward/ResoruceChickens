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

        ChickenRegistryObject greenChicken = new ChickenRegistryObject("green_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/green_chicken_item.png"), new ItemStack(Items.GREEN_DYE), 15921906, Color.GREEN.getRGB(), null, null, false);
        getChickenRegistry().put(greenChicken.getEntityName(), greenChicken);

        ChickenRegistryObject ironChicken = new ChickenRegistryObject("iron_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/iron_chicken_item.png"), new ItemStack(Items.IRON_INGOT), 16777164, 16764108, null, null, true);
        getChickenRegistry().put(ironChicken.getEntityName(), ironChicken);

        ChickenRegistryObject goldChicken = new ChickenRegistryObject("gold_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/gold_chicken_item.png"), new ItemStack(Items.GOLD_INGOT), 13421568, 16777088, null, null, true);
        getChickenRegistry().put(goldChicken.getEntityName(), goldChicken);

        ChickenRegistryObject diamondChicken = new ChickenRegistryObject("diamond_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/diamond_chicken_item.png"), new ItemStack(Items.DIAMOND), 10079487, 15135487, null, null, true);
        getChickenRegistry().put(diamondChicken.getEntityName(), diamondChicken);

        ChickenRegistryObject emeraldChicken = new ChickenRegistryObject("emerald_chicken", new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/emerald_chicken_item.png"), new ItemStack(Items.EMERALD), 52224, 13056, null, null, true);
        getChickenRegistry().put(emeraldChicken.getEntityName(), emeraldChicken);

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
