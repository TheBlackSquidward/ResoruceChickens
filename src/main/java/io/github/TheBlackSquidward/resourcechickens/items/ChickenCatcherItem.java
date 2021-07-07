package io.github.TheBlackSquidward.resourcechickens.items;

import com.sun.javafx.geom.Vec3d;
import io.github.TheBlackSquidward.resourcechickens.entities.CustomChickenEntity;
import io.github.TheBlackSquidward.resourcechickens.init.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

public class ChickenCatcherItem extends BaseItem {

    public ChickenCatcherItem() {
        super(new Properties().stacksTo(1).defaultDurability(128));
    }

    @ParametersAreNonnullByDefault
    @Override
    public ActionResultType interactLivingEntity(ItemStack itemStack, PlayerEntity p, LivingEntity entity, Hand hand) {
        Vec3d pos = new Vec3d(entity.getX(), entity.getY(), entity.getZ());
        World world = p.level;
        if (entity instanceof CustomChickenEntity) {
            CustomChickenEntity chickenEntity = (CustomChickenEntity) entity;
            if (!entity.isBaby()) {
                if (world.isClientSide) {
                   p.level.playSound(p, pos.x, pos.y, pos.z, SoundEvents.CHICKEN_EGG, entity.getSoundSource(), 1.0F, 1.0F);
                } else {
                    p.addItem(chickenEntity.getCustomChickenData().getChickenItem());
                    itemStack.hurtAndBreak(1, p, (p_220045_0_) -> p_220045_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND));
                    entity.remove();
                }} else {
                return ActionResultType.SUCCESS;
            }
        } else if (entity instanceof ChickenEntity) {
            if (!entity.isBaby()) {
                if (world.isClientSide()) {
                    p.level.playSound(p, pos.x, pos.y, pos.z, SoundEvents.CHICKEN_EGG, entity.getSoundSource(), 1.0F, 1.0F);
                } else {
                    p.addItem(new ItemStack(ModItems.vanillaChickenItem.get()));
                    itemStack.hurtAndBreak(1, p, (p_220045_0_) -> p_220045_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND));
                    entity.remove();
                }}
        }
        return ActionResultType.SUCCESS;
    }
}
