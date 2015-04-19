package org.reality.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.reality.main.Config;
import org.reality.main.Reality;
import org.reality.tileentity.TileEntityElementExractor;

/**
 * Created by xCoDe7 on 19/4/2558.
 */
public class BlockElementExtractor extends BlockContainer
{

    public BlockElementExtractor(String unlocalizedName)
    {
        super(Material.rock);
        this.setCreativeTab(Reality.realityChemistry);
        this.setBlockName(unlocalizedName);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
                                    EntityPlayer player, int metadata, float what, float these, float are)
    {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity == null || player.isSneaking()) {
            return false;
        }
        //code to open gui explained later
        player.openGui(Reality.instance, 0, world, x, y, z);
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new TileEntityElementExractor();
    }

    @SideOnly(Side.CLIENT)
    private IIcon front;
    @SideOnly(Side.CLIENT)
    private IIcon side;

    @Override
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.front = p_149651_1_.registerIcon(Config.modID + ":" + "block_element_extractor_front");
        this.side = p_149651_1_.registerIcon(Config.modID + ":" + "block_element_extractor_sides");
    }

    @Override
    public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int whichDirectionFacing = MathHelper.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        par1World.setBlockMetadataWithNotify(x, y, z, whichDirectionFacing, 2);
    }

    @Override
    public IIcon getIcon(int side, int metadata)
    {
        if (metadata == 2 && side == 2 || metadata == 3 && side == 5 || metadata == 0 && side == 3 || metadata == 1 && side == 4)
        {
            return this.front;
        }
        else
        {
            return this.side;
        }
    }
}
