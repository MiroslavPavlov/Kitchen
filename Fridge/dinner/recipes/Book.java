package dinner.recipes;

import java.util.HashSet;

public class Book {

	HashSet<Recipe> recipesBook;

	public Book() {
		this.recipesBook = new HashSet<Recipe>();
	}
	
	void addRecipe(String[] ingredients, double[] amount, String name){
		this.recipesBook.add(Recipe.createRecipe(ingredients, amount, name));
	}
	
}
