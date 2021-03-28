package io.github.TheBlackSquidward.resourcechickens.common.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class CustomFoodItem extends Item {

    public CustomFoodItem(int nutrition, float saturationModifier) {
        super(new Item.Properties().food(new Food.Builder().nutrition(nutrition).saturationMod(saturationModifier).meat().build()));
    }

    public CustomFoodItem(Properties properties) {
        super(properties);
    }

}
