package main.components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import java.math.MathContext;

public class Axis extends JPanel {
	
	private double point_x_axis_distance;
    private double point_y_axis_distance;
	private int window_width;
    private int window_height;
    
    public MathFunc func;
    
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setOpaque(true);
        
        point_x_axis_distance = 50 * 1; // Distância dos pontos do eixo X 0 -> 10
        point_y_axis_distance = 50 * 1; // Distância dos pontos do eixo Y 0 -> 10
    	
        window_width = getWidth();
        window_height = getHeight();
        
        this.drawXAxis(g);
        this.drawYAxis(g);

        g.setColor(Color.BLACK);
	}
	
	private void drawXAxis(Graphics g) {
		//Desenha a linha do eixo X
		g.drawLine(0, window_height / 2, window_width, window_height / 2);
		
		//Desenha as linhas que cortam o eixo X
        for (double i = window_width / 2; i <= window_width; i += point_x_axis_distance) {
        	//X >= 0
            g.drawLine(
            		(int) i,
            		window_height / 2 - 5,
            		(int) i,
            		window_height / 2 + 5
            	);
            //X < 0
            g.drawLine(
            		window_width - ((int) i),
            		window_height / 2 - 5,
            		window_width - ((int) i),
            		window_height / 2 + 5
            	);
        }
	}
	
	private void drawYAxis(Graphics g) {
		//Desenha a linha do eixo Y
		g.drawLine(window_width / 2, 0, window_width / 2, window_height);
		
		//Desenha as linhas que cortam o eixo Y
        for (double i = window_height / 2; i <= window_height; i += point_y_axis_distance) {
        	//Y >= 0
            g.drawLine(
            		window_width / 2 - 5,
            		(int) i,
            		window_width / 2 + 5,
            		(int) i
            	);
            
            //Y < 0
            if(i < 550) {
            	g.drawLine(
                		window_width / 2 - 5,
                		window_height - ((int) i),
                		window_width / 2 + 5,
                		window_height - ((int) i)
                	);
            }
        }
	}
}
			
