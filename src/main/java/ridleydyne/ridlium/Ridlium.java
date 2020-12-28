package ridleydyne.ridlium;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import ridleydyne.ridlium.init.ModBlocks;
import ridleydyne.ridlium.init.ModItems;
import ridleydyne.ridlium.item.RidliumItemGroup;
import ridleydyne.ridlium.world.ModWorldGen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("ridlium")
public class Ridlium
{
    public static final String MOD_ID = "ridlium";
    public static final ItemGroup ITEM_GROUP = new RidliumItemGroup(MOD_ID);

    public Ridlium() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // Add ores to worldgen
        ModWorldGen.RegisterOres();
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        // Register blocks
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            for (ModBlocks block : ModBlocks.values()) {
				event.getRegistry().register(block.getBlock());
			}
        }

        // Register items
        @SubscribeEvent
        public static void RegisterItems(final Register<Item> event) {
            // Items
            for(ModItems item : ModItems.values()){
                event.getRegistry().register(item.getItem());
            }

            for(ModBlocks block : ModBlocks.values()) {
                event.getRegistry().register(block.getBlockItem());
            }            
        }
    }

    
}
