// Lab 4
// Scenario - Given an array that determines the money stored in each house. Find the maximum profit which can be robbed such that no two adjacent houses are robbed.
// [1,2,3,1] - Here the maximum profit will be 3+1=4, without touching the adjacent houses.

// According to the question

// Creation of abstract class 

import java.util.Arrays;

abstract class Robber{

    // Abstract method to display some randomized content

    abstract void RobbingClass();

    // Abstract method declaration for all type of houses

    abstract int RowHouses(int[] houses);
    abstract int SquareHouses(int[] houses);
    abstract int RoundHouses(int[] houses);
    abstract int MultiHouses(int[] squareHouses, int[] roundHouses, int[] rowHouses); // varargs

}

class ProfRobber extends Robber{

    void RobbingClass(){
       System.out.println("Solving House Robber Problem");
    }

    // Logic for row houses

    int RowHouses(int[] houses){

        
        // If there is only 1 element, just return it
        if(houses.length<2){
            return houses[0];
        }

        // Creation of array to store the maximum loot at each index
        // Starting the process of memoization

        int[] dp = new int[houses.length];

        // Memoize maximum loots at first 2 indexes
        dp[0] = houses[0]; // First house just choose whatever is the value
        dp[1] = Math.max(houses[0],houses[1]); // Maximum of two values

        // Use them to fill the complete array
        // loop from 2 till end

        for(int i=2;i<houses.length;i++){
            // Core Logic
            dp[i] = Math.max(dp[i-2] + houses[i], dp[i-1]); // Formula - Max(total_loot[n-2]+loot[n],total_loot[n-1])
        }
        return dp[houses.length-1]; // returning the last value of the array, that will be the maximum profit

    }

    // Logic for round houses

    int RoundHouses(int[] houses){

         if(houses.length<2){
            return houses[0];
        }

        // Creation of array to store the maximum loot at each index
        // Starting the process of memoization

        int[] dp = new int[houses.length];

        // Memoize maximum loots at first 2 indexes
        dp[0] = houses[0]; // First house just choose whatever is the value
        dp[1] = Math.max(houses[0],houses[1]); // Maximum of two values

        // Used copyOfRange to extract specific elements from the original array
        return Math.max(RowHouses(Arrays.copyOfRange(houses, 0, houses.length - 1)), // Excluding the last element
                        RowHouses(Arrays.copyOfRange(houses, 1, houses.length)) // Excluding the first element
        );
    }

    // Squre houses follows the same logic as row houses

    int SquareHouses(int[] houses){

        return RowHouses(houses);

    }

    // Logic for multi houses

    int MultiHouses(int[] squareHouses, int[] roundHouses, int[] rowHouses){

        int maxSquare = SquareHouses(squareHouses);
        int maxRound = RoundHouses(roundHouses);
        int maxRow = RowHouses(rowHouses);

        return maxRound+maxRow+maxSquare;


    }

    

// Main Method
public static void main(String[] args) {
    
    ProfRobber david = new ProfRobber();

    int[] rowHouses = {1,2,3,0}; // Takes 1,3 to get maximum profit
    System.out.println("");
    david.RobbingClass();
    System.out.println("----------------------------");
    System.out.println("Row Houses Result: " + david.RowHouses(rowHouses));

    
    int[] roundHouses = {8,6,3,7}; // Takes {8,6,3} first 8+3 = 11, then takes {6,3,7} 6+7 = 13.
    System.out.println("Round Houses Result: " + david.RoundHouses(roundHouses));

    int[] squareHouses = {5,10,2,7}; // Takes {10,7} to get maximum profit
    System.out.println("Square Houses Result: " + david.SquareHouses(squareHouses));


    int[] rowTypeHouse = {5,3,8,2};
    int[] squareTypeHouse = {10,12,7,6};
    int[] roundTypeHouse = {4,9,11,5};

    System.out.println("");
    System.out.println("Provided input for MultiHouse Building");
    System.out.println("--------------------------------------");
    int totalRobbedAmount = david.MultiHouses(roundTypeHouse, squareTypeHouse, rowTypeHouse);
    System.out.println("Total robbed amount by david without triggering alarms in multi house building : " + totalRobbedAmount);
    System.out.println("");
    
    
}


}


// Core Logic

// public class Robber{

//     int rob(int[] nums){

//         // If there is only 1 element, just return it
//         if(nums.length<2){
//             return nums[0];
//         }

//         // Creation of array to store the maximum loot at each index
//         // Starting the process of memoization

//         int[] dp = new int[nums.length];

//         // Memoize maximum loots at first 2 indexes
//         dp[0] = nums[0]; // First house just choose whatever is the value
//         dp[1] = Math.max(nums[0],nums[1]); // Maximum of two values

//         // Use them to fill the complete array
//         // loop from 2 till end

//         for(int i=2;i<nums.length;i++){
//             // Core Logic
//             dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]); // Formula - Max(total_loot[n-2]+loot[n],total_loot[n-1])
//         }
//         return dp[nums.length-1]; // returning the last value of the array, that will be the maximum profit
//     }

//     public static void main(String[] args) {
//         Robber robber = new Robber();
        
//         int[] nums1 = {2,1,1,2};
//         System.out.println("Test Case 1: " + robber.rob(nums1));
        
//         int[] nums2 = {1,2};
//         System.out.println("Test Case 2: " + robber.rob(nums2));
        
//         int[] nums3 = {2,7,9,3,1};
//         System.out.println("Test Case 3: " + robber.rob(nums3));
        
//         int[] nums4 = {1};
//         System.out.println("Test Case 4: " + robber.rob(nums4));
//     }
// }


// Time and space complexity of this problem is 0(n)
