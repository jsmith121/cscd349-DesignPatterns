import treePackage.*;
public class TreeTester {

	public static void main(String[] args) {
		Tree mytree = new BlueSpruce();
		mytree = Star.getStar(mytree);
		mytree = new Ruffles(mytree);
		mytree = Star.getStar(mytree);
		mytree = new Ruffles(mytree);
		mytree = new BallsSilver(mytree);
		mytree = new LEDs(mytree);
		mytree = Star.getStar(mytree);
		printtree(mytree);


	}
	public static void printtree(Tree mytree)
	{
		System.out.println(mytree.getDescription() + " costs $" + mytree.cost());
	}

}
