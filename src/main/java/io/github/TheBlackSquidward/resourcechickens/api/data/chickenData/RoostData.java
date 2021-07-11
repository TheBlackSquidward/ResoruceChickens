package io.github.TheBlackSquidward.resourcechickens.api.data.chickenData;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.TheBlackSquidward.resourcechickens.api.data.RoostOutputData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoostData {

    public static final RoostData DEFAULT = new RoostData(false, 0, Collections.emptyList());

    public static Codec<RoostData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Codec.BOOL.fieldOf("canRoost").orElse(false).forGetter(RoostData::canRoost),
                Codec.INT.fieldOf("totalRoostTime").orElse(300).forGetter(RoostData::getTotalRoostTime),
                RoostOutputData.CODEC.listOf().fieldOf("roostOutput").orElse(new ArrayList<>()).forGetter(RoostData::getRoostOutputs)
        ).apply(instance, RoostData::new));

    private RoostData(boolean canRoost, int totalRoostTime, List<RoostOutputData> roostOutputs) {
        this.canRoost = canRoost;
        this.totalRoostTime = totalRoostTime;
        this.roostOutputs = roostOutputs;
    }


    protected boolean canRoost;
    protected int totalRoostTime;
    protected List<RoostOutputData> roostOutputs;

    public boolean canRoost() {
        return canRoost;
    }
    public int getTotalRoostTime() {
        return totalRoostTime;
    }
    public List<RoostOutputData> getRoostOutputs() {
        return roostOutputs;
    }

}
