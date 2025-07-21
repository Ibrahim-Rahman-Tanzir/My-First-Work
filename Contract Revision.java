import java.util.Scanner;

public class FaultyTypewriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            int D = scanner.nextInt();
            String N = scanner.next();
          
            if (D == 0 && N.equals("0")) {
                break;
            }

            String result = processNumber(D, N);

            System.out.println(result.isEmpty() ? "0" : result);
        }
        
        scanner.close();
    }
    
    private static String processNumber(int faultyDigit, String originalNumber) {
        StringBuilder result = new StringBuilder();

        char faultyChar = (char)(faultyDigit + '0');

        for (int i = 0; i < originalNumber.length(); i++) {
            char c = originalNumber.charAt(i);
            if (c != faultyChar) {
                result.append(c);
            }
        }

        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        
        return result.length() == 0 ? "0" : result.toString();
    }
}
