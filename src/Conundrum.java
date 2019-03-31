import java.util.Scanner;

public class Conundrum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = 0;

        String S = sc.nextLine();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!((c == 'P' || c == 'p') && i % 3 == 0) && !((c == 'E' || c == 'e') && i % 3 == 1) && !((c == 'R' ||
                    c == 'r') && i % 3 == 2)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
