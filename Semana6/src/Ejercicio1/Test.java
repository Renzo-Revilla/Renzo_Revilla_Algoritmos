package Ejercicio1;


import Actividad1.Stack;
import Ejercicio1.StackLink;
import Actividad1.ExceptionIsEmpty;

public class Test {
 public static void main(String[] args) {


     System.out.println("\n--- Pruebas de la Pila (StackLink) ---");

     Stack<Character> pilaChars = new StackLink<>();
     System.out.println("Pila de caracteres inicial: " + pilaChars);
     System.out.println("¿Está vacía?: " + pilaChars.isEmpty());

     pilaChars.push('a');
     pilaChars.push('b');
     pilaChars.push('c');
     System.out.println("Pila de caracteres después de push: " + pilaChars);
     try {
         System.out.println("Tope de la pila: " + pilaChars.top());
         System.out.println("Pop: " + pilaChars.pop());
         System.out.println("Pila después de pop: " + pilaChars);
         System.out.println("Pop: " + pilaChars.pop());
         System.out.println("Pop: " + pilaChars.pop());
         System.out.println("¿Está vacía?: " + pilaChars.isEmpty());
         System.out.println("Intento de pop en pila vacía: " + pilaChars.pop());
     } catch (ExceptionIsEmpty e) {
         System.out.println(e.getMessage());
     }
 }
}