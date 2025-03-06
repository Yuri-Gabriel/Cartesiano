package main;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
	
	private Axis axis;
	public final static int HEIGHT = 600;
	public final static int WIDTH = 600;
	public static double WINDOW_SCALE = 1;
	
	public Window() {
		this.setSize(HEIGHT, WIDTH);
		this.setResizable(false);
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
		
		
		this.addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent wheel_event) {
				// TODO Auto-generated method stub
				
				double wheel_rotation = wheel_event.getPreciseWheelRotation();
				if(wheel_rotation > 0) {
					// para baixo
					if(WINDOW_SCALE > 0.2) WINDOW_SCALE -= 0.1;
				}
				if(wheel_rotation < 0) {
					// para cima
					
					if(WINDOW_SCALE <= 2.5) WINDOW_SCALE += 0.1;
				}
				axis.repaint();
			}
		});
		
		
		this.setVisible(true);
	}
	
}