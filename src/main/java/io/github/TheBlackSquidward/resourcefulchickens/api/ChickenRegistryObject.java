package io.github.TheBlackSquidward.resourcefulchickens.api;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;

public class ChickenRegistryObject {

    private final String entityName;
    private final ItemStack layItem;
    private final int bgColor;
    private final int fgColor;
    private final ResourceLocation texture;
    private final ChickenRegistryObject parent1;
    private final ChickenRegistryObject parent2;
    private transient boolean hasFeather;

    private transient RegistryObject<Item> chickenFeatherRegistryObject;
    private transient RegistryObject<Item> chickenItemRegistryObject;
    private transient RegistryObject<Item> chickenSpawnEggRegistryObject;
    private transient RegistryObject<EntityType<CustomChickenEntity>> chickenEntityRegistryObject;
    private transient ResourceLocation registryID;


    public ChickenRegistryObject(String entityName, ResourceLocation texture, ItemStack layItem, int bgColor, int fgColor, @Nullable ChickenRegistryObject parent1, @Nullable ChickenRegistryObject parent2) {
        this.entityName = entityName;
        this.layItem = layItem;
        this.bgColor = bgColor;
        this.fgColor = fgColor;
        this.texture = texture;
        this.parent1 = parent1;
        this.parent2 = parent2;
    }
    public ChickenRegistryObject(String entityName, ResourceLocation texture, ItemStack layItem, int bgColor, int fgColor, @Nullable ChickenRegistryObject parent1, @Nullable ChickenRegistryObject parent2, boolean hasFeather) {
        this.entityName = entityName;
        this.layItem = layItem;
        this.bgColor = bgColor;
        this.fgColor = fgColor;
        this.texture = texture;
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
}