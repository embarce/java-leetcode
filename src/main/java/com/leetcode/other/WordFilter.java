package com.leetcode.other;

import java.util.*;

/**
 * @author Embrace
 * git: https://github.com/embarce
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/7/14 20:39
 * Description:
 * FileName: WordFilter
 */
public class WordFilter {

//    List<String> set;


//    public WordFilter(String[] words) {
//        set=new ArrayList<>();
//        set.addAll(Arrays.asList(words));
//    }
//
//    public int f(String pref, String suff) {
//        int res = -1;
//        for (int i = 0; i < set.size(); i++) {
//            if(set.get(i).startsWith(pref) && set.get(i).endsWith(suff)){
//                 res=Math.max(res,i);
//            }
//        }
//        return -1;
//    }


    Map<String, Integer> dictionary;

    public WordFilter(String[] words) {
        dictionary = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int m = word.length();
            for (int prefixLength = 1; prefixLength <= m; prefixLength++) {
                for (int suffixLength = 1; suffixLength <= m; suffixLength++) {
                    dictionary.put(word.substring(0, prefixLength) + "#" + word.substring(m - suffixLength), i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return dictionary.getOrDefault(pref + "#" + suff, -1);
    }
}
