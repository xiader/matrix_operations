
public class MatrixOperationsImpl implements MatrixOperations {


    public MatrixContainer add(MatrixContainer leftMatrix, MatrixContainer rightMatrix) throws WrongMatrixSizeException {
        if(leftMatrix.getRows() != rightMatrix.getRows() || leftMatrix.getColumns() != rightMatrix.getColumns()){
            throw new WrongMatrixSizeException();
        }
        int [][] resultMatrix = new int[leftMatrix.getRows()][leftMatrix.getColumns()];
        for (int row = 0; row < leftMatrix.getRows(); row++){
            for (int column = 0; column < leftMatrix.getColumns(); column++){
                resultMatrix[row][column] = leftMatrix.getMatrixTemplate()[row][column]
                        + rightMatrix.getMatrixTemplate()[row][column];
            }
        }
        return new MatrixContainer(resultMatrix);
    }

    public MatrixContainer subtract(MatrixContainer leftMatrix, MatrixContainer rightMatrix) throws WrongMatrixSizeException {
        if(leftMatrix.getRows() != rightMatrix.getRows() || leftMatrix.getColumns() != rightMatrix.getColumns()){
            throw new WrongMatrixSizeException();
        }
        int [][] resultMatrix = new int[leftMatrix.getRows()][leftMatrix.getColumns()];
        for (int row = 0; row < leftMatrix.getRows(); row++){
            for (int column = 0; column < leftMatrix.getColumns(); column++){
                resultMatrix[row][column] = leftMatrix.getMatrixTemplate()[row][column]
                        - rightMatrix.getMatrixTemplate()[row][column];
            }
        }
        return new MatrixContainer(resultMatrix);
    }

    public MatrixContainer multiply(MatrixContainer leftMatrix, MatrixContainer rightMatrix) throws WrongMatrixSizeException {
        if(leftMatrix.getRows() != rightMatrix.getColumns()){
            throw new WrongMatrixSizeException();
        }
        int [][] resultMatrix = new int[leftMatrix.getColumns()][rightMatrix.getRows()];
        for (int row = 0; row < leftMatrix.getRows(); row++){
            for (int column = 0; column < leftMatrix.getColumns(); column++){
                for (int rightMatrixColomn = 0; rightMatrixColomn < rightMatrix.getRows(); rightMatrixColomn++ ){
                    resultMatrix[row][column] += leftMatrix.getMatrixTemplate()[row][rightMatrixColomn]
                            * rightMatrix.getMatrixTemplate()[rightMatrixColomn][column];
                }

            }
        }
        return new MatrixContainer(resultMatrix);
    }
}
