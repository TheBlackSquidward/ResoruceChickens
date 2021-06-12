package io.github.TheBlackSquidward.resourcechickens.init;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.recipes.recipe.RoostRecipe;
import io.github.TheBlackSquidward.resourcechickens.recipes.serializer.RoostRecipeSerializer;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Resource;

public class RecipeInit {

    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER_REGISTRY = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ResourceChickens.MODID);

    public static final RegistryObject<IRecipeSerializer<RoostRecipe>> ROOST_SERIALIZER = RECIPE_SERIALIZER_REGISTRY.register("roost", RoostRecipeSerializer::new);

    public static IRecipeType<RoostRecipe> ROOST_RECIPE_TYPE = IRecipeType.register("resourcechickens:roost");


}
