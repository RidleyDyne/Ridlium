package ridleydyne.ridlium.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class RidliumCrystalBlock extends Block {  
      
    public RidliumCrystalBlock() {      
        super(Properties
            .create(Material.ROCK)
            .sound(SoundType.STONE)
            .hardnessAndResistance(6.0f, 9.0f)
            .harvestLevel(2)
            .harvestTool(ToolType.PICKAXE)
        );
    }
}
