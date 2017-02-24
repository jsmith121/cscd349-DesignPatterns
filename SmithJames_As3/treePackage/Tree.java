package treePackage;

public abstract class Tree {
	private String description;
	public String getDescription()
	{
		return description;
	}
	public abstract double cost();
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
