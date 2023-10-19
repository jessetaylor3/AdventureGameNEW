package utilities;

public class Utilities {
	private static int defaultCharDelay = 50;
	
	public static void slowPrint(String message) {
		slowPrint(message, defaultCharDelay);
	}
	
	public static void slowPrint(String message, int charDelay) {
		try {
			for (char c : message.toCharArray()) {
				System.out.print(c);
				Thread.sleep(charDelay);
			}
			System.out.println();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt(); //Idk what this is doing
		}
	}
	
	//Method to simulate clearing the console
	public static void clearConsole() {
		for (int i = 0; i<100; i++) {
			System.out.println();
		}
	}
	
	//Getter and setter for delay
	public static int getDefaultCharDelay() {
		return defaultCharDelay;
	}
	
	public static void setDefaultCharDelay(int charDelay) {
		defaultCharDelay = charDelay;
	}

}
