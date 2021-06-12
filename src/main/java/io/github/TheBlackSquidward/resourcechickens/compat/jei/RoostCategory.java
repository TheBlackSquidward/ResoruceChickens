package io.github.TheBlackSquidward.resourcechickens.compat.jei;

import com.mojang.blaze3d.matrix.MatrixStack;
import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.init.ItemInit;
import io.github.TheBlackSquidward.resourcechickens.recipes.recipe.RoostRecipe;
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

public class RoostCategory implements IRecipeCategory<RoostRecipe> {

    public static final ResourceLocation GUI = new ResourceLocation(ResourceChickens.MODID, "textures/gui/jei/roost.png");
    public static final ResourceLocation ID = new ResourceLocation(ResourceChickens.MODID, "roost");
    private final IDrawable background;
    private final IDrawableAnimated arrow;
    private final String localizedName;
    private final IDrawable icon;

    public RoostCategory(IGuiHelper iGuiHelper) {
        IDrawableStatic arrowDrawable = iGuiHelper.createDrawable(GUI, 127, 0, 26, 16);
        this.arrow = iGuiHelper.createAnimatedDrawable(arrowDrawable, 200, IDrawableAnimated.StartDirection.LEFT, false);
        this.icon = iGuiHelper.createDrawableIngredient(new ItemStack(ItemInit.ROOST.get()));
        this.background = iGuiHelper.createDrawable(GUI, 0, 0, 126, 18);
        this.localizedName = I18n.get("gui.resourcechickens.jei.category.roost");
    }

    @Override
    public ResourceLocation getUid() {
        return ID;
    }

    @Override
    public Class<? extends RoostRecipe> getRecipeClass() {
        return RoostRecipe.class;
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
    public void draw(RoostRecipe recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
        this.arrow.draw(matrixStack, 23, 1);
    }

    @Override
    public void setIngredients(RoostRecipe recipe, IIngredients iIngredients) {
        iIngredients.setInputs(VanillaTypes.ITEM, recipe.getInputs());
        iIngredients.setOutputs(VanillaTypes.ITEM, recipe.getOutputs().dissolve());
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, RoostRecipe recipe, IIngredients iIngredients) {
        IGuiItemStackGroup guiItemStacks = iRecipeLayout.getItemStacks();
        guiItemStacks.init(0, true, 0, 0);
        guiItemStacks.init(1, false, 54, 0);
        guiItemStacks.init(2, false, 72, 0);
        guiItemStacks.init(3, false, 90, 0);
        guiItemStacks.init(4, false, 108, 0);
        guiItemStacks.set(iIngredients);
        //TODO port over
        /*
        iRecipeLayout.getItemStacks().addTooltipCallback(new ITooltipCallback<ItemStack>() {
            @Override
            public void onTooltip(int slot, boolean input, ItemStack itemStack, List<ITextComponent> tooltip) {
                if(!input) {
                    ChickenDrop chickenDrop = recipe.matchItemToChickenDrop(itemStack.getItem());
                    tooltip.add(new StringTextComponent("Minimum Drop Amount: " + chickenDrop.getMinAmount()));
                    tooltip.add(new StringTextComponent("Maximum Drop Amount: " + chickenDrop.getMaxAmount()));
                    tooltip.add(new StringTextComponent("Drop Chance: NYI"));
                    //TODO
                }
            }
        });
         */
    }

}
