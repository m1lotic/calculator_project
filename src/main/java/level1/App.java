package level1;

/*
import org.jline.keymap.BindingReader;
import org.jline.keymap.KeyMap;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //스캐너 객체 생성
        Scanner sc = new Scanner(System.in);
        System.out.println("==================== 계산기 시작 ====================\n");

        int a, b, result;
        char type;

        while (true) {
            try {
                System.out.println("양의 정수(0포함) 2개 입력 : ");

                System.out.print("첫 번째 숫자: ");
                a = sc.nextInt();

                System.out.print("두 번째 숫자: ");
                b = sc.nextInt();

//"양의 정수 연산만 허용" 조건 체크
                if (a < 0 || b < 0) {
                    throw new Exception("양의 정수(0을 포함한 수)만 입력가능.");
                }

                System.out.println("================= ( +,-,*,/ 선택 ) =================\n");

                sc.nextLine(); // 남아있는 \n 삭제
                type = sc.nextLine().trim().charAt(0);

// “나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.“ 조건에 따른 오류체크
                if (b == 0 && type == '/') {
                    throw new Exception("0으로 나누기 불가능.");
                }

                result = switch (type) {
                    case '+' -> a + b;
                    case '-' -> a - b;
                    case '*' -> a * b;
                    case '/' -> a / b;
                    default -> throw new IllegalArgumentException("올바르지 않은 사칙연산 기호.");
                };

/* 트러블슈팅 : level 2 상황의 switch문 사용처럼 continue 사용하려 했으나 (->,:) 스위치 표현식에 따른 차이로 오류 발생
                ->는 return 값을 직접 변환하는 형태로, :는 break, continue와 같은 제어문 사용가능

                switch (type) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                    default:
                        System.out.println("올바르지 않은 사칙연산 기호.");
                        continue;  // 잘못된 연산자 입력 시 다시 입력 받기
                }

 */


                System.out.println("결과 : " + result);
                System.out.println("종료하려면 q 입력 ( 다른 내용 입력 시 다른 계산하기 )");

//q 누를시 종료 ( jline 외부 라이브러리 사용 ) -> Scanner 환경에서 사용불가, 실제 터미널에서 사용 가능
               /*
                System.out.println("종료하려면 q 입력 ( 다른 키 누를 시 다른 계산하기 )");
                Terminal terminal = TerminalBuilder.builder().dumb(true).build();
                BindingReader reader = new BindingReader(terminal.reader());

                KeyMap<String> keyMap = new KeyMap<>();
                keyMap.bind("quit", "q");

                String key = reader.readBinding(keyMap);

                if(key != null && "quit".equals(key)){
                    break;
                }
                else{
                    System.out.println("다른 연산 실행");
                }
                */
                if (sc.nextLine().equals("q")) {
                    break;
                } else {
                    System.out.println("==================== 다른 연산 실행 ====================");
                }

            } catch (Exception e) {
                System.out.println("error 발생 : " + e.getMessage() + "\n");
                sc.nextLine(); // 남아있는 \n 삭제
            }
        }
        System.out.println("==================== 계산기 종료 ====================");
    }
}
