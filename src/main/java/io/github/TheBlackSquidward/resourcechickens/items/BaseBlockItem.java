package io.github.TheBlackSquidward.resourcechickens.items;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class BaseBlockItem extends BlockItem {

    public BaseBlockItem(Block block, Properties properties) {
        super(block, properties.tab(ResourceChickens.ITEM_GROUP));
    }

}
