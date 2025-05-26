package Actividad3;

import actividad_1.ExceptionIsEmpty;

public class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {
 class EntryNode {
     E data;
     N priority;

     EntryNode(E data, N priority) {
         this.data = data;
         this.priority = priority;
     }
 }

 private Node<EntryNode> first;
 private Node<EntryNode> last;

 public PriorityQueueLinkSort() {
     this.first = null;
     this.last = null;
 }

 @Override
 public void enqueue(E x, N pr) {
     EntryNode newEntry = new EntryNode(x, pr);
     Node<EntryNode> newNode = new Node<>(newEntry);

     if (isEmpty() || pr.compareTo(this.first.getData().priority) > 0) {
         newNode.setNext(this.first);
         this.first = newNode;
         if (this.last == null && this.first != null) {
             this.last = this.first;
         }
     } else {
         Node<EntryNode> current = this.first;
         while (current.getNext() != null && pr.compareTo(current.getNext().getData().priority) <= 0) {
             current = current.getNext();
         }
         newNode.setNext(current.getNext());
         current.setNext(newNode);
         if (newNode.getNext() == null) {
             this.last = newNode;
         }
     }
 }

 @Override
 public E dequeue() throws ExceptionIsEmpty {
     if (isEmpty()) {
         throw new ExceptionIsEmpty("La cola de prioridad está vacía. No se puede desencolar.");
     }
     E aux = this.first.getData().data;
     this.first = this.first.getNext();
     if (this.first == null) {
         this.last = null;
     }
     return aux;
 }

 @Override
 public E back() throws ExceptionIsEmpty {
     if (isEmpty()) {
         throw new ExceptionIsEmpty("La cola de prioridad está vacía. No se puede ver el final.");
     }
     return this.last.getData().data;
 }

 @Override
 public E front() throws ExceptionIsEmpty {
     if (isEmpty()) {
         throw new ExceptionIsEmpty("La cola de prioridad está vacía. No se puede ver el frente.");
     }
     return this.first.getData().data;
 }

 @Override
 public boolean isEmpty() {
     return this.first == null;
 }

 @Override
 public String toString() {
     if (isEmpty()) {
         return "Cola de prioridad vacía";
     }
     StringBuilder sb = new StringBuilder();
     sb.append("[");
     Node<EntryNode> current = this.first;
     while (current != null) {
         sb.append("(").append(current.getData().data).append(", ").append(current.getData().priority).append(")");
         if (current.getNext() != null) {
             sb.append(", ");
         }
         current = current.getNext();
     }
     sb.append("] (frente -> final, mayor prioridad al frente)");
     return sb.toString();
 }
}