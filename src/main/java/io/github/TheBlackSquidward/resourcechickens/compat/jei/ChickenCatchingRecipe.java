package io.github.TheBlackSquidward.resourcechickens.compat.jei;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api2.CustomChickenData;
import io.github.TheBlackSquidward.resourcechickens.api2.utils.ChickenUtisl;
import io.github.TheBlackSquidward.resourcechickens.items.ChickenItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

public class ChickenCatchingRecipe {

    ItemStack spawnEgg;
    ItemStack chickenItem;

    public ChickenCatchingRecipe(RegistryObject<ChickenItem> vanillaChicken) {
        this.chickenItem = new ItemStack(vanillaChicken.get());
        this.spawnEgg = new ItemStack(Items.CHICKEN_SPAWN_EGG);
    }
    public ChickenCatchingRecipe(CustomChickenData customChickenData) {
        this.spawnEgg = new ItemStack(ChickenUtisl.getItem(ResourceChickens.MOD_ID + ":" + customChickenData.getCoreData().getName() + "_chicken_spawn_egg"));
        this.chickenItem = new ItemStack(ChickenUtisl.getItem(ResourceChickens.MOD_ID + ":" + customChickenData.getCoreData().getName() + "_chicken_item"));
    }


}
