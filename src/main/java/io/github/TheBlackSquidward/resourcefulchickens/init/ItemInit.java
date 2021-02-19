package io.github.TheBlackSquidward.resourcefulchickens.init;

import io.github.TheBlackSquidward.resourcefulchickens.ResourcefulChickens;
import io.github.TheBlackSquidward.resourcefulchickens.common.blocks.*;
import io.github.TheBlackSquidward.resourcefulchickens.common.items.ChickenCatcherItem;
import io.github.TheBlackSquidward.resourcefulchickens.common.items.ChickenItem;
import io.github.TheBlackSquidward.resourcefulchickens.common.items.ChickenStickItem;
import io.github.TheBlackSquidward.resourcefulchickens.common.items.CustomSpawnEggItem;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ResourcefulChickens.MODID);

    //Blocks
    public static final RegistryObject<BlockItem> ELECTRIC_ROOST = ITEMS.register("electric_roost", () -> new BlockItem(BlockInit.ELECTRIC_ROOST.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ROOST = ITEMS.register("roost", () -> new BlockItem(BlockInit.ROOST.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> INCUBATOR = ITEMS.register("incubator", () -> new BlockItem(BlockInit.INCUBATOR.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ELECTRIC_NCUBATOR = ITEMS.register("electric_incubator", () -> new BlockItem(BlockInit.ELECTRIC_INCUBATOR.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> CHICKEN_BREEDER = ITEMS.register("chicken_breeder", () -> new BlockItem(BlockInit.CHICKEN_BREEDER.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ELECTRIC_CHICKEN_BREEDER = ITEMS.register("electric_chicken_breeder", () -> new BlockItem(BlockInit.ELECTRIC_CHICKEN_BREEDER.get(), new Item.Properties()));

    //Misc
    public static final RegistryObject<ChickenStickItem> CHICKEN_STICK = ITEMS.register("chicken_stick", () -> new ChickenStickItem(new Item.Properties().maxStackSize(1)));
    public static final RegistryObject<ChickenCatcherItem> CHICKEN_CATCHER = ITEMS.register("chicken_catcher", ChickenCatcherItem::new);
    public static final RegistryObject<Item> CHICKEN_MANURE = ITEMS.register("chicken_manure", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FERTILIZER = ITEMS.register("fertilizer", () -> new Item(new Item.Properties()));

    //Chickens - Vanilla
    public static final RegistryObject<ChickenItem> VANILLA_CHICKEN = ITEMS.register("vanilla_chicken_item", () -> new ChickenItem(new Item.Properties().maxStackSize(16)));

}
