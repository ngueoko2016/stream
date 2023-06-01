package org.michel.stream;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SortMapDemo {

    public static void main(String... args) {

        Map<Integer, String> map = new HashMap<>();
        //new HashMap<>();
        map.put(3, "three");
        map.put(1, "one");
        map.put(4, "four");
        map.put(2, "two");
        map.put(10, "ten");
        map.put(8, "eight");

       /* List<Map.Entry<Integer, String>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (map1, map2) -> map1.getValue().compareTo( map2.getValue()));
         System.out.println("Map =" + entries);*/

        Map<String,Integer> mapString= map.entrySet().stream()
               /* .sorted((map1, map2) -> map1.getValue().compareTo( map2.getValue()))*/
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(s->s.getValue(),a->a.getKey()));
                //.forEach(System.out::println);
        System.out.println("Map =" + map);
        System.out.println("MapString =" + mapString);


    }
}
