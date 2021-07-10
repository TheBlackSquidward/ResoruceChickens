package io.github.TheBlackSquidward.resourcechickens.init;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.entities.CustomChickenEntity;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ModEntities {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ResourceChickens.MOD_ID);

    private static final Map<String, RegistryObject<EntityType<? extends CustomChickenEntity>>> MOD_CHICKENS = new HashMap<>();

    public static Map<String, RegistryObject<EntityType<? extends CustomChickenEntity>>> getModChickens() {
        return MOD_CHICKENS;
    }

    public static Set<RegistryObject<EntityType<? extends CustomChickenEntity>>> getSetofModChickens() {
        return new HashSet<>(MOD_CHICKENS.values());
    }

}
