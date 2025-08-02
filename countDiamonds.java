import java.util.Scanner;

public class Main {
    public static int countDiamonds(String s) {
        int count = 0;
        int stack = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '<') {
                stack++;
            } else if (c == '>' && stack > 0) {
                stack--;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            System.out.println(countDiamonds(line));
        }
        sc.close();
    }
}
