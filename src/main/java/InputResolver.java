public class InputResolver {


	public MatrixContainer parseInputString(String strInput) {
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

	public String[] parseInputExpression(String expression) {
		return expression.split("");
	}
}
