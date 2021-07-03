package io.github.TheBlackSquidward.resourcechickens.api2.utils;

import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class ChickenUtisl {

    public static @Nullable
    EntityType<?> getEntityType(String entityName) {
        return ForgeRegistries.ENTITIES.getValue(ResourceLocation.tryParse(entityName));
    }

    public static @Nullable EntityType<?> getEntityType(ResourceLocation entityId) {
        return ForgeRegistries.ENTITIES.getValue(entityId);
    }
}
