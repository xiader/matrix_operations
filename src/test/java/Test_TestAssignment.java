
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test_TestAssignment {

    @Test
    void testCases() {
        String firstMatrixInput = "S=[1]";
        String secondMatrixInput = "P=[1]";
        String expression = "S+P";
        Executor executor1 = new Executor(expression, firstMatrixInput, secondMatrixInput);
        executor1.doExecute();
        System.out.println();



        String m1 = "B=[5 2 4; 0 2 -1; 3 -5 -4]";
        String m2 = "E=[-6 -5 -8; -1 -1 -10; 10 0 -7]";
        String m3 = "R=[-1 -7 6; -2 9 -4; 6 -10 2]";
        String expression2 = "R+E+B";
        Executor executor2 = new Executor(expression2, m1, m2, m3);
        executor2.doExecute();
        System.out.println();



        String n1 = "K=[-10 0 2; -6 10 -6; -9 2 0]";
        String n2 = "D=[0 6 7]";
        String n3 = "M=[10 -5 -4]";
        String expression3 = "D*K+M";
        Executor executor3 = new Executor(expression3, n1, n2, n3);
        executor3.doExecute();
        System.out.println();



        String b1 = "R=[6 9; -3 9; -9 10]";
        String b2 = "K=[2 -8 8; -1 2 -4]";
        String expression4 = "K+K*R*K";
        Executor executor4 = new Executor(expression4, b1, b2);
        executor4.doExecute();
        System.out.println();



        String fourthMatrixInput = "M=[-9 5 9; -7 8 7; 10 -3 3]";
        //String expression5 = "M*M+M-M";
        String expression5 = "M+M";
        Executor executor5 = new Executor(expression5, fourthMatrixInput);
        executor5.doExecute();
        System.out.println();


        String y1 = "R=[-9 5;9 -7 8x 7; 10 -3 3]`";
        String expression6 = "K+K*R*K";
        Executor executor6 = new Executor(expression6, y1);
        executor6.doExecute();
        System.out.println();



        String i1 = "P=[6 0 9; -3 1 9; -9 2 10]";
        String i2 = "Q=[2 -8 8 0; -1 2 -4 2]";
        String expression7 = "P+Q";
        Executor executor7 = new Executor(expression7, i1, i2);
        executor7.doExecute();
        System.out.println();



        String pub03In1 = "Q=[9 8; -10 -4; -3 -9]";
        String pub03In2 = "M=[-6 4; 4 10]";
        String pub03In3 = "G=[-6 0; -2 4; -9 2]";
        String pub03In4 = "F=[5 -5; 0 6; 3 -4]";
        String expressionPub03In = "G-F-F+Q*M-Q";

        Executor executor8 = new Executor(expressionPub03In, pub03In1, pub03In2, pub03In3, pub03In4);
        executor8.doExecute();
        System.out.println();

        assertTrue(true);
    }
}