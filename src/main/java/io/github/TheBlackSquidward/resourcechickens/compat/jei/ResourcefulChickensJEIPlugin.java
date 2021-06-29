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

        //Chicken Catching
        registration.addRecipeCatalyst(new ItemStack(ModItems.CHICKEN_CATCHER.get()), ChickenCatchingCategory.ID);

        //Chicken Breeder
        registration.addRecipeCatalyst(new ItemStack(ModItems.oakChickenBreeder.get()), ChickenBreedingCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.darkOakChickenBreeder.get()), ChickenBreedingCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.spruceChickenBreeder.get()), ChickenBreedingCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.birchChickenBreeder.get()), ChickenBreedingCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.acaciaChickenBreeder.get()), ChickenBreedingCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.jungleChickenBreeder.get()), ChickenBreedingCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.poweredChickenBreeder.get()), ChickenBreedingCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.chickenBreederController.get()), ChickenBreedingCategory.ID);

        //Roost
        registration.addRecipeCatalyst(new ItemStack(ModItems.oakRoost.get()), RoostCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.darkOakRoost.get()), RoostCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.spruceRoost.get()), RoostCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.birchRoost.get()), RoostCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.acaciaRoost.get()), RoostCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.jungleRoost.get()), RoostCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.poweredRoost.get()), RoostCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ModItems.roostController.get()), RoostCategory.ID);

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
