package io.github.TheBlackSquidward.resourcechickens.compat.jei;

import com.mojang.blaze3d.matrix.MatrixStack;
import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ChickenBreedingCategory implements IRecipeCategory<ChickenBreedingRecipe> {

    public static final ResourceLocation GUI = new ResourceLocation(ResourceChickens.MODID, "textures/gui/jei/chicken_breeding.png");
    public static final ResourceLocation ID = new ResourceLocation(ResourceChickens.MODID, "chicken_breeding");
    private final IDrawable background;
    private final IDrawableAnimated hearts;
    private final String localizedName;
    private final IDrawable icon;

    public ChickenBreedingCategory(IGuiHelper iGuiHelper) {
        IDrawableStatic heartsDrawable = iGuiHelper.createDrawable(GUI, 90, 0, 26, 12);
        this.icon = iGuiHelper.createDrawableIngredient(new ItemStack(Items.WHEAT_SEEDS));
        this.hearts = iGuiHelper.createAnimatedDrawable(heartsDrawable, 200, IDrawableAnimated.StartDirection.LEFT, false);
        this.background = iGuiHelper.createDrawable(GUI, 0, 0, 90, 18);
        this.localizedName = I18n.get("gui.resourcechickens.jei.category.chicken_breeding");
    }

    public static Collection<?> getBreedingRecipes() {
        List<ChickenBreedingRecipe> recipes = new ArrayList<>();
        for (ChickenRegistryObject chickenRegistryObject : ChickenRegistry.getChickenRegistry().values()) {
            if (chickenRegistryObject.isBreedable()) {
                recipes.add(new ChickenBreedingRecipe(chickenRegistryObject));
            }
        }
        return recipes;
    }

    @Override
    public ResourceLocation getUid() {
        return ID;
    }

    @Override
    public Class<? extends ChickenBreedingRecipe> getRecipeClass() {
        return ChickenBreedingRecipe.class;
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
    public void draw(ChickenBreedingRecipe recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
        this.hearts.draw(matrixStack, 41, 3);
    }

    @Override
    public void setIngredients(ChickenBreedingRecipe recipe, IIngredients iIngredients) {
        iIngredients.setInputs(VanillaTypes.ITEM, recipe.child.buildParentChickenStack());
        iIngredients.setOutput(VanillaTypes.ITEM, recipe.child.buildChickenStack());
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, ChickenBreedingRecipe recipe, IIngredients iIngredients) {
        IGuiItemStackGroup guiItemStacks = iRecipeLayout.getItemStacks();
        guiItemStacks.init(0, true, 0, 0);
        guiItemStacks.init(1, true, 18, 0);
        guiItemStacks.init(2, false, 72, 0);
        guiItemStacks.set(iIngredients);
    }
}
