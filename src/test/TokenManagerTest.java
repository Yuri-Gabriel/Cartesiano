package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import main.exprInterpreter.datastruct.*;
import main.exprInterpreter.token.Token;
import main.exprInterpreter.token.TokenException;
import main.exprInterpreter.token.TokenManager;

@ExtendWith(TimingExtension.class)
public class TokenManagerTest {
	
	// @Test
	// public void tokenize_returns_list_of_tokens() throws TokenException {
	// 	String expr = "2 + 2";
	// 	Assertions.assertTrue(new TokenManeger(expr).tokenize() instanceof List<Token>);
	// }
	@Test
	public void tokenize_dont_accept_other_letters() throws TokenException {
		String expr = "2 + 2 pao";
		Assertions.assertThrows(TokenException.class, () -> new TokenManager(expr).tokenize());
	}
	@Test
	public void tokenize_dont_accept_words() throws TokenException {
		String expr = "2 + 2 a";
		Assertions.assertThrows(TokenException.class, () -> new TokenManager(expr).tokenize());
	}
}
