import java.util.Random;
import java.util.Scanner;

public class Guessgame {
    public static void main(String[] args) {
        int score = 0;
        int rounds = 0;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("Welcome to the Guess game!");
            System.out.println("I'm thinking of a number between 1 and 100.");

            while (!guessed && attempts < 10) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    guessed = true;
                    score += 10 - attempts;
                    rounds++;
                }
            }

            if (!guessed) {
                System.out.println("You didn't guess the number. It was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();

            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Thanks for playing! Your final score is " + score + " in " + rounds + " rounds.");
    }
}