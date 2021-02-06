package ridleydyne.ridlium.item;

import net.minecraft.item.Item;
import ridleydyne.ridlium.Ridlium;

public class RidliumDust extends Item {
    public RidliumDust() {
        super(new Item.Properties()
            .maxStackSize(64)
            .group(Ridlium.ITEM_GROUP)
        );
    }

}
