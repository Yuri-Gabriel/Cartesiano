package main;

import main.exprInterpreter.datastruct.linkedlist.List;
import main.exprInterpreter.token.Token;
import main.exprInterpreter.token.TokenException;
import main.exprInterpreter.token.TokenManeger;

import main.exprInterpreter.parser.*;
import main.exprInterpreter.parser.nodetype.NodeExpression;

public class App {

	public static void main(String[] args) {
		//Window window = new Window();
		String expr = "1 * 1 + 1";
		try {
			List<Token> tokens = new TokenManeger(expr).tokenize();
			while(tokens.haveNext()) {
				System.out.print(tokens.getCurrent().getValue().getValue() + ", ");
			}
			NodeExpression tree = new ParserExpr(tokens).parse();
			System.out.println("\nFuncionou!");
		} catch (Exception err) {
			err.printStackTrace();
		}
		
		
	}

}
