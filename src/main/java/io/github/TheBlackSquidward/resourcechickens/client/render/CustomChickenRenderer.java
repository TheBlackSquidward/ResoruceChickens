package io.github.TheBlackSquidward.resourcechickens.client.render;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.client.model.CustomChickenModel;
import io.github.TheBlackSquidward.resourcechickens.common.entities.CustomChickenEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CustomChickenRenderer extends MobRenderer<CustomChickenEntity, CustomChickenModel<CustomChickenEntity>> {
    public CustomChickenRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new CustomChickenModel<>(), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(CustomChickenEntity entity) {
        ChickenRegistryObject chickenRegistryObject = ChickenRegistry.getChickenRegistryObjectbyEntity(entity);
        return new ResourceLocation(ResourceChickens.MODID, "textures/entity/" + chickenRegistryObject.getEntityName() + ".png");
    }
}
