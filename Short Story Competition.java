import java.util.Scanner;

public class WordProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            int L = sc.nextInt();
            int C = sc.nextInt();
            
            String[] words = new String[N];
            for (int i = 0; i < N; i++) {
                words[i] = sc.next();
            }
            
            int pages = 1;
            int lines = 1;
            int currentLineLength = 0;
            
            for (int i = 0; i < N; i++) {
                int wordLen = words[i].length();
                
                if (currentLineLength == 0) {
                    currentLineLength = wordLen;
                } else {
                    if (currentLineLength + 1 + wordLen <= C) {
                        currentLineLength += 1 + wordLen;
                    } else {
                        lines++;
                        if (lines > L) {
                            pages++;
                            lines = 1;
                        }
                        currentLineLength = wordLen;
                    }
                }
            }
            
            System.out.println(pages);
        }
        
        sc.close();
    }
}
