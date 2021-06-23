package io.github.TheBlackSquidward.resourcechickens.events;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.client.render.CustomChickenRenderer;
import io.github.TheBlackSquidward.resourcechickens.init.ModScreens;
import io.github.TheBlackSquidward.resourcechickens.init.ModTileEntities;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SetupEvents {

    @SubscribeEvent
    public static void setupClient(FMLClientSetupEvent e) {
        ResourceChickens.LOGGER.info("Beginning Client Setup...");
        ChickenRegistry.getChickenRegistry().forEach((customChicken) -> RenderingRegistry.registerEntityRenderingHandler(customChicken.getChickenEntityRegistryObject().get(), CustomChickenRenderer::new));
        ModScreens.registerScreens();
        ModTileEntities.registerTileEntityRenderers();
    }

    @SubscribeEvent
    public static void setupCommon(FMLCommonSetupEvent e) {
        ResourceChickens.LOGGER.info("Beginning Common Setup...");
    }

    @SubscribeEvent
    public static void setupDedicatedServer(FMLDedicatedServerSetupEvent e) {
        ResourceChickens.LOGGER.info("Beginning Dedicated Server Setup...");
    }

}
