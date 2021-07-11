package io.github.TheBlackSquidward.resourcechickens.api.data.chickenData;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenType;

public class CoreData {

    public static final CoreData DEFAULT = new CoreData("error");

    public static Codec<CoreData> CODEC(String chickenName) {
        return RecordCodecBuilder.create(instance -> instance.group(
                Codec.STRING.fieldOf("name").orElse(chickenName).forGetter(CoreData::getName),
                ChickenType.CODEC.fieldOf("chickenType").orElse(ChickenType.DEFAULT).forGetter(CoreData::getChickenType),
                Codec.BOOL.fieldOf("hasFeather").orElse(false).forGetter(CoreData::hasFeather)
        ).apply(instance, CoreData::new));
    }



    private CoreData(String name) {
        this.chickenName = name;
        this.chickenType = ChickenType.DEFAULT;
        this.hasFeather = false;
    }

    private CoreData(String chickenName, ChickenType chickenType, boolean hasFeather) {
        this.chickenName = chickenName;
        this.chickenType = chickenType;
        this.hasFeather = hasFeather;
    }

    protected String chickenName;
    protected ChickenType chickenType;
    protected boolean hasFeather;

    public String getName() {
        return chickenName;
    }
    public ChickenType getChickenType() { return chickenType; }
    public boolean hasFeather() {  return hasFeather; }

}
