import java.util.Scanner;

public class LEDCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); 

        int[] ledCounts = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

        for (int i = 0; i < N; i++) {
            String number = scanner.nextLine();
            int totalLeds = 0;

            for (int j = 0; j < number.length(); j++) {
                char c = number.charAt(j);
                int digit = c - '0';
                totalLeds += ledCounts[digit];
            }
            System.out.println(totalLeds + " leds");
        }
        scanner.close();
    }
}
