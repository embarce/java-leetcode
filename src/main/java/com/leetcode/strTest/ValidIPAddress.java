package com.leetcode.strTest;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/29 12:19
 * Description:
 * FileName: ValidIPAddress
 */
public class ValidIPAddress {

    static Set<Character> set=new HashSet<>();
    static {
        set.add('0');
        set.add('1');
        set.add('2');
        set.add('3');
        set.add('4');
        set.add('5');
        set.add('6');
        set.add('7');
        set.add('8');
        set.add('9');
        for (int i = 0; i < 5; i++) {
            set.add((char) ('a'+i));
        }
        for (int i = 0; i < 5; i++) {
            set.add((char) ('A'+i));
        }
    }

    /**
     * 给定一个字符串 queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 IP 地址，返回 "Neither" 。
     *
     * 有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中 0 <= xi <= 255 且 xi 不能包含 前导零。例如: “192.168.1.1” 、 “192.168.1.0” 为有效IPv4地址， “192.168.01.1” 为无效IPv4地址; “192.168.1.00” 、 “192.168@1.1” 为无效IPv4地址。
     *
     * 一个有效的IPv6地址 是一个格式为“x1:x2:x3:x4:x5:x6:x7:x8” 的IP地址，其中:
     *
     * 1 <= xi.length <= 4
     * xi 是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。
     * 在 xi 中允许前导零。
     * 例如 "2001:0db8:85a3:0000:0000:8a2e:0370:7334" 和 "2001:db8:85a3:0:0:8A2E:0370:7334" 是有效的 IPv6 地址，而 "2001:0db8:85a3::8A2E:037j:7334" 和 "02001:0db8:85a3:0000:0000:8a2e:0370:7334" 是无效的 IPv6 地址。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：queryIP = "172.16.254.1"
     * 输出："IPv4"
     * 解释：有效的 IPv4 地址，返回 "IPv4"
     * 示例 2：
     *
     * 输入：queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
     * 输出："IPv6"
     * 解释：有效的 IPv6 地址，返回 "IPv6"
     * 示例 3：
     *
     * 输入：queryIP = "256.256.256.256"
     * 输出："Neither"
     * 解释：既不是 IPv4 地址，又不是 IPv6 地址
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/validate-ip-address
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param queryIP
     * @return
     */
    public static String validIPAddress(String queryIP) {
        if (queryIP==null || "".equals(queryIP)){
            return "Neither";
        }
        if(queryIP.contains(".")){
            if (queryIP.endsWith(".")) {
                return "Neither";
            }
            String[] split = queryIP.split("\\.");
            if(split.length!=4){
                return "Neither";
            }
            for (String s : split) {
                if (s.startsWith("0") && !"0".equals(s)) {
                    return "Neither";
                }
                int integer = 0;
                try {
                    integer = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    return "Neither";
                }
                if(integer>255){
                    return "Neither";
                }
            }
            return "IPv4";
        }else if(queryIP.contains(":")){
            if (queryIP.endsWith(":")) {
                return "Neither";
            }
            String[] split = queryIP.split(":");
            if(split.length!=8){
                return "Neither";
            }
            for (String s : split) {
                if (s.length()>4 || s.length()<1) {
                    return "Neither";
                }
                char[] chars = s.toCharArray();
                for (char aChar : chars) {
                    if(!set.contains(aChar)){
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }else {
            return "Neither";
        }
    }

    public static void main(String[] args) {
        System.out.println(validIPAddress("20EE:Fb8:85a3:0:0:8A2E:0370:7334"));
    }
}
