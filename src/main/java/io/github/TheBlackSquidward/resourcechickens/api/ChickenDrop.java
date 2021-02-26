package io.github.TheBlackSquidward.resourcechickens.api;

import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;

import java.util.ArrayList;

public class ChickenDrop {

    ArrayList<ChickenDrop> chickenDrops;
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

    public int getDropAmount(World world) {
        return world.rand.nextInt((maxAmount - minAmount) + minAmount) + 1;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }


}
