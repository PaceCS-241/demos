import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;


public class AppTests {
    private GuessingGame game;

    @Before
    public void init() {
        // generate a new game for each test
        game = new GuessingGame();
    }

    @Test
    public void moreGuessesTrue() {
        game.guessesLeft = 5;
        assertEquals(true, game.moreGuesses());
    }

    @Test
    public void moreGuessesFalse() {
        game.guessesLeft = 0;
        assertEquals(false, game.moreGuesses());
    }

    @Test
    public void getGuessPromptNormal() {
        // this will be the test input
        ByteArrayInputStream testIn = new ByteArrayInputStream("10".getBytes());
        System.setIn(testIn);
        // this will capture what the program outputs
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        // need to create a new game that accepts new input stream
        game = new GuessingGame();
        // run the method
        int num = game.getGuess();
        
        // test return is correct
        assertEquals(10, num);

        // test the method outputs the prompt
        String expectedOutput = "Guess a number: ";
        String realOutput = testOut.toString();
        assertEquals(expectedOutput, realOutput);
    }

    @Test
    public void randNumInRange() {
        assertTrue(game.number >= 0);
        assertTrue(game.number <= 100);
    }

}
