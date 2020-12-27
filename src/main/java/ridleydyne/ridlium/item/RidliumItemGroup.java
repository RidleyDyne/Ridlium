package ridleydyne.ridlium.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import ridleydyne.ridlium.init.ModBlocks;

public class RidliumItemGroup extends ItemGroup {
    public RidliumItemGroup(String label) {
        super(label);
        this.setNoTitle();
    }
    
    @Override
	public ItemStack createIcon() {
		return new ItemStack(ModBlocks.RIDLIUM_BLOCK.getBlock());
    }
    
    @Override
	public boolean hasSearchBar() {
		return false;
	}
}
