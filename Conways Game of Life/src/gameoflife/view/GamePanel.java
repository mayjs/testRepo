package gameoflife.view;

import gameoflife.controller.Controller;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	public GamePanel(){
		super();
		setPreferredSize(new Dimension(300,300));
		setSize(300, 300);
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		boolean[][] state = Controller.getInstance().getCellStates();
		
		int tileWidth = this.getWidth()/state.length;
		for(int x = 0; x<state.length; x++){
			int tileHeight = this.getHeight()/state[0].length;
			for(int y = 0; y < state[x].length; y++){
				if(state[x][y]){
					g.fillRect(x*tileWidth,y*tileHeight,tileWidth,tileHeight);
				}
			}
		}
	}
}
