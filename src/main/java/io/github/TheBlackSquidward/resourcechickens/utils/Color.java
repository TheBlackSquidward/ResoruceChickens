package io.github.TheBlackSquidward.resourcechickens.utils;

import com.google.gson.JsonPrimitive;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.JsonOps;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

import java.util.*;

public class Color {


    //TODO proof!!!!!!

    protected static final Map<String, Color> colorsWithNames = new HashMap<>();

    public static final Codec<Color> CODEC = Codec.PASSTHROUGH.comapFlatMap(Color::decodeColor, color -> new Dynamic<>(JsonOps.INSTANCE, new JsonPrimitive(color.value)));
    public static final Color DEFAULT = defaultColor();
    public static final Color RAINBOW;
    private float[] rgbaValue;

    static {
        RAINBOW = createRainbowColor();
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> Color::initRainbow);
    }

    private int r;
    private int g;
    private int b;
    private final int a;
    private int value;
    private boolean defaultValue;
    private boolean isRainbow;

    public Color(int value) {
        this.a = (value >> 24) & 0xFF;
        this.r = (value >> 16) & 0xFF;
        this.g = (value >> 8) & 0xFF;
        this.b = value & 0xFF;
        this.value = value;

        updateFloats();
    }

    public Color(int r, int g, int b, int a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;

        updateValue();
        updateFloats();
    }

    private void updateFloats(){
        rgbaValue = new float[4];
        rgbaValue[0] = this.getFloatRed();
        rgbaValue[1] = this.getFloatGreen();
        rgbaValue[2] = this.getFloatBlue();
        rgbaValue[3] = this.getFloatAlpha();
    }

    private void updateValue(){
        this.value = (this.a << 24) | (this.r << 16) | (this.g << 8) | this.b;
    }

    public float getFloatRed() { return r / 255f; }

    public float getFloatGreen() { return g / 255f; }

    public float getFloatBlue() { return b / 255f; }

    public float getFloatAlpha() { return a / 255f; }

    public int getIntRed() { return r; }

    public int getIntGreen() { return g; }

    public int getIntBlue() { return b; }

    public int getIntAlpha() { return a; }

    public int getValue() { return value; }

    public boolean isDefault(){ return defaultValue; }

    public boolean isRainbow(){ return isRainbow; }

    @Override
    public String toString() {
        if (this.isRainbow) return "rainbow";
        return String.format("#%x", this.value);
    }

    private static Color defaultColor() {
        Color color = new Color(0xffffff);
        color.defaultValue = true;
        return color;
    }

    private static Color createRainbowColor() {
        Color color = new Color(0xff0000);
        color.isRainbow = true;
        colorsWithNames.put("rainbow", color);
        return color;
    }

    public static Color createNamedColor(String name, int value) {
        Color color = new Color(value);
        colorsWithNames.putIfAbsent(name.toLowerCase(Locale.ENGLISH), color);
        return color;
    }

    public static Color parse(String color) {
        if (colorsWithNames.containsKey(color.toLowerCase()))
            return colorsWithNames.get(color.toLowerCase());
        return new Color(parseColor(color));
    }

    public static int parseColor(String color){
        Objects.requireNonNull(color);
        if (color.startsWith("0x") || color.startsWith("#"))
            return Long.decode(color).intValue();
        else if (colorsWithNames.containsKey(color.toLowerCase()))
            return colorsWithNames.get(color.toLowerCase()).getValue();
        return 0;
    }

    public static DataResult<Color> decodeColor(Dynamic<?> dynamic) {
        if (dynamic.asNumber().result().isPresent()) {
            return DataResult.success(new Color(dynamic.asInt(0xffffff)));
        } else if (dynamic.asString().result().isPresent()) {
            return DataResult.success(Color.parse(dynamic.asString("WHITE")));
        }
        return DataResult.error("Color input not valid!");
    }

    public static void initRainbow() { new Timer().scheduleAtFixedRate(new ColorChange(), 0, 20); }

    private static class ColorChange extends TimerTask {
        @Override
        public void run() {
            if(RAINBOW.r > 0 && RAINBOW.b == 0){
                RAINBOW.r--;
                RAINBOW.g++;
            }
            if(RAINBOW.g > 0 && RAINBOW.r == 0){
                RAINBOW.g--;
                RAINBOW.b++;
            }
            if(RAINBOW.b > 0 && RAINBOW.g == 0){
                RAINBOW.r++;
                RAINBOW.b--;
            }

            RAINBOW.updateValue();
            RAINBOW.updateFloats();
        }
    }

}
