package io.github.TheBlackSquidward.resourcechickens.recipes.builder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.github.TheBlackSquidward.resourcechickens.api.utils.Constants;
import io.github.TheBlackSquidward.resourcechickens.api.utils.JsonUtils;
import io.github.TheBlackSquidward.resourcechickens.init.RecipeInit;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChickenBreedingBuilder {

    private final List<Ingredient> input = new ArrayList<>();
    private int totalBreedTime;
    private ItemStack output;

    public ChickenBreedingBuilder setOutput(ItemStack output) {
        this.output = output;
        return this;
    }

    public ChickenBreedingBuilder setTotalBreedTime(int totalBreedTime) {
        this.totalBreedTime = totalBreedTime;
        return this;
    }

    public ChickenBreedingBuilder addInput(Ingredient input) {
        this.input.add(input);
        return this;
    }

    public static ChickenBreedingBuilder newChickenBreedingRecipe() {
        return new ChickenBreedingBuilder();
    }

    public void build(Consumer<IFinishedRecipe> consumer, ResourceLocation id) {
        Ingredient[] ingredients = input.toArray(new Ingredient[0]);
        consumer.accept(new ChickenBreedingBuilder.Result(id, this.totalBreedTime, this.output, ingredients));
    }

    private static class Result implements IFinishedRecipe{
        private final ResourceLocation recipeID;
        private final int totalBreedTime;
        private final ItemStack output;
        private final Ingredient[] input;

        public Result(ResourceLocation recipeID, int totalBreedTime, ItemStack output, Ingredient[] input) {
            this.recipeID = recipeID;
            this.totalBreedTime = totalBreedTime;
            this.output = output;
            this.input = input;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            json.addProperty(Constants.JSON.TOTAL_BREED_TIME, this.totalBreedTime);
            json.add(Constants.JSON.INPUT, toJson(input));
            json.add(Constants.JSON.OUTPUT, JsonUtils.serializeItemStack(output));
        }

        @Override
        public ResourceLocation getId() {
            return this.recipeID;
        }

        @Override
        public IRecipeSerializer<?> getType() {
            return RecipeInit.CHICKEN_BREEDING_SERIALIZER.get();
        }

        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }

        private JsonArray toJson(Ingredient[] input) {
            JsonArray jsonArray = new JsonArray();
            for(Ingredient ingredient : input) {
                jsonArray.add(ingredient.toJson());
            }
            return jsonArray;
        }
    }
}
