package handlers;
import java.util.Scanner;

public class InputHandler {
	private Scanner scanner;
	
	public InputHandler() {
		scanner = new Scanner(System.in);
	}
	
	public String getUserInput() {
		return scanner.nextLine();
	}

	//Add more methods for different inputs?
	public void closeScanner() {
		scanner.close();
	}
}
