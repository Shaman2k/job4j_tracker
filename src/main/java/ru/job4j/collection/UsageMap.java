package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("admin@site.com", "Ivanov");
        map.put("user1@site.com", "Petrov");
        map.put("user2@site.com", "Vasiliev");
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
        System.out.println();
        map.put("admin@site.com", "Sokolov");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " " + value);
        }
    }
}
