import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionResolverTest {

	@Test
	void testInfixToRPN() {
		String[]  inputTokens = new String[] {"M", "+", "M"};
		String[] tokensOrganized = ExpressionResolver.infixToRPN(inputTokens);

		String[] expected = new String[] {"M", "M", "+"};

		assertArrayEquals(expected, tokensOrganized);
	}
}