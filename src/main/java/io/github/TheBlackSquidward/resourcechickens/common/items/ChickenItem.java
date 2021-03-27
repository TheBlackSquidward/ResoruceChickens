package io.github.TheBlackSquidward.resourcechickens.common.items;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.init.ItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class ChickenItem extends Item {

    public ChickenItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        CompoundNBT nbt = stack.getOrCreateTag();
        int gain = nbt.getInt(ResourceChickens.MODID + "_chicken_gain");
        int growth = nbt.getInt(ResourceChickens.MODID + "_chicken_growth");
        int strength = nbt.getInt(ResourceChickens.MODID + "_chicken_strength");
        if (gain != 0) {
            tooltip.add(new StringTextComponent("Gain: " + gain));
        }
        if (growth != 0) {
            tooltip.add(new StringTextComponent("Growth: " + growth));
        }
        if (strength != 0) {
            tooltip.add(new StringTextComponent("Strength: " + strength));
        }
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack itemStack, ItemUseContext context) {
        PlayerEntity p = context.getPlayer();
        if (p != null) {
            BlockPos finalBlockpos;
            World world = context.getLevel();
            if (!world.isClientSide()) {
                if (itemStack.getItem() != ItemInit.VANILLA_CHICKEN.get()) {
                    BlockPos blockpos = context.getClickedPos();
                    Direction direction = context.getClickedFace();
                    BlockState blockstate = world.getBlockState(blockpos);
                    if (!blockstate.canSurvive(world, blockpos)) {
                        finalBlockpos = blockpos;
                    } else {
                        finalBlockpos = blockpos.offset(direction.getNormal());
                    }
                    ChickenRegistryObject chickenRegistryObject = ChickenRegistry.getChickenRegistryObjectbyChickenItem(itemStack.getItem());
                    chickenRegistryObject.getChickenEntityRegisryObject().get().spawn((ServerWorld) world, itemStack, p, finalBlockpos, SpawnReason.SPAWN_EGG, false, false);
                    itemStack.shrink(1);
                    return ActionResultType.CONSUME;
                } else {
                    BlockPos blockpos = context.getClickedPos();
                    Direction direction = context.getClickedFace();
                    BlockState blockstate = world.getBlockState(blockpos);
                    if (!blockstate.canSurvive(world, blockpos)) {
                        finalBlockpos = blockpos;
                    } else {
                        finalBlockpos = blockpos.offset(direction.getNormal());
                    }
                    EntityType.CHICKEN.spawn((ServerWorld) world, itemStack, p, finalBlockpos, SpawnReason.SPAWN_EGG, false, false);
                    itemStack.shrink(1);
                    return ActionResultType.CONSUME;
                }
            } else {
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.SUCCESS;
    }
}
