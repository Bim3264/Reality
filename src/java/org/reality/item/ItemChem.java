package org.reality.item;

import net.minecraft.item.Item;
import org.reality.main.Reality;

/**
 * Created by xCoDe7 on 13/4/2558.
 */
public class ItemChem extends Item
{
    public String unlocalizedName;

    public ItemChem(String unlocalizedName)
    {
        this.setCreativeTab(Reality.realityCreativeTab);
        this.unlocalizedName = unlocalizedName;
        this.setUnlocalizedName(this.unlocalizedName);
    }
}
