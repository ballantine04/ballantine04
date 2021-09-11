// Abstract Factory 
abstract class CarFactory {
	public abstract void createCar(); 
}
// Concrete Factory1
class SedanFactory extends CarFactory {
	Engine engine = null;
	Wheel wheel = null;
	Body body = null;
	
	public void createCar() {
		engine = new SedanEngine();
		wheel = new SedanWheel();
		body = new SedanBody();	
	} 
}
// Concrete Factory2
class SportsFactory extends CarFactory {
	Engine engine = null;
	Wheel wheel = null;
	Body body = null;
	
	public void createCar() {
		engine = new SportsEngine();
		wheel = new SportsWheel();
		body = new SportsBody();	
	} 
}

// Product1
interface Engine {}

class SedanEngine implements Engine{
	public SedanEngine() { 
		System.out.println("Create Sedan Engine!"); 
	}
}

class SportsEngine implements Engine{
	public SportsEngine() {
		System.out.println("Create Sports Engine!");
	}
}
//Product2
interface Wheel {}

class SedanWheel implements Wheel{
	public SedanWheel() {
		System.out.println("Create Sedan Wheel!");
	}
}
class SportsWheel implements Wheel{
	public SportsWheel() {
		System.out.println("Create Sports Wheel!");
	}
}
//Product3
interface Body {}

class SedanBody implements Body{
	public SedanBody() {
		System.out.println("Create Sedan Body!");
	}
}
class SportsBody implements Body{
	public SportsBody() {
		System.out.println("Create Sports Body!");
	}
}
// Client
public class test2 {
	public static void main(String[] args) {
		CarFactory carFactory = null;
		
		System.out.println("[Sedan Car 만들기]");
		carFactory = new SedanFactory();
		carFactory.createCar();
		
		System.out.println("[Sports Car 만들기]");
		carFactory = new SportsFactory();
		carFactory.createCar();
	}
}

[output]

[Sedan Car 만들기]
Create Sedan Engine!
Create Sedan Wheel!
Create Sedan Body!
[Sports Car 만들기]
Create Sports Engine!
Create Sports Wheel!
Create Sports Body!
