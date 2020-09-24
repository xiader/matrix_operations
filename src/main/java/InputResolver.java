import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputResolver {

	private static final String VALIDATION_REGEX = "^\\w=\\[(( ?-?[0-9]+ ?){1,};?){1,}\\]$";
	private final Pattern pattern = Pattern.compile(VALIDATION_REGEX);

	public MatrixContainer parseInputString(String strInput) {
		validate(strInput);

		String plainStr = strInput.substring(strInput.indexOf('[') + 1, strInput.length() - 1);
		String[] parts = plainStr.split("; ");
		int lengthOfRows = parts.length;
		int lengthColumn = parts[0].split(" ").length;
		long[][] twoDArr = new long[lengthOfRows][lengthColumn];
		for (int i = 0; i < lengthOfRows; i++) {
			String[] rows = parts[i].split(" ");
			for (int y = 0; y < lengthColumn; y++) {
				String row = rows[y];
					twoDArr[i][y] = Integer.parseInt(row);
			}
		}

		String matrixName = strInput.substring(0, strInput.indexOf('[') - 1);

		return new MatrixContainer(twoDArr, matrixName);
	}

	private void validate(String strInput) {
		Matcher matcher = pattern.matcher(strInput);
		boolean matchFound = matcher.matches();
		if (!matchFound) {
			throw new IllegalArgumentException("read matrix");
		}
	}

	public String[] parseInputExpression(String expression) {
		return expression.split("");
	}
}
