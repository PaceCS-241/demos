import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // play the game once
        GuessingGame game = new GuessingGame();
        game.play();
    }
}

class GuessingGame {
    Random random;
    Scanner scr;
    int number;
    int maxGuesses;
    int guessesLeft;

    public GuessingGame() {
        // constructor
        // generate a random number
        // init attributes
        this.random = new Random();
        this.scr = new Scanner(System.in);
        this.number = random.nextInt(100) + 1;
        this.maxGuesses = 10;
        this.guessesLeft = maxGuesses;
    }

    public int getGuess() {
        System.out.print("Guess a number: ");
        return scr.nextInt();
    }

    public boolean compareGuess(int guess) {
        // calc difference between number and guess
        int diff = this.number - guess;
        if(diff == 0) {
            // no difference, correct guess
            System.out.println("You win!");
            System.out.printf("It took you %d guesses.\n", this.maxGuesses - this.guessesLeft + 1);
            return true;
        } else if(diff > 0) {
            // guess is too low
            System.out.println("Guess is too low");
        } else {
            // guess is too high
            System.out.println("Guess is too high");
        }
        return false;
    }

    public boolean moreGuesses() {
        return this.guessesLeft > 0;
    }

    public void play() {
        boolean gameResult = false;
        int guess;
        while(!gameResult && moreGuesses()) {
            this.guessesLeft--;
            guess = getGuess();
            gameResult = compareGuess(guess);
        }
        
        if(gameResult)
            // game was won
            System.out.println("Congrats!");
        else
            System.out.println("Sorry you ran out of guesses");

        this.scr.close();
    }
}