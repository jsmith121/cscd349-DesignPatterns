package treePackage;

public class Star extends TreeDecorator{
	private static Star uniqueInstance;
	
	
	private Star(Tree tree){
		this.tree = tree;
		
	}
	
	public static Tree getStar(Tree mytree)
	{
		if(!mytree.getDescription().contains("Star"))
		{
			if(uniqueInstance == null)
			{
				mytree = new Star(mytree);
			}
		}
		else{
			System.out.println("Tree already has a star!");
		}
		return mytree;
	}
	public String getDescription()
	{
		return tree.getDescription() + ", a Star";
	}
	public double cost()
	{
		return 4 + tree.cost();
	}
}
