import java.io.*;
import java.util.*;

public class BOJ_15565 {
    static FastReader scan = new FastReader();
    static int N, M;
    static int[] NList;

    static void input_15565(){
        N = scan.nextInt();
        M = scan.nextInt();

        NList = new int[N + 1];
        for(int i = 1; i <= N; i++) NList[i] = scan.nextInt();
    }

    static void solve_15565(){
        int bestSize = Integer.MAX_VALUE, cnt = 0;

        for(int L = 1, R = 0; L <= N; L++){
            while (R < N && cnt < M){
                R++;
                if(NList[R] == 1) cnt++;
            }
            if(R - L + 1 < bestSize && cnt == M) {
                bestSize = R - L + 1;
            }
            if(NList[L] == 1) cnt--;
        }
        if(bestSize == Integer.MAX_VALUE) bestSize = -1;
        System.out.println(bestSize);
    }

    public static void main(String[] args) {
        input_15565();
        solve_15565();
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
