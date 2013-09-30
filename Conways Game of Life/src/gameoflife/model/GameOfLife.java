package gameoflife.model;

import java.util.LinkedList;
import java.util.List;

public class GameOfLife {
	private boolean[][] cellStates;
	private int width;
	private int height;
	
	public GameOfLife(int w, int h){
		width = w;
		height = h;
		cellStates = new boolean[w][h];
	}
	
	public GameOfLife(int w, int h, boolean randomize){
		this(w,h);
		if(randomize){
			for(int x = 0; x < w; x++){
				for(int y = 0; y < h; y++){
					cellStates[x][y] = Math.random()>0.5d;
				}
			}
		}
	}
	
	public boolean[][] getCellStates(){
		return cellStates;
	}
	
	public void generateNextGeneration(){
		boolean nextGen[][] = new boolean[width][height];
		
		for(int x = 0; x < cellStates.length; x++){
			for(int y = 0; y < cellStates[x].length; y++){
				List<Boolean> neighbours = this.getNeighbours(x, y);
				int aliveCount = 0, deadCount = 0;
				for(Boolean b : neighbours){
					if(b)
						aliveCount++;
					else
						deadCount++;
				}
				//Rule 1: Rebirth if there are exactly 3 alive neighbours
				if(!cellStates[x][y] && aliveCount == 3){
					nextGen[x][y] = true;
					continue; //One rule was applied, continue to next cell
				}
				
				//Rule 2: Living cells die, if they have less then two alive neighbours
				else if(cellStates[x][y] && aliveCount < 2){
					nextGen[x][y] = false;
					continue;
				}
				
				//Rule 3: Living cells stay alive if they have two or three living neighbours
				else if(cellStates[x][y] && aliveCount>2 && aliveCount < 4){
					nextGen[x][y] = true;
					continue;
				}
				
				//Rule 4: Living cells with more then 3 neighbours die
				else{
					nextGen[x][y] = false;
					continue;
				}
			}
		}

		cellStates = nextGen;
		
	}
	
	private List<Boolean> getNeighbours(int x, int y){
		List<Boolean> ret = new LinkedList<Boolean>();
		this.tryAdd(ret, x+1, y);
		this.tryAdd(ret, x-1, y);
		this.tryAdd(ret, x, y+1);
		this.tryAdd(ret, x, y-1);
		
		this.tryAdd(ret, x+1, y+1);
		this.tryAdd(ret, x-1, y-1);
		this.tryAdd(ret, x+1, y-1);
		this.tryAdd(ret, x-1, y+1);
		return ret;
	}
	private boolean tryAdd(List<Boolean> toAdd, int x, int y){
		try{
			toAdd.add(cellStates[x][y]);
		} catch(Exception ex){
			return false;
		} return true;
	}
}
