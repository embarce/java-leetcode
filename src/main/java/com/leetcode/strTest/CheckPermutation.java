package com.leetcode.strTest;

import java.util.Arrays;

/**
 * @author Embrace
 * @Classname CheckPermutation
 * @Description CheckPermutation
 * @Date 2022/9/27 21:08
 * @git: https://github.com/embarce
 */
public class CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars);
        for (int i = 0; i < chars1.length; i++) {
            if(chars1[i] != chars[i]){
                return false;
            }
        }
        return true;
    }
}
