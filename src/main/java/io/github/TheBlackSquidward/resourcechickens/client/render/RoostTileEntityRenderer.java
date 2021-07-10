package io.github.TheBlackSquidward.resourcechickens.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.github.TheBlackSquidward.resourcechickens.api.CustomChickenData;
import io.github.TheBlackSquidward.resourcechickens.blocks.roost.AbstractRoostBlock;
import io.github.TheBlackSquidward.resourcechickens.entities.CustomChickenEntity;
import io.github.TheBlackSquidward.resourcechickens.te.roost.AbstractRoostTE;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.model.ChickenModel;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

import javax.annotation.ParametersAreNonnullByDefault;

public class RoostTileEntityRenderer extends TileEntityRenderer<AbstractRoostTE> {

    public static final ChickenModel<CustomChickenEntity> roostingChickenModel = new ChickenModel<>();

    public RoostTileEntityRenderer(TileEntityRendererDispatcher tileEntityRendererDispatcher) {
        super(tileEntityRendererDispatcher);
    }

    private static ResourceLocation getChickenTexture(CustomChickenData customChickenData) {
        if(customChickenData == null) {
            return new ResourceLocation("minecraft:textures/entity/chicken.png");
        }else {
            return new ResourceLocation("resourcechickens:textures/entity/" + customChickenData.getCoreData().getName() + "_chicken.png");
        }
    }

    @ParametersAreNonnullByDefault
    @Override
    public void render(AbstractRoostTE roost, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer vertexBuilder, int combinedLight, int combinedOverlay) {
        if (roost.hasChicken()) {
            renderChicken(matrixStack, roost, vertexBuilder, combinedLight, combinedOverlay);
        }
    }

    public void renderChicken(MatrixStack matrixStack, AbstractRoostTE roost, IRenderTypeBuffer vertexBuilder, int combinedLight, int combinedOverlay) {
        BlockState blockState = roost.getBlockState();
        Direction direction = blockState.getValue(AbstractRoostBlock.FACING);
        float scale = 1f;
        matrixStack.pushPose();
        matrixStack.translate(0.5, 1.3, 0.5);
        matrixStack.scale(scale, scale, scale);
        matrixStack.mulPose(Vector3f.YN.rotationDegrees(direction.toYRot()));
        matrixStack.mulPose(Vector3f.XP.rotationDegrees(180));
        IVertexBuilder renderBuffer = vertexBuilder.getBuffer(roostingChickenModel.renderType(getChickenTexture(roost.getRoostingChickenData())));
        roostingChickenModel.redThing.render(matrixStack, renderBuffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
        roostingChickenModel.head.render(matrixStack, renderBuffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
        roostingChickenModel.beak.render(matrixStack, renderBuffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
        roostingChickenModel.body.render(matrixStack, renderBuffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
        roostingChickenModel.wing0.render(matrixStack, renderBuffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
        roostingChickenModel.wing1.render(matrixStack, renderBuffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
        matrixStack.popPose();
    }

}

