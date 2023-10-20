package utilities;
import java.util.Random;

public class Randomizer {
	private static final Random random = new Random();
	
	//Generate random number(min, max)
	public static int randomNum(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}
	
	//Generate 4 digit code
	public static String generateRandom4DigitCode() {
		int min = 1000;
		int max = 9999;
		
		//Generate random number between min and max
		int randomCode = randomNum(min, max);
		
		//Convert the random number to string
		String code = String.format("%04d", randomCode);
		return code;
	}
}
