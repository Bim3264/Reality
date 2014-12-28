package org.reality.main;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.reality.main.block.BlockRegister;
import org.reality.main.item.ItemRegister;

@Mod(modid = ModInfo.modID, name = ModInfo.name, version = ModInfo.version)
public class Reality
{
    @Mod.Instance(ModInfo.modID)
    public static Reality instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ItemRegister.register();
        BlockRegister.register();
    }
}
