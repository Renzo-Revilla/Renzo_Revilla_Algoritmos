package Actividad1;

import java.util.LinkedList;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    private class Node {
        E data;
        Node left, right;

        Node(E data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;

    public LinkedBST() {
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    @Override
    public void insert(E element) throws ItemDuplicated {
        root = insert(root, element);
    }

    private Node insert(Node node, E element) throws ItemDuplicated {
        if (node == null) return new Node(element);
        if (element.compareTo(node.data) < 0) {
            node.left = insert(node.left, element);
        } else if (element.compareTo(node.data) > 0) {
            node.right = insert(node.right, element);
        } else {
            throw new ItemDuplicated("Elemento duplicado: " + element);
        }
        return node;
    }

    @Override
    public boolean contains(E element) {
        return search(element) != null;
    }

    @Override
    public E search(E element) {
        return search(root, element);
    }

    private E search(Node node, E element) {
        if (node == null) return null;
        if (element.compareTo(node.data) == 0) return node.data;
        if (element.compareTo(node.data) < 0) return search(node.left, element);
        return search(node.right, element);
    }

    @Override
    public E findMin() {
        if (isEmpty()) return null;
        Node current = root;
        while (current.left != null) current = current.left;
        return current.data;
    }

    @Override
    public E findMax() {
        if (isEmpty()) return null;
        Node current = root;
        while (current.right != null) current = current.right;
        return current.data;
    }

    @Override
    public void remove(E element) {
        root = remove(root, element);
    }

    private Node remove(Node node, E element) {
        if (node == null) return null;
        if (element.compareTo(node.data) < 0) {
            node.left = remove(node.left, element);
        } else if (element.compareTo(node.data) > 0) {
            node.right = remove(node.right, element);
        } else {
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;
            node.data = findMin(node.right);
            node.right = remove(node.right, node.data);
        }
        return node;
    }

    private E findMin(Node node) {
        while (node.left != null) node = node.left;
        return node.data;
    }

    // ===================== RECORRIDOS =====================
    @Override
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    @Override
    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    @Override
    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    // ===================== UTILIDADES =====================
    @Override
    public void destroy() {
        root = null;
    }

    public void destroyNodes() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El árbol está vacío, no se puede destruir.");
        }
        root = null;
    }

    public int countAllNodes() {
        return countAllNodes(root);
    }

    private int countAllNodes(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 0;
        return 1 + countAllNodes(node.left) + countAllNodes(node.right);
    }

    public int countNodes() {
        return countLeafNodes(root);
    }

    private int countLeafNodes(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }

    public int height(E x) {
        Node target = root;
        while (target != null) {
            int cmp = x.compareTo(target.data);
            if (cmp == 0) break;
            else if (cmp < 0) target = target.left;
            else target = target.right;
        }

        if (target == null) return -1;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(target);
        int height = -1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            height++;
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }

        return height;
    }

    public int amplitude(int level) {
        if (root == null || level < 0) return 0;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            if (currentLevel == level) return levelSize;

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            currentLevel++;
        }

        return 0;
    }

    public int areaBST() {
        if (root == null) return 0;

        int hojas = 0;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left == null && current.right == null) {
                hojas++;
            }
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        int altura = height();
        return hojas * altura;
    }

    public void drawBST() {
        drawBST(root, 0);
    }

    private void drawBST(Node node, int nivel) {
        if (node == null) return;

        drawBST(node.right, nivel + 1);

        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }
        System.out.println(node.data);

        drawBST(node.left, nivel + 1);
    }
}
