package io.github.TheBlackSquidward.resourcechickens;

import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.common.entities.CustomChickenEntity;
import io.github.TheBlackSquidward.resourcechickens.init.*;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.network.ResourceChickensPacketHandler;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

import static io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry.initChickens;

@Mod(ResourceChickens.MODID)
public class ResourceChickens {

    public static final Random RANDOM =  new Random();

    public static final String MODID = "resourcechickens";

    public static final Logger LOGGER = LogManager.getLogger();

    public static final net.minecraft.item.ItemGroup ITEM_GROUP = new ResourceChickensItemGroup();

    public ResourceChickens() {
        IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        iEventBus.addListener(this::setup);

        ItemInit.ITEMS.register(iEventBus);
        EntityInit.ENTITY_TYPES.register(iEventBus);
        BlockInit.BLOCKS.register(iEventBus);
        TileEntityInit.TILE_ENTITY.register(iEventBus);
        ContainerInit.CONTAINERS.register(iEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        initChickens();
        ChickenRegistry.registerChickens();
    }

    private void setup(final FMLCommonSetupEvent e) {
        ResourceChickensPacketHandler.init();
        setupChickens();
    }

    private void setupChickens() {
        DeferredWorkQueue.runLater(() -> {
            for(ChickenRegistryObject chicken : ChickenRegistry.getChickenRegistry().values()) {
                GlobalEntityTypeAttributes.put(chicken.getChickenEntityRegisryObject().get(), CustomChickenEntity.setCustomAttributes().build());
            }
        });
    }

}
