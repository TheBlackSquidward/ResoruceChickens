package io.github.TheBlackSquidward.resourcechickens.compat.jei;

import io.github.TheBlackSquidward.resourcechickens.api.data.chickenData.RoostData;
import io.github.TheBlackSquidward.resourcechickens.recipes.RoostRecipe;
import mezz.jei.api.gui.ingredient.ITooltipCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.StringTextComponent;

import javax.annotation.ParametersAreNonnullByDefault;
import java.text.DecimalFormat;
import java.util.List;

public class RoostTooltipCallback implements ITooltipCallback<ItemStack> {

    private static final DecimalFormat FORMATTER = new DecimalFormat("0.0%");

    private final RoostRecipe roostRecipe;

    public RoostTooltipCallback(RoostRecipe roostRecipe) {
        this.roostRecipe = roostRecipe;
    }

    @ParametersAreNonnullByDefault
    @Override
    public void onTooltip(int slotIndex, boolean input, ItemStack ingredient, List tooltip) {
        if(!input) {
            RoostData roostData = roostRecipe.getCustomChickenData().getRoostData();
            roostData.getRoostOutputs().forEach((roostOutputData) -> {
                if(ingredient.sameItem(roostOutputData.getItemOutputData().getDisplayItem())) {
                    tooltip.add(new StringTextComponent("Minimum Drop Amount: " + roostOutputData.getItemOutputData().getMinAmount()));
                    tooltip.add(new StringTextComponent("Maximum Drop Amount: " + roostOutputData.getItemOutputData().getMaxAmount()));
                    tooltip.add(new StringTextComponent("Chance: " + FORMATTER.format(roostOutputData.getChance())));
                }
            });
        }
    }
}
