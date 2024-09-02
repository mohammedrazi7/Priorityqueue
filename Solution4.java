import java.util.Scanner;

public class Solution4 {

    public int lastStoneWeightII(int[] stones) {
        int s = 0;
        for (int v : stones) {
            s += v;
        }
        int m = stones.length;
        int n = s >> 1;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (stones[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }
        return s - dp[m][n] * 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of stones
        System.out.print("Enter the number of stones: ");
        int numStones = scanner.nextInt();

        // Input the weights of the stones
        int[] stones = new int[numStones];
        System.out.println("Enter the weights of the stones:");
        for (int i = 0; i < numStones; i++) {
            stones[i] = scanner.nextInt();
        }

        // Create an instance of Solution and call the method
        Solution4 solution = new Solution4();
        int result = solution.lastStoneWeightII(stones);

        // Output the result
        System.out.println("The smallest possible weight of the last stone is: " + result);
    }
}
