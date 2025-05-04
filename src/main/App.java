package main;

import main.exprInterpreter.*;
import main.exprInterpreter.datastruct.linkedlist.List;

public class App {

	public static void main(String[] args) {
		//Window window = new Window();
		String expr = "x ^ 2 + 9";
		List<Token> list = TokenMagener.tokenize(expr);
		while(list.haveNext()) {
			System.out.print(getstr(list.getCurrent().getValue().getValue()) + ", ");
		}
	}
	
	private static String getstr(char[] list) {
		String str = "";
		for(char c : list) {
			str += c;
		}
		return str;
	}

}
