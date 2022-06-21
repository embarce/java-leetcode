package com.leetcode.strTest;

/**
 * @author Embrace
 * git: https://github.com/embarce
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/6/21 9:41
 * Description: 1108. IP 地址无效化
 * FileName: DefangIPaddr
 */
public class DefangIPaddr {


    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
