package io.github.TheBlackSquidward.resourcefulchickens.api;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ChickenDrop {

    RegistryObject<Item> itemRegistryObject;
    Item item = null;
    int minAmount;
    int maxAmount;

    public ChickenDrop(RegistryObject<Item> itemRegistryObject, int minAmount, int maxAmount) {
        this.itemRegistryObject = itemRegistryObject;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    public ChickenDrop(Item item, int minAmount, int maxAmount){
        this.item = item;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    public Item getItem() {
        if(item == null) {
            return itemRegistryObject.get();
        }else{
            return item;
        }
    }


}
