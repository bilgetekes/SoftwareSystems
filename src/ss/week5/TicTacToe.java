package ss.week5;



public class TicTacToe {
	public static void main(String[] args) {
	if (args.length == 2) {
		Player Player1 = new HumanPlayer(args[0], Mark.XX);
		Player Player2;
		// AI OVERWRITES
		if (args[1].equals("-N")) {
			Player2 = new ComputerPlayer(Mark.OO) {
			};
		} else if (args[1].equals("-S")) {
			Player2 = new ComputerPlayer(Mark.OO, new SmartStrategy()) {
			};
		} else {
			System.out.println("Invalid Arguments, second player will be initialised as a HumanPlayer");
			Player2 = new HumanPlayer("Queen", Mark.OO);
		}

		Game tictac = new Game(Player1, Player2);
		tictac.start();

	} else {
		Player Player1 = new HumanPlayer("Bilge", Mark.XX);
		Player Player2 = new HumanPlayer("Gizem", Mark.OO);
		Game tictac = new Game(Player1, Player2);
		tictac.start();
	}
}
}
