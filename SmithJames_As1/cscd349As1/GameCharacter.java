package cscd349As1;

public class GameCharacter {
	
	private String name;
	private SoloBehavior solo;
	private GuitarBehavior guitar;
	
	public GameCharacter(){	}
	public void setName(String n){this.name = n;}
	public void setSolo(SoloBehavior s)
	{
		if(s instanceof SoloBehavior)
		{
			this.solo = s;
		}
		else
			System.out.println("Operation Failed");

	}
	public void setGuitar(GuitarBehavior g)
	{
		if(g instanceof GuitarBehavior)
		{
			this.guitar = g;
		}
		else
			System.out.println("Operation Failed");
	}
	
	public String getName() {
		return name;
	}
	public SoloBehavior getSolo() {
		return solo;
	}
	public GuitarBehavior getGuitar() {
		return guitar;
	}
	public void doSolo(){
		this.solo.playSolo();
	}
	public void useGuitar(){
		this.guitar.playGuitar();
	}
}
