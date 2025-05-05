package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.exprInterpreter.TokenManeger;
import main.exprInterpreter.datastruct.linkedlist.List;
import main.exprInterpreter.Token;
import main.exprInterpreter.TokenException;

public class TokenManagerTest {
	
	@Test
	public void tokenize_returns_list_of_tokens() throws TokenException {
		String expr = "2 + 2";
		Assertions.assertTrue(new TokenManeger(expr).tokenize() instanceof List<Token>);
	}
	@Test
	public void tokenize_dont_accept_other_letters() throws TokenException {
		String expr = "2 + 2 pao";
		Assertions.assertThrows(TokenException.class, () -> new TokenManeger(expr).tokenize());
	}
	@Test
	public void tokenize_dont_accept_words() throws TokenException {
		String expr = "2 + 2 a";
		Assertions.assertThrows(TokenException.class, () -> new TokenManeger(expr).tokenize());
	}
}
