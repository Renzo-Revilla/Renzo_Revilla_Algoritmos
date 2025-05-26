package Ejercicio3;


import Actividad3.PriorityQueue;
import Ejercicio3.PriorityQueueLinked;
import Actividad1.ExceptionIsEmpty;

public class Test {
 public static void main(String[] args) {


     System.out.println("\n--- Pruebas de la Cola de Prioridad (PriorityQueueLinked) ---");

     PriorityQueue<String, Integer> priorityQueueLinked = new PriorityQueueLinked<>(4);
     System.out.println("Cola de prioridad inicial: " + priorityQueueLinked);
     System.out.println("¿Está vacía?: " + priorityQueueLinked.isEmpty());

     priorityQueueLinked.enqueue("Tarea Baja 1", 0);
     priorityQueueLinked.enqueue("Tarea Alta 1", 3);
     priorityQueueLinked.enqueue("Tarea Media 1", 2);
     priorityQueueLinked.enqueue("Tarea Baja 2", 0);
     priorityQueueLinked.enqueue("Tarea Alta 2", 3);
     System.out.println("Cola de prioridad después de encolar: " + priorityQueueLinked);

     try {
         System.out.println("Frente: " + priorityQueueLinked.front());
         System.out.println("Desencolando: " + priorityQueueLinked.dequeue());
         System.out.println("Cola de prioridad después de desencolar: " + priorityQueueLinked);
         System.out.println("Frente: " + priorityQueueLinked.front());
         System.out.println("Final (back): " + priorityQueueLinked.back());
         System.out.println("Desencolando: " + priorityQueueLinked.dequeue());
         System.out.println("Desencolando: " + priorityQueueLinked.dequeue());
         System.out.println("Desencolando: " + priorityQueueLinked.dequeue());
         System.out.println("Desencolando: " + priorityQueueLinked.dequeue());
         System.out.println("¿Está vacía?: " + priorityQueueLinked.isEmpty());
         System.out.println("Intento de desencolar en cola vacía: " + priorityQueueLinked.dequeue());
     } catch (ExceptionIsEmpty e) {
         System.out.println(e.getMessage());
     }
 }
}