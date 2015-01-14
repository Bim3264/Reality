package org.reality.main.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import org.reality.main.item.ItemFocusLens;

/**
 * Created by Biw on 27/12/2557.
 */
public class TileEntityPowerPedestal extends TileEntity implements IInventory
{
    ItemStack[] items;

    public TileEntityPowerPedestal()
    {
        items = new ItemStack[1];
    }

    @Override
    public int getSizeInventory()
    {
        return items.length;
    }

    @Override
    public ItemStack getStackInSlot(int i)
    {
        return items[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int count)
    {
        ItemStack itemStack = getStackInSlot(i);

        if (itemStack != null)
        {
            if (itemStack.stackSize <= count)
            {
                setInventorySlotContents(i, null);
            }
            else
            {
                itemStack = itemStack.splitStack(count);
                if (itemStack.stackSize == 0)
                {
                    setInventorySlotContents(i, null);
                }
            }
        }

        return itemStack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i)
    {
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack)
    {
        items[i] = itemStack;
        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
        {
            itemStack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName()
    {
        return null;
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return false;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 0;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64;
    }

    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack)
    {
        return itemStack.getItem() instanceof ItemFocusLens;
    }
}
