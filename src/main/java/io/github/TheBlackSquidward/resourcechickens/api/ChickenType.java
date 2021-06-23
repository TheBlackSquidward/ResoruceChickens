package io.github.TheBlackSquidward.resourcechickens.api;

import net.minecraft.util.text.TextFormatting;

public enum ChickenType {

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
}
