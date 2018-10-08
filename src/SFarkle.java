import java.util.Scanner;

/**
 *
 * @author Jaclyn Kordus CSCI-180-01 at 9 am MWF This program takes in one input
 *
 */
public class SFarkle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Let’s Play Farkle! \n");

        //connect keyboard
        Scanner keyboard = new Scanner(System.in);

        //get player names
        String player1Name = getPlayerName(keyboard, "first");
        String player2Name = getPlayerName(keyboard, "second");

        //roll dice
        int player1order = 0;
        int player2order = 0;

        //if both players role the same number, roll again
        while (player1order == player2order) {
            player1order = rollDice();
            player2order = rollDice();
        } //end while

        String firstPlayer = null;
        String secondPlayer;

        //print who the first player is (who goes first)
        if (player1order != player2order) {
            if (player1order > player2order) {
                firstPlayer = player1Name; // first player, goes first
                secondPlayer = player2Name; // second player, goes second
                System.out.println(player1Name + " is the first player. \n");
            } else {
                firstPlayer = player2Name;
                secondPlayer = player1Name;
                System.out.println(player2Name + " is the first player. \n");
            }
        } //ends if

        int singleOneRoll = 100;
        int singleFiveRoll = 50;
        int doubleOneRoll = 1000;
        int doubleTwoRoll = 200;
        int doubleThreeRoll = 300;
        int doubleFourRoll = 400;
        int doubleFiveRoll = 500;
        int doubleSixRoll = 600;
        int unique = 3000;

        int player1Score = 0;
        int player2Score = 0;

        player1Score = playerRoll(player1Name);
        player2Score = playerRoll(player2Name);

        System.out.println(player1Score);
        System.out.println(player2Score);
    }

    public static String getPlayerName(Scanner keyboard, String questionText) {
        System.out.println("Enter the " + questionText + " player's name: ");
        return keyboard.next();
    }

    public static int rollDice() {
        int roll = (int)(Math.random()*6) + 1;

        return roll;
    }

    public static int calculateScore(int roll[]) {
        return 1;
    }

    public static int playerRoll(String playerName) {
        int roll[] = new int[4];

        roll[0] = rollDice();
        roll[1] = rollDice();
        roll[2] = rollDice();
        roll[3] = rollDice();

        System.out.println(playerName + " rolled: " + roll[0] + " " + roll[1] + " " + roll[2] + " " + roll[3]);

        int score = calculateScore(roll);

        return score;
    }
}
