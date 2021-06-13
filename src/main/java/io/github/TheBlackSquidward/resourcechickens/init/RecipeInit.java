package io.github.TheBlackSquidward.resourcechickens.init;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.recipes.recipe.ChickenBreedingRecipe;
import io.github.TheBlackSquidward.resourcechickens.recipes.recipe.RoostRecipe;
import io.github.TheBlackSquidward.resourcechickens.recipes.serializer.ChickenBreedingRecipeSerializer;
import io.github.TheBlackSquidward.resourcechickens.recipes.serializer.RoostRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeInit {

    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER_REGISTRY = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ResourceChickens.MODID);

    public static final RegistryObject<IRecipeSerializer<RoostRecipe>> ROOST_SERIALIZER = RECIPE_SERIALIZER_REGISTRY.register("roost", RoostRecipeSerializer::new);
    public static final RegistryObject<IRecipeSerializer<ChickenBreedingRecipe>> CHICKEN_BREEDING_SERIALIZER = RECIPE_SERIALIZER_REGISTRY.register("chicken_breeding", ChickenBreedingRecipeSerializer::new);

    public static IRecipeType<RoostRecipe> ROOST_RECIPE_TYPE = IRecipeType.register("resourcechickens:roost");
    public static IRecipeType<ChickenBreedingRecipe> CHICKEN_BREEDING_RECIPE_TYPE = IRecipeType.register("resourcechickens:chicken_breeding");

}
