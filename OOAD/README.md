OOP,OOAD,UML 정리(김인수)
--------------------------

[2장. Object-Oriented Principles]

추상화 (abstraction) - 필요한 정보만을 취한다
캡슐화 (encapsulation) - 정보를 숨긴다
계승 (inheritance) - 일반화. is-a
다형성 (polymorphism) - composition을 통해서 polymorphism을 구현
구성 (composition) - has-a. 런타임에 dynamic하게 object를 호출

16page (중요예제)
추상클래스는 필요한 값은 다 있지만 new로 생성하지 않는다. 인터페이스만 정의


[3장. Object-Oriented Development]

절차적언어(procedural programming) : C, fortran >>> SASD
객체지향언어(Object-Oriented programming) : C++ , Java, Ada  >>> OOAD

SASD (Structured Analysis and Structured Design)
 - 알고리즘, Data Structure 중요 (글로벌로 선언하여 여기저기서 사용)
 - 탑다운, 분할 및 정복, DFD(Data flow diagram)

OOAD (Object-Oriented Analysis Design)
 - object communication 을 통한 
 - OOA (컨셉/object 찾기, 요구분석, Usecase 다이어그램)  
 - OOD (sequences 다이어그램 -> class 다이어그램)

11page (중요예제)

Software Process Medel
 - waterfall : 점진적
 - iterative : 반복적, aglie

UP (Unified Process) 
 - 모든 방법론을 다 통합, OOAD의 defacto 표준
 - 미니 waterfall주기는 3week             
 - risk-driven (아키택처), client-driven, architecture-centric, usecase-driven
 - 4 Phase, 9 Disciplines
 - UML 기반


[4장. Introduce to UML]
UML (Unified Modeling Language) 
 - 13가지 모델링 언어
 - OML 에서 정의함
 - ERD, 비지니스모델링, 오브젝트모델링, 컴포넌트 모델링 등 다양하게 사용

UML Grammer = Syntax + Semantics

UML Semantics (의미론)
 - 4 Layer (instance -> model -> meta model -> meta-meta model)  
 - M3 meta-meta model : 탬플릿, .NET 프레임워크
   M2 meta model (모델을 정의)
   M1 model (UML 그리기)
   M0 information (Application)

13 UML diagrams (2.2 까지 있으며 일반적으로 2.0을 사용)
 (Structure Diagram)
 - *class : 대문자, OOA(domain model) ,OOD(design class diagram) 둘다 사용
 - object : 소문자/밑줄 , object명:클래스명, 특정시간의 object 상태 정의가 필요한 경우에만 사용 (snapshot)
 - package : 좌상단 박스에 패키지명, class 의 모음, 논리적 아키텍처, 후반부에 사용됨
 - component : 우상단 커넥터표시, package의 모임, 컴포넌트(=sw개발의 단위, logical)
 - composite structure : 컴포넌트 다이어그램을 계층적으로 표현한 구조 (컴포넌트 내부에 컴포넌트)
 - deployment : SW컴포넌트가 동작할 HW node 까지 표현

 (Behaviour Diagram)
 - activity : flowcharts, data-flow-diagram. 각 state 내부에서 동작함
 - *use case : 각 유즈케이스별 설명 (상세 시나리오 txt) 이 중요. 각 state 간  화살표에서 동작함
 - state machine : 객체의 상태에 따라서 객체의 이벤트가 어떻게 동작하는지 표현
 - *sequence : 시간순서에 따른 (위->아래), 복잡한거 표현시 사이즈가 커짐
 - communication : 시간순서와 무관, 사이즈가 커지지 않음, 순서는 넘버링으로 표현, 압축해서 설명시 사용
 - interaction overview : 전체 시나리오 동작을 볼때 사용. 세부에는 시퀀스 다이어그램
 - timing : object의 행동에 따른 상태를 표현


[5장. Usecase Diagram]
usecase 정의 : 사용자의 목적을 달성위한 텍스트 스토리. 다이어그램이 아님
usecase 레벨 : brief -> casual -> fully dressed

usecase diagram : actor 와 usecase 를 선으로 연결
                       usecase 를 클릭시 text 설명을 확인

추가설명 :
시스템의 바운더리를 정의 가능
Actor 를 사람그림 말고 <<Actor>> 로 하라는 경우도 있음

3가지 포멧
 - brief : 시나리오간 구분 없음
 - casual : Main / Alternate / Exceptional 시나리오를 구분
 - fully dressed : 모든 step을 다 표현 (Preconditions등)

