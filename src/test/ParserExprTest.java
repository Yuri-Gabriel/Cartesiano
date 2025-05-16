package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import main.exprInterpreter.datastruct.linkedlist.*;

import main.exprInterpreter.parser.ParserExpr;
import main.exprInterpreter.parser.nodetype.NodeTerm;
import main.exprInterpreter.parser.ParserException;

import main.exprInterpreter.token.TokenManeger;
import main.exprInterpreter.token.Token;
import main.exprInterpreter.token.TokenException;

@ExtendWith(TimingExtension.class)
public class ParserExprTest {
//
//    @Test
//    public void expr_with_one_operator() throws TokenException, ParserException {
//        String expr = "2 + 2";
//        List<Token> tokens = new TokenManeger(expr).tokenize();
//        NodeCalc correct_tree = new NodeCalc(
//            null,
//            new NodeExpr(
//                new NodeTerm(2)
//            ),
//            '+',
//            new NodeExpr(
//                new NodeTerm(2)
//            )
//        );
//        NodeCalc tree = new ParserExpr(tokens).parse();
//        Assertions.assertTrue(tree.equals(correct_tree));
//    }
//
//    @Test
//    public void expr_with_parentheses() throws TokenException, ParserException {
//        String expr = "2 + (2 + 2)";
//        List<Token> tokens = new TokenManeger(expr).tokenize();
//        NodeCalc correct_tree = null;
//        NodeCalc parentheses_calc = new NodeCalc(
//            correct_tree,
//            new NodeExpr(
//                new NodeTerm(2)
//            ),
//            '+',
//            new NodeExpr(
//                new NodeTerm(2)
//            )
//        );
//        correct_tree = new NodeCalc(
//            null,
//            new NodeExpr(
//                new NodeTerm(2)
//            ),
//            '+',
//            new NodeExpr(
//                parentheses_calc
//            )
//        );
//        NodeCalc tree = new ParserExpr(tokens).parse();
//        Assertions.assertTrue(tree.equals(correct_tree));
//    }
//
//    @Test
//    public void expr_with_operator_more_precedent() throws TokenException, ParserException  {
//        String expr = "2 + 2 * 2";
//        List<Token> tokens = new TokenManeger(expr).tokenize();
//        NodeCalc correct_tree = null;
//        NodeCalc parentheses_calc = new NodeCalc(
//            correct_tree,
//            new NodeExpr(
//                new NodeTerm(2)
//            ),
//            '*',
//            new NodeExpr(
//                new NodeTerm(2)
//            )
//        );
//        correct_tree = new NodeCalc(
//            null,
//            new NodeExpr(
//                new NodeTerm(2)
//            ),
//            '+',
//            new NodeExpr(
//                parentheses_calc
//            )
//        );
//        NodeCalc tree = new ParserExpr(tokens).parse();
//        Assertions.assertTrue(tree.equals(correct_tree));
//    }
//
//    @Test
//    public void expr_with_operator_more_precedent_and_less_precedent() throws TokenException, ParserException  {
//        String expr = "2 + 2 * 2 - 7";
//        List<Token> tokens = new TokenManeger(expr).tokenize();
//        NodeCalc mult_calc = null;
//        NodeCalc mid_calc = null;
//        NodeCalc correct_tree = new NodeCalc(
//            null,
//            null,
//            '-',
//            new NodeExpr(
//                new NodeTerm(7)
//            )
//        );
//        mid_calc = new NodeCalc(
//            correct_tree,
//            new NodeExpr(
//                new NodeTerm(2)
//            ),
//            '+',
//            null
//        );
//        mult_calc = new NodeCalc(
//            mid_calc,
//            new NodeExpr(
//                new NodeTerm(2)
//            ),
//            '*',
//            new NodeExpr(
//                new NodeTerm(2)
//            )
//        );
//        mid_calc.setRight_expr(new NodeExpr(mult_calc));
//        correct_tree.setLeft_expr(new NodeExpr(mid_calc));
//        NodeCalc tree = new ParserExpr(tokens).parse();
//        Assertions.assertTrue(tree.equals(correct_tree));
//    }
//
//    @Test
//    public void error_if_calc_without_first_term() throws TokenException, ParserException {
//        String expr = "+ 2";
//        List<Token> tokens = new TokenManeger(expr).tokenize();
//        Assertions.assertThrows(ParserException.class, () -> {
//            new ParserExpr(tokens).parse();
//        });
//    }
//
//    @Test
//    public void error_if_calc_without_last_term() throws TokenException, ParserException {
//        String expr = "2 + ";
//        List<Token> tokens = new TokenManeger(expr).tokenize();
//        Assertions.assertThrows(ParserException.class, () -> {
//            new ParserExpr(tokens).parse();
//        });
//    }
//
//    @Test
//    public void error_if_calc_without_operator() throws TokenException, ParserException {
//        String expr = "2 2";
//        List<Token> tokens = new TokenManeger(expr).tokenize();
//        Assertions.assertThrows(ParserException.class, () -> {
//            new ParserExpr(tokens).parse();
//        });
//    }
//
//    @Test
//    public void error_if_calc_without_close_parentheses() throws TokenException, ParserException {
//        String expr = "(2 + 2";
//        List<Token> tokens = new TokenManeger(expr).tokenize();
//        Assertions.assertThrows(ParserException.class, () -> {
//            new ParserExpr(tokens).parse();
//        });
//    }
//
//    @Test
//    public void error_if_calc_without_open_parentheses() throws TokenException, ParserException {
//        String expr = "2 + 2)";
//        List<Token> tokens = new TokenManeger(expr).tokenize();
//        Assertions.assertThrows(ParserException.class, () -> {
//            new ParserExpr(tokens).parse();
//        });
//    }
}
