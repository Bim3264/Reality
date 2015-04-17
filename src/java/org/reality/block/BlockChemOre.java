package org.reality.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import org.reality.main.Config;
import org.reality.main.Reality;
import org.reality.science.chemistry.element.Element;

/**
 * Created by xCoDe7 on 13/4/2558.
 */
public class BlockChemOre extends Block
{

    public BlockChemOre(String unlocalizedName)
    {
        super(Material.rock);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(Config.modID + ":" + unlocalizedName);
        this.setCreativeTab(Reality.realityWorldGen);
    }
}
