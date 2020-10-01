import java.util.*;

/**
 * @author Alexander
 * @version 1.0
 */
public class Executor {

	private final InputResolver inputResolver = new InputResolver();
	private final List<String> matrixDefinitions;
	private final String expression;

	/**
	 * creates executor to perform actions over incoming parameters
	 *
	 * @param expression - variables with operators, example: P+Q*P+Q
	 * @param args       - strings in format like: Q=[2 -8 8 0; -1 2 -4 2]
	 */
	public Executor(String expression, String... args) {
		this.matrixDefinitions = Arrays.asList(args);
		this.expression = expression;
	}

	/**
	 * starts execution
	 */
	public void doExecute() {
		Map<String, MatrixContainer> nameAndMatrixValue = new HashMap<>();
		for (String oneDefinition : this.matrixDefinitions) {
			MatrixContainer matrixContainer;
			try {
				matrixContainer = this.inputResolver.parse(oneDefinition);
				nameAndMatrixValue.put(matrixContainer.getMatrixName(), matrixContainer);
			} catch (IllegalArgumentException e) {
				ConsoleOutPut.printError("Exception caught: " + e.getClass().getSimpleName() + ". Can't " + e.getMessage() + ".");
				return;
			}
		}

		String[] expressionAsTokes = this.inputResolver.parseInputExpression(expression);
		String[] expressionAsReversePolishNotation = ExpressionResolver.infixToRPN(expressionAsTokes);

		MatrixContainer result;
		try {
			result = calculateExpression(expressionAsReversePolishNotation, nameAndMatrixValue);
		} catch (IllegalArgumentException e) {
			ConsoleOutPut.printError("Exception caught: " + e.getClass().getSimpleName() + ". Can't " + e.getMessage() + ".");
			return;
		}
		int[][] arr = result.getMatrixTemplate();
		ConsoleOutPut.print(arr);
	}

	//performs operations in required order
	private static MatrixContainer calculateExpression(String[] tokens, Map<String, MatrixContainer> matrixContainerMap) {
		String operators = "+-*";
		MatrixOperationsImpl matrixOperations = new MatrixOperationsImpl();

		Deque<MatrixContainer> stack = new ArrayDeque<>();

		for (String t : tokens) {
			//push to stack if it is a matrix name
			if (!operators.contains(t)) {
				MatrixContainer mc = getByName(matrixContainerMap, t);
				stack.push(mc);
			} else {
				MatrixContainer right = stack.pop();
				MatrixContainer left = stack.pop();
				switch (t) {
					case "+":
						stack.push(matrixOperations.add(left, right));
						break;
					case "-":
						stack.push(matrixOperations.subtract(left, right));
						break;
					case "*":
						stack.push(matrixOperations.multiply(left, right));
						break;
					default:
						throw new UnsupportedOperationException("unrecognisable operand" + t);

				}
			}
		}

		return stack.pop();
	}

	private static MatrixContainer getByName(Map<String, MatrixContainer> mCm, String key) {
		return mCm.get(key);
	}

}
