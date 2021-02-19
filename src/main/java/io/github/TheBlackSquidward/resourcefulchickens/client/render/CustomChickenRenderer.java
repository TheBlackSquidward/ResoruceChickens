package io.github.TheBlackSquidward.resourcefulchickens.client.render;

import io.github.TheBlackSquidward.resourcefulchickens.ResourcefulChickens;
import io.github.TheBlackSquidward.resourcefulchickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcefulchickens.common.entities.CustomChickenEntity;
import io.github.TheBlackSquidward.resourcefulchickens.client.model.CustomChickenModel;
import io.github.TheBlackSquidward.resourcefulchickens.api.ChickenRegistry;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CustomChickenRenderer extends MobRenderer<CustomChickenEntity, CustomChickenModel<CustomChickenEntity>> {
    public CustomChickenRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new CustomChickenModel<>(), 0.3f);
    }

    @Override
    public ResourceLocation getEntityTexture(CustomChickenEntity entity) {
        ChickenRegistryObject chickenRegistryObject = ChickenRegistry.getChickenRegistryObjectbyEntity(entity);
        return new ResourceLocation(ResourcefulChickens.MODID, "textures/entity/" + chickenRegistryObject.getEntityName() + ".png");
    }
}
