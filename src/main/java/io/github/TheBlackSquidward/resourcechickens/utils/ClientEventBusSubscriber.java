package io.github.TheBlackSquidward.resourcechickens.utils;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.client.render.CustomChickenRenderer;
import io.github.TheBlackSquidward.resourcechickens.common.screens.ChickenBreederScreen;
import io.github.TheBlackSquidward.resourcechickens.init.ContainerInit;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ResourceChickens.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent e) {
        ChickenRegistry.getChickenRegistry().forEach((s, customChicken) -> RenderingRegistry.registerEntityRenderingHandler((EntityType)customChicken.getChickenEntityRegisryObject().get(), CustomChickenRenderer::new));
        ScreenManager.registerFactory(ContainerInit.CHICKEN_BREEDER_CONTAINER.get(), ChickenBreederScreen::new);
    }

}
