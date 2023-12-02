// Lab 1 Program 1
// Analyzing Student performance and finding out four quantities

import java.util.Scanner;
public class StudentPerformance {

    int[] marks; // creation of integer array

    // Constructor
    StudentPerformance(){
        marks = new int[10]; // Initializing the marks array to store the marks
    }

    // This method is used to read the student marks

    public void readMarks(){
        try(Scanner input = new Scanner(System.in)){ // Invoking the scanner class
        System.out.println("Enter the marks of 10 students: ");

        // looping statement to iterate over the array items
        for(int i =0;i<10;i++){
            System.out.println("Mark of the student" + (i+1)+":");
            marks[i] = input.nextInt(); // Reading the integer input with the help of scanner instance
        }
        }
    }

    // This method is used to find the highest mark of the student

    public int highestMark(){
        int highest = marks[0]; // creation of a variable highest to store the marks array which is initialized from 0
        for(int i=1;i<marks.length;i++){
            if(marks[i]>highest){
                highest = marks[i];
            }
        }
        return  highest;
    }

    // This method is used to find the least mark of the student

    public int leastMark(){
        int least = marks[0];  // creation of a variable least to store the marks array which is initialized from 0
        for(int i=1;i<marks.length;i++){
            if(marks[i]<least){
                least = marks[i];
            }
        }
        return  least;

    }

    // This method is used to return the mode

    public int getMode() {

        // Initializing mode and maxFrequency variable from 0
        int mode = 0;  
        int maxFrequency = 0;

        for (int i = 0; i < marks.length; i++) {
            int currentMark = marks[i];
            int currentFrequency = 0;  // Initializing the current frequency variable as 0

            // This loop is for incrementing current frequency
        
            for (int j = 0; j < marks.length; j++) {
                if (marks[j] == currentMark) {
                    currentFrequency++; // If the condition satisfies the increment will happen
                }
            }
            if (currentFrequency > maxFrequency || (currentFrequency == maxFrequency && currentMark > mode)) {
                maxFrequency = currentFrequency;
                mode = currentMark;
            }
        }
        return mode;
    }

    // This method is used to return the frequency of the mode

    public int getFreqATMode(){
        int mode = getMode();
        int freqAtMode = 0;
        for (int mark : marks){
            if (mark == mode){
                freqAtMode = freqAtMode + 1; // frequency++
            }
        }
        return freqAtMode;
    }

    // This method is for displaying the highest mark, lowestmark, mode and modeFrequency by calling all the respective function

    void display(){

        int highest = highestMark();
        int lowest  = leastMark();
        int mode = getMode();
        int modeFrequency = getFreqATMode();

        System.out.println("-------------------------------------");
        System.out.println("Highest mark secured in the class: " + highest);
        System.out.println("Lowest mark secured in the class: " + lowest);
        System.out.println("Mode: " + mode);
        System.out.println("Mode Frequency: " + modeFrequency);

    }

    // Object creation and function calling

    public static void main(String[] args) {

        StudentPerformance stud = new StudentPerformance();
        stud.readMarks();
        stud.display();

    }
}