package ridleydyne.ridlium.init;

import ridleydyne.ridlium.block.*;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public enum ModBlocks {
    RIDLIUM_BLOCK(new RidliumBlock()),
    RIDLIUM_ORE(new RidliumOre());


    private final Block block;
    private final BlockItem item;

    ModBlocks(Block block) {
        this.block = block;
        this.item = null;
    }
    ModBlocks(Block block, BlockItem item) {
        this.block = block;
        this.item = item;
    }

    public String getName() {
        return String.valueOf(this).toLowerCase();
    }

    public Block getBlock() {
        if (block.getRegistryName() == null) {
            block.setRegistryName("ridlium", getName());
        }
        return block;
    }

    public Item getItem() {
        return getBlock().asItem();
    }
    
}
