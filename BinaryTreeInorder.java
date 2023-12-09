import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorder {
    // L->Rt->R
    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static void inorderRecursive(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        inorderRecursive(root.left, nodes);
        nodes.add(root.val);
        inorderRecursive(root.right, nodes);
    }

    static void inorderIterative(TreeNode root, List<Integer> res) {
        Stack<TreeNode> treeStack = new Stack<>();
        while (root != null || treeStack.size() > 0) {
            while (root != null) {
                treeStack.push(root);
                root = root.left;
            }
            root = treeStack.pop();
            res.add(root.val);

            root = root.right;
        }
    }

    static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();

        // while (root != null) {
        // root = root.left != null ? root.left : root.right != null ? root.right :
        // null;
        // nodes.add(root.val);
        // }
        // inorderRecursive(root, nodes);
        inorderIterative(root, nodes);
        return nodes;
    }

    public static void main(String[] args) {
        // TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3),
        // null));
        TreeNode root = null;
        System.out.println(inorderTraversal(root));
    }
}
