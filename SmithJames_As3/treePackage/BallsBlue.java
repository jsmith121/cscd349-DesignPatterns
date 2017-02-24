package treePackage;

public class BallsBlue extends TreeDecorator{
	public BallsBlue(Tree tree){this.tree = tree;}
	public String getDescription()
	{
		return tree.getDescription() + ", Blue Balls";
	}
	public double cost()
	{
		return 2 + tree.cost();
	}
}
