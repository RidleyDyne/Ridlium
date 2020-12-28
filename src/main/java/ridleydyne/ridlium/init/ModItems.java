package ridleydyne.ridlium.init;

import net.minecraft.item.Item;
import ridleydyne.ridlium.item.*;

public enum ModItems {
    RIDLIUM_DUST(new RidliumDust()),
    RIDLIUM_INGOT(new RidliumIngot()),
    RIDLIUM_CRYSTAL(new RidliumCrystal());

    private final Item item;

    ModItems(Item item) {
        this.item = item;
        this.item.setRegistryName(this.getName());
    }

    public String getName() {
        return String.valueOf(this).toLowerCase();
    }

    public Item getItem() {
        return this.item;
    }
   
}
