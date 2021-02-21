package io.github.TheBlackSquidward.resourcefulchickens.api;

import io.github.TheBlackSquidward.resourcefulchickens.registries.ItemRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.RegistryObject;

public class CreativeTab extends ItemGroup {

    public CreativeTab() {
        super("resourcefulchickens");
    }

    @Override
    public ItemStack createIcon() {
        return ItemRegistry.VANILLA_CHICKEN.get().getDefaultInstance();
    }

    @Override
    public void fill(NonNullList<ItemStack> items) {
        for(RegistryObject<Item> item : ItemRegistry.ITEMS.getEntries()) {
            items.add(item.get().getDefaultInstance());
        }
    }
}
