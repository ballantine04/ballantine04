Category of GoF Patterns
-------------------------

![image](https://user-images.githubusercontent.com/69576676/131095583-69517194-a4d1-4c16-b190-5f90298ca675.png)


목차
-------------------------

##### Behavior Pattern
- Strategy Pattern
- Observer Pattern
- Template Pattern
- Iterator Pattern
- State Pattern
- Mediator Pattern

##### Creation Pattern
- Factory Method & Abstract Factory Pattern
- Builder Pattern
- Singleton Pattern

##### Structural Pattern
- Decorator Pattern
- Adapter Pattern
- Composite Pattern
- Bridge Pattern

##### Compound Pattern
- MVC

Behavioral Pattern 비교
------------------------------------
### Template Pattern vs Strategy Pattern
- Strategy Pattern : use delegation to vary the entire algorithm.
- Template Pattern : use inheritance to vary part of an algorithm.

### State Pattern vs Strategy Pattern 
- State Pattern : encapsulate a state-based behavior.
- Strategy Pattern : encapsulate interchangeable behaviors.
- Both : Example of "Composition with Delegation". ( diffrence is one of intent. )

### Mediator Pattern vs Observer Pattern
- Mediater Pattern : encapsulate the communication. ( no resuable )
- Observer Pattern : Communication distributed by using observer and subject objects. ( resuable )

Structural Pattern 비교
------------------------------------
### Composite Pattern vs Decorator Pattern
- Composite Pattern : focus on representation not on decoration. ( ex. Tree구조 menu/menuitem )
- Decorator Pattern : add responsibilities to objects without subclassing. ( ex. Append 
- Both : Recursive Composition
### Bridge Pattern vs Adapter Pattern
- Bridge Pattern : let abstractions and implements vary independantly. ( up-front in a design ) ( make a zoo for beasts )
  - Bridge can abstract a complex entity from its implementation.
- Adapter Pattern : make unrelated components work together. ( applied after they're designed )
  - Adapter only abstracts a single interface.
- Both : hide the details of the underlying implementation. (encapsulation)

Creational Pattern 비교
--------------------------
### Factory Method vs Abstract Factory (참고: https://defacto-standard.tistory.com/42 https://victorydntmd.tistory.com/300 https://whereami80.tistory.com/211)
- DIP ( Depend on absstractions, not concrete classes )
- Factory: let subclasses decide which object to create ( use inheritance )
- Abstract Factory: subclass dicide families of realated objects ( use object composition & delegation )


### Builder
- Concrete Director knows how to create products.

### Decorator
- OCP
- attaches additional responsibilities to an object dynamically
- use object composition and delegation




# 개념정리
Composition vs Aggregation
---------------------------

##### Composition: 
Aggregation의 특별한 경우인데, 이것을 "죽음의" 연관관계라고 부를 수도 있습니다. 강력하게 연관된 Aggregation이며, 자식 오브젝트는 자신의 라이프사이클을 가지지 않고, 부모 오브젝트가 소멸될 경우 자식 오브젝트도 함께 소멸됩니다.


![image](https://user-images.githubusercontent.com/69576676/131211555-84d97606-1cf6-4c69-9488-9440367729cc.png)

```java
public class Engine
{
 . . . 
}
public class Car
{
    Engine e = new Engine();  
}
```
##### Aggregation: 
Association의 특별한 경우인데, 모든 오브젝트가 각자의 라이프사이클을 가지고 있으며, 한 오브젝트가 다른 오브젝트를 소유하고 있는 경우입니다.
선생님이 어떤 부서에 Aggregation되어 있다고 합시다. 소속된 관계이기 때문에, 한 선생님이 여러 부서에 Aggregation될 수는 없습니다. 그렇다고 해서 부서가 소멸될 때 선생님도 소멸되는 것은 아닙니다. 이것을 "has-a" 관계라고 할 수 있습니다.


![image](https://user-images.githubusercontent.com/69576676/131211585-671c635e-5ab3-4a56-9f04-db27e476bcb5.png)

```java
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
```
  
##### Association: 
모든 오브젝트가 각자의 라이프사이클을 가지고 있고, 어떤 오브젝트가 다른 오브젝트를 소유하지는 않은 경우입니다.
예를 들면, 선생님과 학생의 경우를 들 수 있습니다. 많은 학생이 한 선생님에게 Association를 가질 수 있고, 한 학생이 여러 선생님에게 Association를 가질 수도 있습니다. 하지만 이 관계에는 누가 누구를 소유하거나 하지는 않습니다. 각자가 생성/소멸을 독립적으로 합니다.


protected ( 접근제한자 ) vs Public or Default
---------------------------
<img src="https://user-images.githubusercontent.com/69576676/131215983-f37f2d93-5a94-4829-8282-a9cc25a3044b.png" width="600" height="420">

final 
------
#### - entity를 한번만 선언 가능
#### - 상속을 하지 못하는 경우
```java
public final class MyFinalClass {...}
public class ThisIsWrong extends MyFinalClass {...} // forbidden
```
#### - method 호출을 하지 못하는 경우
```java
public class Base {
    public       void m1() {...}
    public final void m2() {...}
}

public class Derived extends Base {
    public void m1() {...}  // OK, overriding Base#m1()
    public void m2() {...}  // forbidden
}
```

Reference
----------
README 꾸미기 : https://gist.github.com/ihoneymon/652be052a0727ad59601
