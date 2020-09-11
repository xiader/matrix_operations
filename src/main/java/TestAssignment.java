public class TestAssignment {


	public static void main(String[] args) {

//		String fourthMatrixInput = "M=[-9 5 9; -7 8 7; 10 -3 3]";
//		String expression = "M*M+M-M";
//
//		Executor executor = new Executor(expression, fourthMatrixInput, fourthMatrixInput);
//
//		executor.doExecute();

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
		String expression4 = "R*K";

		Executor executor4 = new Executor(expression4, b1, b2);
		executor4.doExecute();
		System.out.println();
//
//matrix.multiply()

	}
}
