package com.leetcode.strTest;

/**
 * @author Embrace
 * @Classname IsFlipedString
 * @Description TODO
 * @Date 2022/9/29 22:15
 * @git: https://github.com/embarce
 */
public class IsFlipedString {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

}
