package org.reality.main.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.reality.main.tileentity.TileEntityFusionReactor;

/**
 * Created by Biw on 26/12/2557.
 */
public class BlockFusionReactor extends BlockContainer
{
    protected BlockFusionReactor(String blockname)
    {
        super(Material.rock);
        this.setBlockName(blockname);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return new TileEntityFusionReactor();
    }

}
