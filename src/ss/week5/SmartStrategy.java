package ss.week5;

public class SmartStrategy extends  NaiveStrategy{
	private String name;

	public SmartStrategy() {
		this.name = "Smart";
	}

	@Override
	public int determineMove(Board board, Mark mark) {
		// if the middle is empty
		if (board.isEmptyField(Board.DIM * Board.DIM / 2)) {
			return Board.DIM * Board.DIM / 2;
		}
		// if this move could make it win
		for (int i = 0; i < Board.DIM * Board.DIM; i++) {
			if (board.isEmptyField(i)) {
				Board copy = board.deepCopy();
				copy.setField(i, mark);
				if (copy.isWinner(mark))
					return i;
			}
		}
		// if this move could make opponent win
		for (int i = 0; i < Board.DIM * Board.DIM; i++) {
			if (board.isEmptyField(i)) {
				Board copy = board.deepCopy();
				copy.setField(i, mark.other());
				if (copy.isWinner(mark.other()))
					return i;
			}
		}
		// random move
		return super.determineMove(board, mark);
	}

	@Override
	public String getName() {
		return name;
	}
}
