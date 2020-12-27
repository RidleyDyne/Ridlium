package ridleydyne.ridlium.block;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraft.util.math.MathHelper;
import javax.annotation.Nonnull;
import java.util.Random;

public class RidliumOre extends OreBlock {    
    public RidliumOre() {             
        super(Properties
            .create(Material.ROCK)
            .sound(SoundType.STONE)
            .hardnessAndResistance(3.0f, 6.0f)
            .harvestTool(ToolType.PICKAXE)
        );}

    @Override
    protected int getExperience(@Nonnull Random rand) {
        return MathHelper.nextInt(rand, 2, 5); // same as lapis or redstone
    }
    
}
