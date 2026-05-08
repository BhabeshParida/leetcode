class Solution {

    // Check if number is prime
    boolean isPrime(int num) {

        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {

            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int minJumps(int[] nums) {

        int n = nums.length;

        // divisor -> list of indices
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int val = nums[i];

            for (int d = 1; d * d <= val; d++) {

                if (val % d == 0) {

                    map.computeIfAbsent(d,
                            k -> new ArrayList<>()).add(i);

                    if (d != val / d) {

                        map.computeIfAbsent(val / d,
                                k -> new ArrayList<>()).add(i);
                    }
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int jumps = 0;

        // avoid repeated teleport processing
        HashSet<Integer> usedPrime = new HashSet<>();

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int i = q.poll();

                // reached destination
                if (i == n - 1) {
                    return jumps;
                }

                // move left
                if (i - 1 >= 0 && !visited[i - 1]) {

                    visited[i - 1] = true;
                    q.offer(i - 1);
                }

                // move right
                if (i + 1 < n && !visited[i + 1]) {

                    visited[i + 1] = true;
                    q.offer(i + 1);
                }

                // prime teleportation
                int val = nums[i];

                if (isPrime(val) && !usedPrime.contains(val)) {

                    usedPrime.add(val);

                    List<Integer> list = map.get(val);

                    if (list != null) {

                        for (int idx : list) {

                            if (!visited[idx]) {

                                visited[idx] = true;
                                q.offer(idx);
                            }
                        }
                    }
                }
            }

            jumps++;
        }

        return -1;
    }
}