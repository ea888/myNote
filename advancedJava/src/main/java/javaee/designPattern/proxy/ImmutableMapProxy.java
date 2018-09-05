package com.ecvlearning.javaee.designPattern.proxy;

import java.util.HashMap;
import java.util.Map;

public class ImmutableMapProxy <K,V> {
    private final Map<K,V> map = new HashMap<>();

    public void put(K key, V value){
        if(map.containsKey(key)){
            return;
        }else{
            map.put(key, value);
        }
    }

    public V get(K key){
        return this.map.get(key);
    }

    /***
     * pay attention to this Keng!
     * @return
     */
    public Map<K,V> getMap(){
        return this.map;
    }
}
