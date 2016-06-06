package test;

import leslie.struct.binarytree.AVLBinaryTree;

public class Test {

    public static void main(String[] args) {
        AVLBinaryTree tree = new AVLBinaryTree();


        tree.insert(6);
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.preOrder();
        tree.postOrder();
        System.out.println("----insert-end----");

        tree.remove(3);
        tree.preOrder();
        tree.postOrder();
        System.out.println("----remove 3----");

        tree.insert(3);
        tree.preOrder();
        tree.postOrder();

    }
}
