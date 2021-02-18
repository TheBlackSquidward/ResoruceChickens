package io.github.TheBlackSquidward.resourcefulchickens.init;

import io.github.TheBlackSquidward.resourcefulchickens.ResourcefulChickens;
import io.github.TheBlackSquidward.resourcefulchickens.chickens.chickens.GoldChickenEntity;
import io.github.TheBlackSquidward.resourcefulchickens.chickens.chickens.IronChickenEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ResourcefulChickens.MODID);

    /*

    //Entities
    public static final RegistryObject<EntityType<IronChickenEntity>> IRON_CHICKEN = ENTITY_TYPES.register("iron_chicken",
            () -> EntityType.Builder.create(IronChickenEntity::new, EntityClassification.CREATURE)
                    .size(1.0f, 1.0f)
                    .build(new ResourceLocation(ResourcefulChickens.MODID, "chicken").toString()));
    public static final RegistryObject<EntityType<GoldChickenEntity>> GOLD_CHICKEN = ENTITY_TYPES.register("gold_chicken",
            () -> EntityType.Builder.create(GoldChickenEntity::new, EntityClassification.CREATURE)
                    .size(1.0f, 1.0f)
                    .build(new ResourceLocation(ResourcefulChickens.MODID, "chicken").toString()));


     */

}
