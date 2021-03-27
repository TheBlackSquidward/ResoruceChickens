package io.github.TheBlackSquidward.resourcechickens;

import io.github.TheBlackSquidward.resourcechickens.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.RegistryObject;

public class ResourceChickensItemGroup extends net.minecraft.item.ItemGroup {

    public ResourceChickensItemGroup() {
        super("resourcechickens");
    }

    @Override
    public void fillItemList(NonNullList<ItemStack> items) {
        for (RegistryObject<Item> item : ItemInit.ITEMS.getEntries()) {
            items.add(item.get().getDefaultInstance());
        }
    }

    @Override
    public ItemStack makeIcon()  {
        return ItemInit.VANILLA_CHICKEN.get().getDefaultInstance();
    }
}
