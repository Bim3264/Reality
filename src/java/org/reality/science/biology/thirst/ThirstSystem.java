package org.reality.science.biology.thirst;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.world.biome.BiomeGenBase;
import org.reality.renderer.BottleGui;

/**
 * Created by xCoDe7 on 20/4/2558.
 */
public class ThirstSystem
{
    private Minecraft mc;

    public static boolean red = false;

    public ThirstSystem(Minecraft mc)
    {
        this.mc = mc;
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onTick(TickEvent.PlayerTickEvent event)
    {
        if (this.mc.theWorld.getBiomeGenForCoords((int)this.mc.thePlayer.posX, (int)this.mc.thePlayer.posZ) == BiomeGenBase.desert)
        {
            BottleGui.decreasePercentage(0.002f);
        }

        if (this.mc.thePlayer.isSprinting())
        {
            BottleGui.decreasePercentage(0.00125f);
        }

    }
}
