package io.github.TheBlackSquidward.resourcechickens;

import io.github.TheBlackSquidward.resourcechickens.init.ModItems;
import net.minecraft.item.ItemStack;

public class ResourceChickensItemGroup extends net.minecraft.item.ItemGroup {

    public ResourceChickensItemGroup() {
        super("resourcechickens");
    }

    @Override
    public ItemStack makeIcon()  {
        return ModItems.VANILLA_CHICKEN.get().getDefaultInstance();
    }

}
