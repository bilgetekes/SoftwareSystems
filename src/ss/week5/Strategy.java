package ss.week5;


public interface Strategy {

	
	public int determineMove(Board board, Mark mark);

	public String getName();
}
