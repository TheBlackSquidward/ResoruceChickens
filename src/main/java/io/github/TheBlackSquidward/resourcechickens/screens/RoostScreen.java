package io.github.TheBlackSquidward.resourcechickens.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.containers.RoostContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import org.jetbrains.annotations.NotNull;

public class RoostScreen extends ContainerScreen<RoostContainer> {

    private final ResourceLocation GUI = new ResourceLocation(ResourceChickens.MOD_ID, "textures/gui/roost_gui.png");

    RoostContainer roostContainer;

    public RoostScreen(RoostContainer container, PlayerInventory inv, ITextComponent name) {
        super(container, inv, name);
        roostContainer = container;
    }

    @Override
    protected void renderBg(@NotNull MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.getMinecraft().getTextureManager().bind(GUI);
        int relX = (this.width - this.getXSize()) / 2;
        int relY = (this.height - this.getYSize()) / 2;
        this.blit(matrixStack, relX, relY, 0, 0, this.getXSize(), this.getYSize());
        this.blit(matrixStack, relX + 48, relY + 20, 176, 0, getProgressWidth(), 16);
    }

    @Override
    public void render(@NotNull MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    private int getProgressWidth() {
        double progress = this.roostContainer.getProgress();
        return (progress == 0.0D) ? 0 : (1 + (int) (progress * 25.0D));
    }


}
