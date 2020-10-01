import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatrixOperationsImplTest {

	@Test
	void testAddition() {
		MatrixOperationsImpl mc = new MatrixOperationsImpl();
		int[][] twoDArr = new int[3][3];
		twoDArr[0][0] = -9;
		twoDArr[0][1] = 5;
		twoDArr[0][2] = 9;

		twoDArr[1][0] = -7;
		twoDArr[1][1] = 8;
		twoDArr[1][2] = 7;

		twoDArr[2][0] = 10;
		twoDArr[2][1] = -3;
		twoDArr[2][2] = 3;

		MatrixContainer matrixContainer = new MatrixContainer(twoDArr, "M");
		MatrixContainer matrixContainer2 = new MatrixContainer(twoDArr, "M");
		MatrixContainer result = mc.add(matrixContainer, matrixContainer2);

		int[][] expected = new int[3][3];
		expected[0][0] = -18;
		expected[0][1] = 10;
		expected[0][2] = 18;

		expected[1][0] = -14;
		expected[1][1] = 16;
		expected[1][2] = 14;

		expected[2][0] = 20;
		expected[2][1] = -6;
		expected[2][2] = 6;

		boolean isEqual = MatrixContainer.equal(expected, result.getMatrixTemplate());
		assertTrue(isEqual);
	}

	@Test
	void testSubtraction() {
		MatrixOperationsImpl mc = new MatrixOperationsImpl();
		int[][] twoDArr = new int[3][3];
		twoDArr[0][0] = -9;
		twoDArr[0][1] = 5;
		twoDArr[0][2] = 9;

		twoDArr[1][0] = -7;
		twoDArr[1][1] = 8;
		twoDArr[1][2] = 7;

		twoDArr[2][0] = 10;
		twoDArr[2][1] = -3;
		twoDArr[2][2] = 3;

		MatrixContainer matrixContainer = new MatrixContainer(twoDArr, "M");
		MatrixContainer matrixContainer2 = new MatrixContainer(twoDArr, "M");
		MatrixContainer result = mc.subtract(matrixContainer, matrixContainer2);

		int[][] expected = new int[3][3];
		expected[0][0] = 0;
		expected[0][1] = 0;
		expected[0][2] = 0;

		expected[1][0] = 0;
		expected[1][1] = 0;
		expected[1][2] = 0;

		expected[2][0] = 0;
		expected[2][1] = 0;
		expected[2][2] = 0;

		boolean isEqual = MatrixContainer.equal(expected, result.getMatrixTemplate());
		assertTrue(isEqual);
	}

	@Test
	void testMultiplication() {
		MatrixOperationsImpl mc = new MatrixOperationsImpl();
		int[][] twoDArr = new int[3][3];
		twoDArr[0][0] = -9;
		twoDArr[0][1] = 5;
		twoDArr[0][2] = 9;

		twoDArr[1][0] = -7;
		twoDArr[1][1] = 8;
		twoDArr[1][2] = 7;

		twoDArr[2][0] = 10;
		twoDArr[2][1] = -3;
		twoDArr[2][2] = 3;

		MatrixContainer matrixContainer = new MatrixContainer(twoDArr, "M");
		MatrixContainer matrixContainer2 = new MatrixContainer(twoDArr, "M");
		MatrixContainer result = mc.multiply(matrixContainer, matrixContainer2);

		int[][] expected = new int[3][3];
		expected[0][0] = 136;
		expected[0][1] = -32;
		expected[0][2] = -19;

		expected[1][0] = 77;
		expected[1][1] = 8;
		expected[1][2] = 14;

		expected[2][0] = -39;
		expected[2][1] = 17;
		expected[2][2] = 78;

		boolean isEqual = MatrixContainer.equal(expected, result.getMatrixTemplate());
		assertTrue(isEqual);
	}

}