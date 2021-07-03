package io.github.TheBlackSquidward.resourcechickens.client.render;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.client.model.CustomChickenModel;
import io.github.TheBlackSquidward.resourcechickens.entities.CustomChickenEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

public class CustomChickenRenderer extends MobRenderer<CustomChickenEntity, CustomChickenModel<CustomChickenEntity>> {
    public CustomChickenRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new CustomChickenModel<>(), 0.3f);
    }

    @ParametersAreNonnullByDefault
    @Nullable
    @Override
    protected RenderType getRenderType(CustomChickenEntity customChickenEntity, boolean p_230496_2_, boolean p_230496_3_, boolean p_230496_4_) {
        return RenderType.entityTranslucent(this.getTextureLocation(customChickenEntity));
    }

    @ParametersAreNonnullByDefault
    @Override
    public ResourceLocation getTextureLocation(CustomChickenEntity entity) {
        return new ResourceLocation(ResourceChickens.MOD_ID, "textures/entity/" + entity.getChickenName() + "_chicken.png");
    }
}
