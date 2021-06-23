package io.github.TheBlackSquidward.resourcechickens.items;

import com.sun.javafx.geom.Vec3d;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.entities.CustomChickenEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ChickenAnalyzerItem extends BaseItem {

    public ChickenAnalyzerItem() {
        super(new Properties().stacksTo(1));
    }

    //TODO

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        return super.use(p_77659_1_, p_77659_2_, p_77659_3_);
        //TODO open gui
        //NetworkHooks.openGui();
    }

    @Override
    public ActionResultType interactLivingEntity(ItemStack itemStack, PlayerEntity p, LivingEntity entity, Hand hand) {
        Vec3d pos = new Vec3d(entity.getX(), entity.getY(), entity.getZ());
        World world = p.level;
        if(!world.isClientSide()) {
            if (p.isCrouching()) {
                if (entity instanceof CustomChickenEntity) {
                    CustomChickenEntity chickenEntity = (CustomChickenEntity) entity;
                    ChickenRegistryObject chickenRegistryObject = ChickenRegistry.getChickenRegistryObjectbyEntity(chickenEntity);
                    if (!entity.isBaby()) {
                        //TODO message the player - Fires twice
                        p.sendMessage(new StringTextComponent(chickenRegistryObject.getForamattedName()), p.getUUID());
                    /*
                    - Chicken Name
                    - Chicken Type
                    - Lay Item
                    - Growth
                    - Gain
                    - Strength
                     */
                    } else {
                        //TODO messgae the player
                        p.sendMessage(new StringTextComponent("Baby " + chickenRegistryObject.getForamattedName()), p.getUUID());
                    /*
                    - Baby + Chicken Name
                    - Chicken Type
                    - Lay Item
                    - Growth
                    - Gain
                    - Strength
                    - Time till Growth
                     */
                        return ActionResultType.SUCCESS;
                    }
                }
            }
        }
        return ActionResultType.PASS;
    }
}
