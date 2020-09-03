public class TestAssignment {


    public static void main(String[] args) {
        int [][] firstMatrix = new int[2][2];
        String firstMatrixInput = "M=[1 2 2; 0 3 1; -1 2 -4]";
        String secondMatrixInput = "N=[2 1 0; -2 -1 -1; 1 1 2]";
        InputResolver inputResolver = new InputResolver();
        inputResolver.parseInputString(firstMatrixInput);
        MatrixContainer matrixContainer = new MatrixContainer(firstMatrix);
        ExpressionResolver expressionResolver = new ExpressionResolver();
        MatrixOperations matrixOperations = new MatrixOperationsImpl();
       // matrixContainer

    }
}
