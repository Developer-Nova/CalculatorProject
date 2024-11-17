# 🧮 CalculatorProject

**간단한 계산기를 만들며 Java 의 기본 문법과 객체지향에 대해서 학습하였습니다.**

## ☑️ Index
- [🏁 Team](#-Team)   
- [📑 Commit Convention](#-Commit-Convention)   
- [🛜 Git Flow](#-Git-Flow)
- [🔗 Class Diagram](#-Class-Diagram)
- [🔥 Trouble Shouting](#-Trouble-Shouting)
- [✅ 마무리](#-마무리)

<br>

## 🏁 Team
|**우현**|
|--------|
|<img src="https://github.com/Developer-Nova/Sec19-Local-Data-Persistance_ByAngela/assets/123448121/17a2ba3b-a618-4ac8-93b9-0d0e02c19c78" width="110" height="110">|
|[Nova's GitHub](https://github.com/Developer-Nova)|

<br>

## 📑 Commit Convention

**`feat`** : 새로운 기능 추가

**`fix`** : bug fix

**`docs`**  : 문서 수정

**`style`** : 세미콜론 같은 코드의 사소한 스타일 변화.

**`refactor`** : 변수명 수정같은 리팩터링

**`test`** : 테스트 코드 추가 & 수정

**`chore`** : 중요하지 않은 일

<br>

## 🛜 Git Flow

**계산기 프로젝트에 맞춰 `git-flow` 전략을 적용해보고 개발을 진행했습니다. Lv 별 브랜치를 나누어 독립적으로 작업하고 `develop` 브랜치에서 통합 후 `main` 브랜치에 최종 `merge` 하였습니다.**

<img width="1000" src="https://github.com/user-attachments/assets/8a236f32-eb6c-48b2-bf8c-d9499693f595">

- main: 최종 제출

- develop: Lv 별 구현 기능 통합

- lv1_calculator: Lv1 프로젝트 구현

- lv2_calculator: Lv2 프로젝트 구현

<br>

## 🔗 Class Diagram

<img width="1000" src="https://github.com/user-attachments/assets/8bbd9080-3db4-4e87-932e-9373c1bec6d9">

<br>
<br>

## 🔥 Trouble Shouting

### 1. `.nextInt()` 메서드 호출 시 필요하지 않은 문자가 `Scanner` 의 버퍼에 남는 문제

`Scanner` 의 `nextInt()` 메서드를 호출하면 숫자를 읽고 나서 다음 출력문이 의도대로 나오지 않는 문제가 있었습니다.    

`nextInt()` 메서드를 사용하면 오직 숫자값만 가져가기 때문에 입력 버퍼에 개행 문자(엔터키를 누를 때 생긴 \n)가 남아 발생한 문제였습니다.    

그래서 문자열 출력문이나 입력문에서 이 개행 문자 때문에 입력이 겹치거나 자동으로 넘어가는 것처럼 보였습니다.    

<br>

### 해결방법

~~~ java
System.out.print("첫 번째 숫자를 입력하세요: ");
        int firstValue = scanner.nextInt();

        System.out.print("두 번째 숫자를 입력하세요: ");
        int secondValue = scanner.nextInt(); // <- int 값만 가져가기 때문에 (\n) 개행문자가 버퍼에 남아 있음
        //scanner.nextLine(); <- .nextLine() 을 호출하여 입력버퍼에 남은 불필요한 문자 제거

        System.out.print("사칙연산 기호를 입력하세요: ");
        String operator = scanner.nextLine();
~~~

위의 코드처럼 `scanner.nextInt()` 메서드 호출 이후에 `nextLine()` 메서드를 호출하여 입력버퍼에 남아 있는 개행문자 값을 버립니다.

이렇게 하면 이후에 실행되는 출력문이 의도한대로 출력되게 만들 수 있습니다.

<br>

### 2. 에러를 처리하는 시점에 대한 문제

`try-catch` 문을 사용하여 에러를 처리할 때 `main` 메서드에서 모든 에러를 처리하게 되면 `User` 클래스의 로직이 의도대로 실행되지 않는 문제가 있었습니다.

`while(true)` 문 실행 도중에 에러가 발생하게 되면 프로그램 종료가 아닌 유저에게 다시 질문을 하고 다음 로직을 선택할 수 있도록 의도하였지만 아래와 같이 모든 에러를 `main` 메서드에서 처리하게 되면 `while` 문을 빠져나와 프로그램이 종료되어 버리게 됩니다. 

~~~ java
public class Lv2Calculator {

    public static void main(String[] args) {
        User user = new User();

        try {
            user.getStart(new Scanner(System.in));
        } catch (NumberFormatException e) {
            
        } catch (InvalidOperatorException e) {

        } catch (DivisionByZeroException e) {

        } catch (EmptyListException e) {

        }
    }
}
~~~

<br>

### 해결방법

~~~ java
public class User {

    private final Calculator calculator = new Calculator(new ResultRepository());

    public void getStart(Scanner scanner) {
        while (true) {
            System.out.print("메뉴 - 1. 계산 | 2. 조회 | 3. 삭제 | 4. 종료: ");
            try {
                switch (scanner.nextInt()) {
                    case 1 -> processCalculation(scanner);
                    case 2 -> getList();
                    case 3 -> deleteValue();
                    case 4 -> {
                        return;
                    }
                    default -> System.out.println("메뉴를 다시 선택해 주세요.");
                }
            } catch (EmptyListException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해 주세요. error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private void processCalculation(Scanner scanner) throws InputMismatchException {
        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                this.calculator.setFirstValue(scanner.nextDouble());

                System.out.print("두 번째 숫자를 입력하세요: ");
                this.calculator.setSecondValue(scanner.nextDouble());
                scanner.nextLine();

                System.out.print("사칙연산 기호를 입력하세요: ");
                this.calculator.setOperator(scanner.nextLine());

                System.out.println("결과: " + calculator.calculate());
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("숫자를 입력해 주세요. error: " + e.getMessage());
                scanner.nextLine();
            } catch (InvalidOperatorException | DivisionByZeroException e) {
                System.out.println(e.getMessage());
            }

            while (true) {
                System.out.print("더 계산하시겠습니까? (Y / N): ");
                String choice = scanner.nextLine();
                if (choice.equals("Y") || choice.equals("y")) {
                    break;
                } else if (choice.equals("N") || choice.equals("n")) {
                    return;
                } else {
                    System.out.println("다시 입력해주세요.");
                    System.out.println();
                }
            }
        }
    }

    private void getList() throws EmptyListException {
        System.out.println("조회 결과: " + this.calculator.getList());
    }

    private void deleteValue() throws EmptyListException {
        System.out.println("삭제한 값: " + this.calculator.deleteFirstValue());
        getList();
    }
}
~~~

에러 처리를 `User` 클래스의 `while(true)` 문 내부에서 `try-catch` 문을 통해 에러를 처리하면서 에러가 발생하여도 정상적으로 로직이 실행될 수 있도록 수정 하였습니다.

또한 사용자는 `main` 메서드에서 `User` 클래스만 생성하고 `.getStart(new Scanner(System.in));` 메서드만 호출한다면 깔끔하게 계산기를 이용할 수 있습니다.
 
<br>

### 3. Stream 사용시 연산 기호와 열거형 매핑 문제

`Operator` 열거형을 정의한 후 입력받은 연산기호가 맞는지 검증하는 부분에서 `Stream` 을 사용할 때 각 연산기호와 열거형 케이스를 한번더 매핑해줘야 하는 문제가 있었습니다.

큰 문제는 아니였지만 로직에 맞지 않는 불필요한 코드라고 생각되었습니다.

~~~ java
public class Calculator {
    
    private static final Map<String, Supplier<UserOperator>> OPERATOR_MAP = Map.of(
            "+", Operator.ADD::getOperator,
            "-", Operator.SUBTRACTION::getOperator,
            "/", Operator.DIVIDE::getOperator,
            "*", Operator.MULTIPLY::getOperator
    );  // 열거형 케이스와 연산기호를 매핑

    public static UserOperator parseOperator(String operationInput) throws InvalidOperatorException {
        return OPERATOR_MAP
                .getOrDefault(operationInput, () -> {
                    throw new InvalidOperatorException("올바르지 않은 연산자 입니다.");
                })
                .get();
    }  // 매핑된 연산기호와 입력받은 연산기호를 비교하여 일치하는 연산기호의 객체를 반환
}
~~~

위의 코드 처럼 굳이 따로 매핑하지않고 연산기호와 각 연산클래스를 함께 관리하는 방향에 대해서 고민하였습니다.

<br>

### 해결방법

~~~ java
public enum Operator {
    ADD("+", new AddOperator()),
    SUBTRACTION("-", new SubtractionOperator()),
    DIVIDE("/", new DivideOperator()),
    MULTIPLY("*", new MultiplyOperator());

    private final UserOperator objectOperator;
    private final String stringOperator;

    Operator(String stringOperator, UserOperator objectOperator) {
        this.stringOperator = stringOperator;
        this.objectOperator = objectOperator;
    }

    public UserOperator getOperator() {
        return objectOperator;
    }

    public String getStringOperator() {
        return stringOperator;
    }
}
~~~

위의 코드처럼 열거형 케이스를 정의할 때 문자열 연산기호와 그에 맞는 연산 클래스를 함께 관리할 수 있도록 수정하였습니다.

이렇게 함께 관리하게 되면 굳이 매핑하는 코드를 작성하지 않아도 입력받은 연산기호를 `Stream` 을 통해 검증할 수 있습니다.

~~~ java
public static UserOperator parseOperator(String operationInput) throws InvalidOperatorException {
        return EnumSet.allOf(Operator.class).stream()
                .filter(operator -> operator.getStringOperator().equals(operationInput))
                .findFirst()
                .orElseThrow(() -> new InvalidOperatorException("올바르지 않은 연산자 입니다."))
                .getOperator();
    }
~~~

<br>
<br>

## ✅ 마무리

규모가 크지 않은 간단한 프로젝트 이지만 객체지향을 설계할 때 어떤 점을 고려하면 좋을지 그리고 에러 처리의 시점에 대해서 많은 고민을 하게 되었던것 같습니다.













