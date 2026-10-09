# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        max_sum = float('-inf')

        def dfs(node: Optional[TreeNode]) -> int:
            nonlocal max_sum
            if not node:
                return 0

            # Compute maximum branch sums from left and right children.
            # If a branch yields a negative sum, ignore it by clamping to 0.
            left_gain = max(dfs(node.left), 0)
            right_gain = max(dfs(node.right), 0)

            # Potential max path with the current node as the highest turning point (root of the path)
            current_path_sum = node.val + left_gain + right_gain
            max_sum = max(max_sum, current_path_sum)

            # Return the maximum single-branch path sum that can be extended by the parent
            return node.val + max(left_gain, right_gain)

        dfs(root)
        return max_sum