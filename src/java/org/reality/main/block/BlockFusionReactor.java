package org.reality.main.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.reality.main.Config;
import org.reality.main.tileentity.TileEntityFusionReactor;

/**
 * Created by Biw on 26/12/2557.
 */
public class BlockFusionReactor extends BlockContainer
{
    @SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon bottom;
    @SideOnly(Side.CLIENT)
    private IIcon front;
    @SideOnly(Side.CLIENT)
    private IIcon back;

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

    public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
    {
        super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
        this.func_149930_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
    }

    private void func_149930_e(World p_149930_1_, int p_149930_2_, int p_149930_3_, int p_149930_4_)
    {
        if (!p_149930_1_.isRemote)
        {
            Block block = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ - 1);
            Block block1 = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ + 1);
            Block block2 = p_149930_1_.getBlock(p_149930_2_ - 1, p_149930_3_, p_149930_4_);
            Block block3 = p_149930_1_.getBlock(p_149930_2_ + 1, p_149930_3_, p_149930_4_);
            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j())
            {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j())
            {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 4;
            }

            p_149930_1_.setBlockMetadataWithNotify(p_149930_2_, p_149930_3_, p_149930_4_, b0, 2);
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        int back = 2;
//        return side == 1 ? this.top : (side == 0 ? this.bottom : (side == 2  || side == 3 ? this.blockIcon : (side == 5 ? this.back : this.back )));
        if (meta == 2)
            back = 3;
        if (meta == 3)
            back = 2;
        if (meta == 4)
            back = 5;
        if (meta == 5)
            back = 4;

        if (side == meta)
        {
            return this.front;
        }
        if (side == 1)
        {
            return this.top;
        }
        if (side == 0)
        {
            return this.bottom;
        }
        if (side == back)
        {
            return this.back;
        }
        return this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(Config.modID + ":" + "block_fusion_reactor_L_R_sides");
        this.top = iconRegister.registerIcon(Config.modID + ":" + "block_fusion_reactor_top");
        this.bottom = iconRegister.registerIcon(Config.modID + ":" + "block_fusion_reactor_bottom");
        this.front = iconRegister.registerIcon(Config.modID + ":" + "block_fusion_reactor_front");
        this.back = iconRegister.registerIcon(Config.modID + ":" + "block_fusion_reactor_back");
    }

    public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
    {
        int l = MathHelper.floor_double((double) (p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 2, 2);
        }

        if (l == 1)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 5, 2);
        }

        if (l == 2)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 3, 2);
        }

        if (l == 3)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 4, 2);
        }

        if (p_149689_6_.hasDisplayName())
        {
            ((TileEntityFusionReactor)p_149689_1_.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_)).setGuiDisplayName(p_149689_6_.getDisplayName());
        }
    }
}
