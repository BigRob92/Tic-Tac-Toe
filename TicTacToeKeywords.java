import edu.jsu.mcis.*;

public class TicTacToeKeywords {
    private TicTacToeModel model;
	
	public void startNewGame() {
         model = new TicTacToeModel();
        

	}
	
	public void markLocation(int row, int col) {
        model.makeMark(row +1, col + 1);
        

	}
	
	public String getMark(int row, int col) {
		String setMark = " ";
        if (model.getMark(row + 1, col + 1) == mark.X) {
            setMark = "X";
        }
        else if (model.getMark(row + 1, col +1) == mark.O) {
            setMark = "O";
            
        }
        else {
            return " ";
        }
	}
    
	public String getWinner() {
        String userWin = " ";
        if (model.winnerDecided () == decision.Xwin){
            userWin = "X";
        }
        else if (model.winnerDecided () == decision.Owin) {
            userWin = "O";
        }
        else if (model.winnerDecided () == decision.Tie) {
            userWin = "Tie";
        }
		return userWin;
	}
}
