package com.samjin.design.shortenurl;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeUrl {

    Map<Integer,String> map1 = new HashMap<>();
    Map<String,Integer> map2 = new HashMap<>();

    String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(!map2.containsKey(longUrl)){
            map1.put(map1.size()+1, longUrl);
            map2.put(longUrl, map2.size()+1);
        }
        int n = map2.get(longUrl);

        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int r = n % 62;
            n /= 62;
            sb.insert(0, s.charAt(r));
        }

        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int n = 0;
        for(int i = 0; i < shortUrl.length(); i++){
            n = n * 62 + s.indexOf(shortUrl.charAt(i));
        }
        return map1.get(n);
    }


    // Random number
    public String longToShort(String url){
        // randomly generate one String.
        // check if exists in DB
        // if yes, save it and if no, re-generate string.
        return "";
    }
}
