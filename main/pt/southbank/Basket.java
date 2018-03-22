package pt.southbank;

import java.util.ArrayList;
import java.util.List;

public class Basket {
	private List<String> items;

	public Basket() {
		this.items = new ArrayList<>();
	}	
	
	
	public void add(String product) {
		items.add(product);
		
	}

	public List<String> get() {				
		return items;
	}

}
