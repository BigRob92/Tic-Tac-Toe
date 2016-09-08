package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest extends TicTacToe {
	private TicTacToe TestGame = new TicTacToe();
	
	@Test
	public void testInitialBoardIsEmpty() {
		
		assertTrue((TestGame.getMark(1, 1) == null) && (TestGame.getMark(1, 2) == null) && (TestGame.getMark(1, 3) == null) && (TestGame.getMark(2, 1) == null) && (TestGame.getMark(2, 2) == null) && (TestGame.getMark(2, 3) == null) && (TestGame.getMark(3, 1) == null) && (TestGame.getMark(3, 2) == null) && (TestGame.getMark(3, 3) == null));
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		
		TestGame.makeMark(1, 3);
		assertTrue(TestGame.getMark(1, 3) == mark.X);
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		TestGame.makeMark(1,1);
		TestGame.makeMark(3, 1);
		assertTrue(TestGame.getMark(3, 1) == mark.O);
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		
		TestGame.makeMark(1, 1);
		TestGame.makeMark(1, 1);
		assertTrue(TestGame.getMark(1, 1) == mark.X);
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		
		TestGame.makeMark(1, 1);
		assertTrue(TestGame.winnerDecided() == null);
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		TestGame.grid[0][0] = mark.X;
		TestGame.grid[0][1] = mark.X;
		
		TestGame.makeMark(1, 3);
		
		assertTrue(TestGame.winnerDecided() == decision.Xwin);
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		TestGame.grid[0][0] = mark.O;
		TestGame.grid[0][1] = mark.X;
		TestGame.grid[0][2] = mark.X;
		TestGame.grid[1][0] = mark.X;
		TestGame.grid[1][1] = mark.O;
		TestGame.grid[1][2] = mark.O;
		TestGame.grid[2][0] = mark.O;
		TestGame.grid[2][1] = mark.X;
		TestGame.makeMark(3, 3);
		
		
		assertTrue(TestGame.winnerDecided() == decision.Tie);
	}	
}