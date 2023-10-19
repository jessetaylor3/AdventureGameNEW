package utilities;
import java.util.Random;

public class Randomizer {
	private static final Random random = new Random();
	
	//Generate random number(min, max)
	public static int randomNum(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}
}
