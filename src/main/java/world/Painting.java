package world;
import utilities.*;
import entities.*;
import handlers.*;

public class Painting extends ObjectInRoom {
	// Extra attributes
	private boolean passwordDiscovered;
	
	public Painting(String name, String description) {
		super(name, description);
		this.passwordDiscovered = false; // password is not discovered initially
	}
	
	public boolean isPasswordDiscovered() {
		return passwordDiscovered;
	}
	
	@Override
	public void interactWith(Player player, InputHandler inputHandler) {
	    if (!passwordDiscovered) {
	        Utilities.slowPrint("\nIt's just a dusty old painting...no use here.");

	        while (true) { // This will keep looping until a valid input is received
	            Utilities.slowPrint("Do you want to investigate further? (Y/N)");
	            String userInput = inputHandler.getUserInput().trim(); // trim() to remove any leading or trailing whitespace

	            if (userInput.equalsIgnoreCase("Y")) {
	                // Logic for discovering password
	                Utilities.slowPrint("You flip over the painting and run your fingers along the back of the frame.");
	                
	                // Generate code from randomizer class and store as player password
	                String password = Randomizer.generateRandom4DigitCode();
	                player.setPassword(password);
	                
	                // Slow reveal password
	                slowRevealPassword("As you rub the back of the frame, you slowly reveal numbers...\n", 1000, password);
	                
	                this.passwordDiscovered = true; // Set password as discovered
	                
	                Utilities.slowPrint("\nYou memorize the numbers and put the painting back to its original position.");
	                break; // Exit the loop after valid input and action
	            } else if (userInput.equalsIgnoreCase("N")) {
	                Utilities.slowPrint("\nGood call Sherlock Holmes, better leave that where it is...");
	                break; // Exit the loop after valid input and action
	            } else {
	                Utilities.slowPrint("Invalid input. Please enter 'Y' for yes or 'N' for no.");
	                // Loop will continue because neither 'Y' nor 'N' was entered
	            }
	        }
	    } else {
	        // If the player interacts with the painting after the password is already discovered
	        Utilities.slowPrint("\nYou've already discovered the secret of this painting.");
	    }
	}

	
	private void slowRevealPassword(String message, int charDelay, String numbers) {
        try {
            // Print the initial message without delay
            System.out.print(message);

            // Print each number with a delay and spaces
            for (char number : numbers.toCharArray()) {
                Thread.sleep(charDelay);
                System.out.print(number + "    "); // Add spaces after each number
            }
            System.out.println(); // Newline after the last number
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restores the interrupted status after catching InterruptedException
        }
    }
}
