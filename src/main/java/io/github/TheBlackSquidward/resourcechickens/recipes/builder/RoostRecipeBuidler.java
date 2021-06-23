package io.github.TheBlackSquidward.resourcechickens.recipes.builder;

import com.google.gson.JsonObject;
import io.github.TheBlackSquidward.resourcechickens.api.ChanceItemStack;
import io.github.TheBlackSquidward.resourcechickens.api.ChanceItemStackList;
import io.github.TheBlackSquidward.resourcechickens.api.utils.Constants;
import io.github.TheBlackSquidward.resourcechickens.init.ModRecipes;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class RoostRecipeBuidler {

    private Ingredient chicken;
    private int totalRoostTime;
    private final ChanceItemStackList results = new ChanceItemStackList();

    public RoostRecipeBuidler setChicken(Ingredient chicken) {
        this.chicken = chicken;
        return this;
    }

    public RoostRecipeBuidler setTotalRoostTime(int totalRoostTime) {
        this.totalRoostTime = totalRoostTime;
        return this;
    }

    public RoostRecipeBuidler addOutput(ChanceItemStack chanceItemStack) {
        this.results.addChanceItemStack(chanceItemStack);
        return this;
    }

    public static RoostRecipeBuidler newRoostRecipe() {
        return new RoostRecipeBuidler();
    }

    public void build(Consumer<IFinishedRecipe> consumer, ResourceLocation id) {
        consumer.accept(new Result(id, this.totalRoostTime, this.chicken, this.results));
    }

    public static class Result implements IFinishedRecipe{

        private final ResourceLocation recipeID;
        private final int totalRoostTime;
        private final Ingredient chicken;
        private final ChanceItemStackList results;

        public Result(ResourceLocation recipeID, int totalRoostTime, Ingredient chicken, ChanceItemStackList results) {
            this.recipeID = recipeID;
            this.totalRoostTime = totalRoostTime;
            this.chicken = chicken;
            this.results = results;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            json.addProperty(Constants.JSON.TOTAL_ROOST_TIME, this.totalRoostTime);
            json.add(Constants.JSON.INPUT, this.chicken.toJson());
            json.add(Constants.JSON.OUTPUT, results.toJSON());
        }

        @Override
        public ResourceLocation getId() {
            return this.recipeID;
        }

        @Override
        public IRecipeSerializer<?> getType() {
            return ModRecipes.ROOST_SERIALIZER.get();
        }

        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }


}
