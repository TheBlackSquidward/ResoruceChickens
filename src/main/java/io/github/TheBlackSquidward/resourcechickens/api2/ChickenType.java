package io.github.TheBlackSquidward.resourcechickens.api2;

import com.mojang.serialization.Codec;
import net.minecraft.util.text.TextFormatting;

public enum ChickenType {

    DEFAULT(TextFormatting.WHITE + "Default"),
    VANILLA(TextFormatting.WHITE + "Vanilla"),
    SPECIAL(TextFormatting.RED + "S" + TextFormatting.GOLD + "p" + TextFormatting.YELLOW + "e" + TextFormatting.GREEN + "c" + TextFormatting.BLUE + "i" + TextFormatting.DARK_PURPLE + "a" + TextFormatting.LIGHT_PURPLE + "l"),
    DYE(TextFormatting.YELLOW + "Dye"),
    MODDED("Modded");

    ChickenType(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }

    public static final Codec<ChickenType> CODEC = Codec.STRING.xmap(ChickenType::valueOf, ChickenType::toString);
}
