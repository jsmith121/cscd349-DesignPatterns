package transportation;

import java.util.ArrayList;

public class CabinSection extends Section{
	private CabinClass cabinClass;
	private int rooms;
	private int decks;
	private ArrayList<Cabin> cabins;
	
	public CabinSection(int rooms, int decks, CabinClass c)
	{
		this.rooms = rooms;
		this.decks = decks;
		cabins = new ArrayList<Cabin>();
		this.cabinClass = c;
		initRooms();
	}
	
	private void initRooms()
	{
		char l[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
		for (int i = 0; i < rooms; i++) {
			for (int j = 0; j < decks; j++) {
				cabins.add(new Cabin(i + 1, l[j]));
			}
		}
	}
	public boolean hasAvailable() {
		for(int i = 0; i < cabins.size(); i++)
		{
			if(cabins.get(i).isBooked() == false)
			{
				return true;
			}
		}
		return false;
	}
	public void book() {

		for(Cabin c: cabins)
		{
			if(!c.isBooked())
			{
				c.book();
				break;
			}
			else
			{
				System.out.println("No cabins available in this section");
			}
		}
	}
	public CabinClass getCabinClass()
	{
		return cabinClass;
	}
	
	@Override
	public String toString() {
		String ret = "Cabin Section: " + cabinClass.toString() + "\n";
		ret += "\'x\': Booked	\'-\': Available\n\n";
		
		return ret += "\n";
	}
}
