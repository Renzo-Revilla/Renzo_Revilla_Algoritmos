package Actividad1;


public class StackArray<E> implements Stack<E> {
    private E[] array;
    private int tope;

    public StackArray(int n) {
        this.array = (E[]) new Object[n];
        this.tope = -1;
    }

    @Override
    public void push(E x) {
        if (this.tope == this.array.length - 1) {
            // Consider resizing the array if it's full, or throw an exception
            System.out.println("La pila está llena. No se puede agregar el elemento.");
            return;
        }
        this.tope++;
        this.array[this.tope] = x;
    }

    @Override
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía. No se puede hacer pop.");
        }
        E elemento = this.array[this.tope];
        this.tope--;
        return elemento;
    }

    @Override
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía. No se puede ver el tope.");
        }
        return this.array[this.tope];
    }

    @Override
    public boolean isEmpty() {
        return this.tope == -1;
    }

    public boolean isFull() {
        return this.tope == this.array.length - 1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Pila vacía";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = this.tope; i >= 0; i--) {
            sb.append(this.array[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("] (tope)");
        return sb.toString();
    }
}