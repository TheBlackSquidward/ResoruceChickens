package io.github.TheBlackSquidward.resourcefulchickens;

import io.github.TheBlackSquidward.resourcefulchickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcefulchickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcefulchickens.common.entities.CustomChickenEntity;
import io.github.TheBlackSquidward.resourcefulchickens.common.items.ChickenCatcherItem;
import io.github.TheBlackSquidward.resourcefulchickens.init.ItemInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ChickenCatcherEvent {

    @SubscribeEvent
    public void onInteract(PlayerInteractEvent.EntityInteract e) {
        World world = e.getWorld();
        PlayerEntity p = e.getPlayer();
        Entity entity = e.getTarget();
        if (!world.isRemote) {
            if (e.getHand() == Hand.MAIN_HAND) {
                if (entity instanceof CustomChickenEntity) {
                    CustomChickenEntity customChickenEntity = (CustomChickenEntity) entity;
                    if (p.getHeldItemMainhand().getItem() instanceof ChickenCatcherItem) {
                        ChickenRegistryObject chickenRegistryObject = ChickenRegistry.getChickenRegistryObjectbyEntity(customChickenEntity);
                        //TODO maybe some cool particle effects
                        p.addItemStackToInventory(new ItemStack(chickenRegistryObject.getChickenItemRegistryObject().get()));
                        customChickenEntity.remove();
                    }
                }
                if(entity instanceof ChickenEntity) {
                    ChickenEntity chickenEntity = (ChickenEntity) entity;
                    if (p.getHeldItemMainhand().getItem() instanceof ChickenCatcherItem) {
                        //TODO maybe some cool particle effects
                        p.addItemStackToInventory(new ItemStack(ItemInit.VANILLA_CHICKEN.get()));
                        chickenEntity.remove();
                    }
                }
            }
        }
    }
}
