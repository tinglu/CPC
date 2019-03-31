import java.util.Scanner;

public class IncompleteBook {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String[] input = S.split(" ");
        int k = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);

        if (k >= 1 && k <= 365 && d >= k && d <= Math.pow(10, 9)) {

            int count = 0;

            while (d >= k) {
                d = d - k;
                k = 2 * k;
                count++;
            }

            System.out.println(count);

        } else {
            System.out.println(0);
        }
    }

//    public static void main(String[] args) {
//
////        System.out.println(Math.pow(2, 2.7));
//
//        Scanner sc = new Scanner(System.in);
//        int k = sc.nextInt();
//        int d = sc.nextInt();
//
//        if (k >= 1 && k <= 365 && d >= k && d <= Math.pow(10, 9)) {
//            int result = (int) Math.floor(Math.log((float) d /(float) k + 1) / Math.log(2));
//
////            int result = (int) (Math.log((float) d /(float) k + 1) / Math.log(2));
//            System.out.println(result);
////            int count = 0;
////
////            while (d >= 0) {
////                d = d - k;
////                k = 2 * k;
////                count++;
////            }
////
////            System.out.println(count);
//
//        } else {
//            System.out.println(0);
//        }
//    }
}
