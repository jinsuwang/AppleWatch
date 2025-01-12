package com.samjin.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MagicDictionary {

    class Node {
        char c;
        int index;

        Node(char c, int index){
            this.c = c;
            this.index = index;
        }
    }

    Map<String, List<Node>> map;
    public MagicDictionary() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dict) {
        for (String word : dict) {
            for (int i = 0; i < word.length(); i++) {
                String key = word.substring(0, i) + word.substring(i + 1);
                Node node = new Node(word.charAt(i), i);

                if(!map.containsKey(key)){
                    map.put(key, new ArrayList<>());
                }

                map.get(key).add(node);
            }
        }
    }

    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            String key = word.substring(0, i) + word.substring(i + 1);

            if (map.containsKey(key)) {
                for (Node node : map.get(key)) {
                    if (node.index == i && node.c != word.charAt(i)) return true;
                }
            }
        }

        return false;
    }

}
