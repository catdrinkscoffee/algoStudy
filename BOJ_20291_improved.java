import java.io.*;
import java.util.*;

public class BOJ_20291_improved {
    static FastReader scan = new FastReader();
    static StringBuilder ansSet = new StringBuilder();

    static int N;
    static String[] extensions;

    static void input_20291(){
        N = scan.nextInt();
        extensions = new String[N + 1];

        for(int i = 1; i <= N; i++){
            extensions[i] = scan.nextLine().split("[.]")[1];
        }
    }

    static void solve_20291(){
        Arrays.sort(extensions, 1, N + 1);
        for(int i = 1; i <= N;){
            int cnt = 1, j = i + 1;
            while (j <= N){
                if(extensions[j].compareTo(extensions[i]) == 0) {
                    cnt++; j++;
                }
                else break;
            }

            ansSet.append(extensions[i]).append(' ').append(cnt).append('\n');

            i = j;
        }

        System.out.println(ansSet.toString());
    }

    public static void main(String[] args) {
        input_20291();
        solve_20291();
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
