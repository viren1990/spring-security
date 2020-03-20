package io.viren.interviews;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestUniformString {


    private static final Map<String, int[]> testCases = new HashMap<>();
    private static int max = 0;
    private static int maxStartPos = -1;

    static int[] longestUniformSubStringTraditional(final String input) {
        if (null == input || input.length() == 0 || input.equals(""))
            return new int[]{-1, 0};
        int max = 0, maxStartPos = 0;
        final char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int len = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] == chars[i]) {
                    len++;
                    continue;
                }
                break;
            }
            if (len > max) {
                max = len;
                maxStartPos = i;
            }
        }
        return new int[]{maxStartPos, max};
    }

    static int[] longestUniformSubstring(String input) {
        if (null == input || input.length() == 0 || input.equals(""))
            return new int[]{-1, 0};
        max = 0;
        maxStartPos = 0;
        int len = 0, start_pos = 0;
        final char[] chars = input.toCharArray();

        char start = chars[0];

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == start)
                len++;
            else {
                if (len > max) {
                    System.out.println("calling from line 29 for char :" + chars[start_pos]);
                    updateMaxResults(len, start_pos);
                }
                start_pos = i;
                len = 1;
                start = chars[i];
            }
        }
        if (len > max) {
            updateMaxResults(len, start_pos);
        }
        return new int[]{maxStartPos, max};
    }

    private static void updateMaxResults(int len, int startPos) {
        max = len;
        maxStartPos = startPos;
    }

    public static void main(String[] args) {
        testCases.put("", new int[]{-1, 0});
        testCases.put("10000111", new int[]{1, 4});
        testCases.put("aaakkkkbbkkkkk", new int[]{9, 5});

        boolean pass = true;
        for (Map.Entry<String, int[]> testCase : testCases.entrySet()) {
            int[] result = longestUniformSubStringTraditional(testCase.getKey());
            pass = pass && (Arrays.equals(result, testCase.getValue()));
        }
        if (pass) {
            System.out.println("Pass!");
        } else {
            System.out.println("Failed! ");
        }
    }
}
