package dinner.kitchen;


import java.util.TreeMap;

public abstract class ProductKeeper {
	
	protected String listOfAllProducts;
	protected String userProducts;
	
	protected abstract void openKeeper();
	
	protected abstract void closeKeeper();
	
	//Static tree map of all the ingredients that the user will store, or remove from. Serves as a global
	//variable to be used by various other maps and methods
	public static TreeMap<String, Double> ingredients = new TreeMap<String, Double>();
	
	/**
	 * Adds a general product from the list of ingredients
	 */
	public void addProduct(String product, double value) {
		if (ProductKeeper.ingredients.containsKey(product)) {
			double temp = ProductKeeper.ingredients.remove(product);
			ProductKeeper.ingredients.put(product, temp + value);
		}
	}

	/**
	 * Removes a general product from the list of ingredients
	 */
	public void removeProduct(String product, double value) {
		if (ProductKeeper.ingredients.containsKey(product)) {
			double temp = ProductKeeper.ingredients.remove(product);
			ProductKeeper.ingredients.put(product, temp - value);
		}
	}
}