UP에서는 유즈케이스로 Functional Requrement 를 대체
 SRS 
  - F : 유즈케이스 다이어그램
  - NF : 나머지 다이어그램

가이드라인
 - Essential 스타일 (자유도 높음) ↔ Concreate
 - BlackBox 스타일 (자유도 높음)


[6장. Class Diagram]
OOA(domain model) ,OOD(design class diagram)
  
Object 
 - 소문자object명:class명
 - operation 은 없음. attribute 만 표기
 - classname / attributes/ operations
 
Attribute Syntax
 + public (operation default)
 - private (attribute default)
 # protected
 ~ pasckage

 derived attribute : 다른 값에서 계산해서 가져옴. (ex. age)
 Data type : pre define, user define, composite (구조체)
 multiplicity : 여러 값이 올수 있음
 default value
 properties : 상세 특성 (ex. readonly)
 parameters : in/out/inout (아무것도 없으면 디폴트로 in)

Operation Method
 operation 을 코드로 구현하면 method
 class variable,operation : static으로 표기
 getter , setter
 Note symbols : 우측 상단에 살짝 접힌 모양. 커멘트, 수도코드, method body 등

class relationship 타입 -- 상세예제 교재 참조
 (약함)
 dependency : 점선화살표, 한번 연계되고 소멸, 주로 component 다이어그램에서 사용
 association (default) : 실선
 aggregation : 실선에 하얀 마름모, share reference
 composition : 실선에 까만 마름모, contain
 inheritance : 실선에 삼각화살표, 상속
 (강함)
  

[7장. Sequence Diagram]
behaviour 하위의 interaction 하위의 sequence

소스코드의 operation을 채우기 위해서는 sequence 다이어그램이 필요하다.
new 생성은 class 다이어그램으로 확인가능

3Type Message
 - Synchronous message : 까만화살표실선. 일반적. 응답할때까지 대기
 - Asynchronous message : 꺽쇠화살표실선
 - Response message : 꺽쇠화살표점선
 (사선) Time-consuming message : 메시지가 전송하는데 시간이 걸리는 경우

Create : 점선create, 높이는 아래로
destroy : 점선<<destroy>>, X자 표기

Fragment
 - alt : switch case 문, 점선으로 구분, 각 case별로 조건문
 - opt : if문, 조건문 만족시 수행
 - loop : 반복문, loop(min,max) [조건], *이면 (0,*)
 - break : [조건] 만족시 break 상위 box 에서 이후 시나리오는 break. 만약 box 없으면 전체가 종료
 - seq : 위->아래 뿐 아니라 실행가능한 시나리오 순서를 별도로 정의함
 - ref (interation reference) : 미리 정의된 레퍼런스를 수행하고 옴
  
유즈케이스 -> 시퀀스다이어그램 -> 클래스다이어그램 순으로 작성해야한다


[8장. Statechart Diagram] (=State Machine Diagram)
Final state machine 과 동일한 내용을 표현
Activity 다이어그램과 그리는 방식이 반대
State 의 이름이 중요 (현재의 상태값)

State
 - Initial state : 가상상태
 - Final state : 실제상태
 - Terminate node

Operation
 - entry/activity
 - exit/activity
 - do/activity

Transition
 Source state -> event / condition check / action -> Target state

state 종류
 - composite state : (or state), state 내부에 substate 가 또 있는것, substate중 1개만 active 
 - orthogonal state : (and state), state 내부에 점선으로 region 구분, 동시에 여러개가 active, 모든 region 이 end state 가 되면 종료
 - submachine state : 안경모양 표시, state 내부에 substate 가 있는것을 간략히 표현, 누르면 상세한 내용이 보임
 - history state : 
      H* : deep history state (나갔을때 상태 그대로 복귀) 
      H :  shallow history (현재와 같은 레벨로 복귀)


[9장. Activity Diagram]
시스템 액션의 흐름을 보여줌
시스템 내부의 method/function 운영흐름을 보여줌
데이터의 흐름을 보여주지는 않음
decision 을 표현함
bar(바) 를 만나면 분기

값 - Action
실선화살표 - Transition
마름모 - Decision
점선화살표 - 사각형에 State 표현
세로선(swimlanes) - 상단에 어떤객체가 수행하는지 표현 (잘 쓰지는 않음), 가로선으로 해도 동일함


[10장. Component Diagram]
컴포넌트 : 독립적인 개발의 단위, 관련 클래스의 모음, 하위에 컴포넌트도 가능
표현 : <<component>> 콘센트모양

provided interface : 'O' 아이콘,  DataSource, output역할
required interface : '(' 방향으로 들어감, 롤리팝?, FeedProvider, DisplayConverter, input역할

