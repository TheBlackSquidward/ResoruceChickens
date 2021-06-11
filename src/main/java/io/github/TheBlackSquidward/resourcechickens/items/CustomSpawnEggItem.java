package io.github.TheBlackSquidward.resourcechickens.items;

import io.github.TheBlackSquidward.resourcechickens.api.ChickenDrop;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.apache.commons.lang3.text.WordUtils;

import javax.annotation.Nullable;
import java.util.List;

public class CustomSpawnEggItem extends BaseItem {

    public CustomSpawnEggItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        ChickenRegistryObject chickenRegistryObject = ChickenRegistry.getChickenRegistryObjectbyChickenSpawnEggItem(this);
        StringBuilder stringBuilder = new StringBuilder(100);
        if(chickenRegistryObject.getFinalOutput().size() > 1) {
            //TODO more than one drop
        }else{
            for(ChickenDrop chickenDrop : chickenRegistryObject.getFinalOutput()) {
                stringBuilder.append(chickenDrop.getItem().toString());
            }
        }
        String itemOutput = WordUtils.capitalize(stringBuilder.toString().replace("_", " "));
        tooltip.add(new StringTextComponent(TextFormatting.GRAY + "Lay Item: " + TextFormatting.WHITE + itemOutput));
        tooltip.add(new StringTextComponent(TextFormatting.GRAY + "Chicken Type: " + chickenRegistryObject.getChickenType().getName()));
        if(chickenRegistryObject.isBreedable()) {
            tooltip.add(new StringTextComponent(TextFormatting.YELLOW + "Bred from" + TextFormatting.WHITE + ": " + TextFormatting.GOLD + chickenRegistryObject.getParent1().getForamattedName() + TextFormatting.WHITE + " & " + TextFormatting.GOLD + chickenRegistryObject.getParent2().getForamattedName()));
        }else{
            tooltip.add(new StringTextComponent(TextFormatting.RED + "Cannot be bred."));
        }
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack itemStack, ItemUseContext context) {
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
                ChickenRegistryObject chickenRegistryObject = ChickenRegistry.getChickenRegistryObjectbyChickenSpawnEggItem(itemStack.getItem());
                chickenRegistryObject.getChickenEntityRegisryObject().get().spawn((ServerWorld) world, itemStack, p, finalBlockpos, SpawnReason.SPAWN_EGG, false, false);
                itemStack.shrink(1);
                return ActionResultType.CONSUME;
            } else {
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.SUCCESS;
    }

}
