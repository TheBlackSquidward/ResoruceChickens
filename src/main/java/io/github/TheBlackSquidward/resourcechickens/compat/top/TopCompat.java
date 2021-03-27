package io.github.TheBlackSquidward.resourcechickens.compat.top;

import io.github.TheBlackSquidward.resourcechickens.common.te.*;
import mcjty.theoneprobe.api.ITheOneProbe;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

import java.text.DecimalFormat;
import java.util.function.Function;

public class TopCompat implements Function<ITheOneProbe, Void> {

    private static final DecimalFormat FORMATTER = new DecimalFormat("0.0%");

    IFormattableTextComponent formattedName = new StringTextComponent(TextFormatting.BLUE.toString() + TextFormatting.ITALIC.toString() + "Resource Chickens");

    @Override
    public Void apply(ITheOneProbe iTheOneProbe) {
        iTheOneProbe.registerBlockDisplayOverride((mode, probeInfo, player, world, blockState, data) -> {
            TileEntity tileEntity = world.getBlockEntity(data.getPos());
            if(tileEntity instanceof ChickenBreederTE) {
                ChickenBreederTE chickenBreederTE = (ChickenBreederTE) tileEntity;
                probeInfo.horizontal()
                        .item(new ItemStack(blockState.getBlock().asItem()))
                        .vertical()
                        .itemLabel(new ItemStack(blockState.getBlock().asItem()))
                        .text(new StringTextComponent(new TranslationTextComponent("gui.resourcechickens.top.chicken_breeder.progress").getString() + getFormattedProgress(getChickenBreederProgress(chickenBreederTE))))
                        .text(formattedName);
                if(mode.equals(ProbeMode.EXTENDED)) {

                }
                return true;
            }
            if(tileEntity instanceof ElectricChickenBreederTE) {
                ElectricChickenBreederTE electricChickenBreederTE = (ElectricChickenBreederTE) tileEntity;
                //TODO
                return true;
            }
            if(tileEntity instanceof RoostTE) {
                RoostTE roostTE = (RoostTE) tileEntity;
                //TODO
                return true;
            }
            if(tileEntity instanceof ElectricRoostTE) {
                ElectricRoostTE electricRoostTE = (ElectricRoostTE) tileEntity;
                //TODO
                return true;
            }
            if(tileEntity instanceof IncubatorTE) {
                IncubatorTE incubatorTE = (IncubatorTE) tileEntity;
                //TODO
                return true;
            }
            if(tileEntity instanceof ElectricIncubatorTE) {
                ElectricIncubatorTE electricIncubatorTE = (ElectricIncubatorTE) tileEntity;
                //TODO
                return true;
            }
            return false;
        });
        return null;
    }

    public double getChickenBreederProgress(ChickenBreederTE tileEntity) {
        return tileEntity.getProgress();
    }

    public String getFormattedProgress(double progress) {
        return formatProgress(progress);
    }

    public String formatProgress(double progress) {
        return FORMATTER.format(progress);
    }
}
