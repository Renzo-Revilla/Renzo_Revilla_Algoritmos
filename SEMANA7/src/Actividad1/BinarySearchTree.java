package Actividad1;


public interface BinarySearchTree<E extends Comparable<E>> {
    boolean isEmpty();
    int size();
    int height();
    void insert(E element) throws ItemDuplicated;
    boolean contains(E element);
    E search(E element);
    E findMin();
    E findMax();
    void remove(E element);
    void inorder();
    void preorder();
    void postorder();
    void destroy();
}

