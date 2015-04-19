package org.reality.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import org.reality.handler.GuiHandler;
import org.reality.renderer.BottleGui;
import org.reality.science.chemistry.element.Elements;

@Mod(modid = Config.modID, name = Config.name, version = Config.version)
public class Reality
{
    @Mod.Instance(Config.modID)
    public static Reality instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new Blocks();
        new Elements();

        RecipeManager.register();

        GameRegistry.registerBlock(org.reality.block.Blocks.elementExtractor, "block_element_extractor");

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new BottleGui(Minecraft.getMinecraft()));
    }

    public static CreativeTabs realityChemistry = new CreativeTabs("tabReality_Chemistry")
    {
        @Override
        public Item getTabIconItem()
        {
            return Elements.hydrogen.getItem();
        }
    };

    public static CreativeTabs realityWorldGen = new CreativeTabs("tabReality_WorldGen")
    {
        @Override
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(Blocks.stone);
        }
    };
}
