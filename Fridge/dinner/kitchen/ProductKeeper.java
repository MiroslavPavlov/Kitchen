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

			this.allProducts.put(product,ProductKeeper.ingridients.get(product)); // refresh user's list of products
		}
	}

	/**
	 * Removes a general product from the list of ingredients
	 */
	public void removeProduct(String product, double value) {
		if (ProductKeeper.ingredients.containsKey(product)) {
			double temp = ProductKeeper.ingredients.remove(product);
			ProductKeeper.ingredients.put(product, temp - value);

			this.allProducts.put(product,ProductKeeper.ingridients.get(product)); // again refresh user's list of products
		}
	}



	//User's list of products- used when the user wants to see his list of products(fruits,veggies,etc.)
	//I have added some products, but not all of them


	protected Map<String,TreeMap<String,Double>> allProducts;
	//Food categories


	ProductKeeper(){
		this.allProducts= new TreeMap<String, TreeMap<String,Double>>();
		TreeMap<String,Double> vegetables= new TreeMap<>();
		TreeMap<String,Double> fruits= new TreeMap<>();
		TreeMap<String,Double> milkProducts= new TreeMap<>();
		TreeMap<String,Double> drinks= new TreeMap<>();
		TreeMap<String,Double> meat= new TreeMap<>();
		TreeMap<String,Double> legumes= new TreeMap<>();
		TreeMap<String,Double> condiments= new TreeMap<>();

		//vegetables
		vegetables.put("Tomatoe", 0.0);
		vegetables.put("Pepper", 0.0);
		vegetables.put("Garlic", 0.0);
		vegetables.put("Tomatoe", 0.0);
		vegetables.put("Carrot", 0.0);
		vegetables.put("Salad", 0.0);

		//fruits
		fruits.put("Apple", 0.0);
		fruits.put("Peach", 0.0);
		fruits.put("Banana", 0.0);
		fruits.put("Pear", 0.0);
		fruits.put("Watermelon", 0.0);
		fruits.put("Melon", 0.0);
		fruits.put("Grape", 0.0);

		//milk products
		milkProducts.put("Milk", 0.0);
		milkProducts.put("Cheese", 0.0);
		milkProducts.put("Joghurt", 0.0);

		//drinks
		drinks.put("Beer", 0.0);
		drinks.put("Wine", 0.0);
		drinks.put("Water", 0.0);
		drinks.put("Juice", 0.0);
		drinks.put("IceTea", 0.0);
		drinks.put("Cola", 0.0);

		//meat
		meat.put("Fish", 0.0);
		meat.put("Beef", 0.0);
		meat.put("Chicken", 0.0);
		meat.put("Pork", 0.0);

		//legumes
		legumes.put("Green Bean", 0.0);
		legumes.put("Bean", 0.0);

		//condiments
		condiments.put("Oil", 0.0);
		condiments.put("Salt", 0.0);
		condiments.put("Pepper", 0.0);
		condiments.put("Spice", 0.0);

		//
		allProducts.put("Vegetables", vegetables);
		allProducts.put("Fruits", fruits);
		allProducts.put("Milk Products", milkProducts);
		allProducts.put("Drinks", drinks);
		allProducts.put("Meat", meat);
		allProducts.put("Legumes", legumes);
		allProducts.put("Condiments", condiments);






	}


}
