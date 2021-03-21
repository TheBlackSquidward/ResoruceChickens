package io.github.TheBlackSquidward.resourcechickens.compat.jei;

import com.mojang.blaze3d.matrix.MatrixStack;
import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.init.ItemInit;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ChickenCatchingCategory implements IRecipeCategory<ChickenCatchingRecipe> {

    public static final ResourceLocation GUI = new ResourceLocation(ResourceChickens.MODID, "textures/gui/jei/chicken_catching.png");
    public static final ResourceLocation ID = new ResourceLocation(ResourceChickens.MODID, "chicken_catching");
    private final IDrawable background;
    private final IDrawable animation;
    private final String localizedName;
    private final IDrawable icon;

    public ChickenCatchingCategory(IGuiHelper iGuiHelper) {
        IDrawableStatic animationDrawable = iGuiHelper.createDrawable(GUI, 73, 0, 24, 252);
        this.animation = new ChickenCatchingDrawable(animationDrawable, iGuiHelper.createTickTimer(18, 18, false));
        this.icon = iGuiHelper.createDrawableIngredient(new ItemStack(ItemInit.CHICKEN_CATCHER.get()));
        this.background = iGuiHelper.createDrawable(GUI, 0, 0, 72, 18);
        this.localizedName = I18n.format("gui.resourcechickens.jei.category.chicken_catching");
    }

    public static Collection<?> getCatchingRecipes() {
        List<ChickenCatchingRecipe> recipes = new ArrayList<>();
        for (ChickenRegistryObject chickenRegistryObject : ChickenRegistry.getChickenRegistry().values()) {
            recipes.add(new ChickenCatchingRecipe(chickenRegistryObject));
        }
        recipes.add(new ChickenCatchingRecipe(ItemInit.VANILLA_CHICKEN));
        return recipes;
    }

    @Override
    public ResourceLocation getUid() {
        return ID;
    }

    @Override
    public Class<? extends ChickenCatchingRecipe> getRecipeClass() {
        return ChickenCatchingRecipe.class;
    }

    @Override
    public String getTitle() {
        return this.localizedName;
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void draw(ChickenCatchingRecipe recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
        this.animation.draw(matrixStack, 21, 1);
    }

    @Override
    public void setIngredients(ChickenCatchingRecipe recipe, IIngredients iIngredients) {
        iIngredients.setInput(VanillaTypes.ITEM, recipe.egg);
        iIngredients.setOutput(VanillaTypes.ITEM, recipe.chickenItem);
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, ChickenCatchingRecipe recipe, IIngredients iIngredients) {
        IGuiItemStackGroup guiItemStacks = iRecipeLayout.getItemStacks();
        guiItemStacks.init(0, true, 0, 0);
        guiItemStacks.init(1, false, 54, 0);
        guiItemStacks.set(iIngredients);
    }

}
