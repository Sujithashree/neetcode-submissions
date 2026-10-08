class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def validate(node, low, high):
            # An empty node/tree is a valid BST
            if not node:
                return True
            
            # The current node's value must be strictly within (low, high)
            if not (low < node.val < high):
                return False
            
            # Check left and right subtrees with updated bounds
            return (validate(node.left, low, node.val) and 
                    validate(node.right, node.val, high))
        
        return validate(root, float('-inf'), float('inf'))