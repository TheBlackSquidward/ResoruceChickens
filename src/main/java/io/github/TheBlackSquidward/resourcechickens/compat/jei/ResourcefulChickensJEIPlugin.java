package io.github.TheBlackSquidward.resourcechickens.compat.jei;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.containers.RoostContainer;
import io.github.TheBlackSquidward.resourcechickens.init.ModItems;
import io.github.TheBlackSquidward.resourcechickens.init.ModRecipes;
import io.github.TheBlackSquidward.resourcechickens.recipes.recipe.ChickenBreedingRecipe;
import io.github.TheBlackSquidward.resourcechickens.recipes.recipe.RoostRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
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
        registration.addRecipeCatalyst(new ItemStack(ModItems.CHICKEN_CATCHER.get()), ChickenCatchingCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.CHICKEN_BREEDER.get()), ChickenBreedingCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.ELECTRIC_CHICKEN_BREEDER.get()), ChickenBreedingCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.ROOST.get()), RoostCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.ELECTRIC_ROOST.get()), RoostCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.INCUBATOR.get()), IncubatorCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.ELECTRIC_INCUBATOR.get()), IncubatorCategory.ID);
    }

    @Override
    public void registerRecipes(@Nonnull IRecipeRegistration registration) {
        World clientWorld = Minecraft.getInstance().level;
        if (clientWorld != null) {
            registration.addRecipes(ChickenCatchingCategory.getCatchingRecipes(), ChickenCatchingCategory.ID);
            registration.addRecipes(IncubatorCategory.getIncubatorRecipes(), IncubatorCategory.ID);

            List<RoostRecipe> roostRecipes = clientWorld.getRecipeManager().getAllRecipesFor(ModRecipes.ROOST_RECIPE_TYPE);
            registration.addRecipes(roostRecipes, RoostCategory.ID);

            List<ChickenBreedingRecipe> chickenBreedingRecipes = clientWorld.getRecipeManager().getAllRecipesFor(ModRecipes.CHICKEN_BREEDING_RECIPE_TYPE);
            registration.addRecipes(chickenBreedingRecipes, ChickenBreedingCategory.ID);
        }
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(RoostContainer.class, RoostCategory.ID, 0, 1, 5,36);
    }
}
