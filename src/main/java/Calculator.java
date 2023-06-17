import java.io.InputStream;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    private String[] parseValues;
    private int calcResult = 0;

    public Calculator(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        String values = scanner.nextLine();

        parseValues = values.split(" ");
    }

    public int calculate() {
        Stack<String> operatorStack = new Stack<>();

        for (String parseValue : parseValues) {
            if (isOperator(parseValue)) {
                operatorStack.add(parseValue);
            } else {
                int parseInt = Integer.parseInt(parseValue);

                if (operatorStack.isEmpty()) {
                    calcResult += parseInt;
                } else {
                    String operator = operatorStack.pop();
                    calcResult = operateValue(parseInt, operator);
                }
            }
        }

        return calcResult;
    }

    int operateValue(int operateValue, String operator) {
        switch (operator) {
            case "+":
                return plus(operateValue);
            case "-":
                return minus(operateValue);
            case "*":
                return multiple(operateValue);
            case "/":
                return divide(operateValue);
            default:
                throw new IllegalArgumentException("Not Supported Operator");
        }
    }

    Boolean isOperator(String value) {
        return value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/");
    }

    int plus(int addValue) {
        return calcResult + addValue;
    }

    int minus(int minusValue) {
        return calcResult - minusValue;
    }

    int divide(int divideValue) {
        if (divideValue == 0) return 0;

        return calcResult / divideValue;
    }

    int multiple(int multipleValue) {
        return calcResult * multipleValue;
    }
}
