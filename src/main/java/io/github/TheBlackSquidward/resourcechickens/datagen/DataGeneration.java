package io.github.TheBlackSquidward.resourcechickens.datagen;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = ResourceChickens.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneration {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        DataGenerator dataGenerator = e.getGenerator();
        ExistingFileHelper existingFileHelper = e.getExistingFileHelper();
        ResourceChickensBlockTagProvider blockTagGenerator = new ResourceChickensBlockTagProvider(dataGenerator, existingFileHelper);

        dataGenerator.addProvider(blockTagGenerator);
        dataGenerator.addProvider(new ResourceChickensItemTagProvider(dataGenerator, blockTagGenerator, existingFileHelper));
        dataGenerator.addProvider(new ResourceChickensRecipeProvider(dataGenerator));
        dataGenerator.addProvider(new ResourceChickensLootTableProvider(dataGenerator));
        dataGenerator.addProvider(new ResourceChickensItemModelProvider(dataGenerator, existingFileHelper));
        dataGenerator.addProvider(new ResourceChickensLangProvider(dataGenerator));
    }

}
