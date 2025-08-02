import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String expression = sc.nextLine();
            int balance = 0;
            boolean incorrect = false;

            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (c == '(') {
                    balance++;
                } else if (c == ')') {
                    balance--;
                    if (balance < 0) {
                        incorrect = true;
                        break;
                    }
                }
            }

            if (incorrect || balance != 0) {
                System.out.println("incorrect");
            } else {
                System.out.println("correct");
            }
        }

        sc.close();
    }
}
