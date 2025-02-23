package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Axis extends JPanel {
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(
				0,
				Window.getFrames()[0].getHeight()/2,
				Window.getFrames()[0].getWidth(),
				Window.getFrames()[0].getHeight()/2
		);
		
		g.drawLine(
				Window.getFrames()[0].getWidth()/2,
				0,
				Window.getFrames()[0].getWidth()/2,
				Window.getFrames()[0].getHeight()
		);
	}
}
