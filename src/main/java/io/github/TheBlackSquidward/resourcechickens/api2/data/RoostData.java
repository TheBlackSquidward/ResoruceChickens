package io.github.TheBlackSquidward.resourcechickens.api2.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class RoostData {

    public static final RoostData DEFAULT = new RoostData(false, 0);

    public static Codec<RoostData> CODEC() {
        return RecordCodecBuilder.create(instance -> instance.group(
                Codec.BOOL.fieldOf("canRoost").orElse(false).forGetter(RoostData::canRoost),
                //TODO change default value
                Codec.INT.fieldOf("totalRoostTime").orElse(300).forGetter(RoostData::getTotalRoostTime)
        ).apply(instance, RoostData::new));
    }

    private RoostData(boolean canRoost, int totalRoostTime) {
        this.canRoost = canRoost;
        this.totalRoostTime = totalRoostTime;
    }

    protected boolean canRoost;
    protected int totalRoostTime;

    public boolean canRoost() {
        return canRoost;
    }
    public int getTotalRoostTime() {
        return totalRoostTime;
    }

}
