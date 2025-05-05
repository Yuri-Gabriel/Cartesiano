package main;

import main.exprInterpreter.*;
import main.exprInterpreter.datastruct.linkedlist.List;

public class App {

	public static void main(String[] args) {
		//Window window = new Window();
		String expr = "x ^ 31 + 3 - 100 / 0 * 21";
		try {
			List<Token> list = new TokenManeger(expr).tokenize();
			while(list.haveNext()) {
				System.out.print(list.getCurrent().getValue().getValue() + ", ");
			}
		} catch (TokenException e) {
			e.printStackTrace();
		}
		
		
	}

}
