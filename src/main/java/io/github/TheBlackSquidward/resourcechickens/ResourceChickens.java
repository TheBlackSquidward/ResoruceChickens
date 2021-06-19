package io.github.TheBlackSquidward.resourcechickens;

import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.config.Config;
import io.github.TheBlackSquidward.resourcechickens.config.ConfigHelper;
import io.github.TheBlackSquidward.resourcechickens.config.FileHelper;
import io.github.TheBlackSquidward.resourcechickens.init.*;
import io.github.TheBlackSquidward.resourcechickens.network.ResourceChickensPacketHandler;
import io.github.TheBlackSquidward.resourcechickens.compat.top.TopCompat;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry.initChickens;

@Mod(ResourceChickens.MODID)
public class ResourceChickens {

    public static final String MODID = "resourcechickens";

    public static final Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup ITEM_GROUP = new ResourceChickensItemGroup();

    public ResourceChickens() {
        FileHelper.setupPaths();
        IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        iEventBus.addListener(this::setup);

        ItemInit.ITEMS.register(iEventBus);
        EntityInit.ENTITY_TYPES.register(iEventBus);
        BlockInit.BLOCKS.register(iEventBus);
        TileEntityInit.TILE_ENTITY.register(iEventBus);
        ContainerInit.CONTAINERS.register(iEventBus);
        RecipeInit.RECIPE_SERIALIZER_REGISTRY.register(iEventBus);

        iEventBus.addListener(this::onInterModEnqueue);
        MinecraftForge.EVENT_BUS.register(this);

        initChickens();
        ChickenRegistry.registerChickens();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.CommonConfig.commonConfig, "resourcechickens/common.toml");
        ConfigHelper.loadConfig(Config.CommonConfig.commonConfig, FMLPaths.CONFIGDIR.get().resolve("resourcechickens/common.toml"));
    }


    private void setup(final FMLCommonSetupEvent e) {
        ResourceChickensPacketHandler.init();
    }

    public void onInterModEnqueue(InterModEnqueueEvent e) {
        if(ModList.get().isLoaded("theoneprobe")) {
            InterModComms.sendTo("theoneprobe", "getTheOneProbe", TopCompat::new);
            LOGGER.info("Detected The One Probe. Initializing compat.");
        }
    }
}
