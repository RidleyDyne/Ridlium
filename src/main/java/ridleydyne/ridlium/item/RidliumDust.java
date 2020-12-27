package ridleydyne.ridlium.item;

import net.minecraft.item.Item;

/*
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
*/

public class RidliumDust extends Item {
    public RidliumDust() {
        super(new Item.Properties().maxStackSize(64));
    }

    /*
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);

        //tooltip.add(new TranslationTextComponent("").appendString("").mergeStyle(TextFormatting.GRAY));
    }
    */
}
