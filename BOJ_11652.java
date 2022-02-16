import java.io.*;
import java.util.*;

public class BOJ_11652 {
    static FastReader scan = new FastReader();
    static int NFor11652;
    static long[] NListFor11652;
    static long countFor11652, lastCountFor11652, lastNumFor11652;

    static void input_11652(){
        NFor11652 = scan.nextInt();
        NListFor11652 = new long[NFor11652 + 1];
        for(int i = 1; i <= NFor11652; i ++) NListFor11652[i] = scan.nextLong();

        Arrays.sort(NListFor11652, 1, NFor11652 + 1);
        lastNumFor11652 = NListFor11652[1];
    }

    static void solve_11652(){
        countFor11652 = 1;
        lastCountFor11652 = 1;

        for(int i = 2; i <= NFor11652; i++){
            if(NListFor11652[i] == NListFor11652[i - 1]){
                countFor11652++;
            } else {
                countFor11652 = 1;
            }

            if(countFor11652 > lastCountFor11652){
                lastCountFor11652 = countFor11652;
                lastNumFor11652 = NListFor11652[i];
            }
        }
        System.out.println(lastNumFor11652);
    }

    public static void main(String[] args) {
        input_11652();
        solve_11652();
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
