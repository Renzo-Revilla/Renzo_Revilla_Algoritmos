package Actividad1;

public class Test {
    public static void main(String[] args) {
        LinkedBST<Integer> bst1 = new LinkedBST<>();
        LinkedBST<Integer> bst2 = new LinkedBST<>();

        System.out.println("==== Inserción de elementos en Árbol 1 ====");
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
            bst1.insert(70); // Esto lanzará una excepción
        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n==== Inserción de elementos en Árbol 2 ====");
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

        System.out.println("\n==== Recorridos de Árbol 1 ====");
        System.out.print("Inorder: ");
        bst1.inorder();

        System.out.print("Preorder: ");
        bst1.preorder();

        System.out.print("Postorder: ");
        bst1.postorder();

        System.out.println("\n==== Información de Árbol 1 ====");
        System.out.println("Mínimo: " + bst1.findMin());
        System.out.println("Máximo: " + bst1.findMax());
        System.out.println("Buscar 40: " + bst1.search(40));
        System.out.println("Tamaño: " + bst1.size());
        System.out.println("Altura: " + bst1.height());

        System.out.println("\n==== Eliminando un valor de Árbol 1 ====");
        System.out.println("Eliminando el valor 70");
        bst1.remove(70);
        System.out.print("Inorder después de eliminar 70: ");
        bst1.inorder();

        System.out.println("\n==== Métodos adicionales en Árbol 1 ====");
        System.out.println("Nodos no hoja: " + bst1.countAllNodes());
        System.out.println("Nodos hoja: " + bst1.countNodes());
        System.out.println("Altura del subárbol con raíz 30: " + bst1.height(30));
        System.out.println("Amplitud del nivel 2: " + bst1.amplitude(2));
        System.out.println("Área del Árbol 1: " + bst1.areaBST());
        System.out.println("Área del Árbol 2: " + bst2.areaBST());

        boolean igual = sameArea(bst1, bst2);
        System.out.println("¿Tienen la misma área? " + (igual ? "Sí" : "No"));

        System.out.println("\n==== Dibujo de los árboles ====");
        System.out.println("Árbol 1:");
        bst1.drawBST();

        System.out.println("Árbol 2:");
        bst2.drawBST();

        System.out.println("\n==== Destruyendo Árbol 1 ====");
        try {
            bst1.destroyNodes();
            System.out.println("Árbol 1 destruido correctamente.");
            System.out.println("¿Está vacío Árbol 1? " + (bst1.isEmpty() ? "Sí" : "No"));
        } catch (ExceptionIsEmpty e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }
    

    // Método para comparar si dos árboles tienen la misma área
    public static boolean sameArea(LinkedBST<?> a, LinkedBST<?> b) {
        return a.areaBST() == b.areaBST();
    }
}
