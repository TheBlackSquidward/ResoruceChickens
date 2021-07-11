package io.github.TheBlackSquidward.resourcechickens.api.data.chickenData;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.TheBlackSquidward.resourcechickens.utils.Color;

public class RenderData {

    public static RenderData DEFAULT = new RenderData(false, false, Color.DEFAULT, Color.DEFAULT);

    public static Codec<RenderData> CODEC = RecordCodecBuilder.create((instance -> instance.group(
            Codec.BOOL.fieldOf("isGlowing").orElse(false).forGetter(RenderData::isGlowing),
            Codec.BOOL.fieldOf("hasGlint").orElse(false).forGetter(RenderData::hasGlint),
            Color.CODEC.fieldOf("spawnEggPrimaryColor").orElse(Color.DEFAULT).forGetter(RenderData::getSpawnEggPrimaryColor),
            Color.CODEC.fieldOf("spawnEggSecondaryColor").orElse(Color.DEFAULT).forGetter(RenderData::getSpawnEggSecondaryColor)
    ).apply(instance, RenderData::new)));

    protected boolean isGlowing;
    protected boolean hasGlint;
    protected Color spawnEggPrimaryColor;
    protected Color spawnEggSecondaryColor;


    private RenderData(boolean isGlowing, boolean hasGlint, Color spawnEggPrimaryColor, Color spawnEggSecondaryColor) {
        this.isGlowing = isGlowing;
        this.hasGlint = hasGlint;
        this.spawnEggPrimaryColor = spawnEggPrimaryColor;
        this.spawnEggSecondaryColor = spawnEggSecondaryColor;
    }

    public boolean isGlowing() {
        return isGlowing;
    }
    public boolean hasGlint() {
        return hasGlint;
    }
    public Color getSpawnEggPrimaryColor() {
        return spawnEggPrimaryColor;
    }
    public Color getSpawnEggSecondaryColor() {
        return spawnEggSecondaryColor;
    }

}