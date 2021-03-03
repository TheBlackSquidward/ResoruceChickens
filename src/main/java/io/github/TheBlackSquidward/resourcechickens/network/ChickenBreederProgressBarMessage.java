package io.github.TheBlackSquidward.resourcechickens.network;

import io.github.TheBlackSquidward.resourcechickens.common.te.ChickenBreederTE;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class ChickenBreederProgressBarMessage {

    private BlockPos blockPos;
    private final PacketBuffer packetBuffer;

    public ChickenBreederProgressBarMessage(BlockPos blockPos, PacketBuffer packetBuffer) {
        this.blockPos = blockPos;
        this.packetBuffer = packetBuffer;
    }

    public static void encode(ChickenBreederProgressBarMessage message, PacketBuffer packetBuffer){
        packetBuffer.writeBlockPos(message.blockPos);
        packetBuffer.writeBytes(message.packetBuffer);
    }

    public static ChickenBreederProgressBarMessage decode(PacketBuffer packetBuffer){
        return new ChickenBreederProgressBarMessage(packetBuffer.readBlockPos(), packetBuffer);
    }

    public static void handle(ChickenBreederProgressBarMessage message, Supplier<NetworkEvent.Context> context){
        context.get().enqueueWork(() -> {
            ClientPlayerEntity player = Minecraft.getInstance().player;
            if (player != null) {
                TileEntity tileEntity = player.world.getTileEntity(message.blockPos);
                ((ChickenBreederTE) tileEntity).handleGUINetworkPacket(message.packetBuffer);
            }
        });
        context.get().setPacketHandled(true);
    }

}