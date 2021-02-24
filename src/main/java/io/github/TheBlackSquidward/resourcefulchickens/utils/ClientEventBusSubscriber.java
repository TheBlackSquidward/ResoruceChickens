package io.github.TheBlackSquidward.resourcefulchickens.utils;

import io.github.TheBlackSquidward.resourcefulchickens.ResourcefulChickens;
import io.github.TheBlackSquidward.resourcefulchickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcefulchickens.client.render.CustomChickenRenderer;
import io.github.TheBlackSquidward.resourcefulchickens.common.guis.ChickenBreederGUI;
import io.github.TheBlackSquidward.resourcefulchickens.registries.ContainerRegistry;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ResourcefulChickens.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent e) {
        ChickenRegistry.getChickenRegistry().forEach((s, customChicken) -> RenderingRegistry.registerEntityRenderingHandler((EntityType)customChicken.getChickenEntityRegisryObject().get(), CustomChickenRenderer::new));
        ScreenManager.registerFactory(ContainerRegistry.CHICKEN_BREEDER_CONTAINER.get(), ChickenBreederGUI::new);
    }

}
