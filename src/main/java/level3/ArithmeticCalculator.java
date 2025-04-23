package level3;

import calInterface.calculatorInterfaceGeneric;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

public class ArithmeticCalculator<T extends Number> implements calculatorInterfaceGeneric<T>{

    private List<T> results = new ArrayList<>();

    // 연산 메서드 (사칙연산)
    // 트러블 슈팅 : 디버깅으로 배열 까보니 results에 안쌓임 결과가 (레벨2 소스 구조를 수정하다 보니 results(리스트)에 결과값을 저장안함) -> 추가 / goOperation은 연산만 하자.
    @Override
    public T add(T a, T b) {
        T result = goOperation(a, b, operatorType.ADD);
        results.add(result);

        return result;
    }

    @Override
    public T subtract(T a, T b) {
        T result = goOperation(a, b, operatorType.SUBTRACT);
        results.add(result);

        return result;
    }

    @Override
    public T multiply(T a, T b) {
        T result = goOperation(a, b, operatorType.MULTIPLY);
        results.add(result);

        return result;
    }

    @Override
    public T divide(T a, T b) throws ArithmeticException {
        T result = goOperation(a, b, operatorType.DIVIDE);
        results.add(result);

        return result;
    }

    @Override
    public T result() {
        if (!results.isEmpty()) {
            return results.get(results.size() - 1); // 가장 최근 결과 반환
        } else {
            throw new IllegalStateException("계산된 결과가 없음.");
        }
    }

    public List<T> getResults() {
        return results;
    }


    // 저장된 연산 결과들 중 입력받은 값보다 큰 값들만 반환
    public List<T> greaterThanFilterResults(T num) {
        return results.stream()
                .filter(result -> result.doubleValue() > num.doubleValue())
                .collect(Collectors.toList());
    }

    // 연산 수행을 위한 메서드 (OperatorType 사용)
    private T goOperation(T a, T b, operatorType operator) { // 하나가 double이면 연산 결과가 어떻게 되던 double이라 조건은 2개만 하였음!
        if (a instanceof Integer && b instanceof Integer) {
            return (T) Integer.valueOf(operator.calculate(a.intValue(), b.intValue()));
        } else if (a instanceof Double && b instanceof Double) {
            return (T) Double.valueOf(operator.calculate(a.doubleValue(), b.doubleValue()));
        }
        throw new UnsupportedOperationException("지원되지 않는 타입");
    }
}

