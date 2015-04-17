package org.reality.science.chemistry.element;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import org.reality.block.BlockChemOre;
import org.reality.item.ItemChem;

/**
 * Created by xCoDe7 on 13/4/2558.
 */
public class ElementSolid extends Element
{
    private Block block;
    private Item item;
    private boolean haveOre = true;
    private boolean normalIngot = false;

    public ElementSolid(int id, String symbol, String name)
    {
        super(id, symbol, name);

        this.generateNeededStuff(name);
        this.addToArrayIfNotExist(id, this);
    }

    public void generateNeededStuff(String name)
    {
        if (haveOre == true)
        {
            block = new BlockChemOre("ore_" + name.toLowerCase());
        }

        if (normalIngot == false)
        {
            item = new ItemChem("item_" + name.toLowerCase(), this);
        }
        else
        {
            item = new ItemChem("item_" + name.toLowerCase() + "_ingot", this);
        }

        GameRegistry.registerBlock(block,"ore_" + name);
        GameRegistry.registerItem(item, "item_" + name);
    }

    @Override
    public Element addSpecialRules(SpecialRules... specialRules)
    {
        for (int i = 0; i < specialRules.length; i++)
        {
            SpecialRules rules = specialRules[i];

            if (rules == SpecialRules.DOES_NOT_HAVE_ORE)
            {
                this.haveOre = false;
            }
            if (rules == SpecialRules.HAVE_INGOT)
            {
                this.normalIngot = true;
            }
        }
        return this;
    }

    public Block getBlock()
    {
        return this.block;
    }

    public Item getItem()
    {
        return this.item;
    }
}
