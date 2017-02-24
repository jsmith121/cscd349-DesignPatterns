
public class Sorceress extends Hero {
	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;

	// -----------------------------------------------------------------
	public Sorceress() {
		super("Sorceress", 75, 5, .7, 25, 50, .3);

	}// end constructor

	// -----------------------------------------------------------------
	public void increaseHitPoints() {
		int hPoints;

		hPoints = (int) (Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addHitPoints(hPoints);
		System.out.println(
				getName() + " added [" + hPoints + "] points.\n" + "Total hit points remaining are: " + getHitPoints());
		System.out.println();

	}// end increaseHitPoints method
	public void special(DungeonCharacter opponent)
	{
		increaseHitPoints();
	}
	// -----------------------------------------------------------------
	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " casts a spell of fireball at " + opponent.getName() + ":");
		super.attack(opponent);
	}// end override of attack method

	// -----------------------------------------------------------------

}// end class