package com.leetcode.strTest;

import java.util.Comparator;
import java.util.List;

/**
 * @author Embrace
 * git: https://github.com/embarce
 * @version 1.0
 * @since JDK 1.8
 * Date: 2022/7/7 21:14
 * Description: 648. 单词替换
 * FileName: ReplaceWords
 */
public class ReplaceWords {


    /**
     * 在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
     *
     * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
     *
     * 你需要输出替换之后的句子。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
     * 输出："the cat was rat by the bat"
     * 示例 2：
     *
     * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
     * 输出："a a b c"
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/replace-words
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        dictionary.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        String[] s1 = sentence.split(" ");
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            for (String s : dictionary) {
                if (s1[i].startsWith(s)) {
                    s1[i]=s;
                    break;
                }
            }
            stringBuilder.append(s1[i]).append(" ");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length()).toString();
    }
}
