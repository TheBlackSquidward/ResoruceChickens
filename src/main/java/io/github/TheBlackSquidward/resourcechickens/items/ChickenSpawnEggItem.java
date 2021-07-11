package io.github.TheBlackSquidward.resourcechickens.items;

import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.CustomChickenData;
import io.github.TheBlackSquidward.resourcechickens.api.data.chickenData.BreedData;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Objects;

public class ChickenSpawnEggItem extends BaseItem {

    private final Lazy<? extends EntityType<?>> entityType;
    private final CustomChickenData chickenData;

    public ChickenSpawnEggItem(RegistryObject<? extends EntityType<?>> entityTypeSupplier, String chickenName, Properties properties) {
        super(properties);
        this.chickenData = ChickenRegistry.getChickenRegistry().getChickenData(chickenName);
        this.entityType = Lazy.of(entityTypeSupplier);
    }

    public @NotNull EntityType<?> getType() {
        return entityType.get();
    }

    public CustomChickenData getChickenData() {
        return chickenData;
    }

    @ParametersAreNonnullByDefault
    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new StringTextComponent(TextFormatting.GRAY + "Chicken Type: " + chickenData.getCoreData().getChickenType().getName()));
        if(chickenData.getBreedData().canBreed()) {
            BreedData breedData = chickenData.getBreedData();
            tooltip.add(new StringTextComponent(TextFormatting.YELLOW + "Bred from" + TextFormatting.WHITE + ": " + TextFormatting.GOLD + ChickenRegistry.getChickenRegistry().getChickenData(breedData.getParent1()).getFormattedName() + TextFormatting.WHITE + " & " + TextFormatting.GOLD + ChickenRegistry.getChickenRegistry().getChickenData(breedData.getParent2()).getFormattedName()));
        }else{
            tooltip.add(new StringTextComponent(TextFormatting.RED + "Cannot be bred."));
        }
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack itemStack, ItemUseContext context) {
        ItemStack itemstack = context.getItemInHand();
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
                if (getType().spawn((ServerWorld) world, itemstack, context.getPlayer(), finalBlockpos, SpawnReason.SPAWN_EGG, true, !Objects.equals(blockpos, finalBlockpos) && direction == Direction.UP) != null) {
                    itemstack.shrink(1);
                }
                return ActionResultType.CONSUME;
            } else {
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.SUCCESS;
    }

}
