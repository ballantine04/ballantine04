import java.util.ArrayList;
import java.util.Iterator;

class MenuItem{
	String name;
	String description;
	boolean vegetarian;
	double price;
	public MenuItem (String name, String description, boolean vegetarian, double price) {
		this.name = name;
		this.description = description;
		this.vegetarian = vegetarian;
		this.price = price;
	}
	public String getName() {
		return this.name;
	}
}

class PancakeHouseMenu {
	ArrayList menuItems;
	public PancakeHouseMenu () {
		menuItems = new ArrayList();
		addItem("Regular Pancake Breakfast", "pancakes with fried eggs, sausage", false, 2.99);
		addItem("Blueberry Pancakes", "pancakes made with fresh blueberries", true, 3.49);
	}
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name,description,vegetarian,price);
		menuItems.add(menuItem);
	}
	public ArrayList getMenuItems() {
		return menuItems;
	}
	public Iterator createIterator() {
		return new PancakeHouseMenuIterator(menuItems);
	}
}

class DinerMenu {
	static final int MAX_ITEMS = 2; 
	int numberOfItems = 0;
	MenuItem[] menuItems;
    
	public DinerMenu () {
		menuItems = new MenuItem[MAX_ITEMS];
		addItem("Vegetarian BLT", "Bacon with Lettuce & tomato on whole wheat", true, 2.99);
		addItem("Soup of the Day", "Soup of the Day with potato salad", false, 3.29);
	}
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name,description,vegetarian,price);
		if(numberOfItems >= MAX_ITEMS) {
			System.out.println("Sorry menu is full! Can't add any more items");
		}else {
			menuItems[numberOfItems] = menuItem;
			numberOfItems = numberOfItems + 1;
		}
	}
	public MenuItem[] getMenuItems() {
		return menuItems;
	}
	public Iterator createIterator() {
		return new DinerMenuIterator(menuItems);
	}
}

class DinerMenuIterator implements Iterator {
	MenuItem[] items;
	int position = 0;
	public DinerMenuIterator (MenuItem[] items) {
		this.items = items;
	}
	public Object next() {
		MenuItem menuItem = items[position];
		position++;
		return menuItem;
	}
	public boolean hasNext() {
		if(position >= items.length) return false;
		else return true;
	}
}

class PancakeHouseMenuIterator implements Iterator {
	ArrayList items;
	int position = 0;
	public PancakeHouseMenuIterator (ArrayList items) {
		this.items = items;
	}
	public Object next() {
		MenuItem menuItem = (MenuItem) items.get(position);
		position++;
		return menuItem;
	}
	public boolean hasNext() {
		if(position >= items.size()) return false;
		else return true;
	}
}

class Waitress {
	PancakeHouseMenu pancakeHouseMenu;
	DinerMenu dinerMenu;
	public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}
	public void printMenu() {
		Iterator pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator dinerIterator = dinerMenu.createIterator();
		System.out.println("--- BREAKFAST ---");
		printMenu(pancakeIterator);
		System.out.println("--- LUNCH ---");
		printMenu(dinerIterator);
	}
	private void printMenu(Iterator iterator) {
		while(iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.println(menuItem.getName()+", ");
		}
	}
}


public class Iterator_pattern {
	public static void main(String[] args) {
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		DinerMenu dinerMenu = new DinerMenu();
		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
		waitress.printMenu();
	}
}

[output]
--- BREAKFAST ---
Regular Pancake Breakfast, 
Blueberry Pancakes, 
--- LUNCH ---
Vegetarian BLT, 
Soup of the Day, 
