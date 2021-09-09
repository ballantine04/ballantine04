import java.util.ArrayList;
import java.util.Iterator;

class MenuComponent{
    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }
    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }
    public MenuComponent getChild(int i){
        throw new UnsupportedOperationException();
    }
    public String getName(){
        throw new UnsupportedOperationException();
    }
    public String getDescription(){
        throw new UnsupportedOperationException();
    }
    public double getPrice(){
        throw new UnsupportedOperationException();
    }
    public boolean isVegetarian(){
        throw new UnsupportedOperationException();
    }
    public void print(){
        throw new UnsupportedOperationException();
    }
    public void printVege(){
        throw new UnsupportedOperationException();
    }
}

class MenuItem extends MenuComponent{
    String name;
    String description;
    boolean vegetarian;
    double price;
    public MenuItem(String name, String description, boolean vegetarian, double price){
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public double getPrice(){
        return price;
    }
    public boolean isVegetarian(){
        return vegetarian;
    }
    public void print(){
        System.out.print(" "+getName());
        if(this.isVegetarian()) System.out.print("(v)");
        System.out.print(", "+getPrice());
        System.out.println("  --"+ getDescription());
    }
    public void printVege(){
        if(this.isVegetarian()){
            System.out.print(" "+getName());
            System.out.print("(v)");
            System.out.print(", "+getPrice());
            System.out.println("  --"+ getDescription());
        }
    }
}

class Menu extends MenuComponent{
    ArrayList menuComponents = new ArrayList();
    String name;
    String description;
    Iterator iterator = null;
    public Menu(String name, String description){
        this.name = name;
        this.description = description;
    }
    public void add(MenuComponent menuComponent){
        menuComponents.add(menuComponent);
    }
    public void remove(MenuComponent menuComponent){
        menuComponents.remove(menuComponent);
    }
    public MenuComponent getChild(int i){
        return (MenuComponent)menuComponents.get(i);
    }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public void print(){
        Iterator iterator = menuComponents.iterator();
        while(iterator.hasNext()){
            MenuComponent menuComponent = (MenuComponent)iterator.next();
            menuComponent.print();
        }
    }
    public void printVege(){
        Iterator iterator = menuComponents.iterator();
        while(iterator.hasNext()){
            MenuComponent menuComponent = (MenuComponent)iterator.next();
            menuComponent.printVege();
        }
    }
}

class Waitress {
    MenuComponent allMenus;
    public Waitress(MenuComponent allMenus){
        this.allMenus = allMenus;
    }
    public void printMenu(){
        allMenus.print();
    }   
    public void printVegeMenu(){
        allMenus.printVege();
    }
}

public class adapter_pattern{
    public static void main(String[] args) {

        // MID-LEVEL MENU
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
        MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");

        // ROOT-LEVEL MENU
        MenuComponent allMenus = new Menu("ALL MENUS","All menus combined");
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        // BOTTOM-LEVEL MENU
        MenuComponent desertMenu = new Menu("DESSERT MENU", "Dessert of course!");
        dinerMenu.add(desertMenu);

        // add MenuItems to MENU
        pancakeHouseMenu.add(new MenuItem("pancake1", "pancake", true, 1.99));
        pancakeHouseMenu.add(new MenuItem("pancake2", "pancake", false, 2.99));
        pancakeHouseMenu.add(new MenuItem("pancake3", "pancake", true, 3.99));
        dinerMenu.add(new MenuItem("diner1", "diner", true, 1.99));
        dinerMenu.add(new MenuItem("diner2", "diner", false, 2.99));
        dinerMenu.add(new MenuItem("diner3", "diner", true, 3.99));
        cafeMenu.add(new MenuItem("cafe1", "cafe", true, 1.99));
        cafeMenu.add(new MenuItem("cafe2", "cafe", false, 2.99));
        cafeMenu.add(new MenuItem("cafe3", "cafe", true, 3.99));
        desertMenu.add(new MenuItem("desert1", "desert", true, 1.99));
        desertMenu.add(new MenuItem("desert2", "desert", false, 2.99));
        desertMenu.add(new MenuItem("desert3", "desert", true, 3.99));

        //waitress
        Waitress waitress = new Waitress(allMenus);
        System.out.println("[ ALL MENUS ]");
        waitress.printMenu();
        System.out.println("[ ALL MENUS for Vegetarians ]");
        waitress.printVegeMenu();

    }
}

[output] - DFS Search

[ ALL MENUS ]
 pancake1(v), 1.99  --pancake
 pancake2, 2.99  --pancake
 pancake3(v), 3.99  --pancake
 desert1(v), 1.99  --desert
 desert2, 2.99  --desert
 desert3(v), 3.99  --desert
 diner1(v), 1.99  --diner
 diner2, 2.99  --diner
 diner3(v), 3.99  --diner
 cafe1(v), 1.99  --cafe
 cafe2, 2.99  --cafe
 cafe3(v), 3.99  --cafe
 
[ ALL MENUS for Vegetarians ]
 pancake1(v), 1.99  --pancake
 pancake3(v), 3.99  --pancake
 desert1(v), 1.99  --desert
 desert3(v), 3.99  --desert
 diner1(v), 1.99  --diner
 diner3(v), 3.99  --diner
 cafe1(v), 1.99  --cafe
 cafe3(v), 3.99  --cafe
