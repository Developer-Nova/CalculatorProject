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

    }
}
