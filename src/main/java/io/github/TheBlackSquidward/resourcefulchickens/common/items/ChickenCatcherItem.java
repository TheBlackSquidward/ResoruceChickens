package io.github.TheBlackSquidward.resourcefulchickens.common.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;

public class ChickenCatcherItem extends Item {

    public ChickenCatcherItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
        return super.itemInteractionForEntity(stack, playerIn, target, hand);
        //TODO add durability damage and full functionality
    }
}
