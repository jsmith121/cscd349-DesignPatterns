
public class Thief extends Hero {

	public Thief() {
		super("Thief", 75, 6, .8, 20, 40, .5);
	}// end constructor

	public void special(DungeonCharacter opponent) {
		double surprise = Math.random();
		if (surprise <= .4) {
			System.out.println("Surprise attack was successful!\n" + getName() + " gets an additional turn.");
			setNumTurns(getNumTurns() + 1);
			attack(opponent);
		} // end surprise
		else if (surprise >= .9) {
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" + " blocked your attack!");
		} else
			attack(opponent);
	}// end surpriseAttack method

}