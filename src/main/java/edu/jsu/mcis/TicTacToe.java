package edu.jsu.mcis;

public class TicTacToe {
    public enum mark {X,O,empty};
    public mark[][] grid;
    private int turn; 
    private decision gameDecision;
    public enum decision {Xwin,Owin,Tie};
        

    public TicTacToe() {
        grid = new mark[3][3];
        turn = 1;
        gameDecision = null;
    }

    public void makeMark(int i, int j) {
        if(turn == 1) {
            if (grid[i-1][j-1]== null) {
                grid[i-1][j-1] = mark.X;
                turn = 2;
            }
            else {
                turn = 1;
            }
        }
        else {
             if (grid[i-1][j-1]== null) {
                grid[i-1][j-1] = mark.O;
                turn = 1;
            }
            else {
                turn = 2;
            }
            
            
        }
    }
    
    public mark getMark(int i, int j) {
        return grid [i-1][j-1];
    }

    public void printGrid(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.println(grid[i][j] + " ");
            }
        }
    }
    
    public decision winnerDecided() {
        if (((grid[0][0] == mark.X) && (grid[0][1] == mark.X) && (grid[0][2] == mark.X))||((grid[1][0] == mark.X) && (grid[1][1] == mark.X) && (grid[1][2] == mark.X))||((grid[2][0] == mark.X) && (grid[2][1] == mark.X) && (grid[2][2] == mark.X))||((grid[0][0] == mark.X) && (grid[1][0] == mark.X) && (grid[2][0] == mark.X))||((grid[0][1] == mark.X) && (grid[1][1] == mark.X) && (grid[2][1] == mark.X))||((grid[0][2] == mark.X) && (grid[1][2] == mark.X) && (grid[2][2] == mark.X))||((grid[0][0] == mark.X) && (grid[1][1] == mark.X) && (grid[2][2] == mark.X))||((grid[2][0] == mark.X) && (grid[1][1] == mark.X) && (grid[0][2] == mark.X))){
            gameDecision = decision.Xwin;
            return gameDecision;
            
        }
        else if (((grid[0][0] == mark.O) && (grid[0][1] == mark.O) && (grid[0][2] == mark.O))||((grid[1][0] == mark.O) && (grid[1][1] == mark.O) && (grid[1][2] == mark.O))||((grid[2][0] == mark.O) && (grid[2][1] == mark.O) && (grid[2][2] == mark.O))||((grid[0][0] == mark.O) && (grid[1][0] == mark.O) && (grid[2][0] == mark.O))||((grid[0][1] == mark.O) && (grid[1][1] == mark.O) && (grid[2][1] == mark.O))||((grid[0][2] == mark.O) && (grid[1][2] == mark.O) && (grid[2][2] == mark.O))||((grid[0][0] == mark.O) && (grid[1][1] == mark.O) && (grid[2][2] == mark.O))||((grid[2][0] == mark.O) && (grid[1][1] == mark.O) && (grid[0][2] == mark.O))){
            gameDecision = decision.Owin;
            return gameDecision;
        }
        else if ((grid[0][0] != null) && (grid[0][1] != null) && (grid[0][2] != null)&& (grid[1][0] != null) && (grid[1][1] != null) && (grid[1][2] != null)&&(grid[2][0] != null) && (grid[2][1] != null) && (grid[2][2] != null)){
            gameDecision = decision.Tie;
            return gameDecision;
        }
        else{
            gameDecision = null;
            return gameDecision;
        }
    }
    





	//public static void main(String[] args) {
		
	//}
}
