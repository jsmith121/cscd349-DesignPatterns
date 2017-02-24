
public class Warrior extends Hero {

	public Warrior() {
		super("Warrior", 125, 4, .8, 35, 60, .2);
	}// end constructor

	public void special(DungeonCharacter opponent) {
		if (Math.random() <= .4) {
			int blowPoints = (int) (Math.random() * 76) + 100;
			System.out.println(getName() + " lands a CRUSHING BLOW for " + blowPoints + " damage!");
			opponent.subtractHitPoints(blowPoints);
		} // end blow succeeded
		else {
			System.out.println(getName() + " failed to land a crushing blow");
			System.out.println();
		} // blow failed

	}// end crushingBlow method

	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " swings a mighty sword at " + opponent.getName() + ":");
		super.attack(opponent);
	}// end override of attack method
}// end Hero class