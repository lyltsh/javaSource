package com.source.javalang.stringtest;

/**
 * @Description:
 * @Author: leiyulin
 * @date: 2018/6/24
 */
public class StringDemo {
    public static void main(String[] args) {
        String abc = "abc08sf23d";
        System.out.println(abc.startsWith("abc1"));
        System.out.println(abc.indexOf("84"));
    }

    /**
     * Code shared by String and StringBuffer to do searches. The
     * source is the character array being searched, and the target
     * is the string being searched for.
     *
     * @param source       the characters being searched.
     * @param sourceOffset offset of the source string.
     * @param sourceCount  count of the source string.
     * @param target       the characters being searched for.
     * @param targetOffset offset of the target string.
     * @param targetCount  count of the target string.
     * @param fromIndex    the index to begin searching from.
     */
    static int indexOf(char[] source, int sourceOffset, int sourceCount,
                       char[] target, int targetOffset, int targetCount,
                       int fromIndex) {
        if (fromIndex > sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        char first = target[targetOffset];
        int max = sourceOffset + sourceCount - targetCount;
        for (int i = fromIndex + sourceOffset; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first) ;
            }
            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j] == target[k]; j++, k++) ;
                /* Found whole string. */
                if (j == end) {
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }
}
