package ridleydyne.ridlium.world;

import java.util.ArrayList;

import net.minecraft.block.Blocks;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ridleydyne.ridlium.Ridlium;
import ridleydyne.ridlium.init.ModBlocks;
import net.minecraft.util.registry.Registry;

@Mod.EventBusSubscriber
public class ModWorldGen {
    
    private static final ArrayList<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> endOres = new ArrayList<ConfiguredFeature<?, ?>>();
    
    public static void RegisterOres() 
    {
        //Overworld Ore Register
        overworldOres.add(
            register("ridlium_ore", 
            Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, 
                ModBlocks.RIDLIUM_ORE.getBlock().getDefaultState(), 5)) // Vein Size
                .range(16).square() //Spawn height start
                .func_242731_b(2))); //Chunk spawn frequency
 
        //Nether Ore Register
        /*
        netherOres.add(register("ridlium_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER, ModBlocks.RIDLIUM_ORE.getBlock().getDefaultState(), 2)) // Vein Size
                .range(128).square() //Spawn height start
                .func_242731_b(1))); //Chunk spawn frequency
        */

        //The End Ore Register
        /*
        endOres.add(register("ridlium_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.RIDLIUM_ORE.getBlock().getDefaultState(), 2)) //Vein Size
                .range(128).square() //Spawn height start
                .func_242731_b(1))); //Chunk spawn frequency
        */

    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, Ridlium.MOD_ID + ":" + name, configuredFeature);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void gen(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();

        if (netherOres.size() > 0) {
            if(event.getCategory().equals(Biome.Category.NETHER)){
                for(ConfiguredFeature<?, ?> ore : netherOres){
                    if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
                }
            }
        }

        if (endOres.size() > 0) {
            if(event.getCategory().equals(Biome.Category.THEEND)){
                for(ConfiguredFeature<?, ?> ore : endOres){
                    if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
                }
            }
        }

        if (overworldOres.size() > 0) {
            for(ConfiguredFeature<?, ?> ore : overworldOres){                
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
    }

}
