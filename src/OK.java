import java.util.Scanner;

public class OK {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int K = Integer.parseInt(S);

        for (int i = 0; i < K; i++) {
            S = sc.nextLine();
            System.out.println(isOK(S));
        }
    }

    private static String isOK(String S) {
        int oidx = S.indexOf('O');
        for (int i = oidx + 1; i < S.length(); i++) {
            if (S.charAt(i) == 'K') return "YES";
        }
        return "NO";
    }
}
