package CodeJam.MatrixPath;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

public class Solution {
//    public static void go(int N, String pathA, int count) {
//        char[] herPath = pathA.toCharArray();
//        String[] myPath = new String[herPath.length];
//
//        int herPos = 0;
//        int myPos = 0;
//        for (int i = 0; i < herPath.length; i++) {
//            if (myPos == herPos) {
////                System.out.println("mypos: " + myPos + "  -  myPos / N: " + (myPos / N) + "  -  myPos % N: " +
// (myPos
////                        % N));
//                if (herPath[i] == 'E') {
//                    herPos += 1;
//
//                    if (myPos % N == N - 1) { // right most
//                        myPos += N;
//                        myPath[i] = "S";
//                    } else if (myPos / N == N - 1) { // bottom most
//                        myPos += 1;
//                        myPath[i] = "E";
//                    } else {
//                        myPos += N;
//                        myPath[i] = "S";
//                    }
//
//                } else if (herPath[i] == 'S') {
//                    herPos += N;
//                    if (myPos % N == N - 1) { // right most
//                        myPos += N;
//                        myPath[i] = "S";
//                    } else if (myPos / N == N - 1) { // bottom most
//                        myPos += 1;
//                        myPath[i] = "E";
//                    } else {
//                        myPos += 1;
//                        myPath[i] = "E";
//                    }
//
//                }
//
//            } else {
//                if (herPath[i] == 'E') {
//                    herPos += 1;
//
//                    if (myPos % N == N - 1) { // right most
//                        myPos += N;
//                        myPath[i] = "S";
//                    } else if (myPos / N == N - 1) { // bottom most
//                        myPos += 1;
//                        myPath[i] = "E";
//                    } else if (herPos % N - myPos % N > 1) {
////                        I go east too - catch up horizontally
//                        myPos += 1;
//                        myPath[i] = "E";
//                    } else {
//                        myPos += N;
//                        myPath[i] = "S";
//                    }
//                } else if (herPath[i] == 'S') {
//                    herPos += N;
//
//                    if (myPos % N == N - 1) { // right most
//                        myPos += N;
//                        myPath[i] = "S";
//                    } else if (myPos / N == N - 1) { // bottom most
//                        myPos += 1;
//                        myPath[i] = "E";
//                    } else if (herPos / N - myPos / N > 1) {
////                        I go north too - catch up vertically
//                        myPos += N;
//                        myPath[i] = "S";
//                    } else {
//                        myPos += 1;
//                        myPath[i] = "E";
//                    }
//                }
//            }
//
//
////            System.out.println(String.format("herpath - %s - mypath - %s - herpos: %d - mypos: %d", herPath[i],
////                    myPath[i], herPos, myPos));
//        }
//
////        System.out.println(String.format("herpos: %d - mypos: %d", herPos, myPos));
//        System.out.println(String.format("Case #%d: %s", count, String.join("", myPath)));
//
//    }


//    public static void go(int N, String pathA, int count) {
//        char[] herPath = pathA.toCharArray();
//        String[] myPath = new String[herPath.length];
//
//        int herPos = 0;
//        int myPos = 0;
//        for (int i = 0; i < herPath.length; i++) {
//            if (myPos == herPos) {
////                System.out.println("mypos: " + myPos + "  -  myPos / N: " + (myPos / N) + "  -  myPos % N: " + (myPos
////                        % N));
//                if (herPath[i] == 'E') {
//                    herPos += 1;
//
//                    if (myPos % N == N - 1) { // right most
//                        myPos += N;
//                        myPath[i] = "S";
//                    } else if (myPos / N == N - 1) { // bottom most
//                        myPos += 1;
//                        myPath[i] = "E";
//                    } else {
//                        myPos += N;
//                        myPath[i] = "S";
//                    }
//
//                } else if (herPath[i] == 'S') {
//                    herPos += N;
//                    if (myPos % N == N - 1) { // right most
//                        myPos += N;
//                        myPath[i] = "S";
//                    } else if (myPos / N == N - 1) { // bottom most
//                        myPos += 1;
//                        myPath[i] = "E";
//                    } else {
//                        myPos += 1;
//                        myPath[i] = "E";
//                    }
//
//                }
//
//            } else {
//                if (herPath[i] == 'E') {
//                    herPos += 1;
//                } else if (herPath[i] == 'S') {
//                    herPos += N;
//                }
//
//                int diffCol = Math.abs(myPos % N - herPos % N);
//                int diffRow = Math.abs(myPos / N - herPos / N);
//                if (myPos % N == N - 1) { // right most
//                    myPos += N;
//                    myPath[i] = "S";
//                } else if (myPos / N == N - 1) { // bottom most
//                    myPos += 1;
//                    myPath[i] = "E";
//                } else if (diffCol < diffRow) {// go south
//                    myPos += N;
//                    myPath[i] = "S";
//                } else if (diffCol > diffRow) { // go east
//                    myPos += 1;
//                    myPath[i] = "E";
//                } else {
//                    if (herPath[i] == 'E') {
//                        myPos += N;
//                        myPath[i] = "S";
//                    } else if (herPath[i] == 'S') {
//                        myPos += 1;
//                        myPath[i] = "E";
//                    }
//                }
//            }
////
////            System.out.println(String.format("herpath - %s - mypath - %s - herpos: %d - mypos: %d", herPath[i],
////                    myPath[i], herPos, myPos));
//        }
//
////        System.out.println(String.format("herpos: %d - mypos: %d", herPos, myPos));
//        System.out.println(String.format("Case #%d: %s", count, String.join("", myPath)));
//
//    }

    public static void go(int N, String pathA, int count) {
        char[] herPath = pathA.toCharArray();
        String[] myPath = new String[herPath.length];

        for (int i = 0; i < herPath.length; i++) {
            if (herPath[i] == 'E') myPath[i] = "S";
            else myPath[i] = "E";
        }

//        System.out.println(String.format("herpos: %d - mypos: %d", herPos, myPos));
        System.out.println(String.format("Case #%d: %s", count, String.join("", myPath)));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int tests = Integer.parseInt(S);

        int grid;
        int count = 1;
        String pathA;
        for (int i = 0; i < tests; i++) {
            S = sc.nextLine();
            grid = Integer.parseInt(S);
            pathA = sc.nextLine();
            go(grid, pathA, count);
            count++;
        }
    }
}
