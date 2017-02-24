package treePackage;

public class BallsRed extends TreeDecorator{
	public BallsRed(Tree tree){this.tree = tree;}
	public String getDescription()
	{
		return tree.getDescription() + ", Red Balls";
	}
	public double cost()
	{
		return 1 + tree.cost();
	}
}
