//import java.io.*;
//import java.util.*;
//
//public class BOJ_15650 {
//    static StringBuilder sb = new StringBuilder();
//
//    static void input_15650(){
//        FastReader scan = new FastReader();
//        N = scan.nextInt();
//        M = scan.nextInt();
//        selected = new int[M + 1];
//    }
//
//    static int N, M;
//    static int[] selected;
//
//    static void rec_func(int k) {
//        if (k == M + 1) {
//            for (int i = 1; i <= M; i ++) sb.append(selected[i]).append(' ');
//            sb.append('\n');
//        } else {
//            for (int cand = selected[k - 1] + 1; cand <= N; cand++) {
//                selected[k] = cand;
//
//                rec_func(k + 1);
//                selected[k] = 0;
//            }
//        }
//    }
//
//
//    public static void main (String[] args){
//        input_15650();
//
//        rec_func(1);
//        System.out.println(sb.toString());
//    }
//
//
//}
