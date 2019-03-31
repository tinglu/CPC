import java.util.Arrays;
import java.util.Scanner;

public class CountingHaybales {
//    (1)
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        String S = sc.nextLine();
//        String[] nq = S.split(" ");
//        int N = Integer.parseInt(nq[0]);
//        int Q = Integer.parseInt(nq[1]);
//
//        S = sc.nextLine();
//        nq = S.split(" ");
//        int[] positions = new int[nq.length];
//        for (int i = 0; i < nq.length; i++) {
//            positions[i] = Integer.parseInt(nq[i]);
//        }
//
//        Arrays.sort(positions);
//
//        for (int j = 0; j < Q; j++) {
//            S = sc.nextLine();
//            nq = S.split(" ");
//            int from = Integer.parseInt(nq[0]);
//            int end = Integer.parseInt(nq[1]);
//
//            int count = 0;
//            for (int k = from; k <= end; k++) {
//                count += binarySearch(positions, k, 0, positions.length - 1) ? 1 : 0;
//            }
//            System.out.println(count);
//        }
//    }

    //    too slow (n*log n)
    private static boolean binarySearch(int[] A, int N, int lo, int hi) {
        if (hi < lo) return false;

        if (hi == lo) return A[hi] == N;

        int mid = (hi + lo) / 2;
        if (A[mid] == N) return true;

        if (A[mid] < N) return binarySearch(A, N, mid + 1, hi);
        else return binarySearch(A, N, lo, mid - 1);
    }

    //    (2)
    //    linear time complexity
    //    But OUT OF MEMORY!!
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        String S = sc.nextLine();
//        String[] nq = S.split(" ");
//        int N = Integer.parseInt(nq[0]);
//        int Q = Integer.parseInt(nq[1]);
//
//        S = sc.nextLine();
//        nq = S.split(" ");
//
//        int max = Integer.MIN_VALUE;
//
//        for (int i = 0; i < nq.length; i++) {
//            max = Math.max(max, Integer.parseInt(nq[i]));
//        }
//
//        boolean[] pos = new boolean[max + 1];
//        for (int i = 0; i < nq.length; i++) {
//            pos[Integer.parseInt(nq[i])] = true;
//        }
//
//        for (int i = 0; i < Q; i++) {
//            S = sc.nextLine();
//            nq = S.split(" ");
//            int from = Integer.parseInt(nq[0]);
//            int end = Integer.parseInt(nq[1]);
//
//            int count = 0;
//            for (int j = from; j <= end; j++) {
//                count += j < pos.length && pos[j] ? 1 : 0;
//            }
//
//            System.out.println(count);
//        }
//    }

    //    (3) use bit
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String[] nq = S.split(" ");
        int N = Integer.parseInt(nq[0]);
        int Q = Integer.parseInt(nq[1]);

        S = sc.nextLine();
        nq = S.split(" ");
        int[] positions = new int[nq.length];
        for (int i = 0; i < nq.length; i++) {
            positions[i] = Integer.parseInt(nq[i]);
        }

        Arrays.sort(positions);

        for (int j = 0; j < Q; j++) {
            S = sc.nextLine();
            nq = S.split(" ");
            int from = Integer.parseInt(nq[0]);
            int end = Integer.parseInt(nq[1]);

            int fromIdx = binarySearchIdx(positions, from, 0, positions.length - 1);
            int toIdx = binarySearchIdx(positions, end, 0, positions.length - 1);

            if (fromIdx == -1 && toIdx == -1) {
                System.out.println(0);
            } else {
                int a = fromIdx == -1 ? 0 : fromIdx;
                int b = toIdx == -1 ? positions.length - 1 : toIdx;
                System.out.println(b - 1 + 1);
            }

        }
    }

    private static int binarySearchIdx(int[] A, int N, int lo, int hi, boolean dir) {
        if (hi < lo) return -1;

//        if (hi == lo) return A[hi] = N ? hi : -1;

        int mid = (hi + lo) / 2;
        if (A[mid] == N) return mid;

        if (A[mid] < N) return binarySearchIdx(A, N, mid + 1, hi);
        else return binarySearchIdx(A, N, lo, mid - 1);
    }
}
