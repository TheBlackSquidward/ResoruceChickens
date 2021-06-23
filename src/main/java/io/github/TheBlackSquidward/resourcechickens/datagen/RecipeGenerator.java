package io.github.TheBlackSquidward.resourcechickens.datagen;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.*;
import io.github.TheBlackSquidward.resourcechickens.recipes.builder.ChickenBreedingBuilder;
import io.github.TheBlackSquidward.resourcechickens.recipes.builder.RoostRecipeBuidler;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProviderBase{

    private final String roostRecipePath = "roost/";

    public RecipeGenerator(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {

    }

    private ResourceLocation getRoostPath(String fileName) {
        return new ResourceLocation(ResourceChickens.MODID, "roost/" + fileName);
    }
    private ResourceLocation getChickenBreedingPath(String fileName) {
        return new ResourceLocation(ResourceChickens.MODID, "chicken_breeding/" + fileName);
    }
}
