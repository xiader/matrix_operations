import java.util.*;

public class Executor {

    private final InputResolver inputResolver = new InputResolver();
    private final List<String> matrixDefinitions;
    private final String expression;

    public Executor(String expression, String ...args) {
        this.matrixDefinitions = Arrays.asList(args);
        this.expression = expression;
    }

    public void doExecute() {
        Map<String, MatrixContainer> nameAndMatrixValue = new HashMap<>();
        for (String oneDefinition : this.matrixDefinitions) {
            MatrixContainer matrixContainer;
            try {
                matrixContainer = this.inputResolver.parseInputString(oneDefinition);
                nameAndMatrixValue.put(matrixContainer.getMatrixName(), matrixContainer);
            } catch (IllegalArgumentException e) {
                ConsoleOutPut.printError("Exception caught: " + e.getClass().getSimpleName() +". Can't "+ e.getMessage() +".");
                return;
            }
        }

        String[] expressionAsTokes =  this.inputResolver.parseInputExpression(expression);
        String[] expressionAsReversePolishNotation = ExpressionResolver.infixToRPN(expressionAsTokes);

        MatrixContainer result;
        try {
            result = calculateExpression(expressionAsReversePolishNotation, nameAndMatrixValue);
        } catch (IllegalArgumentException e) {
            ConsoleOutPut.printError("Exception caught: " + e.getClass().getSimpleName() +". Can't "+ e.getMessage() +".");
            return;
        }
        long[][] arr = result.getMatrixTemplate();
        ConsoleOutPut.print(arr);
    }


    private static MatrixContainer calculateExpression(String[] tokens, Map<String, MatrixContainer> mCm) {
        MatrixContainer returnValue;
        String operators = "+-*";
        MatrixOperations mo = new MatrixOperationsImpl();

        Deque<MatrixContainer> stack = new ArrayDeque<>();

        for (String t : tokens) {
            //push to stack if it is a matrix name
            if (!operators.contains(t)) {
                MatrixContainer mc = getByName(mCm, t);
                stack.push(mc);
            } else {
                MatrixContainer right = stack.pop();
                MatrixContainer left = stack.pop();
                switch (t) {
                    case "+":
                        stack.push(mo.add(left, right));
                        break;
                    case "-":
                        stack.push(mo.subtract(left, right));
                        break;
                    case "*":
                         stack.push(mo.multiply(left, right));
                        break;
                    default:
                        throw new UnsupportedOperationException("unrecognisable operand" + t);

                }
            }
        }

        returnValue = stack.pop();

        return returnValue;
    }

    private static MatrixContainer getByName(Map<String, MatrixContainer> mCm, String key) {
        return mCm.get(key);
    }

}
