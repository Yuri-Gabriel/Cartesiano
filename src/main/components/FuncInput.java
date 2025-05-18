package main.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import main.Window;

public class FuncInput extends JPanel {
	
	private JTextField inputText;
	private JButton calcBtn;
	
	
	public FuncInput() {

		

		this.setPreferredSize(new Dimension(Window.WIDTH, 100));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
		this.setBorder(border);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.inputText = new JTextField();
		this.inputText.setMaximumSize(new Dimension(250, 30));
		this.inputText.setAlignmentX(CENTER_ALIGNMENT);
		
		this.calcBtn = new JButton("Calcular");
		this.calcBtn.setMaximumSize(new Dimension(150, 30));
		this.calcBtn.setAlignmentX(CENTER_ALIGNMENT);

		this.calcBtn.addActionListener(e -> calculateFunc());

		this.add(Box.createVerticalStrut(15));
		this.add(inputText);
		this.add(Box.createVerticalStrut(5));
		this.add(calcBtn);
	}

	private void calculateFunc() {
		String expr = this.inputText.getText();
		System.out.println(expr);
		Window.graph.setMathExpression(expr);
		Window.graph.repaint();
	}
}
