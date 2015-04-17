package org.reality.science.chemistry.element;

import java.util.ArrayList;

/**
 * Created by xCoDe7 on 5/4/2558.
 */
public class Element
{
    public int id;
    public String symbol;
    public String name;

//    public ArrayList<Element> elements = new ArrayList<Element>();

    public Element(int id, String symbol, String name)
    {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
//        elements.ensureCapacity(118);
    }

    public void addSpecialRules(SpecialRules... specialRules) {}

    public void addToArrayIfNotExist(int index, Element element)
    {
//        if (!elements.contains(element))
        {
//            elements.add(index - 1, element);
        }
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }
}
