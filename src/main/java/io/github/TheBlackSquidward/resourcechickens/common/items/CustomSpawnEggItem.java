package io.github.TheBlackSquidward.resourcechickens.common.items;

import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import net.minecraft.block.BlockState;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class CustomSpawnEggItem extends Item {

    public CustomSpawnEggItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        PlayerEntity p = context.getPlayer();
        ItemStack itemStack = context.getItem();
        if(p != null) {
            BlockPos finalBlockpos;
            World world = context.getWorld();
            if(!world.isRemote()) {
                BlockPos blockpos = context.getPos();
                Direction direction = context.getFace();
                BlockState blockstate = world.getBlockState(blockpos);
                if(!blockstate.causesSuffocation((IBlockReader) world, blockpos)) {
                    finalBlockpos = blockpos;
                }else{
                    finalBlockpos = blockpos.offset(direction);
                }
                ChickenRegistryObject chickenRegistryObject = ChickenRegistry.getChickenRegistryObjectbyChickenSpawnEggItem(itemStack.getItem());
                chickenRegistryObject.getChickenEntityRegisryObject().get().spawn((ServerWorld) world, itemStack, p, finalBlockpos, SpawnReason.SPAWN_EGG, false, false);
                itemStack.shrink(1);
                return ActionResultType.CONSUME;
            }else{
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.SUCCESS;
    }

}
