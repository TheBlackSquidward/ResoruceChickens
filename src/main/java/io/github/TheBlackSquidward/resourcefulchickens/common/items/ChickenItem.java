package io.github.TheBlackSquidward.resourcefulchickens.common.items;

import io.github.TheBlackSquidward.resourcefulchickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcefulchickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcefulchickens.registries.ItemRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class ChickenItem extends Item {

    private int gain = 0;
    private int growth = 0;
    private int strength = 0;

    public ChickenItem(Properties properties) {
        super(properties);
    }

    public ChickenItem(Properties properties, int gain, int growth, int strength) {
        super(properties);
        this.gain = gain;
        this.growth = growth;
        this.strength = strength;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        if(!(gain == 0 && growth == 0 && strength == 0)) {
        }
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        PlayerEntity p = context.getPlayer();
        ItemStack itemStack = context.getItem();
        if(p != null) {
            BlockPos finalBlockpos;
            World world = context.getWorld();
            if (!world.isRemote()) {
                if (itemStack.getItem() != ItemRegistry.VANILLA_CHICKEN.get()) {
                    BlockPos blockpos = context.getPos();
                    Direction direction = context.getFace();
                    BlockState blockstate = world.getBlockState(blockpos);
                    if (!blockstate.causesSuffocation((IBlockReader) world, blockpos)) {
                        finalBlockpos = blockpos;
                    } else {
                        finalBlockpos = blockpos.offset(direction);
                    }
                    ChickenRegistryObject chickenRegistryObject = ChickenRegistry.getChickenRegistryObjectbyChickenItem(itemStack.getItem());
                    chickenRegistryObject.getChickenEntityRegisryObject().get().spawn((ServerWorld) world, itemStack, p, finalBlockpos, SpawnReason.SPAWN_EGG, false, false);
                    itemStack.shrink(1);
                    return ActionResultType.CONSUME;
                } else {
                    BlockPos blockpos = context.getPos();
                    Direction direction = context.getFace();
                    BlockState blockstate = world.getBlockState(blockpos);
                    if (!blockstate.causesSuffocation((IBlockReader) world, blockpos)) {
                        finalBlockpos = blockpos;
                    } else {
                        finalBlockpos = blockpos.offset(direction);
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
