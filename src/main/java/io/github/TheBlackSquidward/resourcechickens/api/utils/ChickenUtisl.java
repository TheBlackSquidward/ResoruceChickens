package io.github.TheBlackSquidward.resourcechickens.api.utils;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class ChickenUtisl {

    public static @Nullable EntityType<?> getEntityType(ResourceLocation entityId) {
        return ForgeRegistries.ENTITIES.getValue(entityId);
    }

    public static Item getItem(String itemName) {
        return ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(itemName));
    }
}
