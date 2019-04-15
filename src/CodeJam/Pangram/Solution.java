package CodeJam.Pangram;

import java.util.*;

public class Solution {
    private static void deciper(int N, int[] numbers, int count) {
        int[] gcd = new int[numbers.length + 1];

//        System.out.println(numbers.length);
//        System.out.println(Arrays.toString(numbers));

        for (int i = 1; i < numbers.length; i++) {
            gcd[i] = gcd(numbers[i], numbers[i - 1]);
        }
//        System.out.println("before1: " + Arrays.toString(gcd));
        gcd[0] = numbers[0] / gcd[1];
        gcd[gcd.length - 1] = numbers[numbers.length - 1] / gcd[gcd.length - 2];
//        System.out.println("before2: " + Arrays.toString(gcd));

        Set<Integer> set = new HashSet<>();
        for (int i : gcd) {
            set.add(i);
        }
        Integer[] distinctGcd = set.toArray(new Integer[set.size()]);
        Arrays.sort(distinctGcd);
//        System.out.println("sorted: " + Arrays.toString(distinctGcd) + " - size: " + distinctGcd.length);

        int charId = 'A';
        Map<Integer, Character> map = new HashMap<>();
        for (int d : distinctGcd) {
            map.put(d, (char) charId);
            charId++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : gcd) {
            sb.append(map.get(i));
        }
        System.out.println(String.format("Case #%d: %s", count, sb.toString()));
    }

    private static int gcd(int num1, int num2) {
        while (num1 != num2) {
            if (num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }
        return num2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int tests = Integer.parseInt(S);

        String[] info;
        int N;
        int L;
        int[] numbers;

        int count = 1;

        String[] nums;
        for (int i = 0; i < tests; i++) {
            S = sc.nextLine();
            info = S.split(" ");
            N = Integer.parseInt(info[0].trim());
            L = Integer.parseInt(info[1].trim());

            numbers = new int[L];

            S = sc.nextLine();
            nums = S.split(" ");
            for (int j = 0; j < L; j++) {
                numbers[j] = Integer.parseInt(nums[j].trim());
            }

            deciper(N, numbers, count);
            count++;
        }
    }
}
