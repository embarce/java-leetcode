package com.leetcode.strTest;

import java.util.*;

/**
 * @author Embrace
 * git: https://github.com/embarce
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/7/11 20:29
 * Description:
 * FileName: MagicDictionary
 */
public class MagicDictionary {

    Map<Integer,Set<String>> map;

    public MagicDictionary() {
        map=new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            int length = s.length();
            Set<String> set = map.getOrDefault(length, new HashSet<>());
            set.add(s);
            map.put(length,set);
        }
    }

    public boolean search(String searchWord) {
        int length = searchWord.length();
        if (map.containsKey(length)) {
            Set<String> set = map.get(length);
            for (String s : set) {
                char[] chars = s.toCharArray();
                char[] searchWordChars = searchWord.toCharArray();
                int diff=0;
                for (int i = 0; i < chars.length; i++) {
                    if(chars[i] != searchWordChars[i]){
                        diff++;
                    }
                    if(diff > 1){
                        break;
                    }
                }
                if(diff==1){
                    return true;
                }
            }
            return false;
        }else {
            return false;
        }
    }
}
