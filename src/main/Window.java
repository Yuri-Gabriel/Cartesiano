package main;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
	
	private Axis axis;
	public final static int HEIGHT = 600;
	public final static int WIDTH = 600;
	
	public Window() {
		this.setSize(HEIGHT, WIDTH);
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);
		
		
		axis = new Axis();
        this.getContentPane().add(axis);
        
		this.addComponentListener(new ComponentAdapter() {
			
            @Override
            public void componentResized(ComponentEvent e) {
				int window_width = Window.getFrames()[0].getWidth();
				int window_height = Window.getFrames()[0].getHeight();
				
				axis.repaint();
				
                System.out.println("W: " + window_width);
                System.out.println("h: " + window_height);
            }
        });
		
		this.setVisible(true);
	}
	
}
