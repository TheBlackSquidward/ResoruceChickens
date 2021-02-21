package io.github.TheBlackSquidward.resourcefulchickens.registries;

import io.github.TheBlackSquidward.resourcefulchickens.ResourcefulChickens;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityRegistry {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ResourcefulChickens.MODID);

}
