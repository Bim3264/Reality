package org.reality.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

/**
 * Created by xCoDe7 on 13/4/2558.
 */
public class BlockChemFluid extends BlockFluidClassic
{
    public BlockChemFluid(Fluid fluid, String unlocalizedName)
    {
        super(fluid, Material.water);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockName(unlocalizedName);
    }
}
