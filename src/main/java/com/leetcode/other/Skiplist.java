package com.leetcode.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author Embrace
 * git: https://github.com/embarce
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/7/26 20:29
 * Description: 调表
 * FileName: Skiplist
 */
public class Skiplist {

    Map<Integer, List<Integer>> map;


    public Skiplist() {
       map = new ConcurrentSkipListMap<>();
    }

    public boolean search(int target) {
        return map.containsKey(target);
    }

    public void add(int num) {
        List<Integer> list =new ArrayList<>();
        if(map.containsKey(num)){
            list = map.get(num);
        }
        list.add(num);
        map.put(num,list);
    }

    public boolean erase(int num) {
        if(map.containsKey(num)){
            List<Integer> list = map.get(num);
            if(list.size()>1){
                list.remove(list.size()-1);
            }else {
                map.remove(num);
            }
            return true;
        }else {
            return false;
        }
    }
}
