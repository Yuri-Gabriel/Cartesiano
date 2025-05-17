package main;

import main.exprInterpreter.datastruct.*;

import main.exprInterpreter.token.Token;
import main.exprInterpreter.token.TokenManager;

import main.exprInterpreter.parser.*;
import main.exprInterpreter.parser.nodetype.NodeExpression;

public class App {

	public static void main(String[] args) {
		//Window window = new Window();
		String expr = "";
		try {
			Queue<Token> tokens = new TokenManager(expr).tokenize();
			while(tokens.havePrev()) {
				System.out.print(toString(tokens.current.getValue().getValue()) + ", ");
			}
			System.out.println();
			NodeExpression tree = new ParserExpr(tokens).parse();
			System.out.println("\nFuncionou!");
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	private static String toString(char[] value) {
		String text = "";
		for(char c : value) {
			text += c;
		}
		return text;
	}

}
