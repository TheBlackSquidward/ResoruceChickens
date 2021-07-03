package io.github.TheBlackSquidward.resourcechickens.api2.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class BreedData {

    public static final BreedData DEFAULT = new BreedData(false, 0, "", "");

    public static Codec<BreedData> CODEC() {
        return RecordCodecBuilder.create(breedDataInstance -> breedDataInstance.group(
                Codec.BOOL.fieldOf("canBreed").orElse(false).forGetter(BreedData::canBreed),
                //TODO change default value
                Codec.INT.fieldOf("totalBreedTime").orElse(2400).forGetter(BreedData::getTotalBreedTime),
                Codec.STRING.fieldOf("parent1").orElse(null).forGetter(BreedData::getParent1),
                Codec.STRING.fieldOf("parent2").orElse(null).forGetter(BreedData::getParent2)
        ).apply(breedDataInstance, BreedData::new));
    }

    private BreedData(boolean canBreed, int totalBreedTime, String parent1, String parent2) {
        this.canBreed = canBreed;
        this.totalBreedTime = totalBreedTime;
        this.parent1 = parent1;
        this.parent2 = parent2;
    }

    protected boolean canBreed;
    protected int totalBreedTime;
    protected String parent1;
    protected String parent2;

    public boolean canBreed() {
        return canBreed;
    }
    public int getTotalBreedTime() {
        return totalBreedTime;
    }
    public String getParent1() {
        return parent1 != null ? parent1.toLowerCase() : "";
    }
    public String getParent2() {
        return parent2 != null ? parent2.toLowerCase() : "";
    }

    public boolean hasParents() {
        return !getParent1().isEmpty() && !getParent2().isEmpty();
    }

}
