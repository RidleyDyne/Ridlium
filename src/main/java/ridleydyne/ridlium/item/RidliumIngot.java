package ridleydyne.ridlium.item;

import net.minecraft.item.Item;
import ridleydyne.ridlium.Ridlium;

public class RidliumIngot extends Item {
    public RidliumIngot() {
        super(new Item.Properties()
            .maxStackSize(64)
            .group(Ridlium.ITEM_GROUP)
        );
    }

}
