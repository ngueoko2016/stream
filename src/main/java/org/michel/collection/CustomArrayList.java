package org.michel.collection;

import java.util.ArrayList;


public class CustomArrayList extends ArrayList {

    @Override
    public boolean add(Object o) {

        if(this.contains(o)) {
            return true;
        }
        return super.add(o);
    }

    public static void main(String...args){

        CustomArrayList list= new CustomArrayList();
        Student s=new Student(2, "NAMA");

        list.add(1);
        list.add("Toto");
        list.add(s);
        System.out.println(list);


    }
}
