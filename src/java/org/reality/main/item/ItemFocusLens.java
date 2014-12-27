package org.reality.main.item;

/**
 * Created by Biw on 27/12/2557.
 */
public class ItemFocusLens extends ModItem
{
    public LensType lensType;

    public ItemFocusLens(String itemname, LensType lensType)
    {
        super(itemname);
        this.lensType = lensType;
    }

    public enum LensType
    {
        RANGE, SPEED, AMOUNT, BYPASS
    }
}
