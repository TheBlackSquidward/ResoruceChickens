package io.github.TheBlackSquidward.resourcechickens.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.github.TheBlackSquidward.resourcechickens.api.CustomChickenData;
import io.github.TheBlackSquidward.resourcechickens.blocks.roost.AbstractRoostBlock;
import io.github.TheBlackSquidward.resourcechickens.te.roost.AbstractRoostTE;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

import javax.annotation.ParametersAreNonnullByDefault;

public class RoostTileEntityRenderer extends TileEntityRenderer<AbstractRoostTE> {

    public static final ChickenModel roostingChickenModel = new ChickenModel();

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
        IVertexBuilder renderBuffer = vertexBuilder.getBuffer(ChickenModel.getRenderType(getChickenTexture(roost.getRoostingChickenData())));
        roostingChickenModel.chin.render(matrixStack, renderBuffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
        roostingChickenModel.head.render(matrixStack, renderBuffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
        roostingChickenModel.bill.render(matrixStack, renderBuffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
        roostingChickenModel.body.render(matrixStack, renderBuffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
        roostingChickenModel.leftWing.render(matrixStack, renderBuffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
        roostingChickenModel.rightWing.render(matrixStack, renderBuffer, combinedLight, combinedOverlay, 1, 1, 1, 1);
        matrixStack.popPose();
    }

    private static class ChickenModel extends Model {
        public ModelRenderer head;
        public ModelRenderer body;
        public ModelRenderer rightLeg;
        public ModelRenderer leftLeg;
        public ModelRenderer rightWing;
        public ModelRenderer leftWing;
        public ModelRenderer bill;
        public ModelRenderer chin;

        public ChickenModel() {
            super(ChickenModel::getRenderType);
            this.head = new ModelRenderer(this, 0, 0);
            this.head.addBox(-2.0F, -6.0F, -2.0F, 4, 6, 3, 0.0F);
            this.head.setPos(0.0F, 15.0F, -4.0F);
            this.bill = new ModelRenderer(this, 14, 0);
            this.bill.addBox(-2.0F, -4.0F, -4.0F, 4, 2, 2, 0.0F);
            this.bill.setPos(0.0F, 15.0F, -4.0F);
            this.chin = new ModelRenderer(this, 14, 4);
            this.chin.addBox(-1.0F, -2.0F, -3.0F, 2, 2, 2, 0.0F);
            this.chin.setPos(0.0F, 15.0F, -4.0F);
            this.body = new ModelRenderer(this, 0, 9);
            this.body.addBox(-3.0F, -4.0F, -3.0F, 6, 8, 6, 0.0F);
            this.body.setPos(0.0F, 16.0F, 0.0F);
            this.rightLeg = new ModelRenderer(this, 26, 0);
            this.rightLeg.addBox(-1.0F, 0.0F, -3.0F, 3, 5, 3);
            this.rightLeg.setPos(-2.0F, 19.0F, 1.0F);
            this.leftLeg = new ModelRenderer(this, 26, 0);
            this.leftLeg.addBox(-1.0F, 0.0F, -3.0F, 3, 5, 3);
            this.leftLeg.setPos(1.0F, 19.0F, 1.0F);
            this.rightWing = new ModelRenderer(this, 24, 13);
            this.rightWing.addBox(0.0F, 0.0F, -3.0F, 1, 4, 6);
            this.rightWing.setPos(-4.0F, 13.0F, 0.0F);
            this.leftWing = new ModelRenderer(this, 24, 13);
            this.leftWing.addBox(-1.0F, 0.0F, -3.0F, 1, 4, 6);
            this.leftWing.setPos(4.0F, 13.0F, 0.0F);
        }

        public static RenderType getRenderType(ResourceLocation resourceLocation) {
            return RenderType.entityTranslucent(resourceLocation);
        }

        @ParametersAreNonnullByDefault
        @Override
        public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder iVertexBuilder, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        }

    }

}

