public class ConsoleOutPut {

	private ConsoleOutPut () {}

	public static void print(long[][] arr) {
		StringBuilder stringBuilder = new StringBuilder("[");
		for (long[] ints : arr) {
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

	public static void printError(String str) {
		System.err.println(str);
	}
}
