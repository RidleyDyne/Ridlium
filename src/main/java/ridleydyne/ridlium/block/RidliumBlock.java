package ridleydyne.ridlium.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import java.util.function.Function;

public class RidliumBlock extends Block {  
      
    public RidliumBlock() {
        super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3.0f, 6.0f).harvestTool(ToolType.PICKAXE).setRequiresTool());
        setRegistryName("ridlium_block");
    }
    
    public RidliumBlock(Material material, SoundType sound, float hardness, float resistance) {
		super(Properties.create(material).sound(sound).hardnessAndResistance(hardness, resistance));
	}
}
