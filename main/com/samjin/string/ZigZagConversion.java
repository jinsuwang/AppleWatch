package com.samjin.string;

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];

        for(int i = 0; i < numRows; i++){
            sbs[i] = new StringBuilder();
        }

        int i = 0;
        while(i < s.length()){
            // 从上到下
            int rowIndex = 0;
            while(i < s.length() && rowIndex <= numRows - 1){
                sbs[rowIndex].append(s.charAt(i));
                i++;
                rowIndex++;
            }

            // 从下到上
            // -2才是倒数第二行
            rowIndex -= 2;
            while(i < s.length() && rowIndex >= 1){
                sbs[rowIndex].append(s.charAt(i));
                i++;
                rowIndex--;
            }
        }

        for(int j = 1; j < numRows; j++){
            sbs[0].append(sbs[j].toString());
        }

        return sbs[0].toString();
    }
}
