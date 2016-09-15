package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TicTacToeGUI extends JPanel implements ActionListener {
    private TicTacToe model = new TicTacToe();
    private JButton[][] button;
    
    
    public TicTacToeGUI() {
        model = new TicTacToe();
        button = new JButton[3][3];
        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button[i].length; j++) {
                button[i][j] = new JButton();
                button[i][j].setPreferredSize(new Dimension(100, 100));
                button[i][j].addActionListener(this);
                button[i][j].setName("Location" + i +  j);
                add(button[i][j]);
            }
        }
    }
        private void CheckForWinner() {
        TicTacToe.decision result = model.winnerDecided();
		final String s;
        if (result == TicTacToe.decision.Xwin) {
            s = "X";
        }
        else if (result == TicTacToe.decision.Owin) {
            s = "O";
        }
        else if (result == TicTacToe.decision.Tie) {
            s = "tie";
        }
		else {
			s = "";
		}
		if (s.length() > 0) {
			new Thread(new Runnable() {
				public void run() {
					JOptionPane.showMessageDialog(null, "The winner is " + s, "Game Over", JOptionPane.INFORMATION_MESSAGE);
				}
			}).start();
                        
		}
        
    }
    
    
    
    public static void main(String[] args) {
        JFrame win = new JFrame("Welcome to a game of Tic Tac Toe");
        win.add(new TicTacToeGUI());
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.pack();
        win.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton b = (JButton)event.getSource();
        String loc = b.getName().substring(8);
        
        int r = Integer.parseInt(loc.substring(0, 1)) + 1;
        int c = Integer.parseInt(loc.substring(1, 2)) + 1;
        
        
        TicTacToe.mark m = model.getMark(r, c);
        if (m == TicTacToe.mark.X) {
            b.setText("X");
        }
        else if (m == TicTacToe.mark.O) {
            b.setText("O");
        }
        CheckForWinner();
    }
    
}