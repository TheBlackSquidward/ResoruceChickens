package io.github.TheBlackSquidward.resourcechickens.events;

import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.IChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.entities.CustomChickenEntity;
import io.github.TheBlackSquidward.resourcechickens.init.ModEntities;
import io.github.TheBlackSquidward.resourcechickens.items.ChickenSpawnEggItem;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    private static final IChickenRegistry chickenRegistry = ChickenRegistry.getChickenRegistry();

    @SubscribeEvent
    public static void onAttributeCreation(EntityAttributeCreationEvent e) {
        ModEntities.getModChickens().forEach((s, customChicken) -> e.put(customChicken.get(), CustomChickenEntity.createAttributes().build()));
    }

    @SubscribeEvent
    public static void onItemColor(ColorHandlerEvent.Item e) {
        ItemColors colors = e.getItemColors();
        chickenRegistry.getChickens().forEach((chickenName, customChickenData) -> {
            if(!customChickenData.getRenderData().getSpawnEggSecondaryColor().isDefault() && !customChickenData.getRenderData().getSpawnEggPrimaryColor().isDefault()) {
                registerItems(colors, ChickenSpawnEggItem::getColor, customChickenData.getChickenSpawnEgg().getItem());
            }
        });
    }

    private static void registerItems(ItemColors handler, IItemColor itemColor, IItemProvider items) {
        try {
            handler.register(itemColor, items);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
