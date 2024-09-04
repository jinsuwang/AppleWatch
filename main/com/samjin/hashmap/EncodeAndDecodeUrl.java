package com.samjin.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeAndDecodeUrl {
    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    HashMap<String, String> map = new HashMap<>();
    Random rand = new Random();
    String key = getRand();

    public String getRand() {
        StringBuilder sb = new StringBuilder();
        // 长度固定为6
        for (int i = 0; i < 6; i++) {
            // 随机字符对应
            sb.append(alphabet.charAt(rand.nextInt(62)));
        }

        return sb.toString();
    }

    public String encode(String longUrl) {
        while (map.containsKey(key)) {
            key = getRand();
        }

        map.put(key, longUrl);

        return "http://tinyurl.com/" + key;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}
