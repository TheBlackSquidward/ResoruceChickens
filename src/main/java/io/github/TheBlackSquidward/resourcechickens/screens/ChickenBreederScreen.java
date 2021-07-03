package io.github.TheBlackSquidward.resourcechickens.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.containers.ChickenBreederContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ChickenBreederScreen extends ContainerScreen<ChickenBreederContainer> {

    private final ResourceLocation GUI = new ResourceLocation(ResourceChickens.MOD_ID, "textures/gui/chicken_breeder_gui.png");

    ChickenBreederContainer chickenBreederContainer;

    public ChickenBreederScreen(ChickenBreederContainer container, PlayerInventory inv, ITextComponent name) {
        super(container, inv, name);
        chickenBreederContainer = container;
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.getMinecraft().getTextureManager().bind(GUI);
        int relX = (this.width - this.getXSize()) / 2;
        int relY = (this.height - this.getYSize()) / 2;
        this.blit(matrixStack, relX, relY, 0, 0, this.getXSize(), this.getYSize());
        this.blit(matrixStack, relX + 84, relY + 22, 176, 0, getProgressWidth(), 12);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
        int x = this.getGuiLeft();
        int y = (this.height - this.getYSize()) / 2;
        if (mouseX > x + 84 && mouseX < x + 110 && mouseY > y + 22 && mouseY < y + 34) {
            this.renderTooltip(matrixStack, new TranslationTextComponent("Progress: " + this.chickenBreederContainer.tileEntity.getFormattedProgress(this.chickenBreederContainer.getProgress())), mouseX, mouseY);
        }
    }

    private int getProgressWidth() {
        double progress = this.chickenBreederContainer.getProgress();
        return (progress == 0.0D) ? 0 : (1 + (int) (progress * 25.0D));
    }
}
