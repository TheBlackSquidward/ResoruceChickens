package io.github.TheBlackSquidward.resourcechickens.api.data.chickenData;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class RenderData {

    public static RenderData DEFAULT = new RenderData(ColorData.DEFAULT, false, false);

    public static Codec<RenderData> CODEC = RecordCodecBuilder.create((instance -> instance.group(
            ColorData.CODEC.fieldOf("colorData").orElse(ColorData.DEFAULT).forGetter(RenderData::getColorData),
            Codec.BOOL.fieldOf("isGlowing").orElse(false).forGetter(RenderData::isGlowing),
            Codec.BOOL.fieldOf("hasGlint").orElse(false).forGetter(RenderData::hasGlint)
    ).apply(instance, RenderData::new)));

    protected ColorData colorData;
    protected boolean isGlowing;
    protected boolean hasGlint;

    private RenderData(ColorData colorData, boolean isGlowing, boolean hasGlint) {
        this.colorData = colorData;
        this.isGlowing = isGlowing;
        this.hasGlint = hasGlint;
    }

    public ColorData getColorData() {
        return colorData;
    }
    public boolean isGlowing() {
        return isGlowing;
    }
    public boolean hasGlint() {
        return hasGlint;
    }

}