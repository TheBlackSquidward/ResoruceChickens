package io.github.TheBlackSquidward.resourcechickens.init;

import io.github.TheBlackSquidward.resourcechickens.screens.*;
import net.minecraft.client.gui.ScreenManager;

public class ModScreens {

    public static void registerScreens() {
        ScreenManager.register(ModContainers.CHICKEN_BREEDER_CONTAINER.get(), ChickenBreederScreen::new);
        ScreenManager.register(ModContainers.ELECTRIC_CHICKEN_BREEDER_CONTAINER.get(), ElectricChickenBreederScreen::new);
        ScreenManager.register(ModContainers.ROOST_CONTAINER.get(), RoostScreen::new);
        ScreenManager.register(ModContainers.ELECTRIC_ROOST_CONTAINER.get(), ElectricRoostScreen::new);
        ScreenManager.register(ModContainers.INCUBATOR_CONTAINER.get(), IncubatorScreen::new);
        ScreenManager.register(ModContainers.ELECTRIC_INCUBATOR_CONTAINER.get(), ElectricIncubatorScreen::new);
    }

}
