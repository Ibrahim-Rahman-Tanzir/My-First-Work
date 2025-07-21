import java.util.Scanner;

public class EncryptionProgram {
    public static String encryptLine(String line) {
        char[] chars = line.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len; i++) {
            if ((chars[i] >= 'A' && chars[i] <= 'Z') || (chars[i] >= 'a' && chars[i] <= 'z')) {
                chars[i] += 3;
            }
        }

        for (int i = 0; i < len / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[len - 1 - i];
            chars[len - 1 - i] = temp;
        }
        
        
        int half = len / 2;
        for (int i = half; i < len; i++) {
            chars[i] -= 1;
        }
        
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); 
        
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            String encrypted = encryptLine(line);
            System.out.println(encrypted);
        }
        
        scanner.close();
    }
}
