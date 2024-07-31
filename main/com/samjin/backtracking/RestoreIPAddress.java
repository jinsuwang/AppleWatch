package com.samjin.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {

        int level = 0;
        int index = 0;
        dfs(s, level, index, "");

        return res;
    }

    public void dfs(String s, int level, int index, String path){
        if ( level == 4 ){
            if (index == s.length()){
                res.add(path);
            }
        }

        for (int i = 1; i <= 3; i++ ){

            if (index + i > s.length() ) break;

            if ( i != 1 && s.charAt(index) == '0') break;

            String tmp = s.substring(index, index+i);

            int val = Integer.valueOf(tmp);

            if (val <= 255){
                dfs(s, level+1, index+i, path + tmp + (level == 3 ? "" : "."));
            }
        }
    }
}
