package dinner.kitchen;




//sure about the name though?
public class Locker extends ProductKeeper {

	// super.listOfAllProducts= "salt, pepper, .. " ;
	// protected String listOfAllProducts="salt,pepper,viniger,oil,flouer, herbs
	// and spices";



	public void openKeeper() {
		System.out.println("Locker is opened! ");
	}

	public void closeKeeper() {
		System.out.println("Locker is closed! ");
	}

	public void showLegumes(){
		for(Entry e: this.allProducts.get("Legumes").entrySet()){
			System.out.println(e.getKey().toString() +": " + e.getValue());
		}
	}

	public void showCondiments(){
		for(Entry e: this.allProducts.get("Condiments").entrySet()){
			System.out.println(e.getKey().toString() +": " + e.getValue());
		}
	}

}
