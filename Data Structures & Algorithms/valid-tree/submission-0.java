

class Solution {
public boolean validTree(int n, int[][] edges) {

    // A tree must have exactly n-1 edges
    if (edges.length != n - 1) {
        return false;
    }
    // Build adjacency list
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        adj.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    boolean[] visited = new boolean[n];
    dfs(0, adj, visited);
    // Check whether all nodes are visited
    for (boolean v : visited) {
        if (!v) {
            return false;
        }
    }
    return true;
}
private void dfs(int node, List<List<Integer>> adj,
                 boolean[] visited) {
    visited[node] = true;
    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            dfs(neighbor, adj, visited);
        }
    }
}

}