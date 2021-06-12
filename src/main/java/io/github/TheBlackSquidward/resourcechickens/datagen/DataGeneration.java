package io.github.TheBlackSquidward.resourcechickens.datagen;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = ResourceChickens.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneration {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        DataGenerator dataGenerator = e.getGenerator();
        ExistingFileHelper existingFileHelper = e.getExistingFileHelper();
        BlockTagGenerator blockTagGenerator = new BlockTagGenerator(dataGenerator, existingFileHelper);

        dataGenerator.addProvider(blockTagGenerator);
        dataGenerator.addProvider(new ItemTagGenerator(dataGenerator, blockTagGenerator, existingFileHelper));
        dataGenerator.addProvider(new RecipeGenerator(dataGenerator));

    }

}
