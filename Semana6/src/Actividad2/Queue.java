package Actividad2;

import Actividad1.ExceptionIsEmpty;

public interface Queue<E> {
 void enqueue(E x);
 E dequeue() throws ExceptionIsEmpty;
 E front() throws ExceptionIsEmpty, ExceptionIsEmpty;
 E back() throws ExceptionIsEmpty;
 boolean isEmpty();
}