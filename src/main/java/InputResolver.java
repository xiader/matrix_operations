import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alexander
 * @version 1.0
 */
public class InputResolver {

	private static final String VALIDATION_REGEX = "^\\w=\\[(( ?-?[0-9]+ ?)+;?)+]$";
	private final Pattern pattern = Pattern.compile(VALIDATION_REGEX);

	/**
	 * transforms matrix string into object representation
	 *
	 * @param matrixAsString- matrix as string, valid format example: P=[6 0 9; -3 1 9; -9 2 10]
	 * @return - encapsulated matrix with its name
	 */
	public MatrixContainer parse(String matrixAsString) {
		validate(matrixAsString);

		String contentInBrackets = matrixAsString.substring(matrixAsString.indexOf('[') + 1, matrixAsString.length() - 1);
		String matrixName = matrixAsString.substring(0, matrixAsString.indexOf('[') - 1);
		String[] parts = contentInBrackets.split("; ");
		int lengthOfRows = parts.length;
		int lengthColumn = parts[0].split(" ").length;
		int[][] twoDArr = new int[lengthOfRows][lengthColumn];
		for (int i = 0; i < lengthOfRows; i++) {
			String[] rows = parts[i].split(" ");
			for (int y = 0; y < lengthColumn; y++) {
				String row = rows[y];
				twoDArr[i][y] = Integer.parseInt(row);
			}
		}

		return new MatrixContainer(twoDArr, matrixName);
	}

	/**
	 * Checks if string satisfies required format
	 *
	 * @param matrixAsString - matrix as string, format example: P=[6 0 9; -3 1 9; -9 2 10]
	 */
	private void validate(String matrixAsString) {
		Matcher matcher = pattern.matcher(matrixAsString);
		boolean matchFound = matcher.matches();
		if (!matchFound) {
			throw new IllegalArgumentException("read matrix");
		}
	}

	/**
	 * tokenize string into array
	 *
	 * @param expression - string like: P+Q*P+Q
	 * @return - characters in array
	 */
	public String[] parseInputExpression(String expression) {
		return expression.split("");
	}
}
