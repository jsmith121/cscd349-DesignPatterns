package treePackage;

public class BallsSilver extends TreeDecorator{
	public BallsSilver(Tree tree){this.tree = tree;}
	public String getDescription()
	{
		return tree.getDescription() + ", Silver Balls";
	}
	public double cost()
	{
		return 3 + tree.cost();
	}
}
