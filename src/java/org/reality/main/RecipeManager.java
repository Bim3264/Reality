package org.reality.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import org.reality.item.Items;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by xCoDe7 on 19/4/2558.
 */
public class RecipeManager
{
    public static HashMap<Block, Item> furnaceRecipes = new HashMap<Block, Item>();

    public static void register()
    {
        Iterator iterator = furnaceRecipes.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry pair = (Map.Entry)iterator.next();

            GameRegistry.addSmelting((Block) pair.getKey(), new ItemStack((Item)pair.getValue()), 0);

            iterator.remove();
        }

        addRecipe(new ItemStack(Items.bottle), new Object[] {"# #", "# #", "###", '#', Blocks.glass});
    }

    public static void addFurnaceRecipe(Block block, Item item)
    {
        furnaceRecipes.put(block, item);
    }

    public static void addRecipe(ItemStack itemStack, Object... recipe)
    {
        CraftingManager.getInstance().addRecipe(itemStack, recipe);
    }
}
