package com.samjin.array;

public class PushDominoes {

    public String pushDominoes(String dominoes) {

        int n = dominoes.length();
        char[] result = dominoes.toCharArray();
        int[] forces = new int[n];

        int force = 0;

        for(int i = 0; i < n; i++){
            if(result[i] == 'R'){
                force = n;
            }else if (result[i] == 'L'){
                force = 0;
            }else {
                force = Math.max(force - 1, 0);
            }
            forces[i] = force;
        }

        force = 0;
        // 从右到左遍历，如果遇到L，就给力，之后逐步减弱；遇到R，力归零。
        for (int i = n - 1; i >= 0; i--) {
            if (result[i] == 'L') {
                force = n; // 设置一个较大的初始力
            } else if (result[i] == 'R') {
                force = 0; // R的右侧不会受到左边L的影响，所以力归零
            } else {
                force = Math.max(force - 1, 0); // 力逐渐减弱，直到归零
            }
            forces[i] -= force; // 这里减去右边的力，因为左侧力已经加在forces[i]上
        }

        for (int i = 0; i < n; i++) {
            if (forces[i] > 0) {
                result[i] = 'R';
            } else if (forces[i] < 0) {
                result[i] = 'L';
            } else {
                result[i] = '.';
            }
        }

        return new String(result);
    }
}
