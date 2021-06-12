package io.github.TheBlackSquidward.resourcechickens.datagen;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChanceItemStack;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenDrop;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.init.ItemInit;
import io.github.TheBlackSquidward.resourcechickens.recipes.builder.RoostRecipeBuidler;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProviderBase{

    private final String roostRecipePath = "roost/";

    public RecipeGenerator(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        registerRoostRecipes(consumer);
    }

    private void registerRoostRecipes(Consumer<IFinishedRecipe> consumer) {
        for (ChickenRegistryObject chickenRegistryObject : ChickenRegistry.getChickenRegistry().values()) {
            RoostRecipeBuidler builder = RoostRecipeBuidler.newRoostRecipe()
                    .setChicken(Ingredient.of(chickenRegistryObject.getChickenItemRegistryObject().get()))
                    .setTotalRoostTime(300);
            for(ChickenDrop chickenDrop : chickenRegistryObject.getChickenDrops()) {
                builder.addOutput(new ChanceItemStack(new ItemStack(chickenDrop.getItem())));
            }
            builder.build(consumer, getRoostPath(chickenRegistryObject.getEntityName()));
        }
    }

    private ResourceLocation getRoostPath(String fileName) {
        return new ResourceLocation(ResourceChickens.MODID, "roost/" + fileName);
    }

}
