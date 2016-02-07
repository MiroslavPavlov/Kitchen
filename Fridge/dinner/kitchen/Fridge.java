package dinner.kitchen;


public class Fridge extends ProductKeeper {


	public void openKeeper() {
		System.out.println("Fridge is opened ");
	}

	public void closeKeeper() {
		System.out.println("Fridge is closed ");
	}


	public void showVegetables(){
		for(Entry e: this.allProducts.get("Vegetables").entrySet()){
			System.out.println(e.getKey().toString() +": " + e.getValue());
		}
	}

	public void showFruits(){
		for(Entry e: this.allProducts.get("Fruits").entrySet()){
			System.out.println(e.getKey().toString() +": " + e.getValue());
		}
	}

	public void showMilkProducts(){
		for(Entry e: this.allProducts.get("Milk Products").entrySet()){
			System.out.println(e.getKey().toString() +": " + e.getValue());
		}
	}

	public void showDrinks(){
		for(Entry e: this.allProducts.get("Drinks").entrySet()){
			System.out.println(e.getKey().toString() +": " + e.getValue());
		}
	}

	public void showMeat(){
		for(Entry e: this.allProducts.get("Meat").entrySet()){
			System.out.println(e.getKey().toString() +": " + e.getValue());
		}
	}

}