표현방법
 - Ball and socket
 - Stereotype
 - Text listings

컴포넌트간 연계
 A ----> B
 : 데이터는 B에서 A로 전달

컴포넌트 내부를 object나 class 까지 표현하면 Composite Structure Diagram

컴포넌트 내부에 있는 컴포넌트끼리 연결할때는 다른 용어를 사용
 - Assembly connector : 내부 컴포넌트끼리 연결
 - Delegation connector : 컴포넌트 외부와 내부를 연결


[11장. OOAD-introduce]
chapter1
OOA : concept/object, requirement (usecase) 
         define domain model

OOD : how collaborate (sequence diagram)
         software object (class diagram)

OOA                                      OOD
1. usecase를 뽑아서              3. sequence diagram 작성
2. 도메인 모델 작성              4. 2와3을 참조해서 class diagram 작성

UML 3가지 사용법
 - sketch : 컨셉 잡기, OOA단계
 - blueprint : 설계도. syntax sementic 을 정확히, OOD단계
 - programming language : UML 도구에서 지원해야함. 유료. 잘 안쓰임

UML 은 OOAD 프로세스가 아님
UML 은 OOthinking 을 가르쳐주지 않음

chapter2
UP (Unified Process)
 - Iterative (반복적) - 미니waterfall 3주
 - Agile에서 영감받음
 - 유연함

Risk-driven
 - 아키택처측면의 리스크
 - 클라이언트 리스크

UP Phases
 - inception : 1주 짜리 initial step. 비전, 기능화필요?, 구매는?, 비용은? -> go/stop 을 결정
 - elaboration : 코어아키택처, 고 리스크 부분 구현 후 discuss 반복. 요구사항 확정
 - construction : 대부분의 일반적인 구현. 
 - trasition : 베타테스트, deploy

UP disciplines (분야) 9가지
 - business modeling
 - requirements
 - design
 - implemetation
 - test
 - deployment
 - configuration & change management
 - project management
 - environment : deveolpment case 를 정의함

Deveolpment Case : Phases 마다 어떤 disciplines 을 적용할지 선택 (모든걸 다하지는 못함) 


[11장. OOAD-inception]
chapter4
inception 은 요구사항도출만 하는 단계가 아님. 아주 간략히 도출(brief 수준)

산출물
 - * usecase model : 기능적 요구사항
 - * supplementary specification : 넓고 얇게
 - vision
 - glossary
 - risk manage plan
 - prototype
 - iteration/phase/development plan

필요한 만큼만 적당히 UML 모델링 수행

chapter5. requirements
UP에서는 requirement 는 iteratively, skillfully 하게 analyzed
FURPS를 requirement의 체크리스트 정도로 활용
 - functional, usability, reliability, performance, supportability

Functional requirement 는 usecase 로 기재 
Non Functional requirement 는 supplementary specification 로 기재

quality attribute : 30~40가지 카테고리. 요구사항마다 이중 일부에 크게 영향을 받음 (ex. 보안, 법, 비용 등등)

chapter6. use case
기능요건을 usecase 에 정의
inception phase 에서는 중요한것만 일부 fully dressed, casual 로 하고 대부분은 brief 수준으로 작성
elaboration 에서 최종 정의

chapter7. other requirements
UP에서는 딱히 정해진 포멧이 있지는 않음.
유즈 케이스에서 정의하기 어려운 다양한 비기능적 요건들을 supplementary specification 에 정의
elaboration 에서 최종 정의



[13장. Elaboration-OOA]
elaboration 
미니waterfall (OOA,OOD,OOI) -> 워크샵(아키택처, 클라이언트 등 이해관계자 참석)
를 3주동안 반복수행

chapter8. iteration basic
risk한 아키택처 구현 및 테스트, requirement 구현

주요산출물
 - 도메인모델 (OOA)
 - 디자인모델 (OOD)
 - Software Architecture Document (AA)
 
chapter9. Domain Model
구조 : 
 - "이름/Attribute"
 - 도메인간 Associate (실선) 으로만 표기

특징 : 
 - 도메인 이해를 돕는 수준으로만 간단히
 - 이해관계자별 관점이 달라서 도메인 모델이 다르게 표현될 수 있다. 
 - operation 없음
 - 만약 자주 사용하는 아키택처라 익숙하다면 거의 class diagram 처럼 생각해도 됨 (전문가라면)
 - software object 가 아니기 때문에 클래스/매소드 등이 불필요
 - elaboration 에서만 작성/사용 

