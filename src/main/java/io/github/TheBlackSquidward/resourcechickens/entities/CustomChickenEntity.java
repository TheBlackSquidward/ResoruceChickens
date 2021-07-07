package io.github.TheBlackSquidward.resourcechickens.entities;

import com.google.gson.JsonObject;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.CustomChickenData;
import io.github.TheBlackSquidward.resourcechickens.api.IResourceChicken;
import io.github.TheBlackSquidward.resourcechickens.api.data.BreedData;
import io.github.TheBlackSquidward.resourcechickens.api.data.CoreData;
import io.github.TheBlackSquidward.resourcechickens.api.data.RoostData;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

public class CustomChickenEntity extends ChickenEntity implements IResourceChicken {

    private static final Ingredient TEMPTATION_ITEM = Ingredient.of(Items.WHEAT_SEEDS);

    protected final CustomChickenData customChickenData;
    protected final String chickenName;

    public CustomChickenEntity(EntityType<? extends ChickenEntity> type, World worldIn, String chickenName) {
        super(type, worldIn);
        this.chickenName = chickenName;
        this.customChickenData = ChickenRegistry.getChickenRegistry().getChickenData(chickenName);
    }

    public CustomChickenData getCustomChickenData() {
        return customChickenData;
    }
    public String getChickenName() {
        return chickenName;
    }
    public JsonObject getRawChickenData() {
        return customChickenData.getRawData();
    }
    public CoreData getCoreData() {
        return customChickenData.getCoreData();
    }
    public BreedData getBreedData() {
        return customChickenData.getBreedData();
    }
    public RoostData getRoostData() {
        return customChickenData.getRoostData();
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEM));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.CHICKEN_AMBIENT;
    }

    @ParametersAreNonnullByDefault
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.CHICKEN_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.CHICKEN_DEATH;
    }

    @ParametersAreNonnullByDefault
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.CHICKEN_STEP, 0.15F, 1.0F);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 4.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    public boolean canFallInLove() {
        return false;
    }
}
