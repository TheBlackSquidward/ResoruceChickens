package io.github.TheBlackSquidward.resourcechickens.common.items;

import com.sun.javafx.geom.Vec3d;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.common.entities.CustomChickenEntity;
import io.github.TheBlackSquidward.resourcechickens.registries.ItemRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ChickenCatcherItem extends Item {

    public ChickenCatcherItem() {
        super(new Item.Properties().maxStackSize(1).maxDamage(128));
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
                    //TODO add particles
                }else{
                    p.addItemStackToInventory(new ItemStack(chickenRegistryObject.getChickenItemRegistryObject().get(), 1));
                    itemStack.damageItem(1, p,(p_220045_0_) -> {
                        p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
                    });
                    entity.remove();
                }
            } else {
                return ActionResultType.SUCCESS;
            }
        }else if(entity instanceof ChickenEntity) {
            if(!entity.isChild()) {
                if(world.isRemote()) {
                    p.getEntityWorld().playSound(p, pos.x, pos.y, pos.z, SoundEvents.ENTITY_CHICKEN_EGG, entity.getSoundCategory(), 1.0F, 1.0F);
                    //TODO add particles
                }else{
                    p.addItemStackToInventory(new ItemStack(ItemRegistry.VANILLA_CHICKEN.get(), 1));
                    itemStack.damageItem(1, p,(p_220045_0_) -> {
                        p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
                    });
                    entity.remove();
                }
            }
        }
        return ActionResultType.SUCCESS;
    }
}
