package org.reality.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.reality.main.Reality;
import org.reality.science.chemistry.element.Element;

import java.util.List;

/**
 * Created by xCoDe7 on 13/4/2558.
 */
public class ItemChem extends Item
{
    private Element element;

    public ItemChem(String textureName, Element element)
    {
        this.setCreativeTab(Reality.realityChemistry);
        this.setUnlocalizedName("itemChem");
        this.setTextureName(textureName);
        this.element = element;
    }

    @Override
    public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_)
    {
        p_77624_3_.add(element.getName());
    }
}
