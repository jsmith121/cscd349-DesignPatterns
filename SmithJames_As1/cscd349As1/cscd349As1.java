package cscd349As1;

public class cscd349As1 {

	public static void main(String[] args) {
		
		GameCharacter player = new GameCharacter();

		player.setName("Slash");
		player.setGuitar(new GibsonSG());
		player.setSolo(new JumpOffStage());
		
		System.out.println("Name: " + player.getName());
		player.useGuitar();
		player.doSolo();
		
		player.setName("Angus Young");
		player.setGuitar(new GibsonFlyingV());
		player.setSolo(new SmashGuitar());
		
		System.out.println();
		System.out.println("Name: " + player.getName());
		player.useGuitar();
		player.doSolo();
		
	}

}
