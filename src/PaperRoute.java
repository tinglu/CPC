import java.util.Scanner;

public class PaperRoute {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int streets = Integer.parseInt(S);

        for (int i = 0; i < streets; i++) {
            S = sc.nextLine();
            int houses = Integer.parseInt(S);
            S = sc.nextLine();
            String[] profitsS = S.split("\\s+");
            int[] profits = new int[houses];
            for (int j = 0; j < houses; j++) {
                profits[j] = Integer.parseInt(profitsS[j].trim());
            }

            System.out.println(maxProfit(profits));
        }
    }

    private static int maxProfit(int[] profits) {
        int currMax = profits[0];
        int maxSoFar = profits[0];

        for (int i = 1; i < profits.length; i++) {
            currMax = Math.max(profits[i], currMax + profits[i]);
            maxSoFar = Math.max(currMax, maxSoFar);
        }

        return maxSoFar < 0 ? 0 : maxSoFar;
    }
}
