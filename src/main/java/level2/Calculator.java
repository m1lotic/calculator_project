package level2;

import calInterface.calculatorInteface;
import java.util.ArrayList;
import java.util.List;


public class Calculator implements calculatorInteface {

    // 연산 결과를 저장하는 필드 ( 연결리스트 )
    private List<Integer> results = new ArrayList<>();

    // "App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정 (캡슐화)"를 위한 setter
    private void setResults(List<Integer> results) {
        this.results = results;
    }

    //각 사칙연산 구현
    @Override
    public int add(int a, int b) {
        int result = a + b;
        results.add(result);
        return result;
    }

    @Override
    public int subtract(int a, int b) {
        int result = a - b;
        results.add(result);
        return result;
    }

    @Override
    public int multiply(int a, int b) {
        int result = a * b;
        results.add(result);
        return result;
    }

    @Override
    public int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("0으로 나누기 불가능.");
        }
        int result = a / b;
        results.add(result);
        return result;
    }

    // 결과 반환 (가장 최근의 결과를 반환)
    @Override
    public int result() {
        if (!results.isEmpty()) {
            return results.get(results.size() - 1); // 가장 최근 결과 반환
        } else {
            throw new IllegalStateException("계산된 결과가 없음.");
        }
    }

    // 결과를 저장하는 컬렉션의 getter 메서드
    public List<Integer> getResults() {
        return results;
    }

    // 가장 먼저 저장된 결과를 삭제하는 메서드 ( 맨 앞 인덱스 제거 )
    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }
}