package main;

import main.exprInterpreter.*;
import main.exprInterpreter.datastruct.linkedlist.List;
import main.exprInterpreter.token.Token;
import main.exprInterpreter.token.TokenException;
import main.exprInterpreter.token.TokenManeger;

import main.exprInterpreter.parser.*;

public class App {

	public static void main(String[] args) {
		//Window window = new Window();
		String expr = "(2 + 2) - 2";
		try {
			List<Token> tokens = new TokenManeger(expr).tokenize();
			while(tokens.haveNext()) {
				System.out.print(tokens.getCurrent().getValue().getValue() + ", ");
			}
			System.out.println();
		} catch (TokenException e) {
			e.printStackTrace();
		}
		
		
	}

}
