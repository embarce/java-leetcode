package com.leetcode.lru;

import java.util.*;

/**
 * @author Embrace
 * git: https://gitee.com/EmbraceQAQ
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/5/19 10:01
 * Description:
 * FileName: LRUCache
 */
public class LRUCache {

    Map<Integer, Integer> cache;
    int cacheCapacity = 0;
    List<Integer> list;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>(capacity);
        cacheCapacity=capacity;
        list=new LinkedList<>();
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            list.remove((Object)key);
            list.add(key);
            return cache.get(key);
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key,value);
            list.remove((Object)key);
            list.add(key);
        }else {
            if(list.size()>=cacheCapacity){
                Integer remove = list.remove(0);
                cache.remove(remove);
            }
            cache.put(key,value);
            list.add(key);
        }
    }


    /**
     * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
     * 实现 LRUCache 类：
     * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
     * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
     *
     *  
     *
     * 示例：
     *
     * 输入
     * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * 输出
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     *
     * 解释
     * LRUCache lRUCache = new LRUCache(2);
     * lRUCache.put(1, 1); // 缓存是 {1=1}
     * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
     * lRUCache.get(1);    // 返回 1
     * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
     * lRUCache.get(2);    // 返回 -1 (未找到)
     * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
     * lRUCache.get(1);    // 返回 -1 (未找到)
     * lRUCache.get(3);    // 返回 3
     * lRUCache.get(4);    // 返回 4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/lru-cache
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(2);
        lruCache.get(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        lruCache.get(1);
        lruCache.get(2);
    }
}
