package io.github.TheBlackSquidward.resourcefulchickens.common.entities;

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
import net.minecraft.nbt.CompoundNBT;
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

public class CustomChickenEntity extends AnimalEntity {

    private static Ingredient TEMPTATION_ITEM = Ingredient.fromItems(Items.WHEAT_SEEDS);
    private static transient int layTime;

    private static final DataParameter<Integer> CHICKEN_GROWTH = EntityDataManager.createKey(CustomChickenEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> CHICKEN_GAIN = EntityDataManager.createKey(CustomChickenEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> CHICKEN_STRENGTH = EntityDataManager.createKey(CustomChickenEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> CHICKEN_LAY_PROGRESS = EntityDataManager.createKey(CustomChickenEntity.class, DataSerializers.VARINT);

    private static final String CHICKEN_GROWTH_NBT = "Growth";
    private static final String CHICKEN_GAIN_NBT = "Gain";
    private static final String CHICKEN_STRENGTH_NBT = "Strength";
    private static final String CHICKEN_LAY_PROGRESS_NBT = "ChickenLayProgress";

    public int timeUntilNextLay = layTime;

    public CustomChickenEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
        layTime = this.rand.nextInt(6000) + 6000;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 4.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D);
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

    protected int getExperiencePoints(PlayerEntity player) {
        return 1 + this.world.rand.nextInt(4);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CHICKEN_AMBIENT;
    }
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_CHICKEN_HURT;
    }
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CHICKEN_DEATH;
    }
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
    }

    @Nullable
    public AgeableEntity createChild(AgeableEntity ageableEntity) {
        return null;
    }

    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }

    @Override
    public void livingTick() {
        super.livingTick();
        if (!this.world.isRemote && this.isAlive() && !this.isChild() && --this.timeUntilNextLay <= 0) {
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.entityDropItem(Items.EGG);
            this.timeUntilNextLay = layTime;
            //TODO change this;
            // For example shed feathers?
        }
    }

    /*
    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.putInt(CHICKEN_GAIN_NBT, 1);
        compoundNBT.putInt(CHICKEN_GROWTH_NBT, 1);
        compoundNBT.putInt(CHICKEN_STRENGTH_NBT, 1);
        compoundNBT.putInt(CHICKEN_LAY_PROGRESS_NBT, 0);
        return compoundNBT;
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(CHICKEN_GROWTH, Integer.valueOf(1));
        this.dataManager.register(CHICKEN_GAIN, Integer.valueOf(1));
        this.dataManager.register(CHICKEN_STRENGTH, Integer.valueOf(1));
        this.dataManager.register(CHICKEN_LAY_PROGRESS, Integer.valueOf(0));
    }
    public void readEntityfromNBT(CompoundNBT compound) {
        super.read(compound);
        this.dataManager.set(CHICKEN_TYPE, compound.getString(TYPE_NBT));
        this.dataManager.set(CHICKEN_GROWTH, Integer.valueOf(compound.getInt(CHICKEN_GROWTH_NBT)));
        this.dataManager.set(CHICKEN_GAIN, Integer.valueOf(compound.getInt(CHICKEN_GAIN_NBT)));
        this.dataManager.set(CHICKEN_STRENGTH, Integer.valueOf(compound.getInt(CHICKEN_STRENGTH_NBT)));
    }

    public void writeEntityToNBT(CompoundNBT compoundNBT) {
        super.writeAdditional(compoundNBT);
        compoundNBT.putString(CHICKEN_GROWTH_NBT, getChickenTypeInternal());
        compoundNBT.putInt("Growth", getGrowth());
        compoundNBT.putInt("Gain", getGain());
        compoundNBT.putInt("Strength", getStrength());
    }

    public String getChickenTypeInternal() {
        return (String)this.dataManager.get(CHICKEN_TYPE);
    }

    public int getGain() {
        return ((Integer)this.dataManager.get(CHICKEN_GAIN)).intValue();
    }

    private void setGain(int gain) {
        this.dataManager.set(CHICKEN_GAIN, Integer.valueOf(gain));
    }

    public int getGrowth() {
        return ((Integer)this.dataManager.get(CHICKEN_GROWTH)).intValue();
    }

    private void setGrowth(int growth) {
        this.dataManager.set(CHICKEN_GROWTH, Integer.valueOf(growth));
    }

    public int getStrength() {
        return ((Integer)this.dataManager.get(CHICKEN_STRENGTH)).intValue();
    }

    private void setStrength(int strength) {
        this.dataManager.set(CHICKEN_STRENGTH, Integer.valueOf(strength));
    }
    */

}
