package io.github.TheBlackSquidward.resourcefulchickens.init;

import io.github.TheBlackSquidward.resourcefulchickens.ResourcefulChickens;
import io.github.TheBlackSquidward.resourcefulchickens.common.items.ChickenCatcherItem;
import io.github.TheBlackSquidward.resourcefulchickens.common.items.ChickenItem;
import io.github.TheBlackSquidward.resourcefulchickens.common.items.ChickenStickItem;
import io.github.TheBlackSquidward.resourcefulchickens.common.items.CustomSpawnEggItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ResourcefulChickens.MODID);

    //Chickens - Vanilla
    public static final RegistryObject<ChickenItem> VANILLA_CHICKEN = ITEMS.register("vanilla_chicken_item", () -> new ChickenItem(new Item.Properties().maxStackSize(16)));

    //Misc
    public static final RegistryObject<ChickenStickItem> CHICKEN_STICK = ITEMS.register("chicken_stick", () -> new ChickenStickItem(new Item.Properties().maxStackSize(1)));
    public static final RegistryObject<ChickenCatcherItem> CHICKEN_CATCHER = ITEMS.register("chicken_catcher", () -> new ChickenCatcherItem(new Item.Properties().maxStackSize(1)));
    public static final RegistryObject<Item> CHICKEN_MANURE = ITEMS.register("chicken_manure", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FERTILIZER = ITEMS.register("fertilizer", () -> new Item(new Item.Properties()));

}
