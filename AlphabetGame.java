// Program 2
// Alphabet War Game - Battle between the letters of the alphabet

// Declaration of private integer variables to hold the strength of each letter

public class AlphabetGame {
    private int strengthW = 4;
    private int strengthP = 3;
    private int strengthB = 2;
    private int strengthS = 1;
    private int strengthM = 4;
    private int strengthQ = 3;
    private int strengthD = 2;
    private int strengthZ = 1;

    // Constructor Overloading

    // Default constructor
    // Initializes the strength of the letters to their default values
    public AlphabetGame() {
    }

    // Parameterized Constructor
    // To allow the customization of letter strengths by accepting values of for each letter's strength

    public AlphabetGame(int strengthW, int strengthP, int strengthB, int strengthS,
                           int strengthM, int strengthQ, int strengthD, int strengthZ) {
        this.strengthW = strengthW;
        this.strengthP = strengthP;
        this.strengthB = strengthB;
        this.strengthS = strengthS;
        this.strengthM = strengthM;
        this.strengthQ = strengthQ;
        this.strengthD = strengthD;
        this.strengthZ = strengthZ;
    }

    // Figuring out who wins in different ways using method overloading

    // Method to determine the winner using one word
    // It takes the single word and calculates the strength of the left and right sides based on the letters in the word


    public String determineWinner(String word) {
        int leftStrength = 0;
        int rightStrength = 0;
        for (char c : word.toCharArray()) {
            switch (c) {
                case 'w':
                    leftStrength += strengthW;
                    break;
                case 'p':
                    leftStrength += strengthP;
                    break;
                case 'b':
                    leftStrength += strengthB;
                    break;
                case 's':
                    leftStrength += strengthS;
                    break;
                case 'm':
                    rightStrength += strengthM;
                    break;
                case 'q':
                    rightStrength += strengthQ;
                    break;
                case 'd':
                    rightStrength += strengthD;
                    break;
                case 'z':
                    rightStrength += strengthZ;
                    break;
            }
        }
        if (leftStrength > rightStrength) {
            return "Left side wins!";
        } else if (rightStrength > leftStrength) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    // Method to determine the winner using separate left and right words
    // It takes two words representing left and right separately and calculates their strengths

    public String determineWinner(String leftWord, String rightWord) {
        int leftStrength = 0;
        int rightStrength = 0;
        for (char c : leftWord.toCharArray()) {
            switch (c) {
                case 'w':
                    leftStrength += strengthW;
                    break;
                case 'p':
                    leftStrength += strengthP;
                    break;
                case 'b':
                    leftStrength += strengthB;
                    break;
                case 's':
                    leftStrength += strengthS;
                    break;
            }
        }
        for (char c : rightWord.toCharArray()) {
            switch (c) {
                case 'm':
                    rightStrength += strengthM;
                    break;
                case 'q':
                    rightStrength += strengthQ;
                    break;
                case 'd':
                    rightStrength += strengthD;
                    break;
                case 'z':
                    rightStrength += strengthZ;
                    break;
            }
        }
        if (leftStrength > rightStrength) {
            return "Left side wins!";
        } else if (rightStrength > leftStrength) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    public static void main(String[] args) {

        AlphabetGame game = new AlphabetGame();

        // Test cases
        System.out.println("AlphabetWar(\"d\"): " + game.determineWinner("d")); // 2>0
        System.out.println("AlphabetWar(\"zdqmwpb\"): " + game.determineWinner("zdqmwpb")); // 10>9
        System.out.println("AlphabetWar(\"wwwwwwz\"): " + game.determineWinner("wwwwwwz")); // 24>1
    }
}

