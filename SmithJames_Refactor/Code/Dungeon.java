
/*
 * This class is the driver file for the Heroes and Monsters project. It will do
 * the following:
 * 
 * 1. Allow the user to choose a hero 2. Randomly select a monster 3. Allow the
 * hero to battle the monster
 * 
 * Once a battle concludes, the user has the option of repeating the above
 * 
 */
public class Dungeon {
	public static void main(String[] args) {

		DungeonCharacter theHero;
		DungeonCharacter theMonster;

		do {
			CharacterFactory monsterFactory = new MonsterFactory();
			CharacterFactory heroFactory = new HeroFactory();
			theHero = heroFactory.makeChar();
			theMonster = monsterFactory.makeChar();
			runGame((Hero) theHero, (Monster) theMonster);

		} while (playAgain());

	}// end main method

	/*-------------------------------------------------------------------
	playAgain allows gets choice from user to play another game.  It returns
	true if the user chooses to continue, false otherwise.
	---------------------------------------------------------------------*/
	public static boolean playAgain() {
		char again;

		System.out.println("Play again (y/n)?");
		again = Keyboard.readChar();

		return (again == 'Y' || again == 'y');
	}// end playAgain method

	/*-------------------------------------------------------------------
	runGame is the actual combat portion of the game.  It requires a Hero
	and a Monster to be passed in.  Battle occurs in rounds.  The Hero
	goes first, then the Monster.  At the conclusion of each round, the
	user has the option of quitting.
	---------------------------------------------------------------------*/
	public static void runGame(Hero theHero, Monster theMonster) {
		System.out.println(theHero.getName() + " battles " + theMonster.getName());
		System.out.println("---------------------------------------------");

		doBattle(theHero, theMonster);
		printResults(theHero, theMonster);
	}// end battle method

	public static void doBattle(Hero theHero, Monster theMonster) {
		char pause = 'p';

		while (theHero.isAlive() && theMonster.isAlive() && pause != 'q') {
			theHero.battleChoices(theMonster);

			if (theMonster.isAlive())
				theMonster.attack(theHero);

			System.out.print("\n-->q to quit, anything else to continue: ");
			pause = Keyboard.readChar();

		} // end battle loop
	}

	public static void printResults(Hero theHero, Monster theMonster) {
		if (!theMonster.isAlive())
			System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else
			System.out.println("Quitters never win ;-)");
	}

}// end Dungeon class