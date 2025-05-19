package main;

import main.exprInterpreter.calculator.Calculator;

public class App {

	public static void main(String[] args) throws Exception {
		// try {
		// 	Window window = new Window();
		// } catch (Exception err) {
		// 	System.out.println(err.getLocalizedMessage());
		// }
		String expr = "sin(x)";
		Calculator calculator = new Calculator(expr);
		calculator.setX_value(1.0);
		double result = calculator.calculate();
	}
}
