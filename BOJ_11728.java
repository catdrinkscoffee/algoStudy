import java.io.*;
import java.util.*;

public class BOJ_11728 {
    static FastReader scan = new FastReader();
    static StringBuilder ans = new StringBuilder();
    static int N, M;
    static int[] NList, MList, mergedList;

    static void input_11728(){
        N = scan.nextInt();
        M = scan.nextInt();

        NList = new int[N + 1];
        for(int i = 1; i <= N; i++) NList[i] = scan.nextInt();

        MList = new int[M + 1];
        for(int i = 1; i <= M; i++) MList[i] = scan.nextInt();

        mergedList = new int[N + M + 1];
    }

    static void solve_11728(){
        int A = 1, B = 1, index = 1;
        while (A <= N && B <= M){
            if(NList[A] >= MList[B]){
//                mergedList[index] = MList[B];
                ans.append(MList[B]); ans.append(' ');
                B++;
            } else {
//                mergedList[index] = MList[A];
                ans.append(NList[A]); ans.append(' ');
                A++;
            }
            index++;
        }
        if(A > N){
            while (B <= M){
//                mergedList[index] = MList[B];
                ans.append(MList[B]); ans.append(' ');
                B++;
            }
        } else {
            while (A <= N){
//                mergedList[index] = MList[A];
                ans.append(NList[A]); ans.append(' ');
                A++;
            }
        }
        System.out.println(ans.toString());
    }

    public static void main(String[] args) {
        input_11728();
        solve_11728();
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
