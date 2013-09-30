package gameoflife.main;

import gameoflife.controller.Controller;
import gameoflife.model.GameOfLife;
import gameoflife.view.CellFrame;

//Everyone loves CGOL!
public class Main {
	public static void main(String[] args){
		GameOfLife gol = new GameOfLife(30,30,true);
		Controller.createInstance(gol, new CellFrame());
	}
}
