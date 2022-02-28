import java.io.*;
import java.util.*;

public class BOJ_1806 {
    static FastReader scan = new FastReader();
    static int N, S;
    static int[] NList;

    static void input_1806(){
        N = scan.nextInt();
        S = scan.nextInt();
        NList = new int[N + 1];

        for(int i = 1; i <= N; i ++) NList[i] = scan.nextInt();
    }

    static void solve_1806(){
        int R = 0, sum = 0, ans = N + 1;

        for(int L = 1; L <= N; L++){
            sum -= NList[L - 1];

            while (R < N && sum < S){
                R++;
                sum += NList[R];
            }
            if(sum >= S){
                ans = Math.min(ans, R - L + 1);
            }
        }

        if(ans == N + 1) ans = 0;

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input_1806();
        solve_1806();
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
