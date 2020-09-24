
public class MatrixOperationsImpl implements MatrixOperations {


    public MatrixContainer add(MatrixContainer leftMatrix, MatrixContainer rightMatrix) {
        if (leftMatrix.getRows() != rightMatrix.getRows() || leftMatrix.getColumns() != rightMatrix.getColumns()) {
            throw new IllegalArgumentException("perform addition");
        }
        long[][] resultMatrix = new long[leftMatrix.getRows()][leftMatrix.getColumns()];
        for (int row = 0; row < leftMatrix.getRows(); row++) {
            for (int column = 0; column < leftMatrix.getColumns(); column++) {
                resultMatrix[row][column] = leftMatrix.getMatrixTemplate()[row][column]
                        + rightMatrix.getMatrixTemplate()[row][column];
            }
        }
        return new MatrixContainer(resultMatrix, null);
    }

    public MatrixContainer subtract(MatrixContainer leftMatrix, MatrixContainer rightMatrix) {
        if (leftMatrix.getRows() != rightMatrix.getRows() || leftMatrix.getColumns() != rightMatrix.getColumns()) {
            throw new IllegalArgumentException("perform subtraction");
        }
        long[][] resultMatrix = new long[leftMatrix.getRows()][leftMatrix.getColumns()];
        for (int row = 0; row < leftMatrix.getRows(); row++) {
            for (int column = 0; column < leftMatrix.getColumns(); column++) {
                resultMatrix[row][column] = leftMatrix.getMatrixTemplate()[row][column]
                        - rightMatrix.getMatrixTemplate()[row][column];
            }
        }
        return new MatrixContainer(resultMatrix, null);
    }

    public MatrixContainer multiply(MatrixContainer leftMatrix, MatrixContainer rightMatrix) {
        int leftMatrixRows = leftMatrix.getRows();
        int leftMatrixColumns = leftMatrix.getColumns();

        int rightMatrixRows = rightMatrix.getRows();
        int rightMatrixColumns = rightMatrix.getColumns();

        if (leftMatrixColumns != rightMatrixRows) {
            throw new IllegalArgumentException("perform multiplication");
        }

        long[][] resultMatrix = new long[leftMatrixRows][rightMatrixColumns];
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
