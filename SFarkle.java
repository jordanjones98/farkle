
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Jaclyn Kordus CSCI-180-01 at 9 am MWF This program takes in one input
 *
 */
public class SFarkle {

    public static String currentPlayer = "";
    public static int bankOrRoll1 = 1;
    public static int bankOrRoll2 = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Let’s Play Farkle! \n");
        int player1Roll = 0;
        int player2Roll = 0;

        //connect keyboard
        Scanner keyboard = new Scanner(System.in);

        //get player names
        System.out.println("Enter the first player's name: ");
        String player1Name = keyboard.nextLine();
        System.out.println("Enter the second player's name:  ");
        String player2Name = keyboard.nextLine();

        //roll dice
        Random dice = new Random();
        // Generate random integers in range 1-6 
        int roll[] = new int[4];
        roll[0] = dice.nextInt(5) + 1;
        roll[1] = dice.nextInt(5) + 1;
        roll[2] = dice.nextInt(5) + 1;
        roll[3] = dice.nextInt(5) + 1;

        int player1order = roll[0] + player1Roll;
        int player2order = roll[1] + player2Roll;

        while (player1order == player2order) {
            player1order = dice.nextInt(5) + 1;
            player2order = dice.nextInt(5) + 1;
        }

        System.out.println(player1Name + " rolled a " + player1order + ".");
        System.out.println(player2Name + " rolled a " + player2order + ".");

        //if both players role the same number, roll again
        String firstPlayer = "";
        String secondPlayer = "";

        //if player 1 rolls higher than player 2, player 1 becomes the firstPlayer
        if (player1order > player2order) {
            firstPlayer = player1Name;
            secondPlayer = player2Name;
            currentPlayer = firstPlayer;
            System.out.println(player1Name + " is the first player. \n");

        }//if player 2 rolls higher than player 1, player 2 becomes the firstPlayer
        else { //player 2 goes first
            firstPlayer = player2Name;
            secondPlayer = player1Name;
            currentPlayer = secondPlayer;
            System.out.println(player2Name + " is the first player. \n");
        }//ends if

        //begin game
        int score1 = 0;
        int score2 = 0;
        int maxScore = 7000;
        int diceLeft = 4;
        int banked = 0;
        //scoring
        int singleOneRoll = 100;
        int singleFiveRoll = 50;
        int doubleOneRoll = 1000;
        int doubleTwoRoll = 200;
        int doubleThreeRoll = 300;
        int doubleFourRoll = 400;
        int doubleFiveRoll = 500;
        int doubleSixRoll = 600;
        int unique = 3000;
        int farkle = 0;

