package cscd349As2;

import java.util.Observable;

public class EyeOfSauron extends Observable{

	private int hobbits;
	private int elves;
	private int dwarves;
	private int men;
	
	public EyeOfSauron() {
		this.hobbits = 0;
		this.elves = 0;
		this.dwarves = 0;
		this.men = 0;
	}
	public void setEnemies(int hobbits, int elves, int dwarves, int men)
	{
		this.hobbits = hobbits;
		this.elves = elves;
		this.dwarves = dwarves;
		this.men = men;
		setChanged();
		this.notifyObservers();
	}
	public int getHobbits() {
		return hobbits;
	}
	public int getElves() {
		return elves;
	}
	public int getDwarves() {
		return dwarves;
	}
	public int getMen() {
		return men;
	}
	

}
