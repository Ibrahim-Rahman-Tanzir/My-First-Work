import java.util.Scanner;

public class Main {

    static long mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left, j = mid, k = left;
        long inv_count = 0;

        while (i <= mid - 1 && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inv_count += (mid - i);
            }
        }

        while (i <= mid - 1) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return inv_count;
    }

    static long mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        long inv_count = 0;
        if (right > left) {
            int mid = (left + right) / 2;
            inv_count += mergeSortAndCount(arr, temp, left, mid);
            inv_count += mergeSortAndCount(arr, temp, mid + 1, right);
            inv_count += mergeAndCount(arr, temp, left, mid + 1, right);
        }
        return inv_count;
    }

    static long countInversions(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        return mergeSortAndCount(arr, temp, 0, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int N = sc.nextInt();
            if (N == 0) break;

            int[] P = new int[N];
            for (int i = 0; i < N; i++) {
                P[i] = sc.nextInt();
            }

            long inversions = countInversions(P);

            if (inversions % 2 == 1) {
                System.out.println("Marcelo");
            } else {
                System.out.println("Carlos");
            }
        }
        sc.close();
    }
}
