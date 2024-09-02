import java.util.*;

class Solution2 {
    static int minCost(int arr[], int n) {
        // Create a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding items to the pQueue
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        // Initialize result
        int res = 0;

        // While size of priority queue is more than 1
        while (pq.size() > 1) {
            // Extract shortest two ropes from pq
            int first = pq.poll();
            int second = pq.poll();

            // Connect the ropes: update result
            // and insert the new rope to pq
            res += first + second;
            pq.add(first + second);
        }

        return res;
    }

    // Driver program to test above function
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Taking the number of ropes as input
        System.out.print("Enter the number of ropes: ");
        int n = scanner.nextInt();

        // Creating an array to store the lengths of the ropes
        int len[] = new int[n];

        // Taking the lengths of the ropes as input
        System.out.println("Enter the lengths of the ropes:");
        for (int i = 0; i < n; i++) {
            len[i] = scanner.nextInt();
        }

        // Calculating and printing the total cost for connecting the ropes
        System.out.println("Total cost for connecting ropes is " + minCost(len, n));
    }
}
