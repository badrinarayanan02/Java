// Program 1

import java.util.*;

public class FrequentNumbers {
    // Static variable to store the input array
    private static int[] numbersArray;

    // Static method to find top K numbers with maximum occurrences
    public static void findTopKFrequentNumbers(int K) {
        if (numbersArray == null || numbersArray.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        // Create a map to store frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : numbersArray) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create a list to store map entries
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequencyMap.entrySet());

        // Sort the list based on frequencies and numbers in descending order
        list.sort((a, b) -> {
            int freqCompare = b.getValue().compareTo(a.getValue()); // Compare frequencies
            if (freqCompare != 0) {
                return freqCompare;
            } else {
                return b.getKey().compareTo(a.getKey()); // Compare numbers if frequencies are equal
            }
        });

        // Display the top K numbers with maximum occurrences
        System.out.println("Top " + K + " numbers with maximum occurrences:");

        for (int i = 0; i < K && i < list.size(); i++) {
            System.out.println(list.get(i).getKey() + " - Frequency: " + list.get(i).getValue());
        }
    }

    public static void main(String[] args) {
        // Sample array of numbers
        numbersArray = new int[]{7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};

        int K = 4; // K value for top K numbers
        findTopKFrequentNumbers(K);
    }
}

