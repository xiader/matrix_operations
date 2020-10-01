import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputResolverTest {


	@Test
	void testParseStringIntoMatrixContainer(){
		String input = "K=[-10 0 2; -6 10 -6; -9 2 0]";
		InputResolver ir = new InputResolver();
		MatrixContainer actual = ir.parse(input);

		int[][] twoDArr = new int[3][3];

		twoDArr[0][0] = -10;
		twoDArr[0][1] = 0;
		twoDArr[0][2] = 2;

		twoDArr[1][0] = -6;
		twoDArr[1][1] = 10;
		twoDArr[1][2] = -6;

		twoDArr[2][0] = -9;
		twoDArr[2][1] = 2;
		twoDArr[2][2] = 0;

		MatrixContainer expected = new MatrixContainer(twoDArr, "K");

		assertEquals(expected, actual);
	}
}