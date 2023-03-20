package tree;

import java.util.LinkedList;

public class TraversalByStack {

    public static void preorderTraversal(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>(); // 定义一个栈用于存放结点

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()){
            if (curr != null){
                System.out.println("去" + curr.val);
                stack.push(curr); // 将当前结点压入栈
                curr = curr.left; // 移向左结点
            }else {
                TreeNode pop = stack.pop();
                System.out.println("回" + pop.val);
                curr = pop.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(4), 2, null), 1, new TreeNode(new TreeNode(5), 3, new TreeNode(6)));
        preorderTraversal(root);
    }

}
