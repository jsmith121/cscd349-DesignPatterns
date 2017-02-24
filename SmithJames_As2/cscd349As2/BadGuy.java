package cscd349As2;

import java.util.Observable;
import java.util.Observer;

public class BadGuy implements Observer {

	private String name;
	private int hobbits;
	private int elves;
	private int dwarves;
	private int men;
	Observable eye;
	
	public BadGuy(EyeOfSauron eye, String name) {
		this.name = name;
		this.eye = eye;
		eye.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof EyeOfSauron)
		{
			EyeOfSauron eye = (EyeOfSauron)arg0;
			this.hobbits = eye.getHobbits();
			this.elves = eye.getElves();
			this.dwarves = eye.getDwarves();
			this.men = eye.getMen();
			display();
		}
	}
	public void defeated()
	{
		eye.deleteObserver(this);
	}
	private void display()
	{
		System.out.println(this.name + " knows about " + hobbits + " hobbits, "
					+ elves + " elves, " + dwarves + " dwarves and " + men + " men.");
	}

}
