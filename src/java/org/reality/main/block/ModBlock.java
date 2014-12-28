package org.reality.main.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import org.reality.main.science.chemistry.BlockProperty;
import org.reality.main.science.chemistry.Element;

/**
 * Created by Biw on 25/12/2557.
 */
public class ModBlock extends Block
{
    public ModBlock(String unlocalizedname)
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setUnlocalizedName(unlocalizedname);
    }

    public ModBlock setProperties(Element[] properties)
    {
        BlockProperty.setBlockProperties(this, properties);
        return this;
    }
}
