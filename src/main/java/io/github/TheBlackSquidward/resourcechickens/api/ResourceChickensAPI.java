package io.github.TheBlackSquidward.resourcechickens.api;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import net.minecraftforge.fml.ModLoadingContext;

public class ResourceChickensAPI {

    public static final String MOD_ID = "resourcechickens";

    private static IChickenRegistry chickenRegistry;

    public static void setChickenRegistry(IChickenRegistry chickenRegistry) {
        if(ResourceChickensAPI.chickenRegistry == null && ModLoadingContext.get().getActiveContainer().getModId().equals(MOD_ID)) {
            ResourceChickensAPI.chickenRegistry = chickenRegistry;
            ResourceChickens.LOGGER.info("Successfully loaded chicken registry.");
        }
    }

    public static IChickenRegistry getChickenRegistry() {
        return chickenRegistry;
    }

}
