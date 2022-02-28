import java.io.*;
import java.util.*;

public class BOJ_6236 {
    static FastReader scan = new FastReader();
    static int N, M;
    static int[] NList;

    static void input_6536(){
        N = scan.nextInt();
        M = scan.nextInt();

        NList = new int[N + 1];
        for(int i = 1; i <= N; i++) NList[i] = scan.nextInt();
    }

    static boolean determine(int m){
        int day = 0, money = m;
        for(int i = 1; i <= N; i++){
            while (money >= NList[i] ){
                money -= NList[i];
                i++;
            }
            day++;
            money = m + money - NList[i];
        }
        return day >= M;
    }

    static void solve_6536(){
        int L = 1, R = Integer.MAX_VALUE, mid;
        while (L <= R){
            mid = (L + R) / 2;
            if(determine(mid)){

            }
        }
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
