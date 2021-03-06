package io.github.TheBlackSquidward.resourcechickens.containers;

import io.github.TheBlackSquidward.resourcechickens.te.ChickenBreederTE;
import io.github.TheBlackSquidward.resourcechickens.init.ContainerInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class ChickenBreederContainer extends Container {

    private final ChickenBreederTE tileEntity;
    private final PlayerEntity playerEntity;
    private final IItemHandler playerInventory;

    public ChickenBreederContainer(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player) {
        super(ContainerInit.CHICKEN_BREEDER_CONTAINER.get(), windowId);
        tileEntity = (ChickenBreederTE) world.getBlockEntity(pos);
        this.playerEntity = player;
        this.playerInventory = new InvWrapper(playerInventory);

        if (tileEntity != null) {
            tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
                addSlot(new SlotItemHandler(h, 0, 8, 20));
                addSlot(new SlotItemHandler(h, 1, 44, 20));
                addSlot(new SlotItemHandler(h, 2, 62, 20));
                addSlot(new SlotItemHandler(h, 3, 116, 20));
                addSlot(new SlotItemHandler(h, 4, 134, 20));
                addSlot(new SlotItemHandler(h, 5, 152, 20));
            });
        }
        layoutPlayerInventorySlots(8, 84);
    }

    private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
        for (int i = 0; i < amount; i++) {
            addSlot(new SlotItemHandler(handler, index, x, y));
            x += dx;
            index++;
        }
        return index;
    }

    private int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for (int j = 0; j < verAmount; j++) {
            index = addSlotRange(handler, index, x, y, horAmount, dx);
            y += dy;
        }
        return index;
    }

    private void layoutPlayerInventorySlots(int leftCol, int topRow) {
        addSlotBox(playerInventory, 9, leftCol, topRow, 9, 18, 3, 18);
        topRow += 58;
        addSlotRange(playerInventory, 0, leftCol, topRow, 9, 18);
    }

    @Override
    public void broadcastChanges() {
        super.broadcastChanges();
        tileEntity.sendGUINetworkPacket(playerEntity);
    }

    public double getProgress() {
        return tileEntity.getProgress();
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return true;
    }
}
