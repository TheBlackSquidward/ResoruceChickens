package io.github.TheBlackSquidward.resourcechickens.recipes;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.CustomChickenData;
import io.github.TheBlackSquidward.resourcechickens.api.utils.ChickenUtisl;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.List;

public class ChickenBreedingRecipe {

    CustomChickenData customChickenData;

    public ChickenBreedingRecipe(CustomChickenData customChickenData) {
        this.customChickenData = customChickenData;
    }

    public List<ItemStack> getInputs() {
        ItemStack parent1 = new ItemStack(ChickenUtisl.getItem(ResourceChickens.MOD_ID + ":" + customChickenData.getBreedData().getParent1() + "_chicken_item"));
        ItemStack parent2 = new ItemStack(ChickenUtisl.getItem(ResourceChickens.MOD_ID + ":" + customChickenData.getBreedData().getParent2() + "_chicken_item"));
        return Arrays.asList(parent1, parent2);
    }

    public ItemStack getOutput() {
        return customChickenData.getChickenItem();
    }
}
