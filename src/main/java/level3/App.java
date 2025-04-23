package level3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Calculator 객체 생성 (Integer 타입 사용)
        ArithmeticCalculator<Integer> calculator = new ArithmeticCalculator<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("==================== 계산기 시작 ====================");

        while (true) {
            System.out.print("첫 번째 숫자: ");
            int a = sc.nextInt();
            System.out.print("두 번째 숫자: ");
            int b = sc.nextInt();

            System.out.println("================= ( +,-,*,/ 선택 ) =================");
            sc.nextLine(); // 남아있는 \n 삭제

            char operatorInput = sc.nextLine().trim().charAt(0);
            operatorType operator = null;

            // OperatorType enum을 이용하여 연산자 선택
            switch (operatorInput) {
                case '+':
                    operator = operatorType.ADD;
                    break;
                case '-':
                    operator = operatorType.SUBTRACT;
                    break;
                case '*':
                    operator = operatorType.MULTIPLY;
                    break;
                case '/':
                    operator = operatorType.DIVIDE;
                    break;
                default:
                    System.out.println("올바르지 않은 사칙연산 기호.");
                    continue; // 잘못된 연산자 입력 시 다시 입력 받기
            }

            try {
                // 연산 수행
                int result = 0;
                switch (operator) {
                    case ADD:
                        result = calculator.add(a, b).intValue();
                        break;
                    case SUBTRACT:
                        result = calculator.subtract(a, b).intValue();
                        break;
                    case MULTIPLY:
                        result = calculator.multiply(a, b).intValue();
                        break;
                    case DIVIDE:
                        result = calculator.divide(a, b).intValue();
                        break;
                }

                // 연산 결과 출력
                System.out.println("결과: " + result);

                // 결과 필터링
                System.out.print("기준값을 입력하세요: ");
                int filterValue = sc.nextInt();

                //System.out.println(calculator.getResults()); : 디버깅으로 배열 까보니 results에 안쌓임 결과가
                System.out.println("입력값보다 큰 결과들: " + calculator.greaterThanFilterResults(filterValue));


            } catch (Exception e) {
                System.out.println("error 발생 : " + e.getMessage() + "\n");
            }

            // 계속 계산할지 종료할지 묻기
            System.out.println("종료하려면 q 입력 ( 다른 내용 입력 시 다른 계산하기 )");
            if (sc.nextLine().equals("q") || sc.nextLine().equals("Q")) {
                break;
            } else {
                System.out.println("==================== 다른 연산 실행 ====================");
            }
        }

        System.out.println("계산기를 종료합니다.");

    }

}
