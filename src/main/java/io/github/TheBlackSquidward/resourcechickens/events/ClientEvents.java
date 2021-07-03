package io.github.TheBlackSquidward.resourcechickens.events;

import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.api2.CustomChickenData;
import io.github.TheBlackSquidward.resourcechickens.entities.CustomChickenEntity;
import io.github.TheBlackSquidward.resourcechickens.init.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onAttributeCreation(EntityAttributeCreationEvent e) {
        ModEntities.getModChickens().forEach((s, customChicken) -> e.put(customChicken.get(), CustomChickenEntity.setCustomAttributes().build()));
    }

}
