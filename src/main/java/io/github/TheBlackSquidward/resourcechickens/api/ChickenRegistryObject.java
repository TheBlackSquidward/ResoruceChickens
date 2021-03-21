package io.github.TheBlackSquidward.resourcechickens.api;

import io.github.TheBlackSquidward.resourcechickens.common.entities.CustomChickenEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class ChickenRegistryObject {

    private final String entityName;
    private final ChickenRegistryObject parent1;
    private final ChickenRegistryObject parent2;
    private RegistryObject<Item> chickenItemRegistryObject;
    private RegistryObject<Item> chickenSpawnEggRegistryObject;
    private RegistryObject<EntityType<CustomChickenEntity>> chickenEntityRegistryObject;
    private ResourceLocation registryID;

    private boolean hasEgg;
    private transient ChickenEggObject eggObject;

    private boolean hasFeather;
    private transient RegistryObject<Item> featherRegistryObject;

    private Item chickenDrop = null;
    private RegistryObject<Item> itemRegistryObject = null;

    private transient RegistryObject<Item> chickenFeatherRegistryObject;

    //No Feathers - Item
    public ChickenRegistryObject(String entityName, Item chickenDrop, @Nullable ChickenRegistryObject parent1, @Nullable ChickenRegistryObject parent2) {
        this.entityName = entityName;
        this.chickenDrop = chickenDrop;
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.hasFeather = false;
        this.hasEgg = false;
    }

    //Has Feather - Item
    public ChickenRegistryObject(String entityName, Item chickenDrop, @Nullable ChickenRegistryObject parent1, @Nullable ChickenRegistryObject parent2, boolean hasFeather) {
        this.entityName = entityName;
        this.chickenDrop = chickenDrop;
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.hasFeather = hasFeather;
        this.hasEgg = false;
    }

    //No Feathers - Custom Egg
    public ChickenRegistryObject(String entityName, ChickenEggObject chickenEggObject, @Nullable ChickenRegistryObject parent1, @Nullable ChickenRegistryObject parent2) {
        this.entityName = entityName;
        this.itemRegistryObject = chickenEggObject.getEggRegistryObject();
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.hasFeather = false;
        this.hasEgg = true;
        this.eggObject = chickenEggObject;
    }

    public ResourceLocation getRegistryID() {
        return registryID;
    }

    public void setRegistryID(ResourceLocation registryID) {
        this.registryID = registryID;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setChickenItemRegistryObject(RegistryObject<Item> chickenItemRegistryObject) {
        this.chickenItemRegistryObject = (this.chickenItemRegistryObject == null) ? chickenItemRegistryObject : this.chickenItemRegistryObject;
    }

    public Item getChickenDrop() {
        if (chickenDrop == null) {
            chickenDrop = itemRegistryObject.get();
        }
        return chickenDrop;
    }

    public RegistryObject<Item> getChickenItemRegistryObject() {
        return chickenItemRegistryObject;
    }

    public void setChickenSpawnEggRegistryObject(RegistryObject<Item> chickenSpawnEggRegistryObject) {
        this.chickenSpawnEggRegistryObject = (this.chickenSpawnEggRegistryObject == null) ? chickenSpawnEggRegistryObject : this.chickenSpawnEggRegistryObject;
    }

    public RegistryObject<Item> getChickenSpawnEggRegistryObject() {
        return chickenSpawnEggRegistryObject;
    }

    public boolean isHasFeather() {
        return hasFeather;
    }

    public RegistryObject<EntityType<CustomChickenEntity>> getChickenEntityRegisryObject() {
        return chickenEntityRegistryObject;
    }

    public void setChickenEntityRegistryObject(RegistryObject<EntityType<CustomChickenEntity>> chickenEntityRegistryObject) {
        this.chickenEntityRegistryObject = chickenEntityRegistryObject;
    }

    public boolean isBreedable() {
        return parent1 != null && parent2 != null;
    }

    public ChickenRegistryObject getParent1() {
        return parent1;
    }

    public ChickenRegistryObject getParent2() {
        return parent2;
    }

    public ItemStack buildChickenStack() {
        ItemStack stack = new ItemStack(getChickenItemRegistryObject().get());
        return stack;
    }

    public List<ItemStack> buildParentChickenStack() {
        if (!isBreedable())
            return null;
        ChickenRegistryObject parent1 = getParent1();
        ChickenRegistryObject parent2 = getParent2();
        return Arrays.asList(parent1.buildChickenStack(), parent2.buildChickenStack());
    }

    public void setChickenFeatherRegistryObject(RegistryObject<Item> chickenFeatherRegistryObject) {
        this.chickenFeatherRegistryObject = chickenFeatherRegistryObject;
    }

    public Item getChickenFeatherItem() {
        return chickenFeatherRegistryObject.get();
    }

    public boolean isHasEgg() {
        return hasEgg;
    }

    public ChickenEggObject getEggObject() {
        return eggObject;
    }

}