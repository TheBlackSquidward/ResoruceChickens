package io.github.TheBlackSquidward.resourcechickens.utils;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.client.render.CustomChickenRenderer;
import io.github.TheBlackSquidward.resourcechickens.entities.CustomChickenEntity;
import io.github.TheBlackSquidward.resourcechickens.init.TileEntityInit;
import io.github.TheBlackSquidward.resourcechickens.screens.*;
import io.github.TheBlackSquidward.resourcechickens.init.ContainerInit;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ResourceChickens.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent e) {
        ChickenRegistry.getChickenRegistry().forEach((customChicken) -> RenderingRegistry.registerEntityRenderingHandler(customChicken.getChickenEntityRegistryObject().get(), CustomChickenRenderer::new));
        ScreenManager.register(ContainerInit.CHICKEN_BREEDER_CONTAINER.get(), ChickenBreederScreen::new);
        ScreenManager.register(ContainerInit.ELECTRIC_CHICKEN_BREEDER_CONTAINER.get(), ElectricChickenBreederScreen::new);
        ScreenManager.register(ContainerInit.ROOST_CONTAINER.get(), RoostScreen::new);
        ScreenManager.register(ContainerInit.ELECTRIC_ROOST_CONTAINER.get(), ElectricRoostScreen::new);
        ScreenManager.register(ContainerInit.INCUBATOR_CONTAINER.get(), IncubatorScreen::new);
        ScreenManager.register(ContainerInit.ELECTRIC_INCUBATOR_CONTAINER.get(), ElectricIncubatorScreen::new);

        TileEntityInit.registerTileEntityRenders();
    }

    @SubscribeEvent
    public static void onAttributeCreation(EntityAttributeCreationEvent e) {
        for(ChickenRegistryObject chicken : ChickenRegistry.getChickenRegistry()) {
            e.put(chicken.getChickenEntityRegistryObject().get(), CustomChickenEntity.setCustomAttributes().build());
        }
    }

}
