public class MatrixContainer {
    private final String matrixName;
    private long [][]matrixTemplate;
    private int rows;
    private int columns;

    public MatrixContainer(long[][] firstMatrix, String matrixName) {
        this.matrixTemplate = firstMatrix;
        this.rows = matrixTemplate.length;
        this.columns = matrixTemplate[0].length;
        this.matrixName = matrixName;
    }

    public long[][] getMatrixTemplate() {
        return matrixTemplate;
    }

    public void setMatrixTemplate(long[][] matrixTemplate) {
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

    public String getMatrixName() {
        return matrixName;
    }
}
