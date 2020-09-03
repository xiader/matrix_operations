public class MatrixContainer {
    private int [][]matrixTemplate;
    private int rows;
    private int columns;

    public MatrixContainer(int[][] firstMatrix) {
        this.matrixTemplate = firstMatrix;
        this.rows = matrixTemplate.length;
        this.columns = matrixTemplate[0].length;
    }

    public int[][] getMatrixTemplate() {
        return matrixTemplate;
    }

    public void setMatrixTemplate(int[][] matrixTemplate) {
        this.matrixTemplate = matrixTemplate;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

}
