package Actividad3;


import Actividad3.PriorityQueue;
import Actividad3.PriorityQueueLinkSort;
import Actividad1.ExceptionIsEmpty;

public class Test {
 public static void main(String[] args) {
     System.out.println("\n--- Pruebas de la Cola de Prioridad (PriorityQueueLinkSort) ---");

     PriorityQueue<String, Integer> colaPrioridadStrings = new PriorityQueueLinkSort<>();
     System.out.println("Cola de prioridad de strings inicial: " + colaPrioridadStrings);
     System.out.println("¿Está vacía?: " + colaPrioridadStrings.isEmpty());

     colaPrioridadStrings.enqueue("Tarea C", 3);
     colaPrioridadStrings.enqueue("Tarea A", 1);
     colaPrioridadStrings.enqueue("Tarea B", 2);
     colaPrioridadStrings.enqueue("Tarea D", 1);
     System.out.println("Cola de prioridad después de enqueue: " + colaPrioridadStrings);

     try {
         System.out.println("Frente de la cola de prioridad: " + colaPrioridadStrings.front());
         System.out.println("Final de la cola de prioridad: " + colaPrioridadStrings.back());

         String elementoDequeue = colaPrioridadStrings.dequeue();
         System.out.println("Elemento dequeue: " + elementoDequeue);
         System.out.println("Cola de prioridad después de dequeue: " + colaPrioridadStrings);

         System.out.println("Frente de la cola de prioridad: " + colaPrioridadStrings.front());
     } catch (ExceptionIsEmpty e) {
         System.out.println(e.getMessage());
}

     PriorityQueue<Double, Double> colaPrioridadDoubles = new PriorityQueueLinkSort<>(); }
 }