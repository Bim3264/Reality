package org.reality.item;

import net.minecraft.item.Item;
import org.reality.main.Config;
import org.reality.main.Reality;

/**
 * Created by xCoDe7 on 20/4/2558.
 */
public class Items
{
    public static final Item bottle         = new Item().setUnlocalizedName("item_ec_bottle").setTextureName(Config.modID + ":" + "item_ec_bottle").setCreativeTab(Reality.realitySurvival);
    public static final Item waterBottle    = new ItemECWaterBased("item_ec_water_bottle").setPercentageIncrease(5);
}
