package org.example.week2;

import java.util.StringTokenizer;

public class TwoStackAlogirthm {
    public static Double calculate(String expression){
        QueueBasedStack<Double> valueStack=new QueueBasedStack<>();
        QueueBasedStack<Character> operatorStack = new QueueBasedStack<>();
        StringTokenizer tokenizer = new StringTokenizer(expression, "");

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (isNumeric(token)) {
                valueStack.push(Double.parseDouble(token));
            } else if (isOperator(token.charAt(0))) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(token.charAt(0))) {
                    performOperation(valueStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            } else if (token.equals("(")) {
                operatorStack.push('(');
            } else if (token.equals(")")) {
                while (operatorStack.peek() != '(') {
                    performOperation(valueStack, operatorStack);
                }
                operatorStack.pop();
            }
        }

        while (!operatorStack.isEmpty()) {
            performOperation(valueStack, operatorStack);
        }

        return valueStack.pop();
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^' || c == '√';
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
            case '√':
                return 3;
            default:
                return 0;
        }
    }

    private static void performOperation(QueueBasedStack<Double> valueStack, QueueBasedStack<Character> operatorStack) {
        char operator = operatorStack.pop();
        double operand2 = valueStack.pop();
        double operand1 = (operator != '√') ? valueStack.pop() : 0;

        double result = 0;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
            case '%':
                result = operand1 % operand2;
                break;
            case '^':
                result = Math.pow(operand1, operand2);
                break;
            case '√':
                result = Math.sqrt(operand2);
                break;
        }

        valueStack.push(result);
    }
}
