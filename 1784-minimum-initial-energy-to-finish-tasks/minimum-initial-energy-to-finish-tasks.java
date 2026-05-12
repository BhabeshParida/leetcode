class Solution {
    public int minimumEffort(int[][] tasks) {

        // Sort tasks based on (minimum - actual) in descending order
        Arrays.sort(tasks, (a, b) -> {
            return (b[1] - b[0]) - (a[1] - a[0]);
        });

        int ans = 0;
        int currentEnergy = 0;

        for (int[] task : tasks) {

            int actual = task[0];
            int minimum = task[1];

            // If current energy is less than required minimum
            if (currentEnergy < minimum) {
                ans += (minimum - currentEnergy);
                currentEnergy = minimum;
            }

            // Perform the task
            currentEnergy -= actual;
        }

        return ans;
    }
}