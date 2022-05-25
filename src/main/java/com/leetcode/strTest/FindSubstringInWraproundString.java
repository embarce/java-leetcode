package com.leetcode.strTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/25 10:13
 * Description: 467. 环绕字符串中唯一的子字符串
 * FileName: FindSubstringInWraproundString
 */
public class FindSubstringInWraproundString {


    /**
     * 把字符串 s 看作是 “abcdefghijklmnopqrstuvwxyz” 的无限环绕字符串，所以 s 看起来是这样的：
     *
     * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." . 
     * 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。 
     *
     *  
     *
     * 示例 1:
     *
     * 输入: p = "a"
     * 输出: 1
     * 解释: 字符串 s 中只有一个"a"子字符。
     * 示例 2:
     *
     * 输入: p = "cac"
     * 输出: 2
     * 解释: 字符串 s 中的字符串“cac”只有两个子串“a”、“c”。.
     * 示例 3:
     *
     * 输入: p = "zab"
     * 输出: 6
     * 解释: 在字符串 s 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/unique-substrings-in-wraparound-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    /**
     * 你告诉我，模拟居然超时了？那么只能是dp了你等着你个狗比
     * @param p
     * @return
     */
    public static int findSubstringInWraproundString(String p) {
        if(p==null || p.length()==0){
            return 0;
        }
        if(p.length()==1){
            return 1;
        }
        char[] chars = p.toCharArray();
        int res = 0;
        Set<String> set=new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            StringBuilder sb=new StringBuilder();
            sb.append(chars[i]);
            if(!set.contains(sb.toString())){
                res++;
                set.add(sb.toString());
            }
            for (int j = i+1; j < chars.length; j++) {
                int tmp = chars[j] - chars[j - 1];
                if(tmp ==1 || tmp ==-25){
                    sb.append(chars[j]);
                    if(!set.contains(sb.toString())){
                        set.add(sb.toString());
                        res++;
                    }
                }else {
                    break;
                }
            }
        }
        return res;
    }


    public static int findSubstringInWraproundStringDp(String p) {
        if (p == null || p.length() == 0) {
            return 0;
        }
        if (p.length() == 1) {
            return 1;
        }
        int[] dp = new int[26];
        char[] chars = p.toCharArray();
        int cur = 1;
        int index = chars[0] - 'a';
        /**
         * 处理第一个
         */
        dp[index] = cur;
        for (int i = 1; i < chars.length; i++) {
            /**
             * 如果前面和当前相差一个字符，让cur++计算字符数，譬如 “abc”  b前面是a 那么只有ab 和 b 两个组合 2个， c前面是ab 那么是 abc bc c 3个=======>推断出让其++即是数量
             */
            int tmp = ((chars[i] - chars[i - 1]) + 26) % 26;
            if(tmp==1){
                cur++;
            }else {
                /**
                 * 如果不是有序的 重置为一个字符子串
                 */
                cur=1;
            }
            dp[chars[i]-'a']=Math.max(dp[chars[i]-'a'],cur);
        }
        int res=0;
        for (int i : dp) {
            res+=i;
        }
        return res;
    }

    public static void main(String[] args) {
       System.out.println(findSubstringInWraproundStringDp("abc"));
    }
}
