import java.io.*;
import java.util.*;

public class BOJ_13144_improved {
    static FastReader scan = new FastReader();
    static int N;
    static int[] NList, cnt;

    static void input_13144(){
        N = scan.nextInt();
        NList = new int[N + 1];
        for(int i = 1; i <= N; i++) NList[i] = scan.nextInt();
        cnt = new int[100000 + 1];
    }

    static void solve_13144(){
        long ans = 0;

        for(int L = 1, R = 0; L <= N; L++){
            while (R < N && cnt[NList[R + 1]] == 0){
                R++;
                cnt[NList[R]]++;
            }
            ans += R - L + 1;

            cnt[NList[L]]--;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input_13144();
        solve_13144();
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

