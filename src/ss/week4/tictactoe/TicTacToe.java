package ss.week4.tictactoe;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
    public static void main(String[] args) {
        // TODO: implement, see P-4.21
    	Player Player1 = new HumanPlayer(args[0], Mark.XX);
		Player Player2 = new HumanPlayer(args[1], Mark.OO);
		Game tictac = new Game(Player1, Player2);
		tictac.start();
    }
}
