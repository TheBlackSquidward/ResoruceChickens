package io.github.TheBlackSquidward.resourcechickens.items;

import com.sun.javafx.geom.Vec3d;
import io.github.TheBlackSquidward.resourcechickens.entities.CustomChickenEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class ChickenAnalyzerItem extends BaseItem {

    public ChickenAnalyzerItem() {
        super(new Properties().stacksTo(1));
    }

    //TODO

    @Override
    public @NotNull ActionResult<ItemStack> use(@NotNull World p_77659_1_, @NotNull PlayerEntity p_77659_2_, @NotNull Hand p_77659_3_) {
        return super.use(p_77659_1_, p_77659_2_, p_77659_3_);
        //TODO open gui
        //NetworkHooks.openGui();
    }

    @Override
    public @NotNull ActionResultType interactLivingEntity(@NotNull ItemStack itemStack, PlayerEntity p, LivingEntity entity, @NotNull Hand hand) {
        Vec3d pos = new Vec3d(entity.getX(), entity.getY(), entity.getZ());
        World world = p.level;
        if(!world.isClientSide()) {
            if (p.isCrouching()) {
                if (entity instanceof CustomChickenEntity) {
                    CustomChickenEntity chickenEntity = (CustomChickenEntity) entity;
                        return ActionResultType.SUCCESS;
                }
            }
        }
        return ActionResultType.PASS;
    }
}
