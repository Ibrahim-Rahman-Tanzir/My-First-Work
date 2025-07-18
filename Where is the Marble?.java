import java.util.*;

public class Main {
    public static int firstOccurrence(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == x) {
                result = mid;
                right = mid - 1; 
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = 1;

        while (true) {
            int N = sc.nextInt();
            int Q = sc.nextInt();
            if (N == 0 && Q == 0) {
                break;
            }

            int[] marbles = new int[N];
            for (int i = 0; i < N; i++) {
                marbles[i] = sc.nextInt();
            }

            Arrays.sort(marbles); 

            System.out.println("CASE# " + caseNum + ":");
            caseNum++;

            for (int i = 0; i < Q; i++) {
                int x = sc.nextInt();
                int pos = firstOccurrence(marbles, x);

                if (pos != -1) {
                    System.out.println(x + " found at " + (pos + 1));
                } else {
                    System.out.println(x + " not found");
                }
            }
        }
    }
}
