- Category of GoF Patterns

![image](https://user-images.githubusercontent.com/69576676/131095583-69517194-a4d1-4c16-b190-5f90298ca675.png)


- 목차

[Behavior Pattern]
- Strategy Pattern
- Observer Pattern
- Template Pattern
- Iterator Pattern
- State Pattern
- Mediator Pattern

[Creation Pattern]
- Factory Method & Abstract Factory Pattern
- Builder Pattern
- Singleton Pattern

[Structural Pattern]
- Decorator Pattern
- Adapter Pattern
- Composite Pattern
- Bridge Pattern

[Compound Pattern]
- MVC




[Composition vs Aggregation]

Composition: Aggregation의 특별한 경우인데, 이것을 "죽음의" 연관관계라고 부를 수도 있습니다. 강력하게 연관된 Aggregation이며, 자식 오브젝트는 자신의 라이프사이클을 가지지 않고, 부모 오브젝트가 소멸될 경우 자식 오브젝트도 함께 소멸됩니다.
![image](https://user-images.githubusercontent.com/69576676/131211555-84d97606-1cf6-4c69-9488-9440367729cc.png)

public class Engine
{
 . . . 
}

public class Car
{
    Engine e = new Engine();  
}

Aggregation: Association의 특별한 경우인데, 모든 오브젝트가 각자의 라이프사이클을 가지고 있으며, 한 오브젝트가 다른 오브젝트를 소유하고 있는 경우입니다.
선생님이 어떤 부서에 Aggregation되어 있다고 합시다. 소속된 관계이기 때문에, 한 선생님이 여러 부서에 Aggregation될 수는 없습니다. 그렇다고 해서 부서가 소멸될 때 선생님도 소멸되는 것은 아닙니다. 이것을 "has-a" 관계라고 할 수 있습니다.
![image](https://user-images.githubusercontent.com/69576676/131211585-671c635e-5ab3-4a56-9f04-db27e476bcb5.png)

public class Address
{
 . . .
}

public class Person
{

     private Address address;
     
     public Person(Address address)
     {
         this.address = address;
     }
}
  
Association: 모든 오브젝트가 각자의 라이프사이클을 가지고 있고, 어떤 오브젝트가 다른 오브젝트를 소유하지는 않은 경우입니다.
예를 들면, 선생님과 학생의 경우를 들 수 있습니다. 많은 학생이 한 선생님에게 Association를 가질 수 있고, 한 학생이 여러 선생님에게 Association를 가질 수도 있습니다. 하지만 이 관계에는 누가 누구를 소유하거나 하지는 않습니다. 각자가 생성/소멸을 독립적으로 합니다.