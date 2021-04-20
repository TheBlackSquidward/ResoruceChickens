package io.github.TheBlackSquidward.resourcechickens.compat.jei;

import io.github.TheBlackSquidward.resourcechickens.api.ChickenDrop;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import net.minecraft.item.Item;

public class RoostRecipe {

    ChickenRegistryObject chicken;

    public RoostRecipe(ChickenRegistryObject chicken) {
        this.chicken = chicken;
    }

    public ChickenDrop matchItemToChickenDrop(Item item) {
        for(ChickenDrop chickenDrop : chicken.getFinalOutput()) {
            if(chickenDrop.getItem() == item) {
                return chickenDrop;
            }
        }
        return null;
    }

}
