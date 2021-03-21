package io.github.TheBlackSquidward.resourcechickens.compat.jei;

import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.common.items.ChickenItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;

public class ChickenCatchingRecipe {

    ChickenRegistryObject chicken;
    ItemStack egg;
    ItemStack chickenItem;

    public ChickenCatchingRecipe(ChickenRegistryObject chicken) {
        this.chicken = chicken;
        this.egg = new ItemStack(chicken.getChickenSpawnEggRegistryObject().get());
        this.chickenItem = chicken.buildChickenStack();
    }

    public ChickenCatchingRecipe(RegistryObject<ChickenItem> vanillaChicken) {
        this.chicken = null;
        this.egg = new ItemStack(Items.CHICKEN_SPAWN_EGG);
        this.chickenItem = new ItemStack(vanillaChicken.get());
    }

}
