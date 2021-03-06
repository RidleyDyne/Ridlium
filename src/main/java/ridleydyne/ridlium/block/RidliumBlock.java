package ridleydyne.ridlium.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class RidliumBlock extends Block {  
      
    public RidliumBlock() {      
        super(Properties
            .create(Material.IRON)
            .sound(SoundType.METAL)
            .hardnessAndResistance(3.0f, 6.0f)
            .harvestLevel(0)
            .harvestTool(ToolType.PICKAXE)
        );
    }
}
