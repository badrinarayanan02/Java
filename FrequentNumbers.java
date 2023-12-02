// Lab 2 Program 1
// Top K numbers with maximum frequency occurances in an array

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SuppressWarnings("unchecked") // This is to disable the warnings

public class FrequentNumbers{

    public static void main(String[] args) {
        int[] numbersArray = {1,1,1,1,2,2,3,3,4};
        int K = 3; // K value for top K numbers

        int[] topKFrequentNumbers = topKfrequent(numbersArray, K);
        System.out.println("---------------------------------");
        System.out.println("Top " + K + " frequent numbers: " + Arrays.toString(topKFrequentNumbers));
        printFrequencies(numbersArray);
    }

    public static int[] topKfrequent(int[] nums, int k){

    List<Integer>[] bucket = new List[nums.length + 1]; // Creation of buckets
    // These buckets will group all the elements by their frequencies

     Map<Integer,Integer> frequencyMap = new HashMap<>(); // Creating a frequency map
     // This frequency map will store the frequency of each integer
     
     // Populating the frequency map, iterate over each element in the array and then put them to the frequency map
     // Once completing this the frequency map will be updated

     for(int n : nums){
        frequencyMap.put(n,frequencyMap.getOrDefault(n,0) + 1);
    }

    // Populating the buckets by looking on all the keys of frequency maps. Using these values the elements can be grouped in the bucket
    // {1,1,1,1,2,2,3,3,4} Consider this example, frequency of  4 is 1, element 1 added in the bucket number 4.
    

     for(int key : frequencyMap.keySet()){
        int frequency = frequencyMap.get(key);
        if(bucket[frequency] == null){
            bucket[frequency] = new ArrayList<>(); // Adding these as a array list, in each buckets it will have a list of all these numbers.
        }
        bucket[frequency].add(key);
     }

     // After creating buckets, create a res variable that will store all of the k most frequent elements

     int[] res = new int[k];
     int counter = 0;

     // This loop that will iterate through all of these buckets from reverse direction, start from end and go all the way till beginning
     // It will look these buckets and keep on adding these elements with the value of k
  
     for(int pos = bucket.length -1; pos>=0 && counter< k; pos--){
        if(bucket[pos] != null){
            for(Integer integer : bucket[pos]){
                res[counter++] = integer;
        }
     }
}
    return res; // The result array will be returned here
}

// This method is to print the frequencies in descending order

public static void printFrequencies(int[] nums) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    
    // Calculating frequencies
    
    for (int n : nums) {
        frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
    }
    
    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequencyMap.entrySet());

    // Sorting the list based on frequencies and numbers in descending order

    list.sort((a, b) -> {
        int freqCompare = b.getValue().compareTo(a.getValue()); // Comparing the frequencies
        if (freqCompare != 0) {
            return freqCompare;
        } else {
            return b.getKey().compareTo(a.getKey()); // Comparing numbers if frequencies are equal
        }
    });

    System.out.println("Frequencies in descending order:");
    for (Map.Entry<Integer, Integer> entry : list) {
        System.out.println("Number: " + entry.getKey() + ", Frequency: " + entry.getValue());
    }
}
}

// Time Complexity and Space Complexity of this solution is 0(n)
