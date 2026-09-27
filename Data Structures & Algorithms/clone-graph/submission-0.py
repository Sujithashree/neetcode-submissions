class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node is None:
            return None

        # original node -> cloned node
        oldToNew = {}

        def dfs(node):
            # Already cloned
            if node in oldToNew:
                return oldToNew[node]

            # Create clone
            copy = Node(node.val)
            oldToNew[node] = copy

            # Clone all neighbors
            for neighbor in node.neighbors:
                copy.neighbors.append(dfs(neighbor))

            return copy

        return dfs(node)