import java.util.*;

abstract class Product {
    public abstract void use();  // Product 객체에서 직접 사용할 메소드.
}

class IDCard extends Product {
    private String owner;

    public IDCard(String owner){
        System.out.println(owner+"의 카드를 만듭니다.");
        this.owner = owner;
    }

    @Override
    public void use(){
        System.out.println(owner+"의 카드를 사용합니다.");
    }

    public String getOwner(){
        return owner;
    }
}

abstract class Factory {
    public final Product create(String owner){
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product p);

}

class IDCardFactory extends Factory {
    private List<String> owners = new ArrayList<>();
    @Override
    protected Product createProduct(String owner){
        return new IDCard(owner);
    }
    @Override
    protected void registerProduct(Product p){
        owners.add(((IDCard) p).getOwner());
    }
    public List<String> getOwner(){
        return owners;
    }
}

class factory_pattern{
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("홍길동");
        Product card2 = factory.create("이순신");
        Product card3 = factory.create("강감찬");
        card1.use();
        card2.use();
        card3.use();

    }
}

[output]
홍길동의 카드를 만듭니다.
이순신의 카드를 만듭니다.
강감찬의 카드를 만듭니다.
홍길동의 카드를 사용합니다.
이순신의 카드를 사용합니다.
강감찬의 카드를 사용합니다.
