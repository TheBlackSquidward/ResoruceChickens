package io.github.TheBlackSquidward.resourcefulchickens;

import io.github.TheBlackSquidward.resourcefulchickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcefulchickens.api.CreativeTab;
import io.github.TheBlackSquidward.resourcefulchickens.common.entities.CustomChickenEntity;
import io.github.TheBlackSquidward.resourcefulchickens.registries.BlockRegistry;
import io.github.TheBlackSquidward.resourcefulchickens.registries.EntityRegistry;
import io.github.TheBlackSquidward.resourcefulchickens.registries.ItemRegistry;
import io.github.TheBlackSquidward.resourcefulchickens.api.ChickenRegistry;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod(ResourcefulChickens.MODID)
public class ResourcefulChickens {

    /*
    TODO:
        - Add textures to items and update the lang file.
        - Add JEI integration
        - Add mod support
        - Make chickens breedable (breeding two parents to produce their respective child)
        - Add blocks
        - Add TOP integration
        - Make chickens shed feathers and drop manure periodically
        - Add advanced versions of electric blokcs that can take upgrades.
        - Add recipes for base chickens and dye chickens.
        - Add forge tags
     */

    public static final Random RANDOM =  new Random();

    public static final String MODID = "resourcefulchickens";

    public static final Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup ITEM_GROUP = new CreativeTab();

    public ResourcefulChickens() {
        IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        iEventBus.addListener(this::setup);

        ItemRegistry.ITEMS.register(iEventBus);
        EntityRegistry.ENTITY_TYPES.register(iEventBus);
        BlockRegistry.BLOCKS.register(iEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        ChickenRegistry.initChickens();
        ChickenRegistry.registerChickens();
    }

    private void setup(final FMLCommonSetupEvent e) {
        setupChickens();
    }

    private void setupChickens() {
        DeferredWorkQueue.runLater(() -> {
            for(ChickenRegistryObject chicken : ChickenRegistry.getChickenRegistry().values()) {
                GlobalEntityTypeAttributes.put(chicken.getChickenEntityRegisryObject().get(), CustomChickenEntity.setCustomAttributes().create());
            }
        });
    }

}
