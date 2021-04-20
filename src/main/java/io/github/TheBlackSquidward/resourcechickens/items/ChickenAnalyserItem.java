package io.github.TheBlackSquidward.resourcechickens.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ChickenAnalyserItem extends Item {

    public ChickenAnalyserItem() {
        super(new Item.Properties().stacksTo(1));
    }

    //TODO

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        return super.use(p_77659_1_, p_77659_2_, p_77659_3_);
        //NetworkHooks.openGui();
    }
}
