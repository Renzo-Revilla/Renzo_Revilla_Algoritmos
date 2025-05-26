package Actividad2;


import Actividad1.ExceptionIsEmpty;

public class Test {
 public static void main(String[] args) {
     System.out.println("\n--- Pruebas de la Cola (QueueLink) ---");

     Queue<String> colaStrings = new QueueLink<>();
     System.out.println("Cola de strings inicial: " + colaStrings);
     System.out.println("¿Está vacía?: " + colaStrings.isEmpty());

     colaStrings.enqueue("Uno");
     colaStrings.enqueue("Dos");
     colaStrings.enqueue("Tres");
     System.out.println("Cola de strings después de enqueue: " + colaStrings);
     try {
         System.out.println("Frente de la cola: " + colaStrings.front());
         System.out.println("Final de la cola: " + colaStrings.back());

         String elementoDequeue = colaStrings.dequeue();
         System.out.println("Elemento dequeue: " + elementoDequeue);
         System.out.println("Cola después de dequeue: " + colaStrings);

         System.out.println("Frente de la cola: " + colaStrings.front());
     } catch (ExceptionIsEmpty e) {
         System.out.println(e.getMessage());
     }

     Queue<Double> colaDoubles = new QueueLink<>();
     colaDoubles.enqueue(3.14);
     colaDoubles.enqueue(2.71);
     System.out.println("Cola de doubles: " + colaDoubles);

     try {
         System.out.println("Dequeue de double: " + colaDoubles.dequeue());
         System.out.println("Dequeue de double: " + colaDoubles.dequeue());
         System.out.println("¿Está vacía?: " + colaDoubles.isEmpty());
         System.out.println("Dequeue de cola vacía: " + colaDoubles.dequeue());
     } catch (ExceptionIsEmpty e) {
         System.out.println(e.getMessage());
     }
 }
}