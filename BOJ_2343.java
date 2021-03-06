import java.io.*;
import java.util.*;

public class BOJ_2343 {
    static FastReader scan = new FastReader();
    static int N, M;
    static int[] NList;

    static void input_2343(){
        N = scan.nextInt();
        M = scan.nextInt();

        NList = new int[N + 1];
        for(int i = 1; i <= N; i++) NList[i] = scan.nextInt();
    }

    static boolean determine(int len){
        int cnt = 1, sum = 0;
        for(int i = 1; i <= N; i++){
            if(sum + NList[i] > len){
                cnt++;
                sum = NList[i];
            } else {
                sum += NList[i];
            }
        }
        return M >= cnt;
    }

    static void solve_2343(){
        int L = 1, R = 1000000000, ans = 0;
        for (int i = 1; i <= N; i++) L = Math.max(L, NList[i]);
        while (L <= R){
            int mid = (L + R) / 2;
            if(determine(mid)){
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input_2343();
        solve_2343();
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
