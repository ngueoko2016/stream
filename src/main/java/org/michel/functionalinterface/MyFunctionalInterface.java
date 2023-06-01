package org.michel.functionalinterface;

@FunctionalInterface
public interface MyFunctionalInterface {
     void m1();

     default  void m2(){
         System.out.println("Test de Methode");
     }
     static void m3(){

     }

}
