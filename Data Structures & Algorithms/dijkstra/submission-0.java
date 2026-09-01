

class Solution {
    public Map<Integer, Integer> shortestPath(
            int n, List<List<Integer>> edges, int src) {

        // Adjacency list
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            graph.get(u).add(new int[]{v, w});
        }

        // Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // {distance, vertex}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int currentDist = current[0];
            int u = current[1];

            // Ignore outdated entry
            if (currentDist > dist[u]) {
                continue;
            }

            // Relax all neighbors
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                int newDist = currentDist + weight;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.offer(new int[]{newDist, v});
                }
            }
        }

        // Convert to required Map
        Map<Integer, Integer> result = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                result.put(i, -1);
            } else {
                result.put(i, dist[i]);
            }
        }

        return result;
    }
}