package com.samjin.array;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int[] cnt = new int[128];
        for(char c : t.toCharArray()){
            cnt[c]++;
        }

        // 记录最小长度的起始位置
        int from = 0;
        // 判断是否找到t中的全部结果了
        int total = t.length();
        // 最小长度
        int min = Integer.MAX_VALUE;
        int start = 0;

        for(int i = 0; i < s.length(); i++){
            // 如果发现了t中的字符，就让total--
            if(cnt[s.charAt(i)]-- > 0) total--;
            // 先找到一个包含全部字符的substring
            // 增加起始位置, 找到最短的substring
            while(total == 0){
                // 先判断最小长度
                if(i - start + 1 < min){
                    min = i - start + 1;
                    from = start;
                }
                // 开始从左缩小窗口
                // 如果s中的字符碰到了t中字符，并且此时对应的字符在cnt中为0
                // 那么说明当前j指向的位置将会少一个t中的字符
                // 此时total++，退出while循环，开始找下一个字符
                if(cnt[s.charAt(start++)]++ == 0) total++;
            }
        }

        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
    }
}
