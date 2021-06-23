package io.github.TheBlackSquidward.resourcechickens.compat.top;

import io.github.TheBlackSquidward.resourcechickens.te.*;
import mcjty.theoneprobe.api.IEntityDisplayOverride;
import mcjty.theoneprobe.api.ITheOneProbe;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.function.Function;

public class TopCompat implements Function<ITheOneProbe, Void> {

    public static final IFormattableTextComponent formattedName = new StringTextComponent(TextFormatting.BLUE.toString() + TextFormatting.ITALIC.toString() + "Resource Chickens");

    private static final IEntityDisplayOverride CHICKEN_ENTITY = new ChickenEntityDisplayOverride();

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
                        .text(new StringTextComponent(new TranslationTextComponent("gui.resourcechickens.top.chicken_breeder.progress").getString() + chickenBreederTE.getFormattedProgress(chickenBreederTE.getProgress())))
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
                probeInfo.horizontal()
                        .item(new ItemStack(blockState.getBlock().asItem()))
                        .vertical()
                        .itemLabel(new ItemStack(blockState.getBlock().asItem()))
                        .text(new StringTextComponent(new TranslationTextComponent("gui.resourcechickens.top.roost.progress").getString() + roostTE.getFormattedProgress(roostTE.getProgress())))
                        .text(formattedName);
                if(mode.equals(ProbeMode.EXTENDED)) {

                }
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
        iTheOneProbe.registerEntityDisplayOverride(CHICKEN_ENTITY);
        return null;
    }
}
