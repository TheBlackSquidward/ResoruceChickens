package io.github.TheBlackSquidward.resourcechickens.datagen;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.util.ResourceLocation;
import java.util.function.Consumer;

public class ResourceChickensRecipeProvider extends ResourceChickensRecipeProviderBase {

    private final String roostRecipePath = "roost/";

    public ResourceChickensRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {

    }
    private ResourceLocation getRoostPath(String fileName) {
        return new ResourceLocation(ResourceChickens.MOD_ID, "roost/" + fileName);
    }
    private ResourceLocation getChickenBreedingPath(String fileName) {
        return new ResourceLocation(ResourceChickens.MOD_ID, "chicken_breeding/" + fileName);
    }
}
