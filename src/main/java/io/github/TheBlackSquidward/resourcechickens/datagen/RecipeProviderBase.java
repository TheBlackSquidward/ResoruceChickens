package io.github.TheBlackSquidward.resourcechickens.datagen;

import io.github.TheBlackSquidward.resourcechickens.recipes.recipe.RoostRecipe;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.RecipeProvider;
import net.minecraftforge.common.data.ForgeRecipeProvider;

public abstract class RecipeProviderBase extends ForgeRecipeProvider {

    public RecipeProviderBase(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

}
