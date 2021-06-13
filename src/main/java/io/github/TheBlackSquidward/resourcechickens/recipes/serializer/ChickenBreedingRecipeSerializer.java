package io.github.TheBlackSquidward.resourcechickens.recipes.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.github.TheBlackSquidward.resourcechickens.api.utils.Constants;
import io.github.TheBlackSquidward.resourcechickens.recipes.recipe.ChickenBreedingRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ChickenBreedingRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ChickenBreedingRecipe> {

    @Override
    public ChickenBreedingRecipe fromJson(ResourceLocation recipeID, JsonObject jsonObject) {
        List<Ingredient> input = new ArrayList<>();
        for(JsonElement jsonElement : jsonObject.getAsJsonArray(Constants.JSON.INPUT)) {
            input.add(Ingredient.fromJson(jsonElement));
        }
        int totalBreedingTime = JSONUtils.getAsInt(jsonObject, Constants.JSON.TOTAL_BREED_TIME);
        ItemStack output = CraftingHelper.getItemStack(jsonObject.getAsJsonObject(Constants.JSON.OUTPUT), true);
        return new ChickenBreedingRecipe(recipeID, totalBreedingTime, output, input.toArray(new Ingredient[0]));
    }

    @Nullable
    @Override
    public ChickenBreedingRecipe fromNetwork(ResourceLocation recipeID, PacketBuffer packetBuffer) {
        Ingredient[] input = new Ingredient[packetBuffer.readInt()];
        for (int i = 0; i < input.length; i++) {
            input[i] = Ingredient.fromNetwork(packetBuffer);
        }
        int totalBreedingTime = packetBuffer.readInt();
        ItemStack output = packetBuffer.readItem();
        return new ChickenBreedingRecipe(recipeID, totalBreedingTime, output, input);
    }

    @Override
    public void toNetwork(PacketBuffer packetBuffer, ChickenBreedingRecipe recipe) {
        packetBuffer.writeInt(recipe.getInput().length);
        for(Ingredient ingredient : recipe.getInput()) {
            ingredient.toNetwork(packetBuffer);
        }
        packetBuffer.writeInt(recipe.getTotalBreedingTime());
        packetBuffer.writeItem(recipe.getOutput());
    }

}
