package gameoflife.controller;

import gameoflife.model.GameOfLife;
import gameoflife.view.CellFrame;

public class Controller {
	private GameOfLife gol;
	private CellFrame frame;
	
	private Controller(GameOfLife gol, CellFrame frame){
		this.gol = gol;
		this.frame = frame;
	}
	
	private static Controller instance;
	
	public static Controller createInstance(GameOfLife gol, CellFrame frame){
		instance = new Controller(gol,frame);
		return instance;
	}
	
	public static Controller getInstance(){
		return instance!=null? instance : createInstance(null, null);
	}
	
	public boolean[][] getCellStates(){
		return gol.getCellStates();
	}
	
	public GameOfLife getGameOfLife(){
		return gol;
	}
}
