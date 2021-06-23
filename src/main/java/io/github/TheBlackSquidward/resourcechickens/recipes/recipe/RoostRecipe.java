package io.github.TheBlackSquidward.resourcechickens.recipes.recipe;

import io.github.TheBlackSquidward.resourcechickens.api.ChanceItemStackList;
import io.github.TheBlackSquidward.resourcechickens.init.ModRecipes;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;

public class RoostRecipe implements IRecipe<IInventory> {

    private final ResourceLocation recipeID;
    private final Ingredient chicken;
    private final ChanceItemStackList outputs;
    private final int totalRoostTime;

    public RoostRecipe(ResourceLocation recipeID, int totalRoostTime, Ingredient chicken, ChanceItemStackList outputs) {
        this.recipeID = recipeID;
        this.totalRoostTime = totalRoostTime;
        this.chicken = chicken;
        this.outputs = outputs;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_) {
        return true;
    }

    @Override
    public boolean matches(IInventory inv, World world) {
        return this.chicken.test(inv.getItem(0));
    }

    @Override
    public ItemStack assemble(IInventory p_77572_1_) {
        return ItemStack.EMPTY;
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
        return ModRecipes.ROOST_SERIALIZER.get();
    }
    @Override
    public IRecipeType<?> getType() {
        return ModRecipes.ROOST_RECIPE_TYPE;
    }

    public int getTotalRoostTime() {
        return totalRoostTime;
    }

    public Ingredient getIngredient() {
        return chicken;
    }

    public ChanceItemStackList getOutputs() {
        return outputs;
    }

    public List<ItemStack> getInputs() {
        return Arrays.asList(chicken.getItems());
    }

}
