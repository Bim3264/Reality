package org.reality.main.util;

import java.util.ArrayList;

/**
 * Created by Biw on 13/1/2558.
 */
@Deprecated
public class SpriteSheet
{
    public ArrayList<SpriteSheet> spriteSheets = new ArrayList<SpriteSheet>();

    public int textureSize = 16;
    public String spriteSheetName = null;

    public SpriteSheet(int textureSize, String spriteSheetName)
    {
        this.spriteSheets.add(this);
        this.textureSize = textureSize;
        this.spriteSheetName = spriteSheetName;
    }

//    public IIcon getIcon(String spriteSheetName, int id)
//    {
//
//    }
}
