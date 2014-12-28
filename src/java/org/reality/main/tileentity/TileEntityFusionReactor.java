package org.reality.main.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;

/**
 * Created by Biw on 26/12/2557.
 */
public class TileEntityFusionReactor extends TileEntity implements IInventory
{

    ItemStack[] items;

    public TileEntityFusionReactor()
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
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer)
    {
        return entityPlayer.getDistanceSq(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5) <= 64;
    }

    @Override
    public void openInventory(EntityPlayer entityPlayer) {}

    @Override
    public void closeInventory(EntityPlayer entityPlayer) {}

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack)
    {
        return itemStack.getItem() == Items.iron_ingot || itemStack.getItem() == Items.gold_ingot;
    }

    @Override
    public int getField(int i) {
        return 0;
    }

    @Override
    public void setField(int i, int i1) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public String getName() {
        return "FusionReactor";
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public IChatComponent getDisplayName() {
        return null;
    }
}
