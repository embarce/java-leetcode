package com.leetcode.strTest;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/13 9:52
 * Description:
 * FileName: OneEditAway
 */
public class OneEditAway {
    /**
     * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
     *
     *  
     *
     * 示例 1:
     *
     * 输入:
     * first = "pale"
     * second = "ple"
     * 输出: True
     *  
     *
     * 示例 2:
     *
     * 输入:
     * first = "pales"
     * second = "pal"
     * 输出: False
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/one-away-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static boolean oneEditAway(String first, String second) {
        if (first.equals(second)) {
            return true;
        } else {
            int fl = first.length();
            int sl = second.length();
            /**
             * 长度一样替换 最多只能一个不同
             */
            if (fl == sl) {
                int status = 0;
                for (int i = 0; i < first.length(); i++) {
                    char c = first.charAt(i);
                    char c1 = second.charAt(i);
                    if (c != c1) {
                        status++;
                        if (status > 1) {
                            return false;
                        }
                    }
                }
                return true;
            }
            /***
             * 两个以上的差距没有办法
             */
            int abs = Math.abs(sl - fl);
            if (abs > 1) {
                return false;
            } else if (abs == 1 && ("".equals(first) || "".equals(second))) {
                return true;
            }
            /**
             * 长度不一样 新增或删除 本质都一样 最后看看相不相等
             */
            int min = Math.min(fl, sl);
            String minStr = (min == fl ? first : second);
            String tagStr = (min == fl ? second : first);
            StringBuilder sb = new StringBuilder(tagStr);
            int ops = 0;
            for (int i = 0; i < min; i++) {
                char c = first.charAt(i);
                char c1 = second.charAt(i);
                if (c != c1) {
                    ops++;
                    sb.deleteCharAt(i);
                    if (sb.toString().equals(minStr)) {
                        break;
                    }
                    if (ops > 1) {
                        break;
                    }
                }
            }
            if (ops == 0) {
                return sb.toString().equals(minStr + sb.charAt(sb.length() - 1));
            } else {
                return sb.toString().equals(minStr);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(oneEditAway("islander","slander"));
    }
}
