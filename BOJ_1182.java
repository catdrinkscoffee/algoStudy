import java.io.*;
import java.util.*;

public class BOJ_1182 {
    static void input_1182(){
        FastReader scan = new FastReader();
        NFor1182 = scan.nextInt();
        SFor1182 = scan.nextInt();

        NListFor1182 = new int[NFor1182 + 1];

        for(int i = 1; i <= NFor1182; i ++) NListFor1182[i] = scan.nextInt();
        ansFor1182 = 0;
    }

    static int ansFor1182, NFor1182, SFor1182;
    static int[] NListFor1182;



    static void solve_1182(int k, int sum){
        if(k == NFor1182 + 1) {
            if(sum == SFor1182) ansFor1182++;
        }
         else {
             // k번째 원소를 포함할 때
            solve_1182(k + 1, sum + NListFor1182[k]);
            // k번째 원소가 포함되지 않을 때
            solve_1182(k + 1, sum);
        }
    }

    public static void main(String[] args) {
        input_1182();
        solve_1182(1, 0);
        // ans
        if(SFor1182 == 0) ansFor1182--;

        System.out.println(ansFor1182);
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
