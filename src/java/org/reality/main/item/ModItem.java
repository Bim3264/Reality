package org.reality.main.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import org.reality.main.Config;
import org.reality.main.science.chemistry.Element;
import org.reality.main.science.chemistry.ItemProperty;

/**
 * Created by Biw on 27/12/2557.
 */
public class ModItem extends Item
{
    public ModItem(String itemname)
    {
        super();
        this.setUnlocalizedName(itemname);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setTextureName(Config.modID + ":" + this.getUnlocalizedName());
    }

    public ModItem setProperties(Element[] properties)
    {
        ItemProperty.setItemProperties(this, properties);
        return this;
    }
}
