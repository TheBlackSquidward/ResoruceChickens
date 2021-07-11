package io.github.TheBlackSquidward.resourcechickens;

import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ResourceChickensAPI;
import io.github.TheBlackSquidward.resourcechickens.api.data.chickenData.CoreData;
import io.github.TheBlackSquidward.resourcechickens.compat.top.TopCompat;
import io.github.TheBlackSquidward.resourcechickens.entities.CustomChickenEntity;
import io.github.TheBlackSquidward.resourcechickens.entities.ResourceChicken;
import io.github.TheBlackSquidward.resourcechickens.files.ChickenFiles;
import io.github.TheBlackSquidward.resourcechickens.files.FileHelper;
import io.github.TheBlackSquidward.resourcechickens.files.config.Config;
import io.github.TheBlackSquidward.resourcechickens.files.config.ConfigHelper;
import io.github.TheBlackSquidward.resourcechickens.init.*;
import io.github.TheBlackSquidward.resourcechickens.items.ChickenSpawnEggItem;
import io.github.TheBlackSquidward.resourcechickens.items.FeatherItem;
import io.github.TheBlackSquidward.resourcechickens.items.ResourceChickenItem;
import io.github.TheBlackSquidward.resourcechickens.network.ResourceChickensPacketHandler;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Mod(ResourceChickens.MOD_ID)
public class ResourceChickens {

    public static final String MOD_ID = "resourcechickens";

    public static final Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup ITEM_GROUP = new ItemGroup();

    public ResourceChickens() {
        FileHelper.setupPaths();
        ResourceChickensAPI.setChickenRegistry(ChickenRegistry.getChickenRegistry());

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.CommonConfig.commonConfig, "resourcechickens/common.toml");
        ConfigHelper.loadConfig(Config.CommonConfig.commonConfig, FMLPaths.CONFIGDIR.get().resolve("resourcechickens/common.toml"));

        ChickenFiles.setupChickens();
        initChickens();

        IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        iEventBus.addListener(this::setup);

        ModItems.ITEMS.register(iEventBus);
        ModEntities.ENTITY_TYPES.register(iEventBus);
        ModBlocks.BLOCKS.register(iEventBus);
        ModTileEntities.TILE_ENTITY.register(iEventBus);
        ModContainers.CONTAINERS.register(iEventBus);
        ModRecipes.RECIPE_SERIALIZER.register(iEventBus);

        //iEventBus.addListener(this::onCommandRegister);
        iEventBus.addListener(this::onInterModEnqueue);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SuppressWarnings("unused")
    private void onCommandRegister(RegisterCommandsEvent e) {
        ModCommands.registerCommands(e.getDispatcher(), e.getEnvironment());
    }

    private void setup(final FMLCommonSetupEvent e) {
        ResourceChickensPacketHandler.init();
    }

    private void onInterModEnqueue(InterModEnqueueEvent e) {
        if(ModList.get().isLoaded("theoneprobe")) {
            InterModComms.sendTo("theoneprobe", "getTheOneProbe", TopCompat::new);
            LOGGER.info("Detected The One Probe. Initializing compat.");
        }
    }

    //TODO move these methods to another location for now it can be here
    public static void initChickens() {
        ChickenRegistry.getChickenRegistry().getChickens().forEach((name, customChickenData) -> {
            CoreData coreData = customChickenData.getCoreData();
            boolean hasFeather = coreData.hasFeather();
            registerChicken(name, hasFeather);
        });
    }
    public static void registerChicken(String chickenName, boolean hasFeather) {
        final RegistryObject<EntityType<? extends CustomChickenEntity>> customChickenEntity = ModEntities.ENTITY_TYPES.register(chickenName + "_chicken",
                () -> EntityType.Builder.<ResourceChicken>of((type, world) -> new ResourceChicken(type, world, chickenName), EntityClassification.CREATURE)
                        .sized(1.0f, 1.0f)
                        .build(new ResourceLocation(ResourceChickens.MOD_ID, chickenName +  "_chicken").toString()));
        ModItems.ITEMS.register(chickenName + "_chicken_item", () -> new ResourceChickenItem(customChickenEntity, chickenName, new Item.Properties().stacksTo(16)));
        ModItems.ITEMS.register(chickenName + "_chicken_spawn_egg", () -> new ChickenSpawnEggItem(customChickenEntity, chickenName, new Item.Properties()));
        if (hasFeather) {
            ModItems.ITEMS.register(chickenName + "_chicken_feather", () -> new FeatherItem(new Item.Properties()));
        }
        ModEntities.getModChickens().put(chickenName, customChickenEntity);
    }


    public static class ItemGroup extends net.minecraft.item.ItemGroup {

        public ItemGroup() {
            super(MOD_ID);
        }

        @NotNull
        @Override
        public ItemStack makeIcon() {
            return ModItems.vanillaChickenItem.get().getDefaultInstance();
        }
    }

}
