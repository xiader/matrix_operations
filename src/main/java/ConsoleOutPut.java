/**
 * @author Alexander
 * @version 1.0
 */
public class ConsoleOutPut {

	private ConsoleOutPut() {
	}

	/**
	 * prints array to console in specific format
	 *
	 * @param arr - array as two dimensional array of int
	 */
	public static void print(int[][] arr) {
		StringBuilder stringBuilder = new StringBuilder("[");
		for (int[] ints : arr) {
			for (int j = 0; (ints != null && j < ints.length); j++) {
				stringBuilder.append(ints[j]).append(", ");
			}
			stringBuilder.setLength(stringBuilder.length() - 2);
			stringBuilder.append("; ");
		}
		stringBuilder.setLength(stringBuilder.length() - 2);
		stringBuilder.append("]");
		System.out.println(stringBuilder);
	}

	/**
	 * prints error to console
	 *
	 * @param str - string to print
	 */
	public static void printError(String str) {
		System.err.println(str);
	}
}
