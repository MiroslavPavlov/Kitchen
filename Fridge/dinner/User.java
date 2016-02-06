package dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dinner.kitchen.Fridge;
import dinner.kitchen.Locker;
import dinner.recipes.Book;
import dinner.recipes.Recipe;

public class User {

	private Fridge fridge;
	private Locker locker;
	private Book book;
	private HashMap<String, Double> productsList;
//	history of lists where we can keep all recipes that user can make with his own ingredients
	private static ArrayList<ArrayList<Integer>> idOfRecipes;
	private static int indexOfSearch = 0;
	
	public User() {
		this.fridge = new Fridge();
		this.locker = new Locker();
		this.book = new Book();
		this.productsList = new HashMap<String, Double>();
		User.idOfRecipes = new ArrayList<ArrayList<Integer>>();
	}
	void allUserProducts(){
		for(Map.Entry<String, Double> entry : fridge.getProducts().entrySet()){
			if(!productsList.containsKey(entry.getKey()))
				productsList.put(entry.getKey(), entry.getValue());
		}
		for(Map.Entry<String, Double> entry : locker.getProducts().entrySet()){
			if(!productsList.containsKey(entry.getKey()))
				productsList.put(entry.getKey(), entry.getValue());
		}
		
	}
	 void putProductInProductList(String s, Double d){
		if(!(productsList.containsKey(s))){
			productsList.put(s, d);
		}else{
			productsList.put(s, (productsList.get(s) + d));
		}
	}
	
	 void removeProductFromList(String s, Double d){
		if(productsList.get(s) >= d){
			productsList.put(s, (productsList.get(s) - d));
		}
	}
//	 only one search for now 
//	 returns int for info about this search if we use further
	 int searchRecipesFromBook(){
		 User.deleteHistory();
		 indexOfSearch ++ ;
		 ArrayList<Integer> a = new ArrayList<Integer>();
//		 for every search when user se this app
		 idOfRecipes.add(a);
		 for(Recipe r : book.getRecipesBook()){
			 boolean canMake = true;
			 for(Map.Entry<String, Double> entry : r.getReceipe().entrySet()){
				 if(!(productsList.containsKey(entry.getKey()) &&
			productsList.get(entry.getKey()) > r.getReceipe().get(entry.getKey()))){
					 canMake = false;
					 break;
				 }
			 }
			 if(canMake){
				 canMake = true;
				 a.add(r.getId());
			 }
		 }
		 return User.idOfRecipes.indexOf(a);
	 }
//	 optimizations for memory use
	 private static void  deleteHistory(){
		 if(indexOfSearch == 100){
			 idOfRecipes = new ArrayList<ArrayList<Integer>>();
			 indexOfSearch = 1;
		 }
	 }
	 
	 
}
