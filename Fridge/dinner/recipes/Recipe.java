package dinner.recipes;

import java.util.TreeMap;

public class Recipe {

	private static int uniqueID = 1;
	
	private String name;
	private Integer id;
	private TreeMap<String, Double> receipe;
	
	
	public Integer getId() {
		return id;
	}
	public TreeMap<String, Double> getReceipe() {
		return receipe;
	}
	private Recipe(String name) {
		this.name = name;
		this.id = uniqueID ++;
		this.receipe = new TreeMap<String, Double>();
	}
	static Recipe createRecipe(String[] ingredients , double[] amount, String name){
		if(ingredients.length == amount.length){
			Recipe r = new Recipe(name);
			for(int i = 0 ; i < ingredients.length ; i ++){
				r.receipe.put(ingredients[i], amount[i]);
			}
			return r;
		}
		System.out.println("invalit list with ingrediants!");
		return null;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
