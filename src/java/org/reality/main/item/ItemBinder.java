package org.reality.main.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Created by Biw on 13/1/2558.
 */
public class ItemBinder extends ModItem
{
    public boolean firstPosition = false;
    NBTTagCompound nbtTagCompound = new NBTTagCompound();

    public ItemBinder(String itemname)
    {
        super(itemname);
    }

    @Override
    public boolean onItemUse(ItemStack tool, EntityPlayer player, World world, int x, int y, int z, int par7, float xFloat, float yFloat, float zFloat)
    {
        if (!player.canPlayerEdit(x, y, z, par7, tool))
        {
            return false;
        }
//        if (world.getBlock(x, y, z))
        if (firstPosition == false)
        {
            nbtTagCompound.setFloat("startX", x);
            nbtTagCompound.setFloat("startY", y);
            nbtTagCompound.setFloat("startZ", z);
            this.firstPosition = true;
        }
        else if (firstPosition == true)
        {
            nbtTagCompound.setFloat("finalX", x);
            nbtTagCompound.setFloat("finalY", y);
            nbtTagCompound.setFloat("finalZ", z);
        }

        if (world.getBlock(x, y, z) == Blocks.air)
        {
            this.firstPosition = false;
            nbtTagCompound.setFloat("startX", 0);
            nbtTagCompound.setFloat("startY", 0);
            nbtTagCompound.setFloat("startZ", 0);

            nbtTagCompound.setFloat("finalX", 0);
            nbtTagCompound.setFloat("finalY", 0);
            nbtTagCompound.setFloat("finalZ", 0);
        }

        return true;
    }
}
