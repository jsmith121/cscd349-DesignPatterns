package transportation;

public class Seat extends Arrangement{

	private char position;
	private int row;
	private char col;
	public char getPosition() {
		return position;
	}
	
	public Seat(int r, char c, char pos) {
		this.row = r;
		this.col = c;
		this.position = pos;
	}
	public int getRow() {
		return row;
	}

	public char getCol() {
		return col;
	}

}
