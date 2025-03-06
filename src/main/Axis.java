package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Axis extends JPanel {
	
	private double point_x_axis_distance;
    private double point_y_axis_distance;
	private int window_width;
    private int window_height;
    
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        
        System.out.println("window_scale: " + Window.WINDOW_SCALE);
        
        point_x_axis_distance = 50 * Window.WINDOW_SCALE; // Distância dos pontos do eixo X
        point_y_axis_distance = 50 * Window.WINDOW_SCALE; // Distância dos pontos do eixo Y
    	
        window_width = getWidth();  // Obtém a largura do painel
        window_height = getHeight(); // Obtém a altura do painel

        g.setColor(Color.BLACK);

        // Desenha eixo X
        g.drawLine(0, window_height / 2, window_width, window_height / 2);

        // Desenha marcações no eixo X
        for (double i = window_width / 2; i <= window_width; i += point_x_axis_distance) {
        	
            g.drawLine(
            		(int) i,
            		window_height / 2 - 5,
            		(int) i,
            		window_height / 2 + 5
            	);
            g.drawLine(
            		window_width - ((int) i),
            		window_height / 2 - 5,
            		window_width - ((int) i),
            		window_height / 2 + 5
            	);
        }

        // Desenha eixo Y
        g.drawLine(window_width / 2, 0, window_width / 2, window_height);

        // Desenha marcações no eixo Y
        for (double i = window_height / 2; i <= window_height; i += point_y_axis_distance) {
            g.drawLine(
            		window_width / 2 - 5,
            		(int) i,
            		window_width / 2 + 5,
            		(int) i
            	);
            g.drawLine(
            		window_width / 2 - 5,
            		window_height - ((int) i),
            		window_width / 2 + 5,
            		window_height - ((int) i)
            	);
        }
        
        g.setColor(Color.RED);
        //x == 300; x = 0
        //y == 300; y = 0
        
        int y = 0;
        for(int x = -3; x <= 3; x++) {
        	y = f(x);
            System.out.println("x: " + x + " y: " + y);
            
            
            System.out.println("\nx_pos: " + get_x_pos(x) + " y_pos: " + get_y_pos(y));
            
            g.drawRect(get_x_pos(x), get_y_pos(y), 1, 1);
            
        }
        
	}
	
	private int get_x_pos(int x) {
		int x_pos = window_width / 2;
		if(x >= 0) {
			for(int i = 0; i < x; i++) {
	        	x_pos += point_x_axis_distance;
	        }
		} else {
			for(int i = 0; i > x; i--) {
	        	x_pos -= point_x_axis_distance;
	        }
		}
		
		return x_pos;
	}
	
	private int get_y_pos(int y) {
		int y_pos = window_width / 2;
		if(y >= 0) {
			for(int i = 0; i < y; i++) {
	        	y_pos -= point_y_axis_distance;
	        }
		} else {
			for(int i = 0; i > y; i--) {
	        	y_pos += point_y_axis_distance;
	        }
		}
		
		return y_pos;
	}
	
	private int f(int x) {
		return x * x * x;
	}
}