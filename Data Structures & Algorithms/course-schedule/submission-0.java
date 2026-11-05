class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Calculate indegree
        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];

            adj.get(b).add(a);
            indegree[a]++;
        }

        // Add courses with indegree 0 to queue
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Process courses
        int completed = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            completed++;

            for (int next : adj.get(course)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // If all courses are completed, no cycle exists
        return completed == numCourses;
    }
}