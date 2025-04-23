package level2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Calculator 객체 생성
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);

        System.out.println("==================== 계산기 시작 ====================");

        while (true) {
            System.out.print("첫 번째 숫자: ");
            int a = sc.nextInt();   
            System.out.print("두 번째 숫자: ");
            int b = sc.nextInt();

            System.out.println("================= ( +,-,*,/ 선택 ) =================");
            sc.nextLine(); // 남아있는 \n 삭제
            char type = sc.nextLine().trim().charAt(0);

            try {
                int result = 0;

                // 연산 수행
                switch (type) {
                    case '+':
                        result = calculator.add(a, b);
                        break;
                    case '-':
                        result = calculator.subtract(a, b);
                        break;
                    case '*':
                        result = calculator.multiply(a, b);
                        break;
                    case '/':
                        result = calculator.divide(a, b);
                        break;
                    default:
                        System.out.println("올바르지 않은 사칙연산 기호.");
                        continue; // 잘못된 연산자 입력 시 다시 입력 받기
                }

                // 연산 결과 출력
                System.out.println("결과: " + result);

                // 추가적인 연산 결과 출력
                System.out.println("현재까지의 연산 결과: " + calculator.getResults());

                // 삭제 기능 구현: 결과 삭제 여부 묻기
                System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (y / n): ");
                if (sc.nextLine().equals("y")||sc.nextLine().equals("Y")) {
                    calculator.removeResult();
                    System.out.println("가장 먼저 저장된 결과 삭제.");
                }
            } catch (Exception e) {
                System.out.println("error 발생 : " + e.getMessage() + "\n");
            }

            // 계속 계산할지 종료할지 묻기
            System.out.println("종료하려면 q 입력 ( 다른 내용 입력 시 다른 계산하기 )");
            if(sc.nextLine().equals("q")||sc.nextLine().equals("Q")){
                break;
            }
            else{
                System.out.println("==================== 다른 연산 실행 ====================");
            }
        }

        System.out.println("계산기를 종료합니다.");
    }
}
