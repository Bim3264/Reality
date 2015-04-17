package org.reality.science.chemistry.element;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import org.reality.block.BlockChemFluid;

/**
 * Created by xCoDe7 on 13/4/2558.
 */
public class ElementLiquid extends Element
{
    public Fluid fluid;
    public Block block;

    public ElementLiquid(int id, String symbol, String name)
    {
        super(id, symbol, name);
        doStuff(name);
        this.addToArrayIfNotExist(id, this);

    }

    //TODO: Fix bugs
    public void doStuff(String name)
    {
//        fluid = new Fluid("fluid_" + name.toLowerCase());
//        fluid.setUnlocalizedName("fluid_" + name.toLowerCase());

//        block = new BlockChemFluid(fluid, "blockfluid_" + name.toLowerCase());
//
//        FluidRegistry.registerFluid(fluid);
//        GameRegistry.registerBlock(block, name.toLowerCase());
    }
}
