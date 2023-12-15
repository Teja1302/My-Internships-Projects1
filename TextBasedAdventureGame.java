package Tasks;
import java.util.Scanner;

public class TextBasedAdventureGame {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        System.out.println("Welcome to the Adventure Game!");
        System.out.println("You wake up in a forest. You see a path leading north.");

        int playerHealth = 100; 
        boolean hasKey = false; 

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Go North");
            System.out.println("2. Look around");
            System.out.println("3. Quit");

            int choice = getUserChoice(1, 3);

            switch (choice) {
                case 1:
                    System.out.println("You follow the path...");
                    playerHealth -= 10; 
                    forestEncounter(playerHealth, hasKey);
                    break;
                case 2:
                    lookAround(playerHealth, hasKey);
                    break;
                case 3:
                    quitGame();
                    break;
            }
        }
    }

    public static void forestEncounter(int playerHealth, boolean hasKey) {
        System.out.println("You arrive in a forest clearing.");

        if (playerHealth <= 0) {
            System.out.println("You are too weak to continue... Game over!");
            quitGame();
        } else {
            System.out.println("You continue your journey...");
            // Simulating further gameplay or encounters
            // For simplicity, let's say the player finds a key in the forest
            System.out.println("You found a key!");
            hasKey = true;
        }
    }

    public static void lookAround(int playerHealth, boolean hasKey) {
        System.out.println("You look around the area.");

        // Display information about the surroundings
        System.out.println("You are in a forest. There is a path leading north.");
        System.out.println("Your health: " + playerHealth);

        if (!hasKey) {
            System.out.println("You see something shiny on the ground.");
        } else {
            System.out.println("You have already found the key here.");
        }
    }

    public static void quitGame() {
        System.out.println("Quitting the game. Goodbye!");
        System.exit(0);
    }

    public static int getUserChoice(int min, int max) {
        int choice;
        while (true) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    break;
                } else {
                    System.out.println("Please enter a valid option!");
                }
            } else {
                System.out.println("Please enter a number!");
                scanner.next(); 
            }
        }
        return choice;
    }
}
