class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        result = []

        def dfs(node):
            if node is None:
                return

            for child in node.children:
                dfs(child)

            result.append(node.val)

        dfs(root)

        return result