import java.util.*;

public class ExpressionResolver {
	// Associativity constants for operators
	private static final int LEFT_ASSOC = 0;
	private static final int RIGHT_ASSOC = 1;

	private static final Map<String, int[]> OPERATORS = new HashMap<>();

	static {
		// Map<"token", []{precendence, associativity}>
		OPERATORS.put("+", new int[]{0, LEFT_ASSOC});
		OPERATORS.put("-", new int[]{0, LEFT_ASSOC});
		OPERATORS.put("*", new int[]{5, LEFT_ASSOC});
	}

	private ExpressionResolver() {
	}

	private static boolean isOperator(String token) {
		return OPERATORS.containsKey(token);
	}

	// Test associativity of operator token
	private static boolean isAssociative(String token, int type) {
		if (!isOperator(token)) {
			throw new IllegalArgumentException("Invalid token: " + token);
		}

		return OPERATORS.get(token)[1] == type;
	}

	// Compare precedence of operators.
	private static int comparePrecedence(String token1, String token2) {
		if (!isOperator(token1) || !isOperator(token2)) {
			throw new IllegalArgumentException("Invalid tokens: " + token1
					+ " " + token2);
		}
		return OPERATORS.get(token1)[0] - OPERATORS.get(token2)[0];
	}

	// Convert infix expression (2 + 2) format into reverse Polish notation (2 2 +)
	public static String[] infixToRPN(String[] inputTokens) {
		ArrayList<String> out = new ArrayList<>();
		Deque<String> stack = new ArrayDeque<>();
		for (String token : inputTokens) {
			if (isOperator(token)) {
				// While stack not empty AND stack top element is an operator
				while (!stack.isEmpty() && isOperator(stack.peek())) {
					if ((isAssociative(token, LEFT_ASSOC) &&
							comparePrecedence(token, stack.peek()) <= 0) ||
							(isAssociative(token, RIGHT_ASSOC) &&
									comparePrecedence(token, stack.peek()) < 0)) {
						out.add(stack.pop());
						continue;
					}
					break;
				}
				// Push the new operator on the stack
				stack.push(token);
			}
			//token is a matrix name
			else {
				out.add(token);
			}
		}
		while (!stack.isEmpty()) {
			out.add(stack.pop());
		}
		String[] output = new String[out.size()];

		return out.toArray(output);
	}







}
