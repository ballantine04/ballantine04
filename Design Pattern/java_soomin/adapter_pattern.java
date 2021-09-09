interface Duck {
    public void quack();
    public void fly();
}

class MallardDuck implements Duck {
    public void quack(){
        System.out.println("Quack!");
    }
    public void fly(){
        System.out.println("Im flying~");
    }
}
interface Turkey {
    public void gobble();
    public void fly();
}
class WildTurkey implements Turkey{
    public void gobble(){
        System.out.println("Gobble Gobble!");
    }
    public void fly(){
        System.out.println("Im flying a short distance...");
    }
}

//Crate adaptor
class TurkeyAdapter implements Duck{
    Turkey turkey;
    public TurkeyAdapter (Turkey turkey){
        this.turkey = turkey;
    }
    public void quack(){
        turkey.gobble();
    }
    public void fly(){
        for(int i=0; i<5; i++) turkey.fly();
    }
}

public class adapter_pattern{
    public static void main(String[] args) {

        MallardDuck duck = new MallardDuck();    
        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("[The Turkey says...]");
        turkey.gobble();
        turkey.fly();

        System.out.println("[The Duck says...]");
        duck.quack();
        duck.fly();

        System.out.println("[The TurkeyAdapter says...]");
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }
}

[output]

[The Turkey says...]
Gobble Gobble!
Im flying a short distance...
  
[The Duck says...]
Quack!
Im flying~

[The TurkeyAdapter says...]
Gobble Gobble!
Im flying a short distance...
Im flying a short distance...
Im flying a short distance...
Im flying a short distance...
Im flying a short distance...
