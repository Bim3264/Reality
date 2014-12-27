package org.reality.main.science.chemistry;

import java.util.ArrayList;

/**
 * Created by Biw on 25/12/2557.
 */
public class Element
{
    public static ArrayList<Element> elements = new ArrayList<Element>();

    //TODO: Continue the table
    public static final Element hydrogen    = new Element(1, "H", "Hydrogen", ElementType.GAS);
    public static final Element helium      = new Element(2, "He", "Helium", ElementType.GAS);
    public static final Element lithium     = new Element(3, "Li", "Lithium", ElementType.SOLID);
    public static final Element beryllium   = new Element(4, "Be", "Beryllium", ElementType.SOLID);
    public static final Element boron       = new Element(5, "B", "Boron", ElementType.SOLID);
    public static final Element carbon      = new Element(6, "C", "Carbon", ElementType.SOLID);
    public static final Element nitrogen    = new Element(7, "N", "Nitrogen", ElementType.GAS);
    public static final Element oxygen      = new Element(8, "O", "Oxygen", ElementType.GAS);
    public static final Element flourine    = new Element(9, "F", "Flourine", ElementType.GAS);
    public static final Element neon        = new Element(10, "Ne", "Neon", ElementType.GAS);
    public static final Element sodium      = new Element(11, "Na", "Sodium", ElementType.SOLID);
    public static final Element magnesium   = new Element(12, "Mg", "Magnesium", ElementType.SOLID);
    public static final Element aluminium   = new Element(13, "Al", "Aluminium", ElementType.SOLID);
    public static final Element silicon     = new Element(14, "Si", "Silicon", ElementType.SOLID);
    public static final Element phosphorus  = new Element(15, "P", "Phosphorus", ElementType.SOLID);
    public static final Element sulfur      = new Element(16, "S", "Sulfur", ElementType.SOLID);
    public static final Element cholrine    = new Element(17, "Cl", "Chlorine", ElementType.GAS);
    public static final Element argon       = new Element(18, "Ar", "Argon", ElementType.GAS);
    public static final Element potassium   = new Element(19, "K", "Potassium", ElementType.SOLID);
    public static final Element calcium     = new Element(20, "Ca", "Calcium", ElementType.SOLID);
    public static final Element scandium    = new Element(21, "Sc", "Scandium", ElementType.SOLID);
    public static final Element titanium    = new Element(22, "Ti", "Titanium", ElementType.SOLID);
    public static final Element vanadium    = new Element(23, "V", "Vanadium", ElementType.SOLID);
    public static final Element chromium    = new Element(24, "Cr", "Chromium", ElementType.SOLID);
    public static final Element manganese   = new Element(25, "Mn", "Maganese", ElementType.SOLID);
    public static final Element iron        = new Element(26, "Fe", "Iron", ElementType.SOLID);
    public static final Element cobalt      = new Element(27, "Co", "Cobalt", ElementType.SOLID);
    public static final Element nickel      = new Element(28, "Ni", "Nickel", ElementType.SOLID);
    public static final Element copper      = new Element(29, "Cu", "Copper", ElementType.SOLID);
    public static final Element zinc        = new Element(30, "Zn", "Zinc", ElementType.SOLID);
    public static final Element gallium     = new Element(31, "Ga", "Gallium", ElementType.LIQUID);

    public static final Element gold        = new Element(79, "Au", "Gold", ElementType.SOLID);

    public int id;
    public String name;
    public String symbol;
    public ElementType type;

    private Element(int id, String symbol, String name, ElementType type)
    {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.type = type;
        this.elements.add(this);
    }
}
