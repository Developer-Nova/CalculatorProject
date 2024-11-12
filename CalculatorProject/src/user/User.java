package user;

import calculator.Calculator;
import exception.DivisionByZeroException;
import operator.*;

import java.util.Scanner;

public class User {

    private final Calculator calculator = new Calculator();

    public void getStart(Scanner scanner) {
        boolean flag = true;

        while (flag) {
            processCalculation(scanner);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            if (scanner.nextLine().equals("exit")) {
                flag = false;
            }
        }
    }

    private void processCalculation(Scanner scanner) {
        System.out.print("첫 번째 숫자를 입력하세요: ");
        this.calculator.setFirstValue(scanner.nextInt());

        System.out.print("두 번째 숫자를 입력하세요: ");
        this.calculator.setSecondValue(scanner.nextInt());
        scanner.nextLine();

        System.out.print("사칙연산 기호를 입력하세요: ");
        this.calculator.setOperator(calculate(scanner.nextLine()));

        System.out.println("결과: " + calculator.calculate());
    }

    private UserOperator calculate(String operator) {
        return switch (operator) {
            case "+" -> new AddOperator();
            case "-" -> new SubtractionOperator();
            case "/" -> new DivideOperator();
            case "*" -> new MultiplyOperator();
            default -> {
                System.out.println("잘못된 연산자 입니다.");
                yield null;
            }
        };
    }
}
