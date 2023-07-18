package tree;

import static tree.RedBlackTree.Color.BLACK;
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

    // 判断节点颜色
    boolean isRed(Node node){
        return node != null && node.color == RED;
    }

    boolean isBlack(Node node){
        return node == null || node.color == BLACK;
    }

    // 右旋、左旋
    private void rightRotate(Node node){
        Node parent = node.parent;
        Node yellow = node.left;
        Node green = yellow.right;
        if (green != null) green.parent = node;

        yellow.right = node;
        yellow.parent = parent;
        node.left = green;
        node.parent = yellow;
        if (parent == null) root = yellow;
        else if (parent.left == node) {
            parent.left = yellow;
        }else parent.right = yellow;
    }

    private void leftRotate(Node node){
        Node parent = node.parent;
        Node yellow = node.right;
        Node green = yellow.left;
        if (green != null) green.parent = node;

        yellow.left = node;
        yellow.parent = parent;
        node.right = green;
        node.parent = yellow;
        if (parent == null) root = yellow;
        else if (parent.right == node) {
            parent.right = yellow;
        }else parent.left = yellow;
    }

}
