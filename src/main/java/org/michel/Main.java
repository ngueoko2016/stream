package org.michel;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String input="ilovejavatechie";
        String[] inputList=input.split("");
       // Map<String,Integer> map= new HashMap<>();

        Map<String, List<String>> map=Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(s->s));

        Map<String, Long> mapLong=Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        List<String> collect = mapLong.entrySet()
                .stream().filter(s -> s.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        /*********First non repeateed element **************/

       String element=Arrays.stream(input.split(""))
                        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                        .entrySet().stream().filter(s->s.getValue()==1)
                        .findFirst()
                        .get().getKey();

/*********First  repeated element **************/

        String repeted=Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(s->s.getValue()>1)
                .findFirst()
                .get().getKey();

        System.out.print("map =");System.out.println(map);
        System.out.print("mapLong =");System.out.println(mapLong);
        System.out.print("collect =");System.out.println(collect);
        System.out.println("element="+element);
        System.out.println("repeted="+repeted);


        int[] numbers={5,9,11,2,8,21,1};
      /*  Arrays.sort(numbers);
        if(numbers.length>1)
        System.out.println("SecondHighest="+numbers[numbers.length-2]);
        else System.out.println("");*/

       Integer second= Arrays.stream(numbers)
               .boxed()
               .sorted(Comparator.reverseOrder())
               .skip(1)
                .findFirst().get();

       // System.out.println("second="+second);


        List<String>  stringNumbers= Arrays.stream(numbers).boxed().map(Object::toString).filter(s->s.startsWith("2")).collect(Collectors.toList());

        System.out.print("stringNumbers =");System.out.println(stringNumbers);


        /********** Longest string ofr a given array ******************/

        String[] inputString={"java","techie","springboot","microservices"};
        String longest=Arrays.stream(inputString).reduce("",
                (a,b)-> a.length()>b.length()?a:b);
      //  System.out.println("longest="+longest);

       // String[] vowels={"e","i","a","u","o","y"};
        String vowels="eiauoy";
        String separator="eb";
        String inputStringToEncode="aae";
        String[] inputStringToEncodeTale=inputStringToEncode.split("");
        String encode=Arrays.stream(inputStringToEncodeTale).reduce("",
                (a,b)->  vowels.contains(b)&&! vowels.contains(a.length()-1>=0?
                        a.substring(a.length()-1):"c")?a+separator+b:a+b);

       // String.join()  inputStringToEncodeTale
        Arrays.stream(inputStringToEncodeTale).forEach(System.out::println);
        System.out.println("encode="+encode);

        List<String> names=Arrays.asList("william", "jones", "aaron", "seppe", "frank", "gilliam");

        Map<String,Integer> mapLetterCounts= names.stream()
                .collect(Collectors.toMap(s->s,s->s.length()));
       Integer count= names.stream()
                .collect(Collectors.toMap(s->s,s->s.length()))
                .entrySet().stream().filter(s-> {
                   return s.getValue() > 5;
               }).map(s->s.getValue())
               .reduce(0,(a,b)->a+b);

        System.out.println("mapLetterCounts= "+count+" : "+mapLetterCounts);
    }

    public static List<String> transform(List<List<String>> collection) {
        List<String> newCollection = new ArrayList<>();
	/*for (List<String> subCollection : collection) {
		for (String value : subCollection) {
			newCollection.add(value);
		}
	}*/

        return collection.stream().flatMap(x->x.stream()).collect(Collectors.toList());

    }

    public static String getString(List<Integer> list) {
        return list.stream().map(x->x%2==0?"e"+x:"o"+x).collect(joining(","));
    }



}
