import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); 
        
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            
            String[] frac1 = parts[0].split("/");
            int N1 = Integer.parseInt(frac1[0]);
            int D1 = Integer.parseInt(frac1[1]);
            
            char op = parts[1].charAt(0);
            
            String[] frac2 = parts[2].split("/");
            int N2 = Integer.parseInt(frac2[0]);
            int D2 = Integer.parseInt(frac2[1]);
            
            int numerator, denominator;
            switch (op) {
                case '+':
                    numerator = N1 * D2 + N2 * D1;
                    denominator = D1 * D2;
                    break;
                case '-':
                    numerator = N1 * D2 - N2 * D1;
                    denominator = D1 * D2;
                    break;
                case '*':
                    numerator = N1 * N2;
                    denominator = D1 * D2;
                    break;
                case '/':
                    numerator = N1 * D2;
                    denominator = N2 * D1;
                    break;
                default:
                    numerator = 0;
                    denominator = 1;
            }
            
            int gcd = computeGCD(Math.abs(numerator), Math.abs(denominator));
            int simplifiedNum = numerator / gcd;
            int simplifiedDen = denominator / gcd;
            
            System.out.printf("%d/%d = %d/%d%n", numerator, denominator, simplifiedNum, simplifiedDen);
        }
    }

    private static int computeGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
