import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        // If array has only one element
        if (n == 1) {
            return 0;
        }

        // Store indices of same values
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        // BFS setup
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int idx = q.poll();

                // Reached last index
                if (idx == n - 1) {
                    return steps;
                }

                // Move to idx + 1
                if (idx + 1 < n && !visited[idx + 1]) {
                    visited[idx + 1] = true;
                    q.offer(idx + 1);
                }

                // Move to idx - 1
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true;
                    q.offer(idx - 1);
                }

                // Jump to same value indices
                if (map.containsKey(arr[idx])) {
                    for (int next : map.get(arr[idx])) {
                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }

                    // Optimization
                    map.remove(arr[idx]);
                }
            }

            steps++;
        }

        return -1;
    }
}