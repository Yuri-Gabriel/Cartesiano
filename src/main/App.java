package main;

import main.exprInterpreter.calculator.Calculator;

public class App {

	public static void main(String[] args) throws Exception {
		// try {
		// 	Window window = new Window();
		// } catch (Exception err) {
		// 	System.out.println(err.getLocalizedMessage());
		// }
		String expr = "log(x) + ln(x)";
		Calculator calculator = new Calculator(expr);
		calculator.setX_value(3.14 / 2);
		double result = calculator.calculate();
		System.out.println();
		System.out.println(expr + " = " + result);
	}
}
