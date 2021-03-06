import java.io.*;
import java.util.*;

public class BOJ_1654 {
    static FastReader scan = new FastReader();

    static int K, N;
    static int[] KList;

    static void input_1654(){
        K = scan.nextInt();
        N = scan.nextInt();
        KList = new int[K + 1];
        for(int i = 1; i <= K; i++) KList[i] = scan.nextInt();
        Arrays.sort(KList, 1, K + 1);
    }
    static boolean determine(long m){
        long cnt = 0;
        for(int i = 1; i <= K; i++){
            cnt += KList[i] / m;
        }
        return cnt >= N;
    }
    static void solve_1654(){
        long L = 1, R = KList[K], bestLen = 0;
        while (L <= R){
            long mid = (L + R) / 2;
            if(determine(mid)){
                bestLen = mid;
                L = mid + 1;
            } else{
                R = mid - 1;
            }
        }
        System.out.println(bestLen);
    }

    public static void main(String[] args) {
        input_1654();
        solve_1654();
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
