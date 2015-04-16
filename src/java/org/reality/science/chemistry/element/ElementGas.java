package org.reality.science.chemistry.element;

/**
 * Created by xCoDe7 on 14/4/2558.
 */
public class ElementGas extends Element
{
    public ElementGas(int id, String symbol, String name)
    {
        super(id, symbol, name);
        this.addToArrayIfNotExist(id, this);
    }
}
