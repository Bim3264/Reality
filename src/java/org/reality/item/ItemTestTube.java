package org.reality.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.reality.main.Config;
import org.reality.main.Reality;
import org.reality.science.chemistry.element.Element;

import java.util.List;

/**
 * Created by xCoDe7 on 13/4/2558.
 */
public class ItemTestTube extends Item
{
    private Element element;
    private String textureName;

    public ItemTestTube(String textureName, Element element)
    {
        this.textureName = textureName;
        this.element = element;
        this.setCreativeTab(Reality.realityChemistry);
        this.setUnlocalizedName("itemChemTube");
        this.setTextureName(Config.modID + ":" + textureName);
        this.setFull3D();
    }

    @Override
    public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_)
    {
        p_77624_3_.add(element.getName() + "(" + element.getSymbol() + ")");
    }
}
