package com.samjin.unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class AccountMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        UnionFind uf = new UnionFind();

        Map<String, String> emailToName = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0); // 第一个元素是用户名
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name); // 将邮箱与用户名关联
                uf.union(account.get(1), email); // 将同一个账户中的所有邮箱连通
            }
        }

        Map<String, List<String>> rootToEmails = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String rootEmail = uf.find(email); // 找到邮箱的根
            rootToEmails.putIfAbsent(rootEmail, new ArrayList<>());
            rootToEmails.get(rootEmail).add(email);
        }

        // 构造结果
        List<List<String>> result = new ArrayList<>();
        for (String rootEmail : rootToEmails.keySet()) {
            List<String> emails = rootToEmails.get(rootEmail);
            Collections.sort(emails); // 邮箱排序
            emails.add(0, emailToName.get(rootEmail)); // 在邮箱列表的开头添加用户名
            result.add(emails);
        }

        return result;
    }
}
