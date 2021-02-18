package io.github.TheBlackSquidward.resourcefulchickens.chickens.chickens;

import io.github.TheBlackSquidward.resourcefulchickens.chickens.CustomChickenEntity;
import io.github.TheBlackSquidward.resourcefulchickens.init.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;

public class GoldChickenEntity extends CustomChickenEntity {

    public GoldChickenEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }
}
