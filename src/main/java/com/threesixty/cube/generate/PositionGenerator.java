package com.threesixty.cube.generate;

import java.util.ArrayList;
import java.util.List;

public class PositionGenerator {

    private static List<String> allPerms = new ArrayList<>();

    private static void permute(String input, int l, int r) {
        if (l == r) {
            allPerms.add(input);
        }
        else {
            for (int i = l; i < r + 1; i++) {
                input = swap(input, l, i);
                permute(input, l + 1, r);
                input = swap(input, l, i);
            }
        }

    }

    private static String swap(final String input, final int i, final int j) {
        final char[] chars = input.toCharArray();
        char temp = chars[i];

        chars[i] = chars[j];
        chars[j] = temp;

        return String.valueOf(chars);
    }

    /**
     * Gives all permutations of a given string
     *
     * @param input
     * @return
     */
    public List<String> allPermutations(String input) {
        permute(input, 0, input.length() - 1);
        return allPerms;
    }

}
