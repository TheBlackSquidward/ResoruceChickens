package io.github.TheBlackSquidward.resourcechickens.blocks.roost;

import io.github.TheBlackSquidward.resourcechickens.containers.ElectricRoostContainer;
import io.github.TheBlackSquidward.resourcechickens.te.PoweredRoostTE;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class PoweredRoostBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public PoweredRoostBlock() {
        super(Properties.of(Material.METAL)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new PoweredRoostTE();
    }

    @Override
    public @NotNull ActionResultType use(@NotNull BlockState p_225533_1_, World world, @NotNull BlockPos pos, @NotNull PlayerEntity player, @NotNull Hand hand, @NotNull BlockRayTraceResult p_225533_6_) {
        if (!world.isClientSide) {
            TileEntity tileEntity = world.getBlockEntity(pos);
            if (tileEntity instanceof PoweredRoostTE) {
                INamedContainerProvider containerProvider = new INamedContainerProvider() {
                    @Override
                    public @NotNull ITextComponent getDisplayName() {
                        return new TranslationTextComponent("gui.resourcechickens.electric_roost");
                    }

                    @Override
                    public Container createMenu(int i, @NotNull PlayerInventory playerInventory, @NotNull PlayerEntity playerEntity) {
                        return new ElectricRoostContainer(i, world, pos, playerInventory, playerEntity);
                    }
                };
                NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider, tileEntity.getBlockPos());
                return ActionResultType.SUCCESS;
            } else {
                throw new IllegalStateException("Our named container provider is missing!");
            }
        } else {
            return ActionResultType.FAIL;
        }
    }


}
