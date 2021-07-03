package io.github.TheBlackSquidward.resourcechickens.api2;

import net.minecraftforge.fml.ModLoadingContext;

public class ResourceChickensAPI {

    public static final String MOD_ID = "resourcechickens";

    private static IChickenRegistry chickenRegistry;

    public static void setChickenRegistry(IChickenRegistry chickenRegistry) {
        if(ResourceChickensAPI.chickenRegistry == null && ModLoadingContext.get().getActiveContainer().getModId().equals(MOD_ID)) {
            ResourceChickensAPI.chickenRegistry = chickenRegistry;
        }
    }

    public static IChickenRegistry getChickenRegistry() {
        return chickenRegistry;
    }

}
