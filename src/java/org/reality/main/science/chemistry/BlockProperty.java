package org.reality.main.science.chemistry;

import net.minecraft.block.Block;

import java.util.HashMap;

/**
 * Created by Biw on 25/12/2557.
 */
public class BlockProperty
{
    public static HashMap<Block, Element[]> blockProperties = new HashMap<Block, Element[]>();

    public static void setBlockProperties(Block block, Element[] elements)
    {
        blockProperties.put(block, elements);
    }
}
