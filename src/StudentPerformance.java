// Program 1

import java.util.Scanner;
public class StudentPerformance {

    int[] marks; // creation of integer array

    // Constructor
    StudentPerformance(){
        marks = new int[10]; // Initializing the marks array to store the marks
    }

    // Inference - This method is used to read the student marks
    public void readMarks(){
        Scanner input = new Scanner(System.in); // Invoking the scanner class
        System.out.println("Enter the marks of 10 students: ");
        // looping statement to iterate over the array items
        for(int i =0;i<10;i++){
            System.out.println("Mark of the student" + (i+1)+":");
            marks[i] = input.nextInt(); // Reading the integer input with the help of scanner instance
        }
    }

    // Inference - This method is used to find the highest mark of the student
    public int highestMark(){
        int highest = marks[0]; // creation of a variable highest to store the marks array which is initialized from 0
        for(int i=1;i<marks.length;i++){
            if(marks[i]>highest){
                highest = marks[i];
            }
        }
        return  highest;
    }

    // Inference - This method is used to find the least mark of the student
    public int leastMark(){
        int least = marks[0];  // creation of a variable least to store the marks array which is initialized from 0
        for(int i=1;i<marks.length;i++){
            if(marks[i]<least){
                least = marks[i];
            }
        }
        return  least;
    }

    // Inference - This method is used to return the mode
    public int getMode() {
        int mode = 0;
        int maxFrequency = 0;

        for (int i = 0; i < marks.length; i++) {
            int currentMark = marks[i];
            int currentFrequency = 0;

            for (int j = 0; j < marks.length; j++) {
                if (marks[j] == currentMark) {
                    currentFrequency++;
                }
            }
            if (currentFrequency > maxFrequency || (currentFrequency == maxFrequency && currentMark > mode)) {
                maxFrequency = currentFrequency;
                mode = currentMark;
            }
        }
        return mode;
    }

    // Inference - This method is used to return the frequency of the mode
    public int getFreqATMode(){
        int mode = getMode();
        int freqAtMode = 0;
        for (int mark : marks){
            if (mark == mode){
                freqAtMode = freqAtMode + 1;
            }
        }
        return freqAtMode;
    }

    // Inference - This method is used display all the results
    void display(){
        int highest = highestMark();
        int lowest  = leastMark();
        int mode = getMode();
        int modeFrequency = getFreqATMode();

        System.out.println("Highest mark secured in the class: " + highest);
        System.out.println("Lowest mark secured in the class: " + lowest);
        System.out.println("Mode: " + mode);
        System.out.println("Mode Frequency: " + modeFrequency);

    }
    public static void main(String[] args) {

        StudentPerformance stud = new StudentPerformance();
        stud.readMarks();
        stud.display();

    }
}



