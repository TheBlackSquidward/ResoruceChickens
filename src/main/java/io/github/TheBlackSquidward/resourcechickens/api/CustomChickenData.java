package io.github.TheBlackSquidward.resourcechickens.api;

import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.data.chickenData.*;
import io.github.TheBlackSquidward.resourcechickens.api.utils.ChickenUtisl;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.text.WordUtils;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class CustomChickenData {

    public static CustomChickenData DEFAULT = new CustomChickenData(CoreData.DEFAULT, BreedData.DEFAULT, RoostData.DEFAULT);

    public static Codec<CustomChickenData> CODEC(String chickenName) {
        return RecordCodecBuilder.create(instance -> instance.group(
            CoreData.CODEC(chickenName).fieldOf("coreData").orElseGet((Consumer<String>) s -> ResourceChickens.LOGGER.error("CoreData is REQUIRED!"),null).forGetter(CustomChickenData::getCoreData),
            BreedData.CODEC.fieldOf("breedData").orElse(BreedData.DEFAULT).forGetter(CustomChickenData::getBreedData),
            RoostData.CODEC.fieldOf("roostData").orElse(RoostData.DEFAULT).forGetter(CustomChickenData::getRoostData)
        ).apply(instance, CustomChickenData::new));
    }

    private CustomChickenData(CoreData coreData, BreedData breedData, RoostData roostData) {
        this.coreData = coreData;
        this.breedData = breedData;
        this.roostData = roostData;

        this.rawData = ChickenRegistry.getChickenRegistry().getRawCustomChickenObject(coreData.getName());
        this.registryID = new ResourceLocation(ResourceChickens.MOD_ID + ":" + coreData.getName() + "_chicken");
        this.entityType = ChickenUtisl.getEntityType(registryID);
    }

    protected CoreData coreData;
    protected RenderData renderData;
    protected BreedData breedData;
    protected RoostData roostData;
    protected SpawnData spawnData;

    protected JsonObject rawData;
    protected ResourceLocation registryID;
    protected EntityType<?> entityType;

    public CoreData getCoreData() {
        return coreData;
    }
    public RenderData getRenderData() {
        return renderData;
    }
    public BreedData getBreedData() {
        return breedData;
    }
    public RoostData getRoostData() {
        return roostData;
    }
    public SpawnData getSpawnData() {
        return spawnData;
    }

    public EntityType<?> getEntityType() {
        return entityType == null ? EntityType.CHICKEN : entityType;
    }
    public ResourceLocation getRegistryID() {
        return registryID;
    }
    @Nullable
    public JsonObject getRawData() {
        return rawData;
    }
    public String getFormattedName() {
        return WordUtils.capitalize(coreData.getName().replace("_", " "));
    }
    public CustomChickenData toImmutable() {
        return this;
    }

    public ItemStack getChickenItem() {
        return new ItemStack(ChickenUtisl.getItem(ResourceChickens.MOD_ID + ":" + getCoreData().getName() + "_chicken_item"));
    }
    public ItemStack getChickenSpawnEgg() {
        return new ItemStack(ChickenUtisl.getItem(ResourceChickens.MOD_ID + ":" + getCoreData().getName() + "_chicken_spawn_egg"));
    }

    public ItemStack getChickenFeather() {
        if(coreData.hasFeather()) {
            return new ItemStack(ChickenUtisl.getItem(ResourceChickens.MOD_ID + ":" + getCoreData().getName() + "_chicken_feather"));
        }
        return ItemStack.EMPTY;
    }

}
