package ridleydyne.ridlium.init;

import ridleydyne.ridlium.Ridlium;
import ridleydyne.ridlium.block.*;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public enum ModBlocks {
    RIDLIUM_BLOCK(new RidliumBlock(), 64),
    RIDLIUM_ORE(new RidliumOre(), 64);

    private final Block block;
    private final BlockItem blockItem;

    ModBlocks(Block block, int maxStackSize) {
        this.block = block;
        this.blockItem = new BlockItem(block, new Item.Properties()
            .maxStackSize(maxStackSize)
            .group(Ridlium.ITEM_GROUP));
        
        this.block.setRegistryName(this.getName());
        this.blockItem.setRegistryName(this.getName());
    }

    public String getName() {
        return String.valueOf(this).toLowerCase();
    }

    public Block getBlock() {
        if (block.getRegistryName() == null) {
            block.setRegistryName(this.getName());
        }
        return block;
    }

    /*
    public Item getItem() {
        return getBlock().asItem();
    }
    */

    public BlockItem getBlockItem() {
        return this.blockItem;
    }
    
}
