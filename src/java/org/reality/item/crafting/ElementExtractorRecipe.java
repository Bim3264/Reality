package org.reality.item.crafting;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.reality.util.MathUtil;

import java.util.HashMap;

/**
 * Created by xCoDe7 on 21/4/2558.
 */
public class ElementExtractorRecipe
{
    private static ElementExtractorRecipe INSTANCE = new ElementExtractorRecipe();
    private boolean smeltingFinish = false;

    public HashMap<Item, ItemStack> recipe = new HashMap<Item, ItemStack>();

    public static ElementExtractorRecipe instance()
    {
        return INSTANCE;
    }

    public void addRecipe(Item input, ItemStack output)
    {
        this.recipe.put(input, output);
    }

    public void addRecipe(Block input, ItemStack output)
    {
        this.addRecipe(Item.getItemFromBlock(input), output);
    }

    public ItemStack getOutput(Item input)
    {
        return recipe.get(input);
    }

    public ItemStack getOutput(Block input)
    {
        return this.getOutput(Item.getItemFromBlock(input));
    }

    int passTick = 0;

    @SubscribeEvent
    public void calculateTick(TickEvent.PlayerTickEvent event)
    {
        if (event.phase == TickEvent.Phase.END)
        {
            passTick++;
        }
        if (passTick == 200)
        {
            passTick = 0;
            this.smeltingFinish = true;
        }
    }

    public int updateAnimation()
    {
        return MathUtil.ddc(passTick, 20, 32);
    }
}
