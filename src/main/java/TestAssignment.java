import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestAssignment {

    /**
     *
     * Program start point. Program was written according to https://github.com/lanavasilieva/Tasks-Library/blob/master/Matrix-Operations/matrix-operations.md
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> res = new ArrayList<>();
        String expression = null;
        boolean isAwaitExpression = false;
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (isAwaitExpression) {
                expression = s;
            }
            if (expression != null) {
                Executor executor = new Executor(expression, getStringArray(res));
                executor.doExecute();

                isAwaitExpression = false;
                expression = null;
                res = new ArrayList<>();
            } else {
                if (s != null) {
                    if (s.equals("")) {
                        isAwaitExpression = true;
                        continue;
                    }
                    res.add(s);
                }
            }

        }
    }

    private static String[] getStringArray(List<String> arr) {
        String[] str = new String[arr.size()];
        for (int j = 0; j < arr.size(); j++) {
            str[j] = arr.get(j);
        }

        return str;
    }
}
