package com.samjin.array;

public class JudgeRouteCircle {

    public boolean judgeCircle(String moves) {
        if(moves == null || moves.length() == 0) return true;
        int[] lr = new int[]{0,0};

        for(int i = 0; i < moves.length(); i++){
            char ins = moves.charAt(i);
            if(ins == 'D'){
                lr[0]--;
            }else if(ins == 'U'){
                lr[0]++;
            }else if(ins == 'L'){
                lr[1]--;
            }else if(ins == 'R'){
                lr[1]++;
            }
        }
        return lr[0] == 0 && lr[1] == 0;
    }

}
