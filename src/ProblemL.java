import java.util.Scanner;

public class ProblemL {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String[] input = S.split(" ");
        int L = Integer.parseInt(input[0]);
        int D = Integer.parseInt(input[1]);
        boolean pass = true;

        for (int l = 0; l < L; l++) {
            S = sc.nextLine();
            input = S.split(" ");

            int dist = Integer.parseInt(input[0]);
            int first = Integer.parseInt(input[1]);
            int green = Integer.parseInt(input[2]);
            int red = Integer.parseInt(input[3]);

            if (dist >= D) {
                pass = false;
                break;
            }

            int r = (dist - first) % (green + red);
            if (r < 0 || r > green) {
                pass = false;
                break;
            }
        }
        if (pass) System.out.println("YES");
        else System.out.println("NO");
    }
}
