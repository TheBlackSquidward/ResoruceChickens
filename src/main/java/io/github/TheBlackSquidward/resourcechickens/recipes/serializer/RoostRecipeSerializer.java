package io.github.TheBlackSquidward.resourcechickens.recipes.serializer;

import com.google.gson.JsonObject;
import io.github.TheBlackSquidward.resourcechickens.api.ChanceItemStackList;
import io.github.TheBlackSquidward.resourcechickens.api.utils.Constants;
import io.github.TheBlackSquidward.resourcechickens.recipes.recipe.RoostRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class RoostRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<RoostRecipe> {

    @Override
    public RoostRecipe fromJson(ResourceLocation recipeID, JsonObject jsonObject) {
        Ingredient chicken = deserializeIngredient(jsonObject, Constants.JSON.INPUT);
        int totalRoostTime = JSONUtils.getAsInt(jsonObject, Constants.JSON.TOTAL_ROOST_TIME);
        ChanceItemStackList outputs = ChanceItemStackList.fromJSON(jsonObject.get(Constants.JSON.OUTPUT).getAsJsonArray());
        return new RoostRecipe(recipeID, totalRoostTime, chicken, outputs);
    }

    @Nullable
    @Override
    public RoostRecipe fromNetwork(ResourceLocation recipeID, PacketBuffer packetBuffer) {
        Ingredient chicken = Ingredient.fromNetwork(packetBuffer);
        int totalRoostTime = packetBuffer.readInt();
        ChanceItemStackList outputs = ChanceItemStackList.read(packetBuffer);
        return new RoostRecipe(recipeID, totalRoostTime, chicken, outputs);
    }

    @Override
    public void toNetwork(PacketBuffer packetBuffer, RoostRecipe recipe) {
        recipe.getIngredient().toNetwork(packetBuffer);
        packetBuffer.writeInt(recipe.getTotalRoostTime());
        recipe.getOutputs().write(packetBuffer);
    }

    private static Ingredient deserializeIngredient(JsonObject json, String key) {
        return Ingredient.fromJson((JSONUtils.isArrayNode(json, key) ? JSONUtils.getAsJsonArray(json, key) : JSONUtils.getAsJsonObject(json, key)));
    }

}
