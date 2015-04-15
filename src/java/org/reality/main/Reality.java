package org.reality.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import org.reality.science.chemistry.element.Elements;
import org.reality.util.LangWriter;

@Mod(modid = Config.modID, name = Config.name, version = Config.version)
public class Reality
{
    @Mod.Instance(Config.modID)
    public static Reality instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        new Elements();
    }

    public static CreativeTabs realityCreativeTab = new CreativeTabs("tabReality")
    {
        @Override
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(Blocks.stone);
        }
    };
}
