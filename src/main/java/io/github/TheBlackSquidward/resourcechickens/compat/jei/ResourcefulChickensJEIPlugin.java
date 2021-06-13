package io.github.TheBlackSquidward.resourcechickens.compat.jei;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.init.ItemInit;
import io.github.TheBlackSquidward.resourcechickens.init.RecipeInit;
import io.github.TheBlackSquidward.resourcechickens.recipes.recipe.ChickenBreedingRecipe;
import io.github.TheBlackSquidward.resourcechickens.recipes.recipe.RoostRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.List;

@JeiPlugin
public class ResourcefulChickensJEIPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ResourceChickens.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper iGuiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new ChickenCatchingCategory(iGuiHelper));
        registration.addRecipeCategories(new ChickenBreedingCategory(iGuiHelper));
        registration.addRecipeCategories(new IncubatorCategory(iGuiHelper));
        registration.addRecipeCategories(new RoostCategory(iGuiHelper));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ItemInit.CHICKEN_CATCHER.get()), ChickenCatchingCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ItemInit.CHICKEN_BREEDER.get()), ChickenBreedingCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ItemInit.ELECTRIC_CHICKEN_BREEDER.get()), ChickenBreedingCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ItemInit.ROOST.get()), RoostCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ItemInit.ELECTRIC_ROOST.get()), RoostCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ItemInit.INCUBATOR.get()), IncubatorCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ItemInit.ELECTRIC_INCUBATOR.get()), IncubatorCategory.ID);
    }

    @Override
    public void registerRecipes(@Nonnull IRecipeRegistration registration) {
        World clientWorld = Minecraft.getInstance().level;
        if (clientWorld != null) {
            registration.addRecipes(ChickenCatchingCategory.getCatchingRecipes(), ChickenCatchingCategory.ID);
            registration.addRecipes(IncubatorCategory.getIncubatorRecipes(), IncubatorCategory.ID);

            List<RoostRecipe> roostRecipes = clientWorld.getRecipeManager().getAllRecipesFor(RecipeInit.ROOST_RECIPE_TYPE);
            registration.addRecipes(roostRecipes, RoostCategory.ID);

            List<ChickenBreedingRecipe> chickenBreedingRecipes = clientWorld.getRecipeManager().getAllRecipesFor(RecipeInit.CHICKEN_BREEDING_RECIPE_TYPE);
            registration.addRecipes(chickenBreedingRecipes, ChickenBreedingCategory.ID);
        }
    }
}
