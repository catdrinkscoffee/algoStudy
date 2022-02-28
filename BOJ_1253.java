// 2월 22일

import java.io.*;
import java.util.*;

public class BOJ_1253 {
    static FastReader scan = new FastReader();
    static int N;
    static long[] NList;

    static void input_1253(){
        N = scan.nextInt();
        NList = new long[N + 1];
        for(int i = 1; i <= N; i++) NList[i] = scan.nextInt();
    }

    static void solve_1253(){
        Arrays.sort(NList, 1, N + 1);
        int L, R, cnt = 0;

        for(int target = 1; target <= N; target++){
           L = 1; R = N;
           boolean isGoodNumber = false;
           while (L < R){
               if (L == target) L++;
               else if (R == target) R--;
               else {
                   if(NList[L] + NList[R] > NList[target]) R--;
                   else if(NList[L] + NList[R] == NList[target]) {
                       isGoodNumber = true; break;
                   } else L++;
               }
            }
            if(isGoodNumber) cnt ++;
        }
        System.out.println(cnt);
    }
    public static void main(String[] args) {
        input_1253();
        solve_1253();
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
