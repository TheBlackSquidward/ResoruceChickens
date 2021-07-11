package io.github.TheBlackSquidward.resourcechickens.api.data.chickenData;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.TheBlackSquidward.resourcechickens.utils.Color;

public class ColorData {

    public static ColorData DEFAULT = new ColorData(Color.DEFAULT, Color.DEFAULT, Color.DEFAULT);

    public static Codec<ColorData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Color.CODEC.fieldOf("spawnEggPrimaryColor").orElse(Color.DEFAULT).forGetter(ColorData::getSpawnEggPrimaryColor),
            Color.CODEC.fieldOf("spawnEggSecondaryColor").orElse(Color.DEFAULT).forGetter(ColorData::getSpawnEggSecondaryColor),
            Color.CODEC.fieldOf("featherColor").orElse(Color.DEFAULT).forGetter(ColorData::getFeatherColor)
    ).apply(instance, ColorData::new));


    protected Color spawnEggPrimaryColor;
    protected Color spawnEggSecondaryColor;
    protected Color featherColor;

    private ColorData(Color spawnEggPrimaryColor, Color spawnEggSecondaryColor, Color featherColor) {
        this.spawnEggPrimaryColor = spawnEggPrimaryColor;
        this.spawnEggSecondaryColor = spawnEggSecondaryColor;
        this.featherColor = featherColor;
    }

    public Color getSpawnEggPrimaryColor() {
        return spawnEggPrimaryColor;
    }
    public Color getSpawnEggSecondaryColor() {
        return spawnEggSecondaryColor;
    }
    public Color getFeatherColor() {
        return featherColor;
    }

}
