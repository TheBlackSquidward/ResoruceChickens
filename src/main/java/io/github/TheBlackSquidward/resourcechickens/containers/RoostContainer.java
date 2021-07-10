package io.github.TheBlackSquidward.resourcechickens.containers;

import io.github.TheBlackSquidward.resourcechickens.init.ModContainers;
import io.github.TheBlackSquidward.resourcechickens.te.roost.AbstractRoostTE;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import org.jetbrains.annotations.NotNull;

public class RoostContainer extends Container {

    private final AbstractRoostTE tileEntity;
    private final IItemHandler playerInventory;

    private final PlayerEntity playerEntity;

    public RoostContainer(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player) {
        super(ModContainers.ROOST_CONTAINER.get(), windowId);
        tileEntity = (AbstractRoostTE) world.getBlockEntity(pos);
        this.playerInventory = new InvWrapper(playerInventory);
        this.playerEntity = player;

        if (tileEntity != null) {
            tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
                addSlot(new SlotItemHandler(h, 0, 26, 20));
                addSlot(new SlotItemHandler(h, 1, 80, 20));
                addSlot(new SlotItemHandler(h, 2, 98, 20));
                addSlot(new SlotItemHandler(h, 3, 116, 20));
                addSlot(new SlotItemHandler(h, 4, 134, 20));
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
    public boolean stillValid(@NotNull PlayerEntity player) {
        return true;
    }

    @Override
    public void broadcastChanges() {
        super.broadcastChanges();
        tileEntity.sendGUINetworkPacket(playerEntity);
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull PlayerEntity playerEntity, int index) {
        //TODO
        return ItemStack.EMPTY;
    }

    public double getProgress() {
        return tileEntity.getProgress();
    }

}
