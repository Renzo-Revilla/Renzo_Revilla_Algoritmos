package Actividad3;


import Actividad1.ExceptionIsEmpty;

public interface PriorityQueue<E, N extends Comparable<N>> {
 void enqueue(E x, N pr);
 E dequeue() throws ExceptionIsEmpty;
 E front() throws ExceptionIsEmpty;
 E back() throws ExceptionIsEmpty;
 boolean isEmpty();
}