package org.michel.stream;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MapReduceDemo {

    public static void main(String[] args){

        List<Integer> numbers= Arrays.asList(7,2,12,3,9);
        List<String> inputs= Arrays.asList("test","ert","bon","egal","glorieux");

        int sum1=numbers.stream().mapToInt(i->i).reduce(0,(a,b)->a+b);
        System.out.println("Sum 1="+sum1);
        Optional<Integer>  reduceSum=numbers.stream().reduce(Integer::sum);
        Optional<Integer>  min=numbers.stream().max(Comparator.naturalOrder());
        System.out.println("min ="+min);



        System.out.println("longest 1 ="+inputs.stream().reduce("",(a,b)->a.length()-b.length()>0?
                        a:b));

     Map.Entry<String, Integer> longest=  inputs.stream().collect(Collectors.toMap(s->s, s->s.length())).
                entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue)).findFirst().get();
        System.out.println("longest 2 ="+longest);

    }
}
