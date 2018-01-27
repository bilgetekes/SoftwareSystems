package ss.week5;


public class ComputerPlayer extends Player {

	private Strategy strategy;
	private String name;

	public ComputerPlayer(Mark mark) {
		this(mark, new NaiveStrategy());
		this.name  = "ComputerPlayer";
	}

	public ComputerPlayer(Mark mark, Strategy strategy) {
		super(strategy.getName(), mark);
		this.strategy = strategy;
		this.name = "ComputerPlayer";
	}

	@Override
	public int determineMove(Board board) {
		return strategy.determineMove(board, getMark());
	}
	
	public String getName() {
       return this.name + " - " + this.getMark();
	}
}