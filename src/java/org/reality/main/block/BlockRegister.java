package org.reality.main.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import org.reality.main.Config;
import org.reality.main.science.chemistry.Element;
import org.reality.main.tileentity.TileEntityFusionReactor;

/**
 * Created by Biw on 25/12/2557.
 */
public class BlockRegister
{
    public static Block pureIron;
    public static Block pureGold;
    public static Block pureDiamond;
    public static Block pureEmerald;

    public static Block fusion_reactor;

    public static void register()
    {
        pureIron = new ModBlock(Config.namePureIron).setProperties(new Element[] {Element.iron});
        pureGold = new ModBlock(Config.namePureGold).setProperties(new Element[] {Element.gold});
        fusion_reactor = new BlockFusionReactor(Config.nameFusionReactor);

        GameRegistry.registerBlock(pureIron, Config.namePureIron);
        GameRegistry.registerBlock(pureGold, Config.namePureGold);
        GameRegistry.registerBlock(fusion_reactor, Config.nameFusionReactor);

        GameRegistry.registerTileEntity(TileEntityFusionReactor.class, "tile_entity_fusion_reactor");
    }
}
