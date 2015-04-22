package org.reality.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import org.reality.inventory.ContainerElementExtractor;
import org.reality.item.crafting.ElementExtractorRecipe;
import org.reality.main.Config;
import org.reality.tileentity.TileEntityElementExractor;

/**
 * Created by xCoDe7 on 19/4/2558.
 */
public class GuiElementExtractor extends GuiContainer
{
    private static boolean isBurning = true;

    public GuiElementExtractor (InventoryPlayer inventoryPlayer, TileEntityElementExractor tileEntity)
    {
        //the container is instanciated and passed to the superclass for handling
        super(new ContainerElementExtractor(inventoryPlayer, tileEntity));
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2)
    {
        //draw text and stuff here
        //the parameters for drawString are: string, x, y, color
        fontRendererObj.drawString("Element Extractor", 8, 6, 4210752);
        //draws "Inventory" or your regional equivalent
        fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);

    }

    private void updateBurnTime()
    {
        int x = (width - xSize);
        int y = (height - ySize);

        if (isBurning == true)
        {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.renderEngine.bindTexture(new ResourceLocation(Config.modID, "textures/gui/gui_element_extractor.png"));

            this.drawTexturedModalRect(x + 71, y + 40, 178, 14, ElementExtractorRecipe.instance().updateAnimation(), 6);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.renderEngine.bindTexture(new ResourceLocation(Config.modID, "textures/gui/gui_element_extractor.png"));

        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

        updateBurnTime();

    }

    public static void setBurning(boolean isBurning)
    {
        GuiElementExtractor.isBurning = isBurning;
    }
}
