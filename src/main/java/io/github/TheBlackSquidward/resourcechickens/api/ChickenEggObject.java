package io.github.TheBlackSquidward.resourcechickens.api;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ChickenEggObject {

    private final RegistryObject<Item> eggRegistryObject;
    private final Item eggDrop;

    public ChickenEggObject(RegistryObject<Item> eggRegistryObject, Item eggDrop) {
        this.eggRegistryObject = eggRegistryObject;
        this.eggDrop = eggDrop;
    }


    public RegistryObject<Item> getEggRegistryObject() {
        return eggRegistryObject;
    }

    public Item getEggDrop() {
        return eggDrop;
    }
}
