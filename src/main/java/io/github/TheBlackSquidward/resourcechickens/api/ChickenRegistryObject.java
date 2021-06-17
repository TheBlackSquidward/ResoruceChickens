package io.github.TheBlackSquidward.resourcechickens.api;

import io.github.TheBlackSquidward.resourcechickens.entities.CustomChickenEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import org.apache.commons.lang3.text.WordUtils;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChickenRegistryObject {

    private final String entityName;
    private final ChickenRegistryObject parent1;
    private final ChickenRegistryObject parent2;
    private final boolean hasFeather;
    private final boolean hasEgg;
    private final List<ChickenDrop> chickenDrops;
    private final ChickenType chickenType;


    private RegistryObject<EntityType<CustomChickenEntity>> chickenEntityRegistryObject;
    private ResourceLocation registryID;

    private RegistryObject<Item> chickenItemRegistryObject;
    private RegistryObject<Item> chickenSpawnEggRegistryObject;
    private RegistryObject<Item> chickenFeatherRegistryObject;

    private transient ChickenEggObject eggObject;



    //Base Constructor
    public ChickenRegistryObject(String entityName, ChickenType chickenType, List<ChickenDrop> chickenDrops, @Nullable ChickenRegistryObject parent1, @Nullable ChickenRegistryObject parent2, boolean hasFeather, boolean hasEgg) {
        this.entityName = entityName;
        this.chickenType = chickenType;
        this.chickenDrops = chickenDrops;
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.hasFeather = hasFeather;
        this.hasEgg = hasEgg;
    }

    //Egg
    public ChickenRegistryObject(String entityName, ChickenType chickenType, List<ChickenDrop> chickenDrops, ChickenEggObject chickenEggObject, @Nullable ChickenRegistryObject parent1, @Nullable ChickenRegistryObject parent2, boolean hasFeather) {
        this(entityName, chickenType, chickenDrops, parent1, parent2, hasFeather, true);
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

    public List<ChickenDrop> getChickenDrops() {
        return chickenDrops;
    }

    public List<ChickenDrop> getFinalOutput() {
        List<ChickenDrop> output = new ArrayList<>();
        output.addAll(getChickenDrops());
        if(hasFeather && chickenFeatherRegistryObject != null) {
            output.add(new ChickenDrop(chickenFeatherRegistryObject, 1, 3));
        }
        return output;
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

    public ChickenType getChickenType() {
        return chickenType;
    }

    public String getForamattedName() {
        String formattedName = entityName.replace("_", " ");
        return WordUtils.capitalize(formattedName);
    }

}