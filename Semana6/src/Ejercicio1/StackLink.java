package Ejercicio1;


import Actividad1.Stack;
import Actividad2.Node;
import Actividad1.ExceptionIsEmpty;

public class StackLink<E> implements Stack<E> {
 private Node<E> top;

 public StackLink() {
     this.top = null;
 }

 @Override
 public void push(E x) {
     Node<E> newNode = new Node<>(x);
     newNode.setNext(this.top);
     this.top = newNode;
 }

 @Override
 public E pop() throws ExceptionIsEmpty {
     if (isEmpty()) {
         throw new ExceptionIsEmpty("La pila está vacía. No se puede hacer pop.");
     }
     E data = this.top.getData();
     this.top = this.top.getNext();
     return data;
 }

 @Override
 public E top() throws ExceptionIsEmpty {
     if (isEmpty()) {
         throw new ExceptionIsEmpty("La pila está vacía. No se puede ver el tope.");
     }
     return this.top.getData();
 }

 @Override
 public boolean isEmpty() {
     return this.top == null;
 }

 @Override
 public String toString() {
     if (isEmpty()) {
         return "Pila vacía";
     }
     StringBuilder sb = new StringBuilder();
     sb.append("[");
     Node<E> current = this.top;
     while (current != null) {
         sb.append(current.getData());
         if (current.getNext() != null) {
             sb.append(", ");
         }
         current = current.getNext();
     }
     sb.append("] (tope)");
     return sb.toString();
 }
}