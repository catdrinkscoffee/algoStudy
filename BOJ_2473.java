import java.io.*;
import java.util.*;

public class BOJ_2473 {
    static FastReader scan = new FastReader();
    static StringBuilder ans = new StringBuilder();
    static int N;
    static int[] NList;

    static void input_2473(){
        N = scan.nextInt();

        NList = new int[N + 1];
        for(int i = 1; i <= N; i++) NList[i] = scan.nextInt();
    }

    static void solve_2473(){
        Arrays.sort(NList, 1, N + 1);

//        for(int i = 1; i <= N; i++) {
//            System.out.print(NList[i]);
//            System.out.print(' ');
//        }
//        System.out.println('\n');

        long bestSum = Long.MAX_VALUE;
        int v1 = 1, v2 = 2, v3 = 3;
        for (int i = 1; i <= N - 2; i++){
            int target = -NList[i];
            int L = i + 1, R = N;
            while (L < R){
                if (bestSum > Math.abs(-(long)target + NList[L] + NList[R])) {
                    bestSum = Math.abs(-(long)target + NList[L] + NList[R]);
                    v1 = -target;
                    v2 = NList[L];
                    v3 = NList[R];
                }
                if (NList[L] + NList[R] > target) R--;
                else L++;
            }
        }
        ans.append(v1).append(' ').append(v2).append(' ').append(v3);
        System.out.println(ans);
    }
    public static void main(String[] args) {
        input_2473();
        solve_2473();
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
