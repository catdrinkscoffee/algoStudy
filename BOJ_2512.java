import java.io.*;
import java.util.*;

public class BOJ_2512 {
    static FastReader scan = new FastReader();
    static int N, M;
    static int[] NList;

    static void input_2512(){
        N = scan.nextInt();
        NList = new int[N + 1];
        for(int i = 1; i <= N; i++) NList[i] = scan.nextInt();
        M = scan.nextInt();
    }

    static boolean determine(int m){
        int sum = 0;
        for(int i = 1; i <= N; i++){
            sum += Math.min(NList[i], m);
        }
        return M >= sum;
    }

    static void solve_2512(){
        Arrays.sort(NList, 1, N + 1);
        int L = 0, R = NList[N], mid, bestBudget = 0;
        while (L <= R){
            mid = (L + R) / 2;
            if(determine(mid)){
                bestBudget = mid;
                L = mid + 1;
            } else{
                R = mid - 1;
            }
        }
        System.out.println(bestBudget);
    }
    public static void main(String[] args) {
        input_2512();
        solve_2512();
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
