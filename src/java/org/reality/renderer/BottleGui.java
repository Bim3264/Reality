package org.reality.renderer;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.reality.main.Config;

/**
 * Created by xCoDe7 on 18/4/2558.
 */
public class BottleGui extends Gui
{
    private Minecraft mc;
    public Vector2f pos = new Vector2f(0,0);
    public int percentage = 49;

    public BottleGui(Minecraft mc)
    {
        super();
        this.mc = mc;
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onExpBarDrawn(RenderGameOverlayEvent event)
    {
        if (event.isCancelable() || event.type != RenderGameOverlayEvent.ElementType.EXPERIENCE)
        {
            return;
        }

        if (Minecraft.getMinecraft().playerController.isNotCreative())
        {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glDisable(GL11.GL_LIGHTING);

            this.mc.renderEngine.bindTexture(new ResourceLocation(Config.modID, "textures/gui/thirst_hud.png"));
            this.drawTexturedModalRect((int) pos.x, (int) pos.y, 0, 0, 32, 16);
            this.drawTexturedModalRect((int) pos.x, (int) pos.y, 0, 16, animate(percentage), 16);
            this.drawString(this.mc.fontRenderer, Integer.toString(percentage) + " %" /** Should be replace with percent*/, (int)pos.x + 2, (int)pos.y + 16, getPercentageColor());
        }
    }

    public int getPercentageColor()
    {
        if (this.percentage < 70 && this.percentage >= 50)
        {
            return 0xFFFF00;
        }
        else if (this.percentage < 50)
        {
            return 0xFF0000;
        }
        else
        {
            return 0x00FF00;
        }
    }

    private int animate(int percentage)
    {
        int width;
        width = (percentage * 8) / 25;
        return width;
    }

    public void setPos(int x, int y)
    {
        this.pos = new Vector2f(x, y);
    }

    public void setPos(Vector2f pos)
    {
        this.pos = pos;
    }

    //Should be set from thirst api
    public void setPercentage(int percentage)
    {
        this.percentage = percentage;
    }
}
