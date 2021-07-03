package io.github.TheBlackSquidward.resourcechickens.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.world.World;

public class ResourceChicken extends CustomChickenEntity{

    public ResourceChicken(EntityType<? extends ChickenEntity> type, World worldIn, String chickenName) {
        super(type, worldIn, chickenName);
    }

}
