package org.reality.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import org.reality.main.Config;
import org.reality.main.Reality;

/**
 * Created by xCoDe7 on 13/4/2558.
 */
public class BlockChemOre extends Block
{
    public String unlocalizedName;

    public BlockChemOre(String unlocalizedName)
    {
        super(Material.rock);
        this.unlocalizedName = unlocalizedName;
        this.setBlockName(this.unlocalizedName);
        this.setBlockTextureName(Config.modID + ":" + this.unlocalizedName);
        this.setCreativeTab(Reality.realityCreativeTab);
    }
}
