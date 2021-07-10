package io.github.TheBlackSquidward.resourcechickens.datagen;

import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.init.ModBlocks;
import io.github.TheBlackSquidward.resourcechickens.init.ModItems;
import net.minecraft.data.DataGenerator;

public class ResourceChickensLangProvider extends ResourceChickensLangProviderBase{

    /*

    "item.resourcechickens.chicken_catcher": "Chicken Catcher",
    "item.resourcechickens.chicken_stick": "Chicken Stick",
    "item.resourcechickens.chicken_analyser": "Chicken Analyzer",

    "item.resourcechickens.chicken_manure": "Chicken Manure",
    "item.resourcechickens.fertilizer": "Fertilizer",

    "item.resourcechickens.lava_infused_egg": "Lava Infused Egg",
    "item.resourcechickens.water_infused_egg": "Water Infused Egg",
    "item.resourcechickens.experience_imbued_egg": "Experience Imbued Egg",

    "item.resourcechickens.diamond_nugget": "Diamond Nugget",
    "item.resourcechickens.emerald_nugget": "Emerald Nugget",
    "item.resourcechickens.netherite_nugget": "Netherite Nugget",
    "item.resourcechickens.redstone_pile": "Small Pile of Redstone",
    "item.resourcechickens.coal_chunk": "Coal Chunk",
    "item.resourcechickens.lapis_dust": "Lapis Dust",
    "item.resourcechickens.ender_fragment": "Ender Fragment",
    "item.resourcechickens.wither_skull_fragment": "Wither Skull Fragment",
    "item.resourcechickens.nether_star_shard": "Nether Star Shard",

    "item.resourcechickens.machine_core": "Machine Core",
    "item.resourcechickens.upgrade_base": "Upgrade Base",
    "item.resourcechickens.speed_upgrade": "Speed Upgrade",
    "item.resourcechickens.energy_upgrade": "Energy Efficiency Upgrade",
    "item.resourcechickens.luck_upgrade": "Luck Upgrade",
    "item.resourcechickens.electric_upgrade": "Electric Upgrade"
     */

    public ResourceChickensLangProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    //TODO add remaining lang entries
    @Override
    protected void addTranslations() {
        generateChickens();
        addItems();
        addBlocks();
        addGUI();
        add("itemGroup.resourcechickens", "Resource Chickens");
    }

    private void addItems() {
        addItem(ModItems.vanillaChickenItem, "Chicken");
    }

    private void addBlocks() {
        addBlock(ModBlocks.acaciaChickenBreeder, "Acacia Chicken Breeder");
        addBlock(ModBlocks.birchChickenBreeder, "Birch Chicken Breeder");
        addBlock(ModBlocks.crimsonChickenBreeder, "Crimson Chicken Breeder");
        addBlock(ModBlocks.darkOakChickenBreeder, "Dark Oak Chicken Breeder");
        addBlock(ModBlocks.warpedChickenBreeder, "Warped Chicken Breeder");
        addBlock(ModBlocks.oakChickenBreeder, "Oak Chicken Breeder");
        addBlock(ModBlocks.spruceChickenBreeder, "Spruce Chicken Breeder");
        addBlock(ModBlocks.jungleChickenBreeder, "Jungle Chicken Breeder");
        addBlock(ModBlocks.poweredChickenBreeder, "Powered Chicken Breeder");

        addBlock(ModBlocks.acaciaRoost, "Acacia Roost");
        addBlock(ModBlocks.birchRoost, "Birch Roost");
        addBlock(ModBlocks.crimsonRoost, "Crimson Roost");
        addBlock(ModBlocks.darkOakRoost, "Dark Oak Roost");
        addBlock(ModBlocks.warpedRoost, "Warped Roost");
        addBlock(ModBlocks.oakRoost, "Oak Roost");
        addBlock(ModBlocks.spruceRoost, "Spruce Roost");
        addBlock(ModBlocks.jungleRoost, "Jungle Roost");
        addBlock(ModBlocks.poweredRoost, "Powered Roost");

        addBlock(ModBlocks.acaciaHenhouse, "Acacia Henhouse");
        addBlock(ModBlocks.birchHenhouse, "Birch Henhouse");
        addBlock(ModBlocks.crimsonHenhouse, "Crimson Henhouse");
        addBlock(ModBlocks.darkOakHenhouse, "Dark Oak Henhouse");
        addBlock(ModBlocks.warpedHenhouse, "Warped Henhouse");
        addBlock(ModBlocks.oakHenhouse, "Oak Henhouse");
        addBlock(ModBlocks.spruceHenhouse, "Spruce Henhouse");
        addBlock(ModBlocks.jungleHenhouse, "Jungle Henhouse");

        addBlock(ModBlocks.roostController, "Roost Controller");
        addBlock(ModBlocks.chickenBreederController, "Chicken Breeder Controller");
        addBlock(ModBlocks.industrialCasing, "Industrial Casing");
        addBlock(ModBlocks.industrialGlass, "Industrial Glass");

        addBlock(ModBlocks.poweredIncubator, "Powered Incubator");
    }

    private void addGUI() {

    }

    private void generateChickens() {
        ChickenRegistry.getChickenRegistry().getChickens().forEach(((chickenName, customChickenData) -> {
            //Entity
            add("entity.resourcechickens." + chickenName + "_chicken", customChickenData.getFormattedName() + " Chicken");
            //Chicken Item
            add("item.resourcechickens." + chickenName + "_chicken_item", customChickenData.getFormattedName() + " Chicken Item");
            //Chicken Spawn Egg
            add("item.resourcechickens." + chickenName + "_chicken_spawn_egg", customChickenData.getFormattedName() + " Chicken Spawn Egg");
            //Feathers
            if (customChickenData.getCoreData().hasFeather()) {
                add("item.resourcechickens." + chickenName + "_chicken_feather", customChickenData.getFormattedName() + " Chicken Feather");
            }
        }));
    }
}
