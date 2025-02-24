package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Axis extends JPanel {
	
	public void paintComponent(Graphics g) {
		int window_width = Window.getFrames()[0].getWidth();
		int window_height = Window.getFrames()[0].getHeight();
		
		int point_x_axis_distance = window_width / 10;
		int point_y_axis_distance = 100;
		
		g.setColor(Color.BLACK);
		
		// x axis
		g.drawLine(
				0,
				window_height/2,
				window_width,
				window_height/2
		);
		
		for(int i = window_width * -1; i <= window_width; i += point_x_axis_distance) {
			g.drawLine(
					i,
					window_height/2-5,
					i,
					window_height/2+5
			);
		}
		
		// y axis
		g.drawLine(
				window_width/2,
				0,
				window_width/2,
				window_height
		);
		
		for(int i = window_height * -1; i <= window_height; i += point_y_axis_distance) {
			g.drawLine(
					window_width/2-5,
					i,
					window_width/2+5,
					i
			);
		}
	}
}
