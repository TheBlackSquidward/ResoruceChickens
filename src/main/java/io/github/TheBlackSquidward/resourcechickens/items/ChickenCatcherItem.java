package io.github.TheBlackSquidward.resourcechickens.items;

import com.sun.javafx.geom.Vec3d;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.entities.CustomChickenEntity;
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
        super(new Item.Properties().stacksTo(1).defaultDurability(128));
    }

    @Override
    public ActionResultType interactLivingEntity(ItemStack itemStack, PlayerEntity p, LivingEntity entity, Hand hand) {
        Vec3d pos = new Vec3d(entity.getX(), entity.getY(), entity.getZ());
        World world = p.level;
        if (entity instanceof CustomChickenEntity) {
            CustomChickenEntity chickenEntity = (CustomChickenEntity) entity;
            ChickenRegistryObject chickenRegistryObject = ChickenRegistry.getChickenRegistryObjectbyEntity(chickenEntity);
            if (!entity.isBaby()) {
                if (world.isClientSide) {
                   p.level.playSound(p, pos.x, pos.y, pos.z, SoundEvents.CHICKEN_EGG, entity.getSoundSource(), 1.0F, 1.0F);
                } else {
                    p.addItem(new ItemStack(chickenRegistryObject.getChickenItemRegistryObject().get(), 1));
                    itemStack.hurtAndBreak(1, p, (p_220045_0_) -> {
                        p_220045_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
                    });
                    entity.remove();
                }} else {
                return ActionResultType.SUCCESS;
            }
        } else if (entity instanceof ChickenEntity) {
            if (!entity.isBaby()) {
                if (world.isClientSide()) {
                    p.level.playSound(p, pos.x, pos.y, pos.z, SoundEvents.CHICKEN_EGG, entity.getSoundSource(), 1.0F, 1.0F);
                } else {
                    itemStack.hurtAndBreak(1, p, (p_220045_0_) -> {
                        p_220045_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
                    });
                    entity.remove();
                }}
        }
        return ActionResultType.SUCCESS;
    }
}
