package io.github.TheBlackSquidward.resourcechickens.api.data.chickenData;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class SpawnData {

    public static SpawnData DEFAULT = new SpawnData(false);

    public static Codec<SpawnData> CODEC = RecordCodecBuilder.create((instance -> instance.group(
            Codec.BOOL.fieldOf("canSpawnInWorld").orElse(false).forGetter(SpawnData::canSpawnInWorld)
            ).apply(instance, SpawnData::new)));

    protected boolean canSpawnInWorld;

    private SpawnData(boolean canSpawnInWorld) {
        this.canSpawnInWorld = canSpawnInWorld;
    }

    public boolean canSpawnInWorld() {
        return canSpawnInWorld;
    }

}
