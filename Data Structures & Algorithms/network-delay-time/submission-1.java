class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph[u].add(new int[]{v, w});
        }

        // dist[i] = shortest time from k to node i
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // {time, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int time = current[0];
            int node = current[1];

            // Ignore outdated entry
            if (time > dist[node]) {
                continue;
            }

            for (int[] edge : graph[node]) {
                int nextNode = edge[0];
                int weight = edge[1];

                int newTime = time + weight;

                if (newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;
                    pq.offer(new int[]{newTime, nextNode});
                }
            }
        }

        // Find the time when the last node receives the signal
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}