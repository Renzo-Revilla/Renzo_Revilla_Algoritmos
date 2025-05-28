package EJERCICIO1;

import Actividad1.ItemDuplicated;
import Actividad1.ExceptionIsEmpty;
public class Test {
    public static void main(String[] args) {
        LinkedBST<Integer> bst1 = new LinkedBST<>();
        LinkedBST<Integer> bst2 = new LinkedBST<>();

        try {
            bst1.insert(50);
            bst1.insert(30);
            bst1.insert(70);
            bst1.insert(20);
            bst1.insert(40);
            bst1.insert(60);
            bst1.insert(80);

            // Intentar insertar duplicado
            System.out.println("Intentando insertar 70 nuevamente (duplicado)");
            bst1.insert(70); // Esto lanzará excepción
        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            bst2.insert(60);
            bst2.insert(40);
            bst2.insert(80);
            bst2.insert(35);
            bst2.insert(45);
            bst2.insert(75);
            bst2.insert(90);
        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Área Árbol 1: " + bst1.areaBST());
        System.out.println("Área Árbol 2: " + bst2.areaBST());
        System.out.println("¿Tienen la misma área? " + (sameArea(bst1, bst2) ? "Sí" : "No"));

        System.out.println("\nDibujo Árbol 1:");
        bst1.drawBST();

        System.out.println("\nVisualización parenthesize Árbol 1:");
        bst1.parenthesize();

        try {
            bst1.destroyNodes();
            System.out.println("\nÁrbol 1 destruido. ¿Está vacío? " + (bst1.isEmpty() ? "Sí" : "No"));
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error al destruir árbol: " + e.getMessage());
        }
    }

    public static boolean sameArea(LinkedBST<?> a, LinkedBST<?> b) {
        return a.areaBST() == b.areaBST();
    }
}
