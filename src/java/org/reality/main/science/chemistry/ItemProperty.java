package org.reality.main.science.chemistry;

import net.minecraft.item.Item;

import java.util.HashMap;

/**
 * Created by Biw on 27/12/2557.
 */
public class ItemProperty
{
    public static HashMap<Item, Element[]> itemProperties = new HashMap<Item, Element[]>();

    public static void setItemProperties(Item item, Element[] elements)
    {
        itemProperties.put(item, elements);
    }
}
