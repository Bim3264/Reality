package org.reality.renderer;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.world.WorldEvent;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.reality.main.Config;
import org.reality.science.biology.thirst.ThirstSystem;
import org.reality.util.MathUtil;

/**
 * Created by xCoDe7 on 18/4/2558.
 */
public class BottleGui extends Gui implements IExtendedEntityProperties
{
    private Minecraft mc;
    private Vector2f pos = new Vector2f(0,0);
    private static Float percentage = 100.0f;
    private static Float max = 100.0f;
    private static Float min = 0.0f;

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
            this.drawTexturedModalRect((int) pos.x, (int) pos.y, 0, 16, (int)animate(percentage), 16);
            this.drawString(this.mc.fontRenderer, Double.toString(Math.ceil((double)percentage)) + " %" /** Should be replace with percent*/, (int)pos.x + 2, (int)pos.y + 16, getPercentageColor());
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onEntityConstruct(EntityEvent.EntityConstructing event)
    {
        event.entity.registerExtendedProperties("BottleGui", this);
    }

    public int getPercentageColor()
    {
        if (percentage < 70 && percentage >= 50)
        {
            return 0xFFFF00;
        }
        else if (percentage < 50)
        {
            ThirstSystem.red = true;
            return 0xFF0000;
        }
        else
        {
            return 0x00FF00;
        }
    }

    private float animate(float percentage)
    {
        float width;
//        width = (percentage * 8) / 25;
        width = MathUtil.ddc((int)percentage, 8, 25);
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

    public static void setPercentage(float percentage)
    {
        BottleGui.percentage = percentage;
    }

    public static float getPercentage()
    {
        return  percentage;
    }

    public static void decreasePercentage(float percentage)
    {
        if (!(BottleGui.percentage <= min))
        {
            BottleGui.percentage -= percentage;
        }
    }

    public static void increasePercentage(float percentage)
    {
        if (!(BottleGui.percentage >= max))
        {
            if ((BottleGui.percentage += percentage) > max)
            {
                setPercentage(100);
            }
            else
            {
                BottleGui.percentage += percentage;
            }
        }
    }

    public static boolean isWaterMaxed()
    {
        if (BottleGui.getPercentage() == max)
            return true;
        return false;
    }


    @Override
    public void saveNBTData(NBTTagCompound compound)
    {
        compound.setFloat("water_percentage", percentage);
        System.out.println("Saving Water Data");
    }

    @Override
    public void loadNBTData(NBTTagCompound compound)
    {
        percentage = compound.getFloat("water_percentage");
        System.out.println("Loading Water Data");
    }

    @Override
    public void init(Entity entity, World world)
    {}
}
