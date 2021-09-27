interface State{
    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();
}

class GumballMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;

    State state = soldOutState;
    int count = 0;

    public GumballMachine(int numberGumballs){
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);

        this.count = numberGumballs;
        if(numberGumballs>0) state = noQuarterState;
    }
    public void insertQuarter() {
        state.insertQuarter();
    }
    public void ejectQuarter(){
        state.ejectQuarter();
    }
    public void trunCrank(){
        state.turnCrank();
    }
    public void dispense(){
        state.dispense();
    }
    void setState(State state){
        this.state = state;
    }
    void releaseBall(){
        System.out.println("A gumball comes rolling out the slot...");
        if(count !=0 ) count = count -1;
    }
    public State getHasQuarterState() {
        return hasQuarterState;
    }
    public State getNoQuarterState() {
        return noQuarterState;
    }
    public State getSoldState() {
        return soldState;
    }
    public State getSoldOutState() {
        return soldOutState;
    }
    public int getCount() {
        return this.count;
    }

}

class NoQuarterState implements State {
    GumballMachine gumballMachine;
    public NoQuarterState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }
    public void insertQuarter(){
        System.out.println("you inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }
    public void ejectQuarter() {
        System.out.println("you haven't inserted a quarter");
    }
    public void turnCrank() {
        System.out.println("you turned, but there's on quarter");
    }
    public void dispense() {
        System.out.println("NoQuarterState - No gumball dispensed");
    }
}

class HasQuarterState implements State {
    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }
    public void insertQuarter(){
        System.out.println("you can't insert another quarter");
    }
    public void ejectQuarter() {
        System.out.println("quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }
    public void turnCrank() {
        System.out.println("you turned...");
        gumballMachine.setState(gumballMachine.getSoldState());
        gumballMachine.dispense();
    }
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}

class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }
    public void insertQuarter(){
        System.out.println("please wait, we're already giving you a gum ball");
    }
    public void ejectQuarter() {
        System.out.println("sorry you already turned the crank");
    }
    public void turnCrank() {
        System.out.println("turning twice doesn't get you another gumball");
    }
    public void dispense() {
        gumballMachine.releaseBall();
        if(gumballMachine.getCount()>0){
            System.out.println("now dispensing");
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }else{
            System.out.println("oops, out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}


class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }
    public void insertQuarter(){
        System.out.println("sorry Sold out!");
    }
    public void ejectQuarter() {
        System.out.println("sorry Sold out!");
    }
    public void turnCrank() {
        System.out.println("sorry Sold out!");
    }
    public void dispense() {
        System.out.println("sorry Sold out!");
    }
}

public class state_pattern{
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(2);
        gumballMachine.insertQuarter();
        System.out.println("------------");
        gumballMachine.ejectQuarter();
        System.out.println("------------");
        gumballMachine.insertQuarter();
        System.out.println("------------");
        gumballMachine.trunCrank();
        System.out.println("------------");
        System.out.println("남은갯수: "+gumballMachine.getCount());
        System.out.println("------------");
        gumballMachine.insertQuarter();
        System.out.println("------------");
        gumballMachine.trunCrank();
        System.out.println("------------");
        System.out.println("남은갯수: "+gumballMachine.getCount());
    }
}



[output]
you inserted a quarter
------------
quarter returned
------------
you inserted a quarter
------------
you turned...
A gumball comes rolling out the slot...
now dispensing
------------
남은갯수: 1
------------
you inserted a quarter
------------
you turned...
A gumball comes rolling out the slot...
oops, out of gumballs!
------------
남은갯수: 0
