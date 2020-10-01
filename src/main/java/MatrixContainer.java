import java.util.Arrays;
import java.util.Objects;

/**
 * @author Alexander
 * @version 1.0
 */
public class MatrixContainer {
    private final String matrixName;
    private int [][]matrixTemplate;
    private int rows;
    private int columns;

    public MatrixContainer(int[][] matrix, String matrixName) {
        this.matrixTemplate = matrix;
        this.rows = matrixTemplate.length;
        this.columns = matrixTemplate[0].length;
        this.matrixName = matrixName;
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

    public String getMatrixName() {
        return matrixName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatrixContainer that = (MatrixContainer) o;
        return rows == that.rows &&
                columns == that.columns &&
                Objects.equals(matrixName, that.matrixName) &&
                equal(matrixTemplate, that.matrixTemplate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(matrixName, rows, columns);
        result = 31 * result + Arrays.hashCode(matrixTemplate);
        return result;
    }


    public static boolean equal(final int[][] arr1, final int[][] arr2) {
        if (arr1 == null) {
            return (arr2 == null);
        }
        if (arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!Arrays.equals(arr1[i], arr2[i])) {
                return false;
            }
        }
        return true;
    }
}
