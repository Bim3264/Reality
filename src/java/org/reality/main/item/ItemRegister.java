package org.reality.main.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import org.reality.main.Config;

/**
 * Created by Biw on 27/12/2557.
 */
public class ItemRegister
{
    public static Item binder;

    public static void register()
    {
        binder = new ItemBinder(Config.nameBinder);

        GameRegistry.registerItem(binder, Config.nameBinder);
    }
}
