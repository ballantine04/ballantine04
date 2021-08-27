class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;
    private volatile static ChocolateBoiler uniqueInstance = null;  
    // = new ChocolateBoiler() -> null - 객체를 미리 생성하면 낭비. [option2]
    // volatile - shared variable 의 synchronize를 보장해주는 역할. [option3]

    private ChocolateBoiler(){   // private 하여 직접 객체 생성하지 못하도록 함.
        empty = true;
        boiled = false;
    }
    public static ChocolateBoiler getInstance(){    
        if(uniqueInstance == null){                 // object 생성 여부 확인
            synchronized(ChocolateBoiler.class){     // synchronized를 통해 하나의 thread만 진입하도록 Lock 적용. [option1]
                if(uniqueInstance == null) {          // 대기중이던 thread 에대해 한번더 object 생성 확인 -> "Double Checked Locking."
                    uniqueInstance = new ChocolateBoiler();
                }
            }
        }
        return uniqueInstance;
    }
}

public class singleton_pattern {
    public static void main(String[] args) {
        ChocolateBoiler boiler = ChocolateBoiler.getInstance();
        
    }
}
