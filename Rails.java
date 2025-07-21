import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            while (true) {
                int[] target = new int[n];
                target[0] = sc.nextInt();
                if (target[0] == 0) {
                    System.out.println();
                    break;
                }

                for (int i = 1; i < n; i++) {
                    target[i] = sc.nextInt();
                }

                Stack<Integer> station = new Stack<>();
                int current = 1;
                int index = 0;

                while (current <= n) {
                    station.push(current);
                    while (!station.isEmpty() && station.peek() == target[index]) {
                        station.pop();
                        index++;
                        if (index == n) break;
                    }
                    current++;
                }

                if (index == n) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }

        sc.close();
    }
}
