package org.reality.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.reality.inventory.ContainerElementExtractor;
import org.reality.gui.GuiElementExtractor;
import org.reality.tileentity.TileEntityElementExractor;

/**
 * Created by xCoDe7 on 19/4/2558.
 */
public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tileEntity = world.getTileEntity(x,y,z);

        if (tileEntity instanceof TileEntityElementExractor)
        {
            return new ContainerElementExtractor(player.inventory, (TileEntityElementExractor)tileEntity);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tileEntity = world.getTileEntity(x,y,z);

        if (tileEntity instanceof TileEntityElementExractor)
        {
            return new GuiElementExtractor(player.inventory, (TileEntityElementExractor)tileEntity);
        }

        return null;
    }
}
