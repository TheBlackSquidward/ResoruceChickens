package io.github.TheBlackSquidward.resourcechickens.events;

import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.entities.CustomChickenEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onAttributeCreation(EntityAttributeCreationEvent e) {
        for(ChickenRegistryObject chicken : ChickenRegistry.getChickenRegistry()) {
            e.put(chicken.getChickenEntityRegistryObject().get(), CustomChickenEntity.setCustomAttributes().build());
        }
    }

}
