package io.github.TheBlackSquidward.resourcechickens.api.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class RoostOutputData {

    public static final Codec<RoostOutputData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ItemOutputData.CODEC.fieldOf("itemOutput").forGetter(RoostOutputData::getItemOutputData),
            Codec.doubleRange(0.0, 1.0).fieldOf("chance").orElse(1.0).forGetter(RoostOutputData::getChance)
    ).apply(instance, RoostOutputData::new));

    public RoostOutputData(ItemOutputData itemOutputData, double chance) {
        this.itemOutputData = itemOutputData;
        this.chance = chance;
    }

    protected ItemOutputData itemOutputData;
    protected final double chance;

    public ItemOutputData getItemOutputData() {
        return itemOutputData;
    }
    public double getChance() {
        return chance;
    }

}
