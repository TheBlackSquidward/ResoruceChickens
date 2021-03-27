package io.github.TheBlackSquidward.resourcechickens.network;

import io.github.TheBlackSquidward.resourcechickens.common.te.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class GUISyncMessage {

    private final BlockPos blockPos;
    private final PacketBuffer packetBuffer;

    public GUISyncMessage(BlockPos blockPos, PacketBuffer packetBuffer) {
        this.blockPos = blockPos;
        this.packetBuffer = packetBuffer;
    }

    public static void encode(GUISyncMessage message, PacketBuffer packetBuffer) {
        packetBuffer.writeBlockPos(message.blockPos);
        packetBuffer.writeBytes(message.packetBuffer);
    }

    public static GUISyncMessage decode(PacketBuffer packetBuffer) {
        return new GUISyncMessage(packetBuffer.readBlockPos(), packetBuffer);
    }

    public static void handle(GUISyncMessage message, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            ClientPlayerEntity player = Minecraft.getInstance().player;
            if (player != null) {
                TileEntity tileEntity = player.level.getBlockEntity(message.blockPos);
                if (tileEntity instanceof ChickenBreederTE) {
                    ((ChickenBreederTE) tileEntity).handleGUINetworkPacket(message.packetBuffer);
                }
                if(tileEntity instanceof RoostTE) {
                    //TODO handle packet
                }
                if(tileEntity instanceof IncubatorTE) {
                    //TODO
                }
                if(tileEntity instanceof ElectricChickenBreederTE) {
                    //TODO
                }
                if(tileEntity instanceof ElectricRoostTE) {
                    //TODO
                }
                if(tileEntity instanceof ElectricIncubatorTE) {
                    //TODO
                }
            }
        });
        context.get().setPacketHandled(true);
    }

}
