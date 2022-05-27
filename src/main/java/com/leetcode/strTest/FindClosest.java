package com.leetcode.strTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/27 10:27
 * Description: 单词距离
 * FileName: FindClosest
 */
public class FindClosest {

    static Map<String, List<Integer>> map=new HashMap<>();

    /**
     * 有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
     *
     * 示例：
     *
     * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
     * 输出：1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/find-closest-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public static int findClosest(String[] words, String word1, String word2) {
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            }else {
                List<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(words[i],list);
            }
        }
        int min = Integer.MAX_VALUE;
        List<Integer> word1List = map.get(word1);
        List<Integer> word2List = map.get(word2);
        if(word1List.size()==1 && word2List.size()==1){
            return Math.abs(word1List.get(0)-word2List.get(0));
        }
        for (Integer w1Index : word1List) {
            for (Integer w2Index : word2List) {
                min=Math.min(Math.abs(w1Index-w2Index),min);
            }
        }
        map.forEach((k,v)-> System.out.println(k+"======="+v));
        return min;
    }


    public int findClosestEz(String[] words, String word1, String word2) {
        int length = words.length;
        int ans = length;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                index1 = i;
            } else if (word.equals(word2)) {
                index2 = i;
            }
            if (index1 >= 0 && index2 >= 0) {
                ans = Math.min(ans, Math.abs(index1 - index2));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[]  words = {"I","am","a","student","from","a","university","in","a","city"};
        String word1 = "a";
        String word2 = "student";
        System.out.println(findClosest(words,word1,word2));
    }
}
