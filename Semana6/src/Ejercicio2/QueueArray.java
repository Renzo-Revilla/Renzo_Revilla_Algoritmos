package Ejercicio2;

import Actividad2.Queue;
import Actividad1.ExceptionIsEmpty;

public class QueueArray<E> implements Queue<E> {
 private E[] array;
 private int first;
 private int last;
 private int capacity;
 private int size;

 public QueueArray(int capacity) {
     this.capacity = capacity;
     this.array = (E[]) new Object[capacity];
     this.first = 0;
     this.last = -1;
     this.size = 0;
 }

 @Override
 public void enqueue(E x) {
     if (size == capacity) {
         System.out.println("La cola está llena. No se puede encolar.");
         return;
     }
     this.last = (this.last + 1) % this.capacity;
     this.array[this.last] = x;
     this.size++;
 }

 @Override
 public E dequeue() throws ExceptionIsEmpty {
     if (isEmpty()) {
         throw new ExceptionIsEmpty("La cola está vacía. No se puede desencolar.");
     }
     E data = this.array[this.first];
     this.array[this.first] = null; // Para ayudar al garbage collector
     this.first = (this.first + 1) % this.capacity;
     this.size--;
     return data;
 }

 @Override
 public E front() throws ExceptionIsEmpty {
     if (isEmpty()) {
         throw new ExceptionIsEmpty("La cola está vacía. No se puede ver el frente.");
     }
     return this.array[this.first];
 }

 @Override
 public E back() throws ExceptionIsEmpty {
     if (isEmpty()) {
         throw new ExceptionIsEmpty("La cola está vacía. No se puede ver el final.");
     }
     return this.array[this.last];
 }

 @Override
 public boolean isEmpty() {
     return this.size == 0;
 }

 @Override
 public String toString() {
     if (isEmpty()) {
         return "Cola vacía";
     }
     StringBuilder sb = new StringBuilder();
     sb.append("[");
     for (int i = 0; i < this.size; i++) {
         sb.append(this.array[(this.first + i) % this.capacity]);
         if (i < this.size - 1) {
             sb.append(", ");
         }
     }
     sb.append("] (frente -> final)");
     return sb.toString();
 }
}