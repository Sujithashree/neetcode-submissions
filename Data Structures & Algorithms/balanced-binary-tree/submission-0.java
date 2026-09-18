class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        // Empty tree is balanced
        if (node == null) {
            return 0;
        }

        int left = height(node.left);

        // Left subtree is unbalanced
        if (left == -1) {
            return -1;
        }

        int right = height(node.right);

        // Right subtree is unbalanced
        if (right == -1) {
            return -1;
        }

        // Current node is unbalanced
        if (Math.abs(left - right) > 1) {
            return -1;
        }

        // Return height
        return 1 + Math.max(left, right);
    }
}