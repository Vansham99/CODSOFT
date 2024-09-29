import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 7;
        int roundNumber = 1;
        int score = 0;
        String playAgain;

        do {
            System.out.println("\n--- Round " + roundNumber + " ---");
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            // Loop to manage the guesses with a limit on attempts
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.println("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Guess a number between " + minRange + " and " + maxRange + ": ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < randomNumber) {
                    System.out.println("Too low!");
                } else if (guess > randomNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You've guessed the number.");
                    guessedCorrectly = true;
                    score++;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all attempts! The correct number was " + randomNumber + ".");
            }

            System.out.println("Your score: " + score);
            System.out.println("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().toLowerCase();
            roundNumber++;

        } while (playAgain.equals("yes"));

        System.out.println("Thanks for playing! Your final score is: " + score);
        scanner.close();
    }
}
