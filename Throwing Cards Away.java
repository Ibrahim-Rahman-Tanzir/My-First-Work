import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            Queue<Integer> deck = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                deck.offer(i);
            }

            StringBuilder discarded = new StringBuilder();
            discarded.append("Discarded cards:");

            boolean firstDiscard = true;

            while (deck.size() > 1) {
                int discardedCard = deck.poll(); 
                if (firstDiscard) {
                    discarded.append(" ").append(discardedCard);
                    firstDiscard = false;
                } else {
                    discarded.append(", ").append(discardedCard);
                }

                int movedCard = deck.poll(); 
                deck.offer(movedCard);
            }
            int remainingCard = deck.poll();

            System.out.println(discarded.toString());
            System.out.println("Remaining card: " + remainingCard);
        }
        sc.close();
    }
}
