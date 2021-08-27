abstract class Character {
    // WeaponBehavior weapon // Object Composition  with Interface
    WeaponBehavior weapon = new HandBehavior(); 
  
    public Character(){ }
    public abstract void display(); // Inheritance - not varing

    public void fight(){
        weapon.useWeapon();
    }

    public void setWeapon(WeaponBehavior w){
        this.weapon = w;      // weapon 에 대해 Object 추가.   WeaponBehavior weapon  <- 내용
    }
}

// Concrete Class 생성(Inheritance상속)  - 변하지 않는 데이터들.. Display 등
class King extends Character{
    // Concrete Class
    public void display(){ 
        System.out.println("I'm a King");
    }
}
class Queen extends Character{
    public void display(){ 
        System.out.println("I'm a Queen");
    }
}
class Prince extends Character{
    public void display(){ 
        System.out.println("I'm a Prince");
    }
}


// Interface (implements) 만들기 - 변할수 있는.. 유지보수가 필요한 데이터들을  Interface를 사용해서 분리! - Stredegy Pattern!
interface WeaponBehavior{
    public void useWeapon();
}

class HandBehavior implements WeaponBehavior{
    public void useWeapon(){
        System.out.println("Only my hands...");
    }
}
class AxeBehavior implements WeaponBehavior{
    public void useWeapon(){
        System.out.println( "hit with Axe!!");
    }
}
class KnifeBehavior implements WeaponBehavior{
    public void useWeapon(){
        System.out.println("hit with Knife!!");
    }
}
class SwordBehavior implements WeaponBehavior{
    public void useWeapon(){
        System.out.println("hit with Sword!!");
    }
}

public class strategy_pattern {
    public static void main(String[] args) {

        System.out.println("[King]");
        Character king = new King();
        king.display();
        king.fight();  // Compile Error
        king.setWeapon(new AxeBehavior());
        king.fight();

        System.out.println("[Queen]");
        Character queen = new Queen();
        queen.display();
        queen.fight();
        queen.setWeapon(new KnifeBehavior());
        queen.fight();


        System.out.println("[Prince]");
        Character prince = new Prince();
        prince.display();
        prince.fight();
        prince.setWeapon(new SwordBehavior());
        prince.fight();

    }
}

[Output]

[King]
I'm a King
Only my hands...
hit with Axe!!
  
[Queen]
I'm a Queen
Only my hands...
hit with Knife!!
  
[Prince]
I'm a Prince
Only my hands...
hit with Sword!!
