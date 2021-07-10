package io.github.TheBlackSquidward.resourcechickens.items;

import io.github.TheBlackSquidward.resourcechickens.utils.Constants;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
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
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public abstract class ChickenItem extends BaseItem {

    public ChickenItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable World worldIn, @NotNull List<ITextComponent> tooltip, @NotNull ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        CompoundNBT nbt = stack.getOrCreateTag();
        int gain = nbt.getInt(Constants.NBT.GAIN);
        int growth = nbt.getInt(Constants.NBT.GROWTH);
        int strength = nbt.getInt(Constants.NBT.STRENGTH);
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
        CompoundNBT nbt = itemStack.getOrCreateTag();
        int gain = nbt.getInt(Constants.NBT.GAIN);
        int growth = nbt.getInt(Constants.NBT.GROWTH);
        int strength = nbt.getInt(Constants.NBT.STRENGTH);
        PlayerEntity p = context.getPlayer();
        if (p != null) {
            BlockPos finalBlockpos;
            World world = context.getLevel();
            if (!world.isClientSide()) {
                BlockPos blockpos = context.getClickedPos();
                Direction direction = context.getClickedFace();
                BlockState blockstate = world.getBlockState(blockpos);
                if (!blockstate.canSurvive(world, blockpos)) {
                    finalBlockpos = blockpos;
                } else {
                    finalBlockpos = blockpos.offset(direction.getNormal());
                }
                getType(nbt).spawn((ServerWorld) world, itemStack, p, finalBlockpos, SpawnReason.SPAWN_EGG, false, false);
                itemStack.shrink(1);
                return ActionResultType.CONSUME;
            } else {
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.SUCCESS;
    }

    @NotNull
    public abstract EntityType<?> getType(@Nullable final CompoundNBT nbt);

}
