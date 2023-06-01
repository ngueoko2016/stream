package org.michel.collection;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Student implements Comparable<Student>{
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

  /*  @Override
    public int hashCode() {
        return Objects.hash(id,name);
    }
*/
  /*  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id && name.equals(student.name);
    }*/

    @Override
    public int compareTo(Student s) {
        return id-s.id;
    }
    public static  void main(String[] varArgs){
        CustomArrayList list= new CustomArrayList();
        Student s1=new Student(101, "NAMA");
        Student s2=new Student(109, "TOTO");
        Student s3=new Student(105, "SACHA");
        Student s4=new Student(101, "MAMA_2");

        list.add(s1); list.add(s2); list.add(s3);list.add(s4);
        Map<Student,Integer> mapStudent=new TreeMap<>();

        mapStudent.put(s1,1);
        mapStudent.put(s2,2);
        mapStudent.put(s3,3);
        mapStudent.put(s4,4);

        mapStudent.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Student::getName).reversed()))
                .forEach(System.out::println);

        System.out.println("mapStudent= "+mapStudent);


        /***********************************************/
        //list.add(null);
        System.out.println(list);
       // Collections.sort(list);

        Comparator<Student> comparator= (s12,s22)->
                                      (s12.id-s22.id)==0? s12.name.compareTo(s22.name):
                                              s12.id-s22.id;

        BiFunction<Student,Student,Integer> function= (s12, s22)->
                (s12.id-s22.id)==0? s12.name.compareTo(s22.name):
                        s12.id-s22.id;

       // Collections.sort(list, comparator);
        Collections.sort(list, Comparator.comparing(Student::getId).thenComparing(Student::getName));
        System.out.println("list="+list);
  /*************************************************************/

        Student s34=new Student(101, "MAMA_2");

        Optional<String> optionalStudent=Optional.ofNullable(s34.getName());

        System.out.println(optionalStudent.map(String::toUpperCase));

    }

}
