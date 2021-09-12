import java.util.*;
public class WhackAMole {
    //defines the number of moles left
    public int molesLeft = 10;
    //defines attempts left
    public int attemptsLeft;
    //defines the grid for the game
    public char [][] moleGrid;
    /**
     * Constructor method used to determine attempts left and then to fill up the grid with '*'.
     * @param numAttemptsLeft, attempts left to get all of the moles.
     * @param gridDimensions,the size of the square grid.
     */
    public WhackAMole(int numAttemptsLeft, int gridDimensions) {
	this.attemptsLeft = numAttemptsLeft;
	this.moleGrid = new char [gridDimensions][gridDimensions];
	for (int i = 0;i < this.moleGrid.length; i++) {
	    for (int j = 0; j<this.moleGrid.length; j++) {
		this.moleGrid[i][j] = '*';
	    }
	 }
    }
    /**
     * This method is used to place the moles (can't double place in the same location).
     * @param x, this is the x position on the grid.
     * @param y, this is the y position on the grid.
     * @return boolean, clarifies whether method was successful (didn't double place).
     */
    boolean place (int x, int y) {
	    if (this.moleGrid[x][y] == 'M') 
		{return false;}
	    else 
		{
		this.moleGrid[x][y] ='M';
		return true;
		}
    }
    /**
     * This function is used to whack at the grid, if it hits something -> W else -> o
     * @param x, this is the x position on the grid.
     * @param y, this is the y position on the grid.
     */
    void whack (int x, int y) {
	this.attemptsLeft--; 
	if (this.moleGrid[x][y] == 'M') 
		{
	    	this.moleGrid[x][y] = 'W';
	      	this.molesLeft--;
		}
	else if (this.moleGrid[x][y] == '*') 
		{this.moleGrid[x][y] = 'o';}
    }
    //print full grid with all values
    void printGrid() {
	for (int i = 0;i < this.moleGrid.length; i++) {
	    for (int j = 0; j<this.moleGrid.length; j++) {		
		    	System.out.print(this.moleGrid[i][j]+" ");
	    }
	    System.out.println();
	}
    }
    //print  grid with all M values hidden, used every turn
    void printGridToUser() {
	for (int i = 0;i < this.moleGrid.length; i++) {
	    for (int j = 0; j<this.moleGrid.length; j++) {
		if (this.moleGrid[i][j]!='M') {
		    	System.out.print(this.moleGrid[i][j]+" ");
			}
		else 
			{System.out.print("* ");}
	    }
	    System.out.println();
	}
	System.out.println("moles left:" + this.molesLeft);
	System.out.println("attempts left:" + this.attemptsLeft);
    }

}


