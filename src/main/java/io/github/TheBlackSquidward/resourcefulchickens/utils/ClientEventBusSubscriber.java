package io.github.TheBlackSquidward.resourcefulchickens.utils;

import io.github.TheBlackSquidward.resourcefulchickens.ResourcefulChickens;
import io.github.TheBlackSquidward.resourcefulchickens.chickens.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcefulchickens.client.render.CustomChickenRenderer;
import io.github.TheBlackSquidward.resourcefulchickens.init.EntityInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ResourcefulChickens.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent e) {
        ChickenRegistry.getChickenRegistry().forEach((s, customChicken) -> RenderingRegistry.registerEntityRenderingHandler((EntityType)customChicken.getChickenEntityRegisryObject().get(), CustomChickenRenderer::new));
    }

}
