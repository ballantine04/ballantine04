abstract class CaffeineBeverage {
    public String custom_input = "y";

    final void prepareRecipe(){
        boilwater();
        brew();
        pourInCup();
        if(customerWantsCondiments())addCondiments(); // Hook Method 추가.
    }
    abstract void brew();             // SubClass 에서 정의
    abstract void addCondiments();    // SubClass 에서 정의

    public void boilwater(){                      // 공통되는부분은 Parent-Class에서 정의
        System.out.println("Boiling water");      // Template-Pattern 에서는 Inheritance 활용
    }
    public void pourInCup(){
        System.out.println("Pouring into cup");
    }
    boolean customerWantsCondiments(){
        return true;
    }

}

class Coffee extends CaffeineBeverage {
    public void brew() {
        System.out.println("Dripping coffee through filter");
    }
    public void addCondiments(){
        System.out.println("Adding Sugar and Milk");
    }
    public boolean customerWantsCondiments(){
        String Answer = custom_input;
        if(Answer.equals("y")){
            return true;
        }else{
            return false;
        }
    }
}
class Tea extends CaffeineBeverage {
    public void brew() {
        System.out.println("Steeping the tea");
    }
    public void addCondiments() {
        System.out.println("Adding Lemnon");
    }
}

public class template_pattern {
    public static void main(String[] args) {
        
        System.out.println("[Make Coffee]");
        CaffeineBeverage coffee = new Coffee();
        coffee.custom_input = "n";  //default(y)
        coffee.customerWantsCondiments();  // Call Hooking Condition.
        coffee.prepareRecipe();  

        System.out.println("[Make Tea]");
        CaffeineBeverage tea = new Tea();
        tea.prepareRecipe();

    }
}


[output]
[Make Coffee]
Boiling water
Dripping coffee through filter
Pouring into cup
[Make Tea]
Boiling water
Steeping the tea
Pouring into cup
Adding Lemnon
