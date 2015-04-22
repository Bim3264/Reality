package org.reality.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import org.reality.item.ItemTestTube;

/**
 * Created by xCoDe7 on 21/4/2558.
 */
public class SlotTestTube extends Slot
{
    public SlotTestTube(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_)
    {
        super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
    }

    @Override
    public boolean isItemValid(ItemStack p_75214_1_)
    {
        if (p_75214_1_.getItem() instanceof ItemTestTube)
        {
            return true;
        }
        return false;
    }
}
