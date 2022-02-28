import java.io.*;
import java.util.*;

public class BOJ_2230 {
    static FastReader scan = new FastReader();
    static int N, M;
    static int[] NList;

    static void input_2230(){
        N = scan.nextInt();
        M = scan.nextInt();

        NList = new int[N + 1];
        for(int i = 1; i <= N; i++) NList[i] = scan.nextInt();
    }

    static void solve_2230(){
        Arrays.sort(NList, 1, N + 1);
        int bestSub = Integer.MAX_VALUE;
        for (int L = 1, R = 1; L <= N; L++){
            while (R < N && NList[R] - NList[L] < M) ++R;
            if(NList[R] - NList[L] >= M) bestSub = Math.min(bestSub, NList[R] - NList[L]);
        }
        System.out.println(bestSub);
    }

    public static void main(String[] args) {
        input_2230();
        solve_2230();
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
