package org.reality.science.chemistry.element;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import org.reality.item.ItemTestTube;

/**
 * Created by xCoDe7 on 14/4/2558.
 */
public class ElementGas extends Element
{
    public Item item;

    public ElementGas(int id, String symbol, String name)
    {
        super(id, symbol, name);
        this.addToArrayIfNotExist(id, this);
        this.generateNeededStuff(name);
    }

    public void generateNeededStuff(String name)
    {
        item = new ItemTestTube("item_" + name.toLowerCase() + "_tube", this);

        GameRegistry.registerItem(item, "item_" + name.toLowerCase() + "_tube");
    }

    public Item getItem()
    {
        return this.item;
    }
}
