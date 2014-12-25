package org.reality.main.human.system.circulatory.heart;

import org.reality.main.human.Organ;

/**
 * Created by Biw on 7/9/2557.
 */
public class Heart extends Organ
{
    public static int HEART_RATE = 110;

    public Heart()
    {
        this.ORGAN_FUNCTION = "Pumps blood to others organ in the body";
        this.ORGAN_NAME = "Heart";
        this.ORGAN_SYSTEM = "Circulatory";
    }
}
