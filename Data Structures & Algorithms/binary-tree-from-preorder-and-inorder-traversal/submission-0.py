# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # Map values to their indices in inorder for O(1) lookups
        inorder_map = {val: idx for idx, val in enumerate(inorder)}
        pre_idx = 0

        def helper(left: int, right: int) -> Optional[TreeNode]:
            nonlocal pre_idx
            
            # Base case: no elements to construct subtree
            if left > right:
                return None

            # The current root is preorder[pre_idx]
            root_val = preorder[pre_idx]
            pre_idx += 1
            root = TreeNode(root_val)

            # Split inorder into left and right subtrees
            mid = inorder_map[root_val]

            # Recurse: build left subtree first, then right subtree
            root.left = helper(left, mid - 1)
            root.right = helper(mid + 1, right)

            return root

        return helper(0, len(inorder) - 1)