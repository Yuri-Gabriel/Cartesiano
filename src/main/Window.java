package main;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import main.components.Axis;
import main.components.FuncInput;
import main.components.Graph;

public class Window extends JFrame {
	
	private Axis axis;
	public static Graph graph;
	public final static int HEIGHT = 600;
	public final static int WIDTH = 600;
	
	public Window() {
		this.setSize(HEIGHT, WIDTH);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		this.setTitle("Cartesiano");
		
		FuncInput input = new FuncInput();
		
		axis = new Axis();
		
        graph = new Graph();
        graph.setMathExpression("x ^ 2");
        
        JPanel layeredPane = new JPanel();
        layeredPane.setLayout(new OverlayLayout(layeredPane));
        layeredPane.add(graph);
        layeredPane.add(axis);
        
        this.add(input, BorderLayout.NORTH);
        this.add(layeredPane, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
}