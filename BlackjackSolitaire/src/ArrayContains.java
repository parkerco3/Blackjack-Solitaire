import java.util.Arrays;
import java.util.stream.*;
public class ArrayContains {
	
	public static void check(int[] arr, int checkValue) {
		boolean test = false;
		for (int element : arr) {
			if (element == checkValue) {
				test = true;
				break;
			}
		}
			
	}

}