만드는 이유
 - 도메인에 대한 이해
 - 클래스를 구현하기 전에 사전연습


chapter10. system sequence diagram (SSD)
Usecase Model 
 : usecase (usecase diagram + usecase text)  + SSD

목적 : system operation 을 도출 (external actor의 시스템 인터페이스) >> OOD 에서 구현

실제 인터페이스(GUI/UI/HW 등) 가 어떻게 구현될지는 아직 모르기때문에 추상적으로 도출
 

chapter11. operation contracts
Elaboration 마지막에 operation 이 확정되면 그때 작성
필수 요소는 아님 (유즈케이스가 불분명할때만 작성)

구성
 - operation
 - cross references
 - preconditions
 - postconditions (유즈케이스 내용과 유사)


[14장. Elaboration-OOD]
chapter12. requirements to disign iteratively

chapter13. logical architecture and UML package diagram
소프트웨어 아키텍쳐란 - SW시스템 구성과 관련된 중요한 결정의 모임
 - 구조와 인터페이스를 선택
 - 구조와 행위의 요소를 구성
 - 아키택쳐 스타일
  >> AD

Logical Architecture - UML 패키지 다이어그램으로 작성

대표 Logical Architecture - Layer

Layered Architecture - 3개 layer 로 구성
 - UI layer
 - Business layer (application logic and domain object layer)
 - technical services layer (kernel, OS 등)

Layerd Architecture >> 패키지 다이어그램으로 표현 가능 >> 코드로 매핑 가능


chapter14. on to object design
Static Model (class diagram, packge diagram, deployment diagram)
Dynamic Model (sequence diagram, statechart diagram, activity diagram) - operation body 구현시 사용
위 두가지가 반복적으로 돌아가며 수행됨. 둘다 중요

object design skill 은 매우 어렵다 >> 참고자료 필요
 > 어떤 오브젝트에 할당할것인지 이론 (GRASP - 9가지)
    : 아무것도 없는 초기 상황에서 sd, cd 를 그리기 어려울때 참조하는 샘플. 초심자용
 > 디자인패턴 (23가지)
    : 디자인 완료된 상태에서 다이어그램을 일부 수정했을때 dependancy 로 복잡한 상황을 극복위해
     문제해결방안 예제. Reuse 를 목적으로 사용


[15장. Elaboration-OOI]
chapter19. designing for visibility
A->B 로 통신하려면 A에서 B가 보여야 함

visibility 구현
 - class diagram
 - code level 에서 구현하면서

4가지 방법 (A->B)
 - attribute visibility : B는 A의 속성
 - parameter visibility : B는 A의 파라메타. 받아서 attribute에 할당해서 쓰면 attribute visibility 로 전환된다
 - local visibility : A에서 B를 new로 생성 or 호출한 값을 variable 로 받아서 사용  
 - global visibility : B는 전역 object. 객체지향에서는 지양 ( C++은 가능하나 Java는 불가능 )


chapter20. mapping design to code
class diagram에서 시작 -> code generation -> skeletion code -> sequence diam 을 보고 mothed body를 채움

dependancy 가 없는 것부터 만들기 시작


[16장. OOAD summary]
1. OOA : 유즈케이스 정의 , 도메인모델 정의
2. OOD : 유즈케이스 -> interacion diagram 생성
         interaciton diagrm, domain model -> class diagram 생성
3. 유즈케이스별로 OOA, OOD iterative 하게 반복 

OOAD 의 표준 : UP

UP
 - inception : go/stop 결정
 - elaboration : requirement 확정, 코어아키텍처 구현, 3주
 - construction : 나머지 대부분 구현
 - transition : 배포

UP의 Environment Discipline 에서 Process Tailering  (현재 환경에 맞도록 프로젝트를 정의) >> Development Case작성

OOA 
 Domain Model
 Usecase Medel : usecase diagram -> usecase text -> system sequence diagram
                                                                    (-> system operation도출)
OOD
 Design Medel : sequence diagram
                     (개체는 도메인모델에서 , 흐름은 system operation 에서 가져와 작성)
                    class diagram
                     (sequence diagram 을 바탕으로 작성)

구현
 class diagram -> skeleton code 작성 > code body 는 sequence diagrm 에서 채움

OOD 를 위해서는 어려움. Deep principle 이 필요 > 패턴활용 (GRASP 9개 - 초기작성용 , Design Pattern 23개 - 재사용시 문제점 예방)

Object 모델 2가지
 - static model : class diagram
 - dynamic model : interaction diagram (sequence diagram)  , 양이 더 많다. 

OOI (implementation, 구현)
 - visibility
 - mapping


