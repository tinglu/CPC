import java.util.Arrays;
import java.util.Scanner;

public class ProblemG {
    static int[] denominator = {1, 2, 5, 10, 20, 50};

    public static int calcExtra(int diff, int[] stock) {
        int extra = 0;

        for (int i = stock.length - 1; i >= 0; i--) {

            int d = Math.min(diff / denominator[i], stock[i]);

            if (stock[i] * denominator[i] >= diff) {
                d = d + 1;
                extra = d * denominator[i] - diff;
                break;
            }
//            else {
//                diff = diff - d * denominator[i];
//                for (int mmm : stock) {
//                    System.out.print(mmm + ", ");
//                }
//                System.out.println();
//                stock[i] -= d;
//            }


        }

//        System.out.println(diff);
//        if (diff > 0) {
//            for (int j = 0; j < stock.length; j++) {
//                if (stock[j] != 0 && stock[j] * denominator[j] > diff) {
//                    extra = stock[j] * denominator[j] - diff;
//                    break;
//                }
//            }
//        }

        return extra;
    }

    public static int changeExtra(int diff, int[] stock, int dIdx) {
        if (dIdx < 0) return diff;

        if (stock[dIdx] > 0) {
            int numOfThisCoinNeeded = Math.min(diff / denominator[dIdx], stock[dIdx]);
            if (numOfThisCoinNeeded > 0) {
                int canPayByThisCoin = numOfThisCoinNeeded * denominator[dIdx];
                stock[dIdx] -= numOfThisCoinNeeded;
                int remaining = diff % canPayByThisCoin;

                if (remaining == 0) return 0;

                if (stock[dIdx] > 0 && remaining > 0) {
                    int thisExtra = denominator[dIdx] - remaining;
                    int nextChange = changeExtra(remaining, stock, dIdx - 1);

                    if (nextChange < thisExtra) {
                        return nextChange;
                    } else {
                        stock[dIdx] -= 1;
                        return thisExtra;
                    }
                }

            }
        }
        return changeExtra(diff, stock, dIdx - 1);
    }

    public static void main(String[] args) {
        int[] stock = new int[6];

        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String[] input = S.split(" ");
        for (int i = 0; i < 6; i++) {
            stock[i] = Integer.parseInt(input[i]);
        }

        int transactions = Integer.parseInt(sc.nextLine());
        int extra = 0;

        for (int t = 0; t < transactions; t++) {
            String ts = sc.nextLine();
            String[] tran = ts.split(" ");
            int total = Integer.parseInt(tran[0]);

            int paid = 0;
            int diff;

            for (int j = 1; j < tran.length; j++) {
                paid += Integer.parseInt(tran[j]) * denominator[j - 1];
                stock[j - 1] += Integer.parseInt(tran[j]);
            }

            diff = paid - total;

//            extra += calcExtra(diff, stock);
            int ext = changeExtra(diff, stock, stock.length - 1);
            extra += ext;
        }

        System.out.println(extra);
    }
}
