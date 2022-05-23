package com.example.lab1kpp;
import java.util.HashMap;

public class Hash {
    private HashMap<Double, Integer> hash_map = new HashMap<>();

    public boolean isContain(String key) {

        return this.hash_map.containsKey(key);

    }
    public void addToMap(double key, Integer result) {

        hash_map.put(key, result);

    }
    public int getValueByKey(String key) {

        return this.hash_map.get(key);

    }

}
