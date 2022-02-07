import java.io.*;
import java.util.*;

public class BOJ_15663 {
    static StringBuilder ansSet = new StringBuilder();
    static ArrayList<String> ansContainer = new ArrayList<String>();

    static void input_15663() {
        FastReader scan = new FastReader();

        NFor15663 = scan.nextInt();
        MFor15663 = scan.nextInt();

        NListFor15663 = new int[NFor15663 + 1];
        selectedFor15663 = new int[NFor15663 + 1][2];

        for(int i = 1; i <= NFor15663; i++) NListFor15663[i] = scan.nextInt();

        Arrays.sort(NListFor15663);
    }

    static int NFor15663, MFor15663;
    static int[] NListFor15663;
    static int[][] selectedFor15663;

    static void solve_15663(int k, int count) {
        if(k == NFor15663 + 1 || count == MFor15663){
            if(count == MFor15663){
                for(int i = 0; i < count; i++){
                    for(int j = 1; j <= NFor15663; j++){
                        if(selectedFor15663[j][0] == 1 && selectedFor15663[j][1] == i) ansSet.append(NListFor15663[j]).append(' ');
                    }
                }
                if(!ansContainer.contains(ansSet.toString())){
                    ansContainer.add(ansSet.toString());
                    System.out.println(ansSet.toString());
                }
                ansSet.delete(0, NFor15663 * 2);
            }
        } else {
            for(int index = 1; index <= NFor15663; index++){
                if(selectedFor15663[index][0] == 1) continue;
                else {
                    selectedFor15663[index][0] = 1;
                    selectedFor15663[index][1] = count;
                    solve_15663(k + 1, count + 1);
                    selectedFor15663[index][0] = 0;
                    selectedFor15663[index][1] = -1;
                }
            }
        }
    }
    public static void main(String[] args) {
        input_15663();
        solve_15663(1, 0);
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
