package main;

import main.exprInterpreter.datastruct.linkedlist.List;
import main.exprInterpreter.nodetype.NodeCalc;
import main.exprInterpreter.token.Token;
import main.exprInterpreter.token.TokenException;
import main.exprInterpreter.token.TokenManeger;

import main.exprInterpreter.parser.*;

public class App {

	public static void main(String[] args) {
		//Window window = new Window();
		String expr = "1 + 3 * 4 - 5";
		try {
			List<Token> tokens = new TokenManeger(expr).tokenize();
			while(tokens.haveNext()) {
				System.out.print(tokens.getCurrent().getValue().getValue() + ", ");
			}
			NodeCalc root = new ParserExpr(tokens).parse();
			System.out.println("\nFuncionou!");
		} catch (TokenException err) {
			err.printStackTrace();
		} catch (ParserException err) {
			err.printStackTrace();;
		}
		
		
	}

}
