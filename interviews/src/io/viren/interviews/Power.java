package io.viren.interviews;

public class Power {

    public static void main(String[] args) {

        System.out.println(powerRecursively(2, 5) == 32);
    }

    /**
     * O(n)
     */
    private static double power(double base, int exponent) {
        if (exponent == 0)
            return 1;

        double value = 1;
        for (int i = 0; i < exponent; i++) {
            value = value * base;
        }
        return value;
    }

    /**
     * O(logn) time complexity.
     *
     * @param base
     * @param exponent
     * @return
     */
    private static double powerRecursively(double base, int exponent) {
        if (exponent == 0)
            return 1;
        double pow = powerRecursively(base, exponent / 2);

        if (exponent % 2 != 0) {
            return base * pow * pow;
        }
        return pow * pow;
    }
}
