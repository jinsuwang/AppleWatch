package com.samjin.string;

public class MinimumInsertionsToBalanceAParenthesesString {
    public int minInsertions(String s) {

        int open = 0; // 用于记录未闭合的左括号 '(' 的数量
        int insertions = 0; // 用于记录所需的插入次数
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                // 遇到左括号，增加未闭合左括号数量
                open++;
            }else{
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    // 这是一个成对的右括号“))”
                    i++; // 跳过下一个右括号
                } else {
                    // 这是单独的一个右括号“) ”，需要插入一个右括号
                    insertions++;
                }

            }

            // 需要匹配一个左括号
            if (open > 0) {
                // 存在未匹配的左括号
                open--;
            } else {
                // 没有多余的左括号，需要插入一个左括号
                insertions++;
            }
            i++;
        }

        insertions += 2 * open;
        return insertions;
    }
}
