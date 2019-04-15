package CodeJam.Foregone;

import java.util.Scanner;

public class Solution {
    private void calc(int num, int count) {
        int length = (int) (Math.log10(num) + 1);

        int[] group1 = new int[length];
        int[] group2 = new int[length];

        int c = length;
        int tmp;
        while (c > 0) {
            int pow = (int) Math.pow(10, c - 1);
            tmp = num / (pow);
            if (tmp == 4) {
                group1[c - 1] = 1;
                group2[c - 1] = tmp - 1;
            } else {
                group1[c - 1] = tmp;
            }
            num = num % pow;
            c--;
        }
        int A = 0, B = 0;
        for (int i = 0; i < group1.length; i++) {
            A += group1[i] * Math.pow(10, i);
        }
        for (int i = 0; i < group2.length; i++) {
            B += group2[i] * Math.pow(10, i);
        }
        System.out.println(String.format("Case #%d: %d %d", count, A, B));
    }

    private void test() {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int tests = Integer.parseInt(S);

        int num, count = 1;
        for (int i = 0; i < tests; i++, count++) {
            S = sc.nextLine();
            num = Integer.parseInt(S);
            calc(num, count);
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.test();
    }
}
