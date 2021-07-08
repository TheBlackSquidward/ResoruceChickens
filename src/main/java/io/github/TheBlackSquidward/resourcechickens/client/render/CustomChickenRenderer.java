package io.github.TheBlackSquidward.resourcechickens.client.render;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.entities.CustomChickenEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.ChickenModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class CustomChickenRenderer extends MobRenderer<CustomChickenEntity, ChickenModel<CustomChickenEntity>> {

    public CustomChickenRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new ChickenModel<>(), 0.3F);
    }

    @NotNull
    public ResourceLocation getTextureLocation(CustomChickenEntity customChickenEntity) {
        return new ResourceLocation(ResourceChickens.MOD_ID, "textures/entity/" + customChickenEntity.getChickenName() + "_chicken.png");
    }

    protected float getBob(CustomChickenEntity customChickenEntity, float partialTicks) {
        float f = MathHelper.lerp(partialTicks, customChickenEntity.oFlap, customChickenEntity.flap);
        float f1 = MathHelper.lerp(partialTicks, customChickenEntity.oFlapSpeed, customChickenEntity.flapSpeed);
        return (MathHelper.sin(f) + 1.0F) * f1;
    }

}
