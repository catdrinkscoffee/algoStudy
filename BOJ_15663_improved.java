import java.io.*;
import java.util.*;

public class BOJ_15663_improved {
    static StringBuilder ansSet = new StringBuilder();

    static void input_15663() {
        FastReader scan = new FastReader();

        NFor15663 = scan.nextInt();
        MFor15663 = scan.nextInt();

        NListFor15663 = new int[NFor15663 + 1];
        selectedFor15663 = new int[NFor15663 + 1];
        used = new int[NFor15663 + 1];

        for(int i = 1; i <= NFor15663; i++) NListFor15663[i] = scan.nextInt();

        Arrays.sort(NListFor15663, 1, NFor15663 + 1);
    }

    static int NFor15663, MFor15663;
    static int[] NListFor15663, used, selectedFor15663;

    static void solve_15663(int k) {
        if(k == MFor15663 + 1){
            for (int i = 1; i <= MFor15663; i++) ansSet.append(selectedFor15663[i]).append(' ');
            ansSet.append('\n');
        } else {
            int last_cand = 0;
            for(int cand = 1; cand <= NFor15663; cand++){
                if(used[cand] == 1) continue;
                if(NListFor15663[cand] == last_cand) continue;

                last_cand = NListFor15663[cand];
                selectedFor15663[k] = NListFor15663[cand]; used[cand] = 1;
                solve_15663(k + 1);
                selectedFor15663[k] = 0; used[cand] = 0;
            }
        }
    }
    public static void main(String[] args) {
        input_15663();
        solve_15663(1);
        System.out.println(ansSet.toString());
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
