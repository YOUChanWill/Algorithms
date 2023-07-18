package tree;

import static tree.RedBlackTree.Color.RED;

public class RedBlackTree {

    enum Color {RED,BLACK;} // 红黑节点

    private Node root; // 根节点

    private static class Node{
        int key;
        Object value;
        Node left;
        Node right;
        Node parent; // 父节点
        Color color = RED; //新节点默认为红色

        // 判断是否为左孩子
        boolean isLeftChild(){
            return parent != null && parent.left == this;
        }

        // 叔叔节点
        Node uncle(){
            if (parent == null || parent.parent == null) return null;
            if (parent.isLeftChild()) return parent.parent.right;
            else return parent.parent.left;
        }

        // 兄弟节点
        Node sibling(){
            if (parent == null) return null;
            if (this.isLeftChild()) return parent.right;
            else return parent.left;
        }
    }


}
