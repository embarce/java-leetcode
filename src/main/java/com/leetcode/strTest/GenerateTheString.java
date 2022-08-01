package com.leetcode.strTest;

/**
 * @author Embrace
 * git: https://github.com/embarce
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/8/1 20:20
 * Description: 1374. 生成每种字符都是奇数个的字符串
 * FileName: GenerateTheString
 */
public class GenerateTheString {
    /**
     * 4
     * 3 1
     * 5
     * 3 2
     */
    public static String generateTheString(int n) {

        StringBuffer res = new StringBuffer();
        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                res.append('p');
            }
        } else {
            int i = n - 1;
            for (int j = 0; j < i; j++) {
                res.append('p');
            }
            res.append('z');
        }
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(generateTheString(4));
    }
}
