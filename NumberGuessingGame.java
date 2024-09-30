import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound +
                ". Try to guess it.");

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Enter your guess (Attempt " + attempt + "/" + maxAttempts + "): ");
            int userGuess = scanner.nextInt();

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                score += calculateScore(attempt, maxAttempts);
                break;
            } else if (userGuess < targetNumber) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Too high. Try again.");
            }

            if (attempt == maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }
        }

        System.out.println("Your score: " + score);
        System.out.println("Thanks for playing!");
    }

    public static int calculateScore(int attempts, int maxAttempts) {
        int maxScore = 1000;
        double scoreMultiplier = 1.0 - ((double) (attempts - 1) / (double) maxAttempts);
        return (int) (maxScore * scoreMultiplier);
    }
}