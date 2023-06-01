package org.michel.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailFastMap {
    public static void main(String...args){

        Map<Integer, String> map = new ConcurrentHashMap<>();
                //new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");

        Iterator iterator= map.entrySet().iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
            map.put(3,"three");
        }

    }

}
