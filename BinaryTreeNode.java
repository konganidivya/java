
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    TreeNode root;

    public int countNonLeafNodes(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return 0; 
        return 1 + countNonLeafNodes(node.left) + countNonLeafNodes(node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.right.left = new TreeNode(5);
        tree.root.right.right = new TreeNode(6);

        int count = tree.countNonLeafNodes(tree.root);
        System.out.println("Number of non-leaf nodes: " + count);
    }
}
