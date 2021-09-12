import java.util.*;
/*
Name: Chandan Chandel
Purpose:  Whack A Mole Text based game.
Date: 2021-09-07
Notes: 
*/
public class Main {
    /**
     * This is the main method which makes use of to read in our input, then call the appropriate methods to calculate, finally print.
     * @param args Unused.
     * @return Nothing.
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int x = 0;
	int y = 0;
	Scanner s1;
	System.out.println("please enter the number of attempts and the size of the grid");
	System.out.println("example: I want 50 attempts on a 10x10 grid: 50 10");
	try{
	    s1 = new Scanner(System.in);
	    x=s1.nextInt();
	    y=s1.nextInt();
	    if (x<=0||y<=0) 
	    	{throw new InputMismatchException();}
	  }
	 catch(InputMismatchException e) {
	     System.out.println("Enter the correct input type, or the game will end");
	     System.exit(0);
	 }
	WhackAMole game = new WhackAMole(x, y);// declare the WhackAMole game attempts and grid size.
	//placing 10 moles randomly
	for (int i = 0; i  < 10; i++ ) {
	   x = (int)(Math.random()*game.moleGrid.length);
	   y = (int)(Math.random()*game.moleGrid.length);
	   if (!game.place(x,y)) 
	   	{i--;}
	}
	while(game.attemptsLeft!=0 && game.molesLeft!=0) {
	    System.out.println("please enter coordinates in the following format: x y");
	    System.out.println("W for whacked mole, o for missed attempt, at the end of the game M is where the moles are.");
	    System.out.println("Note: if you want to quit the game and find out where all the moles are, enter this: -1 -1");
	    try{
		s1 = new Scanner(System.in);
		x=s1.nextInt();
		y=s1.nextInt();
		  if (x > game.moleGrid.length||y > game.moleGrid.length) 
		    	{throw new InputMismatchException();}
	    }
	    catch(InputMismatchException e) {
		System.out.println("Enter the correct input type, or the game will end");
		System.exit(0);
	    }

	    if (x == -1 && y ==-1) {
		game.printGrid();
		System.exit(0);
	    }
	    game.whack(x,y);
	    game.printGridToUser();
	}
	
    }
}
