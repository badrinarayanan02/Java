// Program 2
// Alphabet War Game

public class AlphabetGame {
    private int strengthW = 4;
    private int strengthP = 3;
    private int strengthB = 2;
    private int strengthS = 1;
    private int strengthM = 4;
    private int strengthQ = 3;
    private int strengthD = 2;
    private int strengthZ = 1;

    // Default constructor
    public AlphabetGame() {
    }

    // Parameterized Constructor to allow the customization of letter strengths
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

    // Method to determine the winner using one word
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
        System.out.println("AlphabetWar(\"z\"): " + game.determineWinner("z"));
        System.out.println("AlphabetWar(\"zdqmwpbs\"): " + game.determineWinner("zdqmwpbs"));
        System.out.println("AlphabetWar(\"wwwwwwz\"): " + game.determineWinner("wwwwwwz"));
    }
}

