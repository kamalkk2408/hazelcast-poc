package org.kishorek.kamal;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        processHazelcast();
    }

    private static void processHazelcast(){
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        IMap<Integer, String> myMap = hz.getMap("myMap");

        for(int i =0; i< 5;i++){
            myMap.set(i, "value = "+i);
        }

        myMap.forEach((key, value) -> {
            System.out.println("Key: "+key + ", Value: "+value);
        });
    }
}