package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//
class Node {
    char data;
    Node left;
    Node right;

    Node(char data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    static Node root;

    // 使用先序遍历构建二叉树
    static Node buildTree(Scanner scanner) {
        System.out.print("请输入节点值（输入'.'表示空节点）：");
        String input = scanner.next();
        if (input.equals(".")) {
            return null;
        }
        Node newNode = new Node(input.charAt(0));
        System.out.println("输入节点 " + newNode.data + " 的左子节点：");
        newNode.left = buildTree(scanner);
        System.out.println("输入节点 " + newNode.data + " 的右子节点：");
        newNode.right = buildTree(scanner);
        return newNode;
    }

    // 层次遍历二叉树
    static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    // 判断是否为完全二叉树
    static boolean isCompleteBinaryTree(Node root) {
        if (root == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false; // 用于标记是否遇到空节点

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            // 如果已经遇到空节点，且当前节点不为空，说明不是完全二叉树
            if (flag && node != null) {
                return false;
            }

            if (node == null) {
                flag = true; // 标记遇到空节点
                continue;
            }

            queue.add(node.left);
            queue.add(node.right);
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        root = buildTree(scanner);
        System.out.print("层次遍历结果：");
        levelOrderTraversal(root);

        boolean isComplete = isCompleteBinaryTree(root);
        System.out.println("\n是否为完全二叉树：" + isComplete);
    }
}
