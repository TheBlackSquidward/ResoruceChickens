package io.github.TheBlackSquidward.resourcechickens.recipes;

import io.github.TheBlackSquidward.resourcechickens.api.CustomChickenData;
import io.github.TheBlackSquidward.resourcechickens.items.ChickenItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;

public class ChickenCatchingRecipe {

    ItemStack spawnEgg;
    ItemStack chickenItem;

    public ChickenCatchingRecipe(RegistryObject<ChickenItem> vanillaChicken) {
        this.chickenItem = new ItemStack(vanillaChicken.get());
        this.spawnEgg = new ItemStack(Items.CHICKEN_SPAWN_EGG);
    }
    public ChickenCatchingRecipe(CustomChickenData customChickenData) {
        this.spawnEgg = customChickenData.getChickenSpawnEgg();
        this.chickenItem = customChickenData.getChickenItem();
    }

    public ItemStack getChickenItem() {
        return chickenItem;
    }

    public ItemStack getSpawnEgg() {
        return spawnEgg;
    }

}
