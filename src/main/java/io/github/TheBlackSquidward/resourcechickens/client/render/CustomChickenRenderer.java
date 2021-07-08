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

    protected float getBob(CustomChickenEntity pLivingBase, float pPartialTicks) {
        float f = MathHelper.lerp(pPartialTicks, pLivingBase.oFlap, pLivingBase.flap);
        float f1 = MathHelper.lerp(pPartialTicks, pLivingBase.oFlapSpeed, pLivingBase.flapSpeed);
        return (MathHelper.sin(f) + 1.0F) * f1;
    }

}
