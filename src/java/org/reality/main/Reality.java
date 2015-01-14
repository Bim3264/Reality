package org.reality.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.reality.main.block.BlockRegister;
import org.reality.main.item.ItemRegister;

@Mod(modid = Config.modID, name = Config.name, version = Config.version)
public class Reality
{
    @Mod.Instance(Config.modID)
    public static Reality instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ItemRegister.register();
        BlockRegister.register();
    }
}
