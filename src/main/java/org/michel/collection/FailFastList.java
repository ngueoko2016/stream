package org.michel.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastList {


   public static void main(String[] args) {

       List list= new CopyOnWriteArrayList();
               //new ArrayList<>();
       list.add("a");
       list.add("b");
       Iterator elements= list.iterator();

       while(elements.hasNext()){
           Object element=elements.next();
           System.out.println((String)element);
          list.add("c");
       }
       System.out.println(" List Length ="+list.size());
   }

}
