abstract class Beverage {
    protected String description = "Unknown Beverage";
    public String getDescription() {
        return description;
    }
    public abstract double cost();
}

class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }
    public double cost(){
        return 1.99;
    }
}

class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "DarkRoast";
    }
    public double cost(){
        return 2.99;
    }
}

abstract class CondimentDecorator extends Beverage {
    protected Beverage beverage;
    public abstract String getDescription();
}

class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
    public double cost(){
        return .20 + beverage.cost();
    }
}

class Whip extends CondimentDecorator {
    public Whip(Beverage beverage){
        this.beverage = beverage;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
    public double cost(){
        return .10 + beverage.cost();
    }
}

public class decorator_pattern{
    public static void main(String[] args) {

        // beverage1
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()+" $"+beverage.cost());
        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription()+" $"+beverage.cost());
        beverage = new Whip(beverage);
        System.out.println(beverage.getDescription()+" $"+beverage.cost());

        // beverage2
        Beverage beverage2 = new DarkRoast();
        System.out.println(beverage2.getDescription()+" $"+beverage2.cost());
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription()+" $"+beverage2.cost());
    }
}

[output]
Espresso $1.99
Espresso, Mocha $2.19
Espresso, Mocha, Whip $2.29
DarkRoast $2.99
DarkRoast, Whip $3.09
