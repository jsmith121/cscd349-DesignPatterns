package transportation;

import java.util.Random;

import transportation.SeatClass;

public class FlightSection extends Section {
	private SeatClass seatClass;
	private int rows, cols;
	private Seat seats[][];
	private int price;

	public FlightSection(int rows, SeatClass seatC, char layout) {
		this.rows = rows;
		this.seatClass = seatC;
		Random r = new Random();
		this.price = (int) (r.nextDouble()*100);
		initSeats(layout);
	}

	private void initSeats(char layout) {

		char l[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
		if (layout == 'S') {
			char WMA[] = { 'W', 'A', 'A' };
			cols = 3;
			this.seats = new Seat[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < 3; j++) {
					seats[i][j] = new Seat(i + 1, l[j], WMA[j]);
				}
			}
		} else if (layout == 'M') {
			char WMA[] = { 'W', 'A', 'A', 'W' };

			cols = 4;
			this.seats = new Seat[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < 4; j++) {
					seats[i][j] = new Seat(i + 1, l[j], WMA[j]);
				}
			}
		} else if (layout == 'W') {
			char WMA[] = { 'W', 'M', 'A', 'A', 'M', 'M', 'M', 'A', 'M', 'W' };
			cols = 10;
			this.seats = new Seat[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					seats[i][j] = new Seat(i + 1, l[j], WMA[j]);
				}
			}
		}
	}

	public boolean hasAvailable() {

		for (int r = 0; r < this.rows; r++) {
			for (int c = 0; c < this.cols; c++) {
				if (seats[r][c].isBooked() == false) {
					return true;
				}
			}
		}
		return false;
	}

	public void book(int row, char col) {
		for (int r = 0; r < this.rows; r++) {
			for (int c = 0; c < this.cols; c++) {
				if (seats[r][c].getRow() == row && seats[r][c].getCol() == col) {
					if (!seats[r][c].isBooked()) {
						seats[r][c].book();
					} else {
						System.out.println("Cannot book seat, seat is either booked or does not exist.");
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		String ret = "Flight Section: " + seatClass.toString() + " Price: $" + price + "\n";
		ret += "\'x\': Booked	\'-\': Available\n\n";
		for (int i = 0; i < rows; i++) {
			ret += "	";
			for (int j = 0; j < cols; j++) {
				if (seats[i][j].isBooked())
					ret += "x";
				else
					ret += "-";
			}
			ret += "\n";
		}
		return ret += "\n";
	}

	public SeatClass getSeatClass() {
		return this.seatClass;
	}

	public void bookPref(char pref) {
		boolean booked = false;
		if (pref == 'W' || pref == 'A') {
			for (int r = 0; r < this.rows; r++) {
				for (int c = 0; c < this.cols; c++) {
					if (!seats[r][c].isBooked() && !booked && seats[r][c].getPosition() == pref) {
						seats[r][c].book();
						booked = true;
					}
				}
			}
			
			if (!booked) {
				System.out.println("No seats available matching that preference");
				for (int r = 0; r < this.rows; r++) {
					for (int c = 0; c < this.cols; c++) {
						if (!seats[r][c].isBooked() && !booked) {
							seats[r][c].book();
							booked = true;
						}
					}
				}
			}
		}
		else{
			System.out.println("Invalid seating preference");
		}
	}
	public void setPrice(int p)
	{
		this.price = p;
	}

}
