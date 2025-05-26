package Actividad1;

import Actividad1.Stack;
import Actividad1.StackArray;

public class Test {
 public static void main(String[] args) {
     System.out.println("--- Pruebas de la Pila (StackArray) ---");

     Stack<Integer> pilaEnteros = new StackArray<>(5);
     System.out.println("Pila de enteros inicial: " + pilaEnteros);
     System.out.println("¿Está vacía?: " + pilaEnteros.isEmpty());

     pilaEnteros.push(10);
     pilaEnteros.push(20);
     pilaEnteros.push(30);
     System.out.println("Pila de enteros después de push: " + pilaEnteros);
     System.out.println("Tope de la pila: ");
     try {
         System.out.println(pilaEnteros.top());
     } catch (ExceptionIsEmpty e) {
         System.out.println(e.getMessage());
     }

     try {
         int elementoPop = pilaEnteros.pop();
         System.out.println("Elemento pop: " + elementoPop);
         System.out.println("Pila después de pop: " + pilaEnteros);
     } catch (ExceptionIsEmpty e) {
         System.out.println(e.getMessage());
     }

     Stack<String> pilaStrings = new StackArray<>(3);
     pilaStrings.push("Hola");
     pilaStrings.push("Mundo");
     System.out.println("Pila de strings: " + pilaStrings);

     try {
         System.out.println("Pop de string: " + pilaStrings.pop());
         System.out.println("Pop de string: " + pilaStrings.pop());
         System.out.println("¿Está vacía?: " + pilaStrings.isEmpty());
         System.out.println("Pop de string de pila vacía: " + pilaStrings.pop());
     } catch (ExceptionIsEmpty e) {
         System.out.println(e.getMessage());
     }
 }
}