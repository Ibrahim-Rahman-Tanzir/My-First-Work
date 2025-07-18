import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int city = 1;

        while (true) {
            int N = sc.nextInt();
            if (N == 0) break;

            int[] people = new int[N];
            int[] consumption = new int[N];
            int[] perPerson = new int[N];
            int totalPeople = 0;
            int totalConsumption = 0;

            for (int i = 0; i < N; i++) {
                people[i] = sc.nextInt();
                consumption[i] = sc.nextInt();
                perPerson[i] = consumption[i] / people[i];
                totalPeople += people[i];
                totalConsumption += consumption[i];
            }

      
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (perPerson[i] > perPerson[j]) {
                      
                        int tempP = people[i];
                        people[i] = people[j];
                        people[j] = tempP;

                      
                        int tempC = perPerson[i];
                        perPerson[i] = perPerson[j];
                        perPerson[j] = tempC;
                    }
                }
            }

            if (city > 1) {
                System.out.println();
            }

            System.out.println("Cidade# " + city + ":");

            int current = perPerson[0];
            int sumPeople = people[0];

            for (int i = 1; i < N; i++) {
                if (perPerson[i] == current) {
                    sumPeople += people[i];
                } else {
                    System.out.print(sumPeople + "-" + current + " ");
                    current = perPerson[i];
                    sumPeople = people[i];
                }
            }

            System.out.println(sumPeople + "-" + current);

  
            double average = (double) totalConsumption / totalPeople;
            int avgInt = (int)(average * 100);
            average = avgInt / 100.0;

            System.out.printf("Consumo medio: %.2f m3.\n", average);
            city++;
        }

        sc.close();
    }
}
