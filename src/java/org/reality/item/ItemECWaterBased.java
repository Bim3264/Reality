package org.reality.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.reality.main.Config;
import org.reality.main.Reality;
import org.reality.renderer.BottleGui;

/**
 * Created by xCoDe7 on 20/4/2558.
 */

public class ItemECWaterBased extends ItemFood
{
    private String unlocalizedName;
    private float percentageIncrease = 0.0f;

    public ItemECWaterBased(String unlocalizedName)
    {
        super(0,0,false);
        this.unlocalizedName = unlocalizedName;
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Config.modID + ":" + unlocalizedName.toLowerCase().substring(5));
        this.setCreativeTab(Reality.realitySurvival);
        this.setAlwaysEdible();
    }

    public ItemECWaterBased setPercentageIncrease(float percentageIncrease)
    {
        this.percentageIncrease = percentageIncrease;
        return this;
    }

    @Override
    public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
    {
        BottleGui.increasePercentage(percentageIncrease);
        p_77654_3_.inventory.decrStackSize(p_77654_3_.inventory.currentItem, 1);
        p_77654_3_.inventory.addItemStackToInventory(new ItemStack(Items.bottle, 1));
        return p_77654_1_;
    }
}
