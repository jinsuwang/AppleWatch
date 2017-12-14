package com.samjin.string;

/**
 * Created by sjjin on 9/11/17.
 */
public class AddBinary {


    Boolean extra = false;

    public String addBinary(String a, String b) {

        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;

        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        while(i >=0 && j >= 0){
            char currA = a.charAt(i);
            char currB = b.charAt(j);

            char newChar = createNewChar(currA, currB);
            sb.append(newChar);
            i--; j--;
        }

        while(i >= 0){ sb.append(createNewChar(a.charAt(i), '0'));  i--;}
        while(j >= 0){ sb.append(createNewChar(b.charAt(j), '0')); j--;}

        if(extra) sb.append('1');

        return sb.reverse().toString();
    }

    private char createNewChar(char a, char b){
        if( a == '0' && b == '0' ){
            return extra ? '1' : '0';
        }else if( a == '1' && b == '1'){
            return extra ? '1' : '0';
        }else{
            if(extra){
                return '0';
            }else{
                return '1';
            }
        }
    }
}
