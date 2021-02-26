package io.github.TheBlackSquidward.resourcechickens.registries;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityRegistry {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ResourceChickens.MODID);

}
