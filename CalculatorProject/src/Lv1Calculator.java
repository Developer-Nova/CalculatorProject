import java.util.Scanner;

public class Lv1Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            getStart(scanner);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String userChoice = scanner.nextLine();
            if (userChoice.equals("exit")) {
                flag = false;
            }
        }
    }

    private static void getStart(Scanner scanner) {
        System.out.print("첫 번째 숫자를 입력하세요: ");
        int firstValue = scanner.nextInt();

        System.out.print("두 번째 숫자를 입력하세요: ");
        int secondValue = scanner.nextInt();
        scanner.nextLine();

        System.out.print("사칙연산 기호를 입력하세요: ");
        String operator = scanner.nextLine();

        calculate(firstValue, secondValue, operator);
    }

    private static void calculate(int firstValue, int secondValue, String operator) {
        int result;
        switch (operator) {
            case "+":
                result = add(firstValue, secondValue);
                break;
            case "-":
                result = subtraction(firstValue, secondValue);
                break;
            case "/":
                result = divide(firstValue, secondValue);
                break;
            case "*":
                result = multiply(firstValue, secondValue);
                break;
            default:
                result = 0;
                System.out.println("잘못된 연산자 입니다.");
        }

        System.out.println("결과: " + result);
    }

    private static int multiply(int firstValue, int secondValue) {
        return firstValue * secondValue;
    }

    private static int divide(int firstValue, int secondValue) {
        return (secondValue != 0) ? firstValue / secondValue : safeDivideWithZeroCheck();
    }

    private static int subtraction(int firstValue, int secondValue) {
        return firstValue - secondValue;
    }

    private static int add(int firstValue, int secondValue) {
        return firstValue + secondValue;
    }

    private static int safeDivideWithZeroCheck() {
        System.out.println("0 으로 나눌 수 없습니다.");
        return 0;
    }
}
