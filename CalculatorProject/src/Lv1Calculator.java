import java.util.Scanner;

public class Lv1Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        getStart(scanner);
    }

    private static void getStart(Scanner scanner) {
        System.out.print("첫 번째 숫자를 입력하세요: ");
        int firstValue = scanner.nextInt();

        System.out.print("두 번째 숫자를 입력하세요: ");
        int secondValue = scanner.nextInt();

        System.out.print("사칙연산 기호를 입력하세요: ");
        String operator = scanner.nextLine();

        calculate(firstValue, secondValue, operator);
    }

    private static void calculate(int firstValue, int secondValue, String operator) {
        int result;
        switch (operator) {
            case "+":
                result = firstValue + secondValue;
                break;
            case "-":
                result = firstValue - secondValue;
                break;
            case "/":
                result = firstValue / secondValue;
                break;
            case "*":
                result = firstValue * secondValue;
                break;
            default:
                result = 0;
                System.out.println("잘못된 연산자 입니다.");
        }
        System.out.println("결과: " + result);
    }
}
