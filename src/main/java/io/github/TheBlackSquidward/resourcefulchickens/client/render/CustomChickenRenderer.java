package io.github.TheBlackSquidward.resourcefulchickens.client.render;

import io.github.TheBlackSquidward.resourcefulchickens.ResourcefulChickens;
import io.github.TheBlackSquidward.resourcefulchickens.chickens.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcefulchickens.chickens.CustomChickenEntity;
import io.github.TheBlackSquidward.resourcefulchickens.client.model.CustomChickenModel;
import io.github.TheBlackSquidward.resourcefulchickens.init.EntityInit;
import io.github.TheBlackSquidward.resourcefulchickens.utils.ChickenRegistry;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.swing.text.html.parser.Entity;

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
