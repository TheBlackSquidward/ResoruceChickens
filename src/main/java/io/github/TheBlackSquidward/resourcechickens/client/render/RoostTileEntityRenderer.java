package io.github.TheBlackSquidward.resourcechickens.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.blocks.RoostBlock;
import io.github.TheBlackSquidward.resourcechickens.te.RoostTE;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class RoostTileEntityRenderer extends TileEntityRenderer<RoostTE> {

    public static final ChickenModel roostingChickenModel = new ChickenModel();

    public RoostTileEntityRenderer(TileEntityRendererDispatcher tileEntityRendererDispatcher) {
        super(tileEntityRendererDispatcher);
    }

    @Override
    public void render(RoostTE roostTE, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer vertexBuilder, int combinedLight, int combinedOverlay) {
        if (roostTE.hasChicken()) {
            renderChicken(matrixStack, roostTE, vertexBuilder, combinedLight, combinedOverlay);
        }
    }

    //TODO rendering dark
    public void renderChicken(MatrixStack matrixStack, RoostTE roostTE, IRenderTypeBuffer vertexBuilder, int combinedLight, int combinedOverlay) {
        int light = getLightAtPos(roostTE.getWorld(), roostTE.getBlockPos());
        int overlay = combinedOverlay;

        int red = 2;
        int green = 2;
        int blue = 2;
        int alpha = 2;

        ResourceChickens.LOGGER.debug(light);

        BlockState blockState = roostTE.getBlockState();
        Direction direction = blockState.getValue(RoostBlock.FACING);
        float scale = 1f;
        matrixStack.pushPose();
        matrixStack.translate(0.5, 1.3, 0.5);
        matrixStack.scale(scale, scale, scale);
        matrixStack.mulPose(Vector3f.YN.rotationDegrees(direction.toYRot()));
        matrixStack.mulPose(Vector3f.XP.rotationDegrees(180));
        IVertexBuilder renderBuffer = vertexBuilder.getBuffer(roostingChickenModel.getRenderType(getChickenTexture(roostTE.getRoostingChicken())));
        roostingChickenModel.chin.render(matrixStack, renderBuffer, light, overlay, red, green, blue, alpha);
        roostingChickenModel.head.render(matrixStack, renderBuffer, light, overlay, red, green, blue, alpha);
        roostingChickenModel.bill.render(matrixStack, renderBuffer, light, overlay, red, green, blue, alpha);
        roostingChickenModel.body.render(matrixStack, renderBuffer, light, overlay, red, green, blue, alpha);
        roostingChickenModel.leftWing.render(matrixStack, renderBuffer, light, overlay, red, green, blue, alpha);
        roostingChickenModel.rightWing.render(matrixStack, renderBuffer, light, overlay, red, green, blue, alpha);
        matrixStack.popPose();
    }

    private static ResourceLocation getChickenTexture(ChickenRegistryObject chickenRegistryObject) {
        if(chickenRegistryObject == null) {
            return new ResourceLocation("minecraft:textures/entity/chicken.png");
        }else {
            return new ResourceLocation("resourcechickens:textures/entity/" + chickenRegistryObject.getEntityName() + ".png");
        }
    }

    private int getLightAtPos(World world, BlockPos pos) {
        int blockLight = world.getBrightness(LightType.BLOCK, pos);
        int skyLight = world.getBrightness(LightType.SKY, pos);
        return LightTexture.pack(blockLight, skyLight);
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
            super(RenderType::entityTranslucent);
            int i = 16;
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

        public RenderType getRenderType(ResourceLocation resourceLocation) {
            return RenderType.entityCutoutNoCull(resourceLocation);
        }

        public void setupAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            this.head.xRot = headPitch * 0.017453292F;
            this.head.yRot = netHeadYaw * 0.017453292F;
            this.bill.xRot = this.head.xRot;
            this.bill.yRot = this.head.yRot;
            this.chin.xRot = this.head.xRot;
            this.chin.yRot = this.head.yRot;
            this.body.xRot = ((float)Math.PI / 2F);
            this.rightLeg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
            this.leftLeg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
            this.rightWing.zRot = ageInTicks;
            this.leftWing.zRot = -ageInTicks;
        }

        public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
            this.setupAnim(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        }

        @Override
        public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder iVertexBuilder, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        }
    }

}

