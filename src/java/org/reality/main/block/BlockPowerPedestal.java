package org.reality.main.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.reality.main.tileentity.TileEntityPowerPedestal;

/**
 * Created by Biw on 27/12/2557.
 */
public class BlockPowerPedestal extends BlockContainer
{
    public BlockPowerPedestal(String blockname)
    {
        super(Material.rock);
        this.setBlockName(blockname);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return new TileEntityPowerPedestal();
    }
}
