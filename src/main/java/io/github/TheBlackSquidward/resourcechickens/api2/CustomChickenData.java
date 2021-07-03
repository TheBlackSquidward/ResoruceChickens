package io.github.TheBlackSquidward.resourcechickens.api2;

import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api2.data.BreedData;
import io.github.TheBlackSquidward.resourcechickens.api2.data.CoreData;
import io.github.TheBlackSquidward.resourcechickens.api2.data.RoostData;
import io.github.TheBlackSquidward.resourcechickens.api2.utils.ChickenUtisl;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

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
        this.formattedName = new TranslationTextComponent("entity.resourcechickens." + coreData.getName() + "_chicken");
    }

    protected CoreData coreData;
    protected BreedData breedData;
    protected RoostData roostData;

    protected JsonObject rawData;
    protected ResourceLocation registryID;
    protected EntityType<?> entityType;
    protected TranslationTextComponent formattedName;

    public CoreData getCoreData() {
        return coreData;
    }
    public BreedData getBreedData() {
        return breedData;
    }
    public RoostData getRoostData() {
        return roostData;
    }

    public EntityType<?> getEntityType() {
        return entityType == null ? EntityType.BEE : entityType;
    }
    public ResourceLocation getRegistryID() {
        return registryID;
    }
    @Nullable
    public JsonObject getRawData() {
        return rawData;
    }
    public TranslationTextComponent getFormattedName() {
        return formattedName;
    }
    public CustomChickenData toImmutable() {
        return this;
    }

}
