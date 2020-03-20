package io.viren.interviews;

public class Smallest {

    /*
     * public static int FindMin(int a[])
     * Returns the smallest number in array that has been rotated
     * For example - Array {3,4,5,6,1,2} returns 1
     */

    public static int FindMin(int a[]) {
        if (null == a || a.length == 0) {
            System.err.println("Bogus input");
        }
        int smallest = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < smallest)
                smallest = a[i];
        }
        System.out.println("Smallest is " + smallest);
        return smallest;
    }

    public static void main(String args[]) {
        boolean result = true;
        result = result && FindMin(new int[]{3, 4, 5, 6, 1, 2}) == 1;
        result = result && FindMin(new int[]{2, 1}) == 1;
        result = result && FindMin(new int[]{1}) == 1;

        try {
            FindMin(null);
            result = false;
        } catch (Exception e) {
            result = result && true;
        }

        if (result) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }
}
