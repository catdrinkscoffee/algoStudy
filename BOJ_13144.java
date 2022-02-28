import java.io.*;
import java.util.*;

public class BOJ_13144 {
    static FastReader scan = new FastReader();
    static int N;
    static int[] NList;

    static void input_13144(){
        N = scan.nextInt();
        NList = new int[N + 1];
        for(int i = 1; i <= N; i++) NList[i] = scan.nextInt();
    }

    static void solve_13144(){
        int R, cnt = 0;

        for(int L = 1; L <= N; L++){
            boolean isExist = false;
            R = L;
            while (R < N){
                R++;
                for(int i = L; i < R; i++){
                    if(NList[i] == NList[R]){
                        isExist = true;
                        break;
                    }
                }
                if(isExist == true) break;
            }
            if(R == N && NList[L] != NList[R]) R++;
            if(L == N) R++;
            cnt += R - L;
        }

        System.out.println(cnt);
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

