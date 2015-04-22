package org.reality.util;

/**
 * Created by xCoDe7 on 21/4/2558.
 */
public class MathUtil
{
    public static double gcd(double a, double b)
    {
        while (b > 0)
        {
            double temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static double lcm(double a, double b)
    {
        return a * (b / gcd(a, b));
    }

    public static int ddc(int pass, int d1, int d2)
    {
        int ans = (pass * d1) / d2;
        return ans;
    }
}
