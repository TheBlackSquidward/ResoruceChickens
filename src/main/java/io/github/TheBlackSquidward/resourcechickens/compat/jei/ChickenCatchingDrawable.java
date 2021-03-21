package io.github.TheBlackSquidward.resourcechickens.compat.jei;

import com.mojang.blaze3d.matrix.MatrixStack;
import mezz.jei.api.gui.ITickTimer;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;

public class ChickenCatchingDrawable implements IDrawable {

    private final IDrawableStatic drawable;

    private final ITickTimer tickTimer;

    public ChickenCatchingDrawable(IDrawableStatic drawable, ITickTimer tickTimer) {
        this.drawable = drawable;
        this.tickTimer = tickTimer;
    }

    public int getWidth() {
        return 24;
    }

    public int getHeight() {
        return 14;
    }

    public void draw(MatrixStack matrixStack) {
        draw(matrixStack, 0, 0);
    }

    public void draw(MatrixStack matrixStack, int xOffset, int yOffset) {
        int animationValue = this.tickTimer.getValue();
        int maxValue = this.tickTimer.getMaxValue();
        int maskTop = 14 * animationValue;
        int maskBottom = 14 * (maxValue - animationValue - 1);
        this.drawable.draw(matrixStack, xOffset, yOffset - maskTop, maskTop, maskBottom, 0, 0);
    }

}
