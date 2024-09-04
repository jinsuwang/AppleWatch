package com.samjin.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class InMemoryFileSystem {

    Node root;

    public InMemoryFileSystem() {
        root = new Node("/");
    }

    public List<String> ls(String path) {
        Node node = traverse(path);
        List<String> res = new ArrayList<>();
        if (node.isFile){
            res.add(node.name);
        } else{
            for (String child : node.children.keySet()){
                res.add(child);
            }
        }
        Collections.sort(res);
        return res;
    }

    public void mkdir(String path) {
        traverse(path);
    }

    public void addContentToFile(String filePath, String content) {
        Node node = traverse(filePath);
        node.isFile = true;
        node.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        Node node = traverse(filePath);
        return node.content.toString();
    }

    private Node traverse(String filePath){
        String[] path = filePath.split("/");

        Node curr = root;

        for( int i = 1; i < path.length; i++){
            if (!curr.children.containsKey(path[i])){
                Node node = new Node(path[i]);
                curr.children.put(path[i],node);
            }
            curr = curr.children.get(path[i]);
        }
        return curr;
    }

    class Node {
        String name;
        boolean isFile;
        StringBuilder content;
        HashMap<String, Node> children;

        Node(String name){
            this.name = name;
            content = new StringBuilder();
            children = new HashMap<>();
        }
    }
}
