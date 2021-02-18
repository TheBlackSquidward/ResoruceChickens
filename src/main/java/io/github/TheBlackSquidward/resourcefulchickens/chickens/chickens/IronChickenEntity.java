package io.github.TheBlackSquidward.resourcefulchickens.chickens.chickens;

import io.github.TheBlackSquidward.resourcefulchickens.chickens.CustomChickenEntity;
import io.github.TheBlackSquidward.resourcefulchickens.init.EntityInit;
import io.github.TheBlackSquidward.resourcefulchickens.init.ItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class IronChickenEntity extends CustomChickenEntity {

    public IronChickenEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

}
