import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static int precedence(char op) {
        switch (op) {
            case '^': return 4;
            case '*':
            case '/': return 3;
            case '+':
            case '-': return 2;
            default: return 0;
        }
    }
    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty()) stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c) && stack.peek() != '(') {
                    if (c == '^' && stack.peek() == '^') break;
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < N; i++) {
            String infix = sc.nextLine().trim();
            String postfix = infixToPostfix(infix);
            System.out.println(postfix);
        }
    }
}
