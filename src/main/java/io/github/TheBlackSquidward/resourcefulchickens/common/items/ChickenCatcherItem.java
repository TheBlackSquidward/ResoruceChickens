package io.github.TheBlackSquidward.resourcefulchickens.common.items;

import com.sun.javafx.geom.Vec3d;
import io.github.TheBlackSquidward.resourcefulchickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcefulchickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcefulchickens.common.entities.CustomChickenEntity;
import io.github.TheBlackSquidward.resourcefulchickens.init.ItemInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.Random;

public class ChickenCatcherItem extends Item {

    public ChickenCatcherItem() {
        super(new Item.Properties().maxDamage(128).maxStackSize(1).setNoRepair());
    }

    @Override
    public ActionResultType itemInteractionForEntity(ItemStack itemStack, PlayerEntity p, LivingEntity entity, Hand hand) {
        Vec3d pos = new Vec3d(entity.getPosX(), entity.getPosY(), entity.getPosZ());
        World world = p.getEntityWorld();
        if (entity instanceof CustomChickenEntity) {
            CustomChickenEntity chickenEntity = (CustomChickenEntity) entity;
            ChickenRegistryObject chickenRegistryObject = ChickenRegistry.getChickenRegistryObjectbyEntity(chickenEntity);
            if (!entity.isChild()) {
                if (world.isRemote) {
                    p.getEntityWorld().playSound(p, pos.x, pos.y, pos.z, SoundEvents.ENTITY_CHICKEN_EGG, entity.getSoundCategory(), 1.0F, 1.0F);
                    p.addItemStackToInventory(new ItemStack(chickenRegistryObject.getChickenItemRegistryObject().get(), 1));
                    entity.remove();
                    //TODO add pretty particles and do damage to the catcher
                }
            } else {
                return ActionResultType.SUCCESS;
            }
        }else if(entity instanceof ChickenEntity) {
            if(!entity.isChild()) {
                if(world.isRemote()) {
                    p.getEntityWorld().playSound(p, pos.x, pos.y, pos.z, SoundEvents.ENTITY_CHICKEN_EGG, entity.getSoundCategory(), 1.0F, 1.0F);
                    p.addItemStackToInventory(new ItemStack(ItemInit.VANILLA_CHICKEN.get(), 1));
                    entity.remove();
                    //TODO add pretty particles and do damage to the catcher
                }
            }
        }
        return ActionResultType.SUCCESS;
    }
}
