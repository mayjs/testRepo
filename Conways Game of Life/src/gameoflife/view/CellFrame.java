package gameoflife.view;

import gameoflife.controller.Controller;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class CellFrame extends JFrame{
	private JPanel buttonPanel;
	private JButton stepButton;
	private JButton runButton;
	private JSlider speedSlider;
	
	private GamePanel gamePanel;
	
	public CellFrame(){
		super("Conways game of life");
		this.setLayout(new GridLayout(2, 1));
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,3));
		
		stepButton = new JButton("Neue Generation");
		stepButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controller.getInstance().getGameOfLife().generateNextGeneration();
				gamePanel.paintImmediately(0,0,gamePanel.getWidth(),gamePanel.getHeight());
			}
		});
		stepButton.setSize(this.getWidth(), 30);
		buttonPanel.add(stepButton);
		
		this.add(buttonPanel);
		
		gamePanel = new GamePanel();
		this.add(gamePanel);
		
		
		
		this.pack();
		this.setVisible(true);
	}
}
