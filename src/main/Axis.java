package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Axis extends JPanel {
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        
        int window_width = getWidth();  // Obtém a largura do painel
        int window_height = getHeight(); // Obtém a altura do painel
        
        int point_x_axis_distance = 50; // Distância dos pontos do eixo X
        int point_y_axis_distance = 50; // Distância dos pontos do eixo Y
        
        if(Window.WINDOW_SCALE > 0) {
        	
        }
        System.out.println("window_scale: " + Window.WINDOW_SCALE);

        g.setColor(Color.BLACK);

        // Desenha eixo X
        g.drawLine(0, window_height / 2, window_width, window_height / 2);

        // Desenha marcações no eixo X
        for (int i = window_width / 2; i <= window_width; i += point_x_axis_distance) {
            g.drawLine(i, window_height / 2 - 5, i, window_height / 2 + 5);
            g.drawLine(window_width - i, window_height / 2 - 5, window_width - i, window_height / 2 + 5);
        }

        // Desenha eixo Y
        g.drawLine(window_width / 2, 0, window_width / 2, window_height);

        // Desenha marcações no eixo Y
        for (int i = window_height / 2; i <= window_height; i += point_y_axis_distance) {
            g.drawLine(window_width / 2 - 5, i, window_width / 2 + 5, i);
            g.drawLine(window_width / 2 - 5, window_height - i, window_width / 2 + 5, window_height - i);
        }
	}
	
	private int getMDC(int number) {
		
		for(int i = number - 1; i > 0; i--) {
			if(number % i == 0) {
				return i;
			}
		}
		
		return 0;
	}
}
