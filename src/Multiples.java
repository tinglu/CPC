import java.util.Scanner;

public class Multiples {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int K = Integer.parseInt(S);

        for (int i = 0; i < K; i++) {
            S = sc.nextLine();
            String[] line = S.split(" ");
            int X = Integer.parseInt(line[0]);
            int D = Integer.parseInt(line[1]);

            System.out.println(findLargest(X, D));
        }
    }

    private static int findLargest(int X, int D) {
        int length = (int) (Math.log10(X) + 1);
        if (length > D) {
            if (D > 1) {
                return -1;
            } else {
                return 0;
            }
        }

        int start = (int) Math.pow(10, D) - 1;
        if (start % X == 0) {
            return start;
        } else {
            int x = start - start % X;
            int lenX = (int) (Math.log10(x) +1);
            return lenX == D ? x : -1;
        }
    }
}
