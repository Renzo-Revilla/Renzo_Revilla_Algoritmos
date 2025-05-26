package Ejercicio2;

import Actividad2.Queue;
import Ejercicio2.QueueArray;
import Actividad1.ExceptionIsEmpty;

public class Test {
 public static void main(String[] args) {
     // ... (Pruebas de Actividad 1 aquí) ...

     System.out.println("\n--- Pruebas de la Cola (QueueArray) ---");

     Queue<Integer> colaEnterosArray = new QueueArray<>(4);
     System.out.println("Cola de enteros inicial: " + colaEnterosArray);
     System.out.println("¿Está vacía?: " + colaEnterosArray.isEmpty());

     colaEnterosArray.enqueue(1);
     colaEnterosArray.enqueue(2);
     colaEnterosArray.enqueue(3);
     System.out.println("Cola después de encolar: " + colaEnterosArray);
     try {
         System.out.println("Frente: " + colaEnterosArray.front());
         System.out.println("Final: " + colaEnterosArray.back());
         System.out.println("Desencolando: " + colaEnterosArray.dequeue());
         System.out.println("Cola después de desencolar: " + colaEnterosArray);
         colaEnterosArray.enqueue(4);
         System.out.println("Cola después de encolar: " + colaEnterosArray);
         System.out.println("Desencolando: " + colaEnterosArray.dequeue());
         System.out.println("Desencolando: " + colaEnterosArray.dequeue());
         System.out.println("Desencolando: " + colaEnterosArray.dequeue());
         System.out.println("¿Está vacía?: " + colaEnterosArray.isEmpty());
         System.out.println("Intento de desencolar en cola vacía: " + colaEnterosArray.dequeue());
     } catch (ExceptionIsEmpty e) {
         System.out.println(e.getMessage());
     }
 }
}