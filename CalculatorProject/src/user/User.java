package user;

import calculator.Calculator;
import calculator.repository.ResultRepository;
import exception.DivisionByZeroException;
import exception.EmptyListException;
import exception.InvalidOperatorException;

import java.util.InputMismatchException;
import java.util.Scanner;

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
