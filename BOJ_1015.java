import java.io.*;
import java.util.*;

public class BOJ_1015 {
    static FastReader scan = new FastReader();
    static StringBuilder ansSet = new StringBuilder();

    static int NFor1015;
    static int[] NListFor1015, copiedNList;

    static void input_1015 (){
        NFor1015 = scan.nextInt();
        NListFor1015 = new int[NFor1015 + 1];
        copiedNList = new int[NFor1015 + 1];

        for(int i = 1; i <= NFor1015; i++) NListFor1015[i] = scan.nextInt();

        copiedNList = NListFor1015.clone();
    }

    static void solve_1015(){
        Arrays.sort(NListFor1015);
        for(int orderChk = 1; orderChk < NListFor1015.length; orderChk++){
            for(int traveler = 1; traveler < NListFor1015.length; traveler++){
                if(copiedNList[orderChk] == NListFor1015[traveler]) {
                    ansSet.append(traveler - 1).append(' ');
                    NListFor1015[traveler] = -1;
                    break;
                }
            }
        }
        System.out.println(ansSet.toString());
    }
    public static void main(String[] args) {
        input_1015();
        solve_1015();
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
