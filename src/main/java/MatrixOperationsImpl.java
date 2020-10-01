/**
 * @author Alexander
 * @version 1.0
 */
public class MatrixOperationsImpl {

	/**
	 * performs matrix addition
	 *
	 * @param leftMatrix  - first matrix as MatrixContainer
	 * @param rightMatrix - second matrix as MatrixContainer
	 * @return - result of addition as MatrixContainer
	 */
	public MatrixContainer add(MatrixContainer leftMatrix, MatrixContainer rightMatrix) {
		int leftMatrixRows = leftMatrix.getRows();
		int leftMatrixColumns = leftMatrix.getColumns();
		if (leftMatrixRows != rightMatrix.getRows() || leftMatrixColumns != rightMatrix.getColumns()) {
			throw new IllegalArgumentException("perform addition");
		}
		int[][] resultMatrix = new int[leftMatrixRows][leftMatrixColumns];
		for (int row = 0; row < leftMatrixRows; row++) {
			for (int column = 0; column < leftMatrixColumns; column++) {
				resultMatrix[row][column] = leftMatrix.getMatrixTemplate()[row][column]
						+ rightMatrix.getMatrixTemplate()[row][column];
			}
		}

		return new MatrixContainer(resultMatrix, null);
	}

	/**
	 * performs matrix subtraction
	 *
	 * @param leftMatrix  - first matrix as MatrixContainer
	 * @param rightMatrix - second matrix as MatrixContainer
	 * @return - result of subtraction as MatrixContainer
	 */
	public MatrixContainer subtract(MatrixContainer leftMatrix, MatrixContainer rightMatrix) {
		int leftMatrixRows = leftMatrix.getRows();
		int leftMatrixColumns = leftMatrix.getColumns();

		if (leftMatrixRows != rightMatrix.getRows() || leftMatrixColumns != rightMatrix.getColumns()) {
			throw new IllegalArgumentException("perform subtraction");
		}
		int[][] resultMatrix = new int[leftMatrixRows][leftMatrixColumns];
		for (int row = 0; row < leftMatrixRows; row++) {
			for (int column = 0; column < leftMatrixColumns; column++) {
				resultMatrix[row][column] = leftMatrix.getMatrixTemplate()[row][column]
						- rightMatrix.getMatrixTemplate()[row][column];
			}
		}

		return new MatrixContainer(resultMatrix, null);
	}

	/**
	 * performs matrix multiplication
	 *
	 * @param leftMatrix  - first matrix as MatrixContainer
	 * @param rightMatrix - second matrix as MatrixContainer
	 * @return - result of multiplication as MatrixContainer
	 */
	public MatrixContainer multiply(MatrixContainer leftMatrix, MatrixContainer rightMatrix) {
		int leftMatrixRows = leftMatrix.getRows();
		int leftMatrixColumns = leftMatrix.getColumns();

		int rightMatrixRows = rightMatrix.getRows();
		int rightMatrixColumns = rightMatrix.getColumns();

		if (leftMatrixColumns != rightMatrixRows) {
			throw new IllegalArgumentException("perform multiplication");
		}

		int[][] resultMatrix = new int[leftMatrixRows][rightMatrixColumns];
		for (int row = 0; row < leftMatrixRows; row++) {
			for (int column = 0; column < rightMatrixColumns; column++) {
				for (int rightMatrixColomn = 0; rightMatrixColomn < leftMatrixColumns; rightMatrixColomn++) {
					resultMatrix[row][column] += leftMatrix.getMatrixTemplate()[row][rightMatrixColomn]
							* rightMatrix.getMatrixTemplate()[rightMatrixColomn][column];
				}
			}
		}

		return new MatrixContainer(resultMatrix, null);
	}
}
