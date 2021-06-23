package io.github.TheBlackSquidward.resourcechickens.recipes.recipe;

import io.github.TheBlackSquidward.resourcechickens.init.ModRecipes;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChickenBreedingRecipe implements IRecipe<IInventory> {

    private final ResourceLocation recipeID;
    private final int totalBreedingTime;
    private final Ingredient[] input;
    private final ItemStack output;

    public ChickenBreedingRecipe(ResourceLocation recipeID, int totalBreedingTime, ItemStack output, Ingredient... input) {
        this.recipeID = recipeID;
        this.totalBreedingTime = totalBreedingTime;
        this.output = output;
        this.input = input;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean matches(IInventory p_77569_1_, World p_77569_2_) {
        return false;
    }

    @Override
    public ItemStack assemble(IInventory p_77572_1_) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public ResourceLocation getId() {
        return recipeID;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipes.CHICKEN_BREEDING_SERIALIZER.get();
    }
    @Override
    public IRecipeType<?> getType() {
        return ModRecipes.CHICKEN_BREEDING_RECIPE_TYPE;
    }

    public int getTotalBreedingTime() {
        return totalBreedingTime;
    }

    public ItemStack getOutput() {
        return output;
    }

    public Ingredient[] getInput() {
        return input;
    }

    public List<ItemStack> getInputs() {
        List<ItemStack> itemStacks = new ArrayList<>();
        for(Ingredient ingredient : input) {
            itemStacks.addAll(Arrays.asList(ingredient.getItems()));
        }
        return itemStacks;
    }
}
