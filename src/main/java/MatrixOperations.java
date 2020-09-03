public interface MatrixOperations {

//   void add(int[][] leftMatrix, int[][] rightMatrix);
//
//   void subtract(int[][] leftMatrix, int[][] rightMatrix);
//
//   void multiply(int[][] leftMatrix, int[][] rightMatrix);

    MatrixContainer add(MatrixContainer leftMatrix, MatrixContainer rightMatrix) throws WrongMatrixSizeException;

    MatrixContainer subtract(MatrixContainer leftMatrix, MatrixContainer rightMatrix) throws WrongMatrixSizeException;

    MatrixContainer multiply(MatrixContainer leftMatrix, MatrixContainer rightMatrix) throws WrongMatrixSizeException;

}
