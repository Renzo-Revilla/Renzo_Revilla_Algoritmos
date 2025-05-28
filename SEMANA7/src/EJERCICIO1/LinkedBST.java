package EJERCICIO1;

import java.util.Queue;
import java.util.LinkedList;
import Actividad1.ExceptionIsEmpty;
import Actividad1.ItemDuplicated;

public class LinkedBST<E extends Comparable<E>> {
    private class Node {
        E data;
        Node left, right;
        Node(E data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    public LinkedBST() {
        root = null;
    }

    // ----------------- MÉTODOS BÁSICOS -----------------

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(E item) throws ItemDuplicated {
        root = insertRec(root, item);
    }

    private Node insertRec(Node node, E item) throws ItemDuplicated {
        if (node == null) {
            return new Node(item);
        }
        int cmp = item.compareTo(node.data);
        if (cmp == 0) {
            throw new ItemDuplicated("El elemento ya existe: " + item);
        } else if (cmp < 0) {
            node.left = insertRec(node.left, item);
        } else {
            node.right = insertRec(node.right, item);
        }
        return node;
    }

    public boolean search(E item) {
        return searchRec(root, item);
    }

    private boolean searchRec(Node node, E item) {
        if (node == null) return false;
        int cmp = item.compareTo(node.data);
        if (cmp == 0) return true;
        else if (cmp < 0) return searchRec(node.left, item);
        else return searchRec(node.right, item);
    }

    public E findMin() {
        if (isEmpty()) return null;
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    public E findMax() {
        if (isEmpty()) return null;
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    public int size() {
        return sizeRec(root);
    }

    private int sizeRec(Node node) {
        if (node == null) return 0;
        return 1 + sizeRec(node.left) + sizeRec(node.right);
    }

    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(heightRec(node.left), heightRec(node.right));
    }

    // Eliminar nodo (no solicitado, pero lo tienes en el test)
    public void remove(E item) {
        root = removeRec(root, item);
    }

    private Node removeRec(Node node, E item) {
        if (node == null) return null;
        int cmp = item.compareTo(node.data);
        if (cmp < 0) node.left = removeRec(node.left, item);
        else if (cmp > 0) node.right = removeRec(node.right, item);
        else {
            // nodo con un solo hijo o sin hijo
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;
            // nodo con dos hijos: obtener sucesor (mínimo del subárbol derecho)
            node.data = findMinNode(node.right).data;
            node.right = removeRec(node.right, node.data);
        }
        return node;
    }

    private Node findMinNode(Node node) {
        Node current = node;
        while (current.left != null) current = current.left;
        return current;
    }

    // Recorridos
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }
    private void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.data + " ");
            inorderRec(node.right);
        }
    }

    public void preorder() {
        preorderRec(root);
        System.out.println();
    }
    private void preorderRec(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    public void postorder() {
        postorderRec(root);
        System.out.println();
    }
    private void postorderRec(Node node) {
        if (node != null) {
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.data + " ");
        }
    }

    // ----------------- MÉTODOS SOLICITADOS -----------------

    // a. destroyNodes() - Elimina todos los nodos, lanza ExceptionIsEmpty si árbol vacío
    public void destroyNodes() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("El árbol está vacío");
        root = null; // Simplemente apuntamos a null, el GC liberará
    }

    // b. countAllNodes() - Nodos NO hoja
    public int countAllNodes() {
        return countAllNodesRec(root);
    }

    private int countAllNodesRec(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 0; // hoja
        return 1 + countAllNodesRec(node.left) + countAllNodesRec(node.right);
    }

    // c. countNodes() - Según tu descripción: "que retorne número de nodos no-hojas" (igual a b)
    // Pero parece redundante, en caso fuera contar hojas, aquí te dejo el método para contar hojas:
    public int countNodes() {
        return countLeaves(root);
    }

    private int countLeaves(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    // d. height(x) iterativo - altura del subárbol cuya raíz tiene dato igual a x; si no existe, -1
    public int height(E x) {
        Node subRoot = findNodeIterative(x);
        if (subRoot == null) return -1;
        return heightIterative(subRoot);
    }

    // Busca nodo iterativamente (BFS)
    private Node findNodeIterative(E x) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.data.equals(x)) return current;
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
        return null;
    }

    // Altura iterativa a partir de nodo dado (BFS)
    private int heightIterative(Node node) {
        if (node == null) return -1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int height = -1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            height++;
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        return height;
    }

    // e. amplitude(Nivel) - cantidad máxima de nodos en un nivel dado
    public int amplitude(int nivel) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int currentLevel = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            if (currentLevel == nivel) return levelSize;
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            currentLevel++;
        }
        return 0; // Nivel no existe
    }

    // 02.a areaBST() - área = número de hojas * altura del árbol (iterativo)
    public int areaBST() {
        int hojas = countNodes();
        int altura = height();
        return hojas * altura;
    }

    // 02.b drawBST() - Dibuja el árbol con nodos y aristas
    public void drawBST() {
        drawBSTRec(root, 0);
    }

    private void drawBSTRec(Node node, int level) {
        if (node == null) return;
        // Espacios para sangría
        for (int i = 0; i < level; i++) System.out.print("   ");
        System.out.println(node.data);
        drawBSTRec(node.left, level + 1);
        drawBSTRec(node.right, level + 1);
    }

    // Método parenthesize() - visualización con paréntesis y sangría
    public void parenthesize() {
        parenthesizeRec(root, 0);
    }

    private void parenthesizeRec(Node node, int indent) {
        if (node == null) return;
        for (int i = 0; i < indent; i++) System.out.print("  ");
        System.out.println(node.data);
        if (node.left != null || node.right != null) {
            if (node.left != null) {
                for (int i = 0; i < indent; i++) System.out.print("  ");
                System.out.print("(");
                System.out.println();
                parenthesizeRec(node.left, indent + 1);
                for (int i = 0; i < indent; i++) System.out.print("  ");
                System.out.println(")");
            } else {
                for (int i = 0; i < indent + 1; i++) System.out.print("  ");
                System.out.println("()");
            }
            if (node.right != null) {
                for (int i = 0; i < indent; i++) System.out.print("  ");
                System.out.print("(");
                System.out.println();
                parenthesizeRec(node.right, indent + 1);
                for (int i = 0; i < indent; i++) System.out.print("  ");
                System.out.println(")");
            } else {
                for (int i = 0; i < indent + 1; i++) System.out.print("  ");
                System.out.println("()");
            }
        }
    }
}
