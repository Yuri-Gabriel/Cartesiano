package main.components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.exprInterpreter.calculator.Calculator;
import main.exprInterpreter.datastruct.Queue;
import main.exprInterpreter.parser.ParserExpr;
import main.exprInterpreter.parser.nodetype.NodeExpression;
import main.exprInterpreter.token.Token;
import main.exprInterpreter.token.TokenManager;

public class Graph extends JPanel {

	private Calculator calculator;
	private Queue<Token> tokens;
	private NodeExpression treeExpr;

	private int window_width;
    private int window_height;
	
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		this.setOpaque(false);
		g.setColor(Color.RED);
		
		window_width = getWidth();  // Obtém a largura do painel
        window_height = getHeight(); // Obtém a altura do painel
		
        
        //Defini os valores maximos e minimos para X e Y de acordo com o tamanho da janela
		double xMin = window_width / -5;
        double xMax = window_width / 5;
        double yMin = window_height / -5;
        double yMax = window_height / 5;
		
        //Defini quando pixels da janela cabem em um ponto do plano cartesiano 
		double scaleX = window_width / (xMax - xMin) * 1;
        double scaleY = window_height / (yMax - yMin) * 1;
        
        double y = 0;
        for(double x = -10.0; x <= 10.0; x += 0.001) {
        	y = this.calculate(x);
            
        	//Converte os valores do ponto cartesiando em posisões em pixels para desenhar na janela
            int pixelX = (int) ((x - xMin) * scaleX);
            int pixelY = (int) ((yMax - y) * scaleY);
            
            
            //Desenha apenas os pixels que representam os valores de X e Y estão dentro da janela
            if((pixelX > 0 && pixelX < getWidth()) && (pixelY > 0 && pixelY < getHeight())) {
            	g.drawRect(
                		(int) pixelX,
                		(int) pixelY,
                		1,
                		1
                	);
            }
        }
	}
	
	public void setMathExpression(String expr) {
		try {
			this.tokens = new TokenManager(expr).tokenize();
			this.treeExpr = new ParserExpr(tokens).parse();
			this.calculator = new Calculator(this.treeExpr);
		} catch (Exception err) {
			JOptionPane.showMessageDialog(
				null,
				err.getMessage(),
				"Erro",
				JOptionPane.ERROR_MESSAGE
			);
		}
	}

	private double calculate(double x) {
		try {
			
			this.calculator.setX_value(x);
			double retult = this.calculator.calculate();
			return retult;
		} catch (Exception err) {
			JOptionPane.showMessageDialog(
				null,
				err.getMessage(),
				"Erro",
				JOptionPane.ERROR_MESSAGE
			);
			return 0;
		}
	}

}