        // loop repeats until score1 or score 2 is greater than or equal to 7000
        while (maxScore >= score1 || maxScore >= score2) {
            //if the player has 4 dice
            if (diceLeft == 4) {
                if (bankOrRoll1 == 1) {
                    roll[0] = dice.nextInt(5) + 1;
                    roll[1] = dice.nextInt(5) + 1;
                    roll[2] = dice.nextInt(5) + 1;
                    roll[3] = dice.nextInt(5) + 1;
                    System.out.println("Total Points " + firstPlayer + ": " + score1 + " " + secondPlayer + ": " + score2);
                    System.out.println(firstPlayer + "'s turn. Banked: " + banked + " Dice left: 4");
                    System.out.println(firstPlayer + ", enter a 1 to roll or a 2 to bank points and stop: ");
                    bankOrRoll1 = keyboard.nextInt();
                    if (bankOrRoll1 == 1) {
                        System.out.println(firstPlayer + " rolled: " + " " + roll[0] + " " + roll[1] + " " + roll[2] + " " + roll[3] + " " + ".");
                            //possible scores for firstPlayer with 4 dice
                        //if unique
                        if ((roll[0] != roll[1]) && ((roll[0] != roll[2])) && ((roll[1] != roll[2])) && ((roll[0] != roll[3])) && ((roll[1] != roll[3])) && ((roll[2] != roll[3]))) {
                            score1 = score1 + unique;
                            banked = unique;
                            diceLeft = 4;
                        } //if player rolls two 1s 
                        else if (((roll[0] == 1) && (roll[1] == 1)) || ((roll[0] == 1) && (roll[2] == 1)) || ((roll[1] == 1) && (roll[2] == 1)) || ((roll[0] == 1) && (roll[3] == 1)) || ((roll[1] == 1) && (roll[3] == 1)) || ((roll[2] == 1) && (roll[3] == 1))) {
                            score1 = score1 + doubleOneRoll;
                            banked = doubleOneRoll;
                            diceLeft = 2;
                        } //if player rolls two 6s
                        else if (((roll[0] == 6) && (roll[1] == 6)) || ((roll[0] == 6) && (roll[2] == 6)) || ((roll[1] == 6) && (roll[2] == 6)) || ((roll[0] == 6) && (roll[3] == 6)) || ((roll[1] == 6) && (roll[3] == 6)) || ((roll[2] == 6) && (roll[3] == 6))) {
                            score1 = score1 + doubleSixRoll;
                            banked = doubleSixRoll;
                            diceLeft = 2;
                        } //if player rolls two 5s 
                        else if (((roll[0] == 5) && (roll[1] == 5)) || ((roll[0] == 5) && (roll[2] == 5)) || ((roll[1] == 5) && (roll[2] == 5)) || ((roll[0] == 5) && (roll[3] == 5)) || ((roll[1] == 5) && (roll[3] == 5)) || ((roll[2] == 5) && (roll[3] == 5))) {
                            score1 = score1 + doubleFiveRoll;
                            banked = doubleFiveRoll;
                            diceLeft = 2;
                        }//if player rolls two 4s
                        else if (((roll[0] == 4) && (roll[1] == 4)) || ((roll[0] == 4) && (roll[2] == 4)) || ((roll[1] == 4) && (roll[2] == 4)) || ((roll[0] == 4) && (roll[3] == 4)) || ((roll[1] == 4) && (roll[3] == 4)) || ((roll[2] == 4) && (roll[3] == 4))) {
                            score1 = score1 + doubleFourRoll;
                            banked = doubleFourRoll;
                            diceLeft = 2;
                        } //if player rolls two 3s
                        else if (((roll[0] == 3) && (roll[1] == 3)) || ((roll[0] == 3) && (roll[2] == 3)) || ((roll[1] == 3) && (roll[2] == 3)) || ((roll[0] == 3) && (roll[3] == 3)) || ((roll[1] == 3) && (roll[3] == 3)) || ((roll[2] == 3) && (roll[3] == 3))) {
                            score1 = score1 + doubleThreeRoll;
                            banked = doubleThreeRoll;
                            diceLeft = 2;
                        } //if player rolls two 2s
                        else if (((roll[0] == 2) && (roll[1] == 2)) || ((roll[0] == 2) && (roll[2] == 2)) || ((roll[1] == 2) && (roll[2] == 2)) || ((roll[0] == 2) && (roll[3] == 2)) || ((roll[1] == 2) && (roll[3] == 6)) || ((roll[2] == 2) && (roll[3] == 2))) {
                            score1 = score1 + doubleTwoRoll;
                            banked = doubleTwoRoll;
                            diceLeft = 2;
                        } //if player rolls one 1
                        else if ((roll[0] == 1) || (roll[1] == 1) || (roll[2] == 1) || (roll[3] == 1)) {
                            score1 = score1 + singleOneRoll;
                            banked = singleOneRoll;
                            diceLeft = 2;
                        } //if player rolls one 5
                        else if ((roll[0] == 5) || (roll[1] == 5) || (roll[2] == 5) || (roll[3] == 5)) {
                            score1 = score1 + singleFiveRoll;
                            banked = singleFiveRoll;
                            diceLeft = 2;
                        } //if player doesn't score they farkle
                        else {
                            score1 = farkle;
                            banked = farkle;
                            System.out.println("You Farkled");
                            //bankOrRoll2 = 1 is when secondPlayer rolls
                            bankOrRoll2 = 1;
                            break;
                            // end turn
                        } //end if, else if, else
                        //System.out.println("Please enter a 1 to roll or a 2 to bank points and stop: ");
                        //bankOrRoll1 = keyboard.nextInt();

                    } else if (bankOrRoll1 == 2) {
                        System.out.println("Total Points " + firstPlayer + ": " + score1 + " " + secondPlayer + ": " + score2);
                        //bankOrRoll2 = 1 is when secondPlayer rolls
                        bankOrRoll2 = 1;
                        bankOrRoll1 = 1;
                        break;
                    } else { //if bankOrRoll1 is anything other than a 1 or 2
                        roll[0] = dice.nextInt(5) + 1;
                        roll[1] = dice.nextInt(5) + 1;
                        roll[2] = dice.nextInt(5) + 1;
                        roll[3] = dice.nextInt(5) + 1;
                        System.out.println("Please enter a 1 to roll or a 2 to bank points and stop: ");
                        bankOrRoll1 = keyboard.nextInt();
                    } //ends if, else if, else
                }//if fisrtPlayer banks points and stops 
                System.out.println("Total Points " + firstPlayer + ": " + score1 + " " + secondPlayer + ": " + score2);
                System.out.println(firstPlayer + "'s turn. Banked: " + banked + " " + diceLeft);
                System.out.println(firstPlayer + ", enter a 1 to roll or a 2 to bank points and stop: ");
                bankOrRoll1 = keyboard.nextInt();
                    //System.out.println(firstPlayer + " rolled: " + " " + roll[0] + " " + roll[1] + " " + roll[2] + " " + roll[3] + " " + ".");

                //secondPlayer rolls 4 dice
                if (bankOrRoll2 == 1 && secondPlayer.equals(currentPlayer)) {
                    roll[0] = dice.nextInt(5) + 1;
                    roll[1] = dice.nextInt(5) + 1;
                    roll[2] = dice.nextInt(5) + 1;
                    roll[3] = dice.nextInt(5) + 1;
                    System.out.println(secondPlayer + " rolled: " + " " + roll[0] + " " + roll[1] + " " + roll[2] + " " + roll[3] + " " + ". \n");
                    System.out.println("Total Points " + firstPlayer + ": " + score1 + " " + secondPlayer + ": " + score2);
                    System.out.println(secondPlayer + "'s turn. Banked: " + banked + " Dice left: 4");
                    //possible scores for secondPlayer with 4 dice
                    //if unique
                    if ((roll[0] != roll[1]) && ((roll[0] != roll[2])) && ((roll[1] != roll[2])) && ((roll[0] != roll[3])) && ((roll[1] != roll[3])) && ((roll[2] != roll[3]))) {
                        score2 = score2 + unique;
                        banked = unique;
                        diceLeft = 4;
                    } //if player rolls two 1s 
                    else if (((roll[0] == 1) && (roll[1] == 1)) || ((roll[0] == 1) && (roll[2] == 1)) || ((roll[1] == 1) && (roll[2] == 1)) || ((roll[0] == 1) && (roll[3] == 1)) || ((roll[1] == 1) && (roll[3] == 1)) || ((roll[2] == 1) && (roll[3] == 1))) {
                        score2 = score2 + doubleOneRoll;
                        banked = doubleOneRoll;
                        diceLeft = 2;
                    } //if player rolls two 6s
                    else if (((roll[0] == 6) && (roll[1] == 6)) || ((roll[0] == 6) && (roll[2] == 6)) || ((roll[1] == 6) && (roll[2] == 6)) || ((roll[0] == 6) && (roll[3] == 6)) || ((roll[1] == 6) && (roll[3] == 6)) || ((roll[2] == 6) && (roll[3] == 6))) {
                        score2 = score2 + doubleSixRoll;
                        banked = doubleSixRoll;
                        diceLeft = 2;
                    } //if player rolls two 5s 
                    else if (((roll[0] == 5) && (roll[1] == 5)) || ((roll[0] == 5) && (roll[2] == 5)) || ((roll[1] == 5) && (roll[2] == 5)) || ((roll[0] == 5) && (roll[3] == 5)) || ((roll[1] == 5) && (roll[3] == 5)) || ((roll[2] == 5) && (roll[3] == 5))) {
                        score2 = score2 + doubleFiveRoll;
                        banked = doubleFiveRoll;
                        diceLeft = 2;
                    } //if player rolls two 4s
                    else if (((roll[0] == 4) && (roll[1] == 4)) || ((roll[0] == 4) && (roll[2] == 4)) || ((roll[1] == 4) && (roll[2] == 4)) || ((roll[0] == 4) && (roll[3] == 4)) || ((roll[1] == 4) && (roll[3] == 4)) || ((roll[2] == 4) && (roll[3] == 4))) {
                        score2 = score2 + doubleFourRoll;
                        banked = doubleFourRoll;
                        diceLeft = 2;
                    } //if player rolls two 3s
                    else if (((roll[0] == 3) && (roll[1] == 3)) || ((roll[0] == 3) && (roll[2] == 3)) || ((roll[1] == 3) && (roll[2] == 3)) || ((roll[0] == 3) && (roll[3] == 3)) || ((roll[1] == 3) && (roll[3] == 3)) || ((roll[2] == 3) && (roll[3] == 3))) {
                        score2 = score2 + doubleThreeRoll;
                        banked = doubleThreeRoll;
                        diceLeft = 2;
                    } //if player rolls two 2s
                    else if (((roll[0] == 2) && (roll[1] == 2)) || ((roll[0] == 2) && (roll[2] == 2)) || ((roll[1] == 2) && (roll[2] == 2)) || ((roll[0] == 2) && (roll[3] == 2)) || ((roll[1] == 2) && (roll[3] == 6)) || ((roll[2] == 2) && (roll[3] == 2))) {
                        score2 = score2 + doubleTwoRoll;
                        banked = doubleTwoRoll;
                        diceLeft = 2;
                    } //if player rolls one 1
                    else if ((roll[0] == 1) || (roll[1] == 1) || (roll[2] == 1) || (roll[3] == 1)) {
                        score2 = score2 + singleOneRoll;
                        banked = singleOneRoll;
                        diceLeft = 2;
                    } //if player rolls one 5
                    else if ((roll[0] == 5) || (roll[1] == 5) || (roll[2] == 5) || (roll[3] == 5)) {
                        score2 = score2 + singleFiveRoll;
                        banked = singleFiveRoll;
                        diceLeft = 2;
                    } //if player doesn't score they farkle
                    else {
                        score2 = farkle;
                        banked = farkle;
                        System.out.println("You Farkled");
                        //bankOrRoll1 = 1 is when firstPlayer rolls
                        bankOrRoll1 = 1;
                        // end turn 
                    } // ends if, if else, else
                } //ends if
                // if secondPlayer banks points and stops
                else if (bankOrRoll2 == 2) {
                    //bankOrRoll1 = 1 is when firstPlayer rolls
                    bankOrRoll1 = 1;
                    System.out.println("Total Points " + firstPlayer + ": " + score1 + " " + secondPlayer + ": " + score2);
                } else { // if bankOrRoll2 is anything other than 1 or 2
                    System.out.println("Please enter a 1 to roll or a 2 to bank points and stop: ");
                    bankOrRoll2 = keyboard.nextInt();
                } // ends if, else if, else
                System.out.println("Total Points " + firstPlayer + ": " + score1 + " " + secondPlayer + ": " + score2);
                System.out.println(secondPlayer + "'s turn. Banked: " + banked + " Dice left: 2");
                System.out.println(secondPlayer + ", enter a 1 to roll or a 2 to bank points and stop: ");
                bankOrRoll2 = keyboard.nextInt();
            }//ends4 dice
            while (diceLeft == 2) {
                //firstPlayer rolls 2 die
                if (bankOrRoll1 == 1) {
                    roll[0] = dice.nextInt(5) + 1;
                    roll[1] = dice.nextInt(5) + 1;
                    System.out.println(firstPlayer + " rolled: " + " " + roll[0] + " " + roll[1] + " " + roll[2] + " " + roll[3] + " " + ". \n");
                    System.out.println("Total Points " + firstPlayer + ": " + score1 + " " + secondPlayer + ": " + score2);
                    System.out.println(firstPlayer + "'s turn. Banked: " + banked + " Dies left: 4");
                    System.out.println(firstPlayer + ", enter a 1 to roll or a 2 to bank points and stop: ");
                    bankOrRoll1 = keyboard.nextInt();
                        //possible scores for firstPlayer with 2 dice
                     //if player rolls two 1s 
                    if (((roll[0] == 1) && (roll[1] == 1))) {
                        score1 = score1 + doubleOneRoll;
                        banked = doubleOneRoll;
                    } //if player rolls two 6s
                    else if (((roll[0] == 6) && (roll[1] == 6))) {
                        score1 = score1 + doubleSixRoll;
                        banked = doubleSixRoll;
                    } //if player rolls two 5s 
                    else if (((roll[0] == 5) && (roll[1] == 5))) {
                        score1 = score1 + doubleFiveRoll;
                        banked = doubleFiveRoll;
                    } //if player rolls two 4s
                    else if (((roll[0] == 4) && (roll[1] == 4))) {
                        score1 = score1 + doubleFourRoll;
                        banked = doubleFourRoll;
                    } //if player rolls two 3s
                    else if (((roll[0] == 3) && (roll[1] == 3))) {
                        score1 = score1 + doubleThreeRoll;
                        banked = doubleThreeRoll;
                    } //if player rolls two 2s
                    else if (((roll[0] == 2) && (roll[1] == 2))) {
                        score1 = score1 + doubleTwoRoll;
                        banked = doubleTwoRoll;
                    } //if player rolls one 1
                    else if ((roll[0] == 1) || (roll[1] == 1)) {
                        score1 = score1 + singleOneRoll;
                        banked = singleOneRoll;
                        diceLeft = 1;
                    } //if player rolls one 5
                    else if ((roll[0] == 5) || (roll[1] == 5)) {
                        score1 = score1 + singleFiveRoll;
                        banked = singleFiveRoll;
                        diceLeft = 1;
                    } //if player doesn't score they farkle
                    else {
                        score1 = farkle;
                        System.out.println("You Farkled");
                        //bankOrRoll2 is when secondPlayer rolls
                        bankOrRoll2 = 1;
                    }
                
                } else if (bankOrRoll1 == 2) {
                    System.out.println("Total Points " + firstPlayer + ": " + score1 + " " + secondPlayer + ": " + score2);
                    //bankOrRoll2 = 1 is when secondPlayer goes first
                    bankOrRoll2 = 1;
                } else { //if bankOrRoll1 is anything other than 1 or 2
                    System.out.println("Please enter a 1 to roll or a 2 to bank points and stop: ");
                    bankOrRoll1 = keyboard.nextInt();
                }//ends if, else if, else
            }
            diceLeft = 1;
            System.out.println("Total Points " + firstPlayer + ": " + score1 + " " + secondPlayer + ": " + score2);
            System.out.println(secondPlayer + "'s turn. Banked: " + banked + " Dice left: 4");
            System.out.println(secondPlayer + ", enter a 1 to roll or a 2 to bank points and stop: ");
            bankOrRoll1 = keyboard.nextInt();
            System.out.println(secondPlayer + " rolled: " + " " + roll[0] + " " + roll[1] + " " + roll[2] + " " + roll[3] + " " + ".");
            if (diceLeft == 2) {
                //secondplayer rolls 2 dice
                if (bankOrRoll2 == 1) {
                    roll[0] = dice.nextInt(5) + 1;
                    roll[1] = dice.nextInt(5) + 1;
                    System.out.println("Total Points " + firstPlayer + ": " + score1 + " " + secondPlayer + ": " + score2);
                    System.out.println(secondPlayer + "'s turn. Banked: " + banked + " Dies left: 2");
                    System.out.println(secondPlayer + " rolled: " + " " + roll[0] + " " + roll[1] + " " + roll[2] + " " + roll[3] + " " + ".");

                    //possible scores for secondPlayer with 2 dice
                    //if player rolls two 1s 
                    if (((roll[0] == 1) && (roll[1] == 1))) {
                        score2 = score2 + doubleOneRoll;
                        banked = doubleOneRoll;
                    } //if player rolls two 6s
                    else if (((roll[0] == 6) && (roll[1] == 6))) {
                        score2 = score2 + doubleSixRoll;
                        banked = doubleSixRoll;
                    } //if player rolls two 5s 
                    else if (((roll[0] == 5) && (roll[1] == 5))) {
                        score2 = score2 + doubleFiveRoll;
                        banked = doubleFiveRoll;
                    } //if player rolls two 4s
                    else if (((roll[0] == 4) && (roll[1] == 4))) {
                        score2 = score2 + doubleFourRoll;
                        banked = doubleFourRoll;
                    } //if player rolls two 3s
                    else if (((roll[0] == 3) && (roll[1] == 3))) {
                        score2 = score2 + doubleThreeRoll;
                        banked = doubleThreeRoll;
                    } //if player rolls two 2s
                    else if (((roll[0] == 2) && (roll[1] == 2))) {
                        score2 = score2 + doubleTwoRoll;
                        banked = doubleTwoRoll;
                    } //if player rolls one 1
                    else if ((roll[0] == 1) || (roll[1] == 1)) {
                        score2 = score2 + singleOneRoll;
                        banked = singleOneRoll;
                        diceLeft = 1;
                    } //if player rolls one 5
                    else if ((roll[0] == 5) || (roll[1] == 5)) {
                        score2 = score2 + singleFiveRoll;
                        banked = singleFiveRoll;
                        diceLeft = 1;
                    } //if player doesn't score they farkle
                    else {
                        score2 = farkle;
                        banked = farkle;
                        System.out.println("You Farkled");
                        //bankOrRoll1 is when firstPlayer rolls
                        bankOrRoll1 = 1;
                    } //ends if, else if, else
                    System.out.println("Total Points " + firstPlayer + ": " + score1 + " " + secondPlayer + ": " + score2);
                    System.out.println(secondPlayer + "'s turn. Banked: " + banked + " Dies left: 1");
                    System.out.println(secondPlayer + " rolled: " + " " + roll[0] + " " + roll[1] + " " + roll[2] + " " + roll[3] + " " + ".");
                } else if (bankOrRoll2 == 2) {
                    System.out.println("Total Points " + firstPlayer + ": " + score1 + " " + secondPlayer + ": " + score2);
                    //bankOrRoll1 = 1 is when firstPlayer rolls
                    bankOrRoll1 = 1;
                } else {
                    System.out.println("Please enter a 1 to roll or a 2 to bank points and stop: ");
                    bankOrRoll2 = keyboard.nextInt();
                } //ends if, else if, else
                System.out.println("Total Points " + firstPlayer + ": " + score1 + " " + secondPlayer + ": " + score2);
                System.out.println(secondPlayer + "'s turn. Banked: " + banked + " Dice left: 4");
                System.out.println(secondPlayer + ", enter a 1 to roll or a 2 to bank points and stop: ");
                bankOrRoll2 = keyboard.nextInt();
                System.out.println(secondPlayer + " rolled: " + " " + roll[0] + " " + roll[1] + " " + roll[2] + " " + roll[3] + " " + ".");
                diceLeft = 1;
            }
            if (diceLeft == 1) {
                //firstPlayer rolls 1 die
                roll[0] = dice.nextInt(5) + 1;
                if (bankOrRoll1 == 1) {
                    System.out.println("Total Points " + firstPlayer + ": " + score1 + " " + secondPlayer + ": " + score2);
                    System.out.println(firstPlayer + "'s turn. Banked: " + banked + "Dies left: 1");
                    System.out.println(firstPlayer + ", enter a 1 to roll or a 2 to bank points and stop: ");
                    bankOrRoll1 = keyboard.nextInt();
                    System.out.println(firstPlayer + " rolled: " + " " + roll[0] + " " + roll[1] + " " + roll[2] + " " + roll[3] + " " + ".");

                    //possible scores for firstPlayer with 1 die
                    if ((roll[0] == 1) || (roll[1] == 1)) {
                        score1 = score1 + singleOneRoll;
                        banked = singleOneRoll;
                    } //if player rolls one 5
                    else if ((roll[0] == 5) || (roll[1] == 5)) {
                        score1 = score1 + singleFiveRoll;
                        banked = singleFiveRoll;
                    } //if player doesn't score they farkle
                    else {
                        score1 = farkle;
                        banked = farkle;
                        System.out.println("You Farkled");
                        //bankOrRoll2 = 1 is when secondPlayer rolls
                        bankOrRoll2 = 1;
                    }// ends if, else if, else

                } else if (bankOrRoll1 == 2) {
                    System.out.println("Total Points " + firstPlayer + ": " + score1 + " " + secondPlayer + ": " + score2);
                    //bankOrRoll2 = 1 is when secondPlayer rolls
                    bankOrRoll2 = 1;
                } else {
                    System.out.println("Please enter a 1 to roll or a 2 to bank points and stop: ");
                    bankOrRoll1 = keyboard.nextInt();
                } //ends if, else if, else
                diceLeft = 0;
                bankOrRoll2 = 1;
                // if secondPlayer rolls
                if (bankOrRoll2 == 1) {
                    roll[0] = dice.nextInt(5) + 1;
                    System.out.println("Total Points " + firstPlayer + ": " + score1 + " " + secondPlayer + ": " + score2);
                    System.out.println(firstPlayer + "'s turn. Banked: " + banked + " Dies left: 1");
                    System.out.println(firstPlayer + ", enter a 1 to roll or a 2 to bank points and stop: ");
                    bankOrRoll1 = keyboard.nextInt();
                    System.out.println(firstPlayer + " rolled: " + " " + roll[0] + " " + roll[1] + " " + roll[2] + " " + roll[3] + " " + ".");

                    //possible scores for secondPlayer with 1 die
                    if ((roll[0] == 1) || (roll[1] == 1)) {
                        score1 = score1 + singleOneRoll;
                        banked = singleOneRoll;
                    } //if player rolls one 5
                    else if ((roll[0] == 5) || (roll[1] == 5)) {
                        score1 = score1 + singleFiveRoll;
                        banked = singleFiveRoll;
                    } //if player doesn't score they farkle
                    else {
                        score1 = farkle;
                        banked = farkle;
                        System.out.println("You Farkled");
                        //bankOrRoll1 = 1 is when firstPlayer rolls
                        bankOrRoll1 = 1;
                    }

                } else if (bankOrRoll2 == 2) {
                    System.out.println("Total Points " + firstPlayer + ": " + score1 + " " + secondPlayer + ": " + score2);
                    //bankOrRoll1 = 1 is when firstPlayer rolls
                    bankOrRoll1 = 1;
                } else {
                    System.out.println("Please enter a 1 to roll or a 2 to bank points and stop: ");
                    bankOrRoll2 = keyboard.nextInt();
                }
                diceLeft = 0;
                bankOrRoll1 = 1;

            }

        }
    }

}

