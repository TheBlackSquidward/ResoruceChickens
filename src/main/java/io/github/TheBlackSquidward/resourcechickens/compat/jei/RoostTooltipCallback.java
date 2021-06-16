package io.github.TheBlackSquidward.resourcechickens.compat.jei;

import io.github.TheBlackSquidward.resourcechickens.recipes.recipe.RoostRecipe;
import mezz.jei.api.gui.ingredient.ITooltipCallback;

import java.util.List;

public class RoostTooltipCallback implements ITooltipCallback {

    private final RoostRecipe roostRecipe;

    public RoostTooltipCallback(RoostRecipe roostRecipe) {
        this.roostRecipe = roostRecipe;
    }

    @Override
    public void onTooltip(int slotIndex, boolean input, Object ingredient, List tooltip) {
        //TODO
    }

}
