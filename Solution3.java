import java.util.*;

public class Solution3 {
    public static List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count the frequency of each word
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Use a PriorityQueue to sort words by frequency and lexicographical order
        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> {
            int freqCompare = frequencyMap.get(w1) - frequencyMap.get(w2);
            if (freqCompare == 0) {
                return w2.compareTo(w1); // If frequencies are the same, sort by lexicographical order (reverse)
            } else {
                return freqCompare; // Otherwise, sort by frequency
            }
        });

        // Step 3: Keep only the top k elements in the PriorityQueue
        for (String word : frequencyMap.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll(); // Remove the least frequent or lexicographically largest word if more than k elements
            }
        }

        // Step 4: Extract the elements from the PriorityQueue and reverse to get the correct order
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.reverse(result); // Reverse to get the correct order

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the array of words
        System.out.println("Enter the words separated by spaces:");
        String[] words = scanner.nextLine().split(" ");

        // Input the value of k
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        // Get the k most frequent words
        List<String> result = topKFrequent(words, k);

        // Output the result
        System.out.println("The top " + k + " most frequent words are:");
        for (String word : result) {
            System.out.println(word);
        }
    }
}
