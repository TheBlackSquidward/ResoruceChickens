package io.github.TheBlackSquidward.resourcechickens.compat.jei;

import com.mojang.blaze3d.matrix.MatrixStack;
import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.data.chickenData.RoostData;
import io.github.TheBlackSquidward.resourcechickens.init.ModItems;
import io.github.TheBlackSquidward.resourcechickens.recipes.RoostRecipe;
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
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RoostCategory implements IRecipeCategory<RoostRecipe> {

    public static final ResourceLocation GUI = new ResourceLocation(ResourceChickens.MOD_ID, "textures/gui/jei/roost.png");
    public static final ResourceLocation ID = new ResourceLocation(ResourceChickens.MOD_ID, "roost");
    private final IDrawable background;
    private final IDrawableAnimated arrow;
    private final String localizedName;
    private final IDrawable icon;

    public RoostCategory(IGuiHelper iGuiHelper) {
        IDrawableStatic arrowDrawable = iGuiHelper.createDrawable(GUI, 127, 0, 26, 16);
        this.arrow = iGuiHelper.createAnimatedDrawable(arrowDrawable, 200, IDrawableAnimated.StartDirection.LEFT, false);
        this.icon = iGuiHelper.createDrawableIngredient(new ItemStack(ModItems.oakRoost.get()));
        this.background = iGuiHelper.createDrawable(GUI, 0, 0, 126, 18);
        this.localizedName = I18n.get("gui.resourcechickens.jei.category.roost");
    }

    @Override
    public @NotNull ResourceLocation getUid() {
        return ID;
    }

    @Override
    public @NotNull Class<? extends RoostRecipe> getRecipeClass() {
        return RoostRecipe.class;
    }

    @Override
    public @NotNull String getTitle() {
        return this.localizedName;
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void draw(@NotNull RoostRecipe recipe, @NotNull MatrixStack matrixStack, double mouseX, double mouseY) {
        this.arrow.draw(matrixStack, 23, 1);
    }

    @Override
    public void setIngredients(RoostRecipe recipe, IIngredients iIngredients) {
        iIngredients.setInputs(VanillaTypes.ITEM, recipe.getInput());
        iIngredients.setOutputs(VanillaTypes.ITEM, recipe.getOutputs());
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, @NotNull RoostRecipe recipe, @NotNull IIngredients iIngredients) {
        IGuiItemStackGroup guiItemStacks = iRecipeLayout.getItemStacks();
        guiItemStacks.init(0, true, 0, 0);
        guiItemStacks.init(1, false, 54, 0);
        guiItemStacks.init(2, false, 72, 0);
        guiItemStacks.init(3, false, 90, 0);
        guiItemStacks.init(4, false, 108, 0);
        guiItemStacks.set(iIngredients);
        iRecipeLayout.getItemStacks().addTooltipCallback(new RoostTooltipCallback(recipe));
    }

    public static Collection<?> getRoostRecipes() {
        List<RoostRecipe> recipes = new ArrayList<>();
        ChickenRegistry.getChickenRegistry().getChickens().forEach(((chickenName, customChickenData) -> {
            RoostData roostData = customChickenData.getRoostData();
            if(roostData.canRoost()) {
                recipes.add(new RoostRecipe(customChickenData));
            }
        }));
        return recipes;
    }

}
