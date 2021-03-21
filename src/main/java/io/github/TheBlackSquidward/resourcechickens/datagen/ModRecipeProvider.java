package io.github.TheBlackSquidward.resourcechickens.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        //TODO all base egg recipes
        //TODO upgrade recipes
        //TODO fertiliser recipes
        //TODO block recipes
    }
}
