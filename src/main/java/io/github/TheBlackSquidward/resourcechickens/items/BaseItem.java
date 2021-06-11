package io.github.TheBlackSquidward.resourcechickens.items;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import net.minecraft.item.Item;

public class BaseItem extends Item {

    public BaseItem(Properties properties) {
        super(properties.tab(ResourceChickens.ITEM_GROUP));
    }

}
