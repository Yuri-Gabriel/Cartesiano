package main.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import main.Window;

public class FuncInput extends JPanel {
	
	private JTextField inputText;
	
	public FuncInput() {
		this.setPreferredSize(new Dimension(Window.WIDTH, 100));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
		this.setBorder(border);
		
		this.inputText = new JTextField();
		this.inputText.setPreferredSize(new Dimension(250, 30));
		
		this.inputText.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				valueChanged();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				valueChanged();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) { }
		});
		
		this.add(inputText);
	}
	
	private void valueChanged() {
		System.out.println(this.inputText.getText());
		Window.graph.setFunc((x) -> {
			return Math.pow(Math.E, x);
		});
		Window.graph.repaint();
	}
}
