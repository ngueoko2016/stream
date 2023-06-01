package org.michel.stream;

import org.michel.collection.CustomArrayList;
import org.michel.collection.Student;

import java.util.Collections;
import java.util.Comparator;
import java.util.function.BiFunction;

public class SortListDemo {
    public static  void main(String[] varArgs){

        CustomArrayList list= new CustomArrayList();
        Student s1=new Student(101, "NAMA");
        Student s2=new Student(109, "TOTO");
        Student s3=new Student(105, "SACHA");
        Student s4=new Student(101, "MANA");
        list.add(s1); list.add(s2); list.add(s3);list.add(s4);
        //list.add(null);
        System.out.println(list);
        // Collections.sort(list);  // Usage of Camparable

        Comparator<Student> comparator= (s12, s22)->
                (s12.getId()-s22.getId())==0? s12.getName().compareTo(s22.getName()):
                        s12.getId()-s22.getId();

       /* BiFunction<Student,Student,Integer> function= (s12, s22)->
                (s12.getId()-s22.getId())==0? s12.getName().compareTo(s22.getName()):
                        s12.getId()-s22.getId();*/

        // Collections.sort(list, comparator);   // Use of Lambda expression with @Functional Programming

        // Use Define comparator;
        Collections.sort(list, Comparator.comparing(Student::getId).thenComparing(Student::getName));

        System.out.println(list);
    }
}
