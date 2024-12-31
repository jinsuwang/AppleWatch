package com.samjin.string;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin {
    public String toGoatLatin(String sentence) {
        // 定义元音集合，大小写均可
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');

        // 将句子按空格分割为单词数组
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        // 遍历每个单词
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder goatLatinWord = new StringBuilder();

            // 如果是元音开头
            if (vowels.contains(word.charAt(0))) {
                goatLatinWord.append(word);
            } else {
                // 如果是辅音开头，处理第一个字母
                goatLatinWord.append(word.substring(1)).append(word.charAt(0));
            }

            // 添加 "ma" 和对应数量的 "a"
            goatLatinWord.append("ma");
            for (int j = 0; j <= i; j++) {
                goatLatinWord.append("a");
            }

            // 添加处理后的单词到结果中
            if (i > 0) {
                result.append(" ");
            }
            result.append(goatLatinWord);
        }

        return result.toString();
    }
}
