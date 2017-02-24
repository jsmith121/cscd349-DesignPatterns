package treePackage;

public class LEDs extends TreeDecorator{
	public LEDs(Tree tree){this.tree = tree;}
	public String getDescription()
	{
		return tree.getDescription() + ", LEDs";
	}
	public double cost()
	{
		return 10 + tree.cost();
	}
}
