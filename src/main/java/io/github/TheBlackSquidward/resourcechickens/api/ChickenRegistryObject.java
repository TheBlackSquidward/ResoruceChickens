package io.github.TheBlackSquidward.resourcechickens.api;

import io.github.TheBlackSquidward.resourcechickens.common.entities.CustomChickenEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class ChickenRegistryObject {

    private final String entityName;
    private final ChickenRegistryObject parent1;
    private final ChickenRegistryObject parent2;
    private transient boolean hasFeather;

    private Item chickenDrop = null;
    private RegistryObject<Item> itemRegistryObject = null;

    private transient RegistryObject<Item> chickenFeatherRegistryObject;
    private transient RegistryObject<Item> chickenItemRegistryObject;
    private transient RegistryObject<Item> chickenSpawnEggRegistryObject;
    private transient RegistryObject<EntityType<CustomChickenEntity>> chickenEntityRegistryObject;
    private transient ResourceLocation registryID;

    public ChickenRegistryObject(String entityName, Item chickenDrop, @Nullable ChickenRegistryObject parent1, @Nullable ChickenRegistryObject parent2, boolean hasFeather) {
        this.entityName = entityName;
        this.chickenDrop = chickenDrop;
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.hasFeather = hasFeather;
    }
    public ChickenRegistryObject(String entityName, RegistryObject<Item> itemRegistryObject, @Nullable ChickenRegistryObject parent1, @Nullable ChickenRegistryObject parent2, boolean hasFeather) {
        this.entityName = entityName;
        this.itemRegistryObject = itemRegistryObject;
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.hasFeather = hasFeather;
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
        if(chickenDrop == null) {
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

}