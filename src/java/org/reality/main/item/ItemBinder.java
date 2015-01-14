package org.reality.main.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Biw on 13/1/2558.
 */
public class ItemBinder extends ModItem
{

    public ItemBinder(String itemname)
    {
        super(itemname);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        return super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
    }
}
