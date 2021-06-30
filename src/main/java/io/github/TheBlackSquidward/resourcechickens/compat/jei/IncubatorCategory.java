package io.github.TheBlackSquidward.resourcechickens.compat.jei;

import com.mojang.blaze3d.matrix.MatrixStack;
import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.init.ModItems;
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
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IncubatorCategory implements IRecipeCategory<IncubatorRecipe> {

    public static final ResourceLocation GUI = new ResourceLocation(ResourceChickens.MODID, "textures/gui/jei/incubator.png");
    public static final ResourceLocation ID = new ResourceLocation(ResourceChickens.MODID, "incubator");
    private final IDrawable background;
    private final IDrawableAnimated arrow;
    private final String localizedName;
    private final IDrawable icon;

    public IncubatorCategory(IGuiHelper iGuiHelper) {
        IDrawableStatic arrowDrawable = iGuiHelper.createDrawable(GUI, 73, 0, 26, 16);
        this.arrow = iGuiHelper.createAnimatedDrawable(arrowDrawable, 200, IDrawableAnimated.StartDirection.LEFT, false);
        this.icon = iGuiHelper.createDrawableIngredient(new ItemStack(ModItems.poweredIncubator.get()));
        this.background = iGuiHelper.createDrawable(GUI, 0, 0, 72, 18);
        this.localizedName = I18n.get("gui.resourcechickens.jei.category.incubator");

    }

    public static Collection<?> getIncubatorRecipes() {
        List<IncubatorRecipe> recipes = new ArrayList<>();
        for(ChickenRegistryObject chickenRegistryObject : ChickenRegistry.getChickenRegistry()) {
            if(chickenRegistryObject.isHasEgg()) {
                recipes.add(new IncubatorRecipe(chickenRegistryObject.getEggObject()));
            }
        }
        return recipes;
    }

    @Override
    public ResourceLocation getUid() {
        return ID;
    }

    @Override
    public Class<? extends IncubatorRecipe> getRecipeClass() {
        return IncubatorRecipe.class;
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
    public void draw(IncubatorRecipe recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
        this.arrow.draw(matrixStack, 23, 1);
    }

    @Override
    public void setIngredients(IncubatorRecipe recipe, IIngredients iIngredients) {
        iIngredients.setInput(VanillaTypes.ITEM, new ItemStack(recipe.egg.getEggRegistryObject().get()));
        iIngredients.setOutput(VanillaTypes.ITEM, new ItemStack(recipe.egg.getEggDrop()));
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, IncubatorRecipe incubatorRecipe, IIngredients iIngredients) {
        IGuiItemStackGroup guiItemStacks = iRecipeLayout.getItemStacks();
        guiItemStacks.init(0, true, 0, 0);
        guiItemStacks.init(1, false, 54, 0);
        guiItemStacks.set(iIngredients);
    }
}
