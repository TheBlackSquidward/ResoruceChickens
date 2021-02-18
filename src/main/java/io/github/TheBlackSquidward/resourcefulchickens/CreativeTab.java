package io.github.TheBlackSquidward.resourcefulchickens;

import io.github.TheBlackSquidward.resourcefulchickens.init.ItemInit;
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
        return ItemInit.CHICKEN_STICK.get().getDefaultInstance();
    }

    @Override
    public void fill(NonNullList<ItemStack> items) {
        for(RegistryObject<Item> item : ItemInit.ITEMS.getEntries()) {
            items.add(item.get().getDefaultInstance());
        }
    }
}
