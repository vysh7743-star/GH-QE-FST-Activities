import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"Rock", "Paper", "Scissors"};

        int playerScore = 0;
        int computerScore = 0;

        System.out.println("Welcome to Rock-Paper-Scissors!");
        System.out.println("Enter 0 for Rock, 1 for Paper, 2 for Scissors, or 9 to quit.");

        while (true) {
            try {
                System.out.print("\nYour choice: ");
                int playerChoice = scanner.nextInt();

                if (playerChoice == 9) {
                    System.out.println("Thanks for playing!");
                    break; // exit the game
                }

                // Validate input
                if (playerChoice < 0 || playerChoice > 2) {
                    System.out.println("Invalid choice! Please enter 0, 1, 2, or 9 to quit.");
                    continue;
                }

                // Computer choice
                int computerChoice = random.nextInt(3);

                System.out.println("You chose: " + choices[playerChoice]);
                System.out.println("Computer chose: " + choices[computerChoice]);

                // Determine winner
                if (playerChoice == computerChoice) {
                    System.out.println("It's a tie!");
                } else if ((playerChoice == 0 && computerChoice == 2) ||
                           (playerChoice == 1 && computerChoice == 0) ||
                           (playerChoice == 2 && computerChoice == 1)) {
                    System.out.println("You win this round!");
                    playerScore++;
                } else {
                    System.out.println("Computer wins this round!");
                    computerScore++;
                }

                // Display scores
                System.out.println("Score -> You: " + playerScore + " | Computer: " + computerScore);

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number (0, 1, 2, or 9 to quit).");
                scanner.nextLine(); // clear the invalid input
            }
        }

        System.out.println("\nFinal Score -> You: " + playerScore + " | Computer: " + computerScore);
        System.out.println("Game Over!");
        scanner.close();
    }
}
