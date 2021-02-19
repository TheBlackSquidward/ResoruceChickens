package io.github.TheBlackSquidward.resourcefulchickens.common.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class ChickenItem extends Item {

    public int growth = 1;
    public int gain = 1;
    public int strength= 1;

    public ChickenItem(Properties properties) {
        super(properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        //tooltip.add(new StringTextComponent("Growth: " + growth));
        //tooltip.add(new StringTextComponent("Gain: " + gain));
        //tooltip.add(new StringTextComponent("Strength: " + strength));
    }

}
