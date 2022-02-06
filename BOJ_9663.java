import java.io.*;
import java.util.*;

public class BOJ_9663 {
    static void input_9663(){
        FastReader scan = new FastReader();

        queenNum = scan.nextInt();
        queenArrangement = new int[queenNum + 1];

        caseCountForNQueen = 0;
    }

    static int queenNum, caseCountForNQueen;
    static int[] queenArrangement;

    static boolean isAvailableForNQueen(int currentRow, int currentCol){
        for (int rowForCheck = 1; rowForCheck <= currentRow - 1; rowForCheck++){
            if((queenArrangement[rowForCheck] == currentCol) || (Math.abs(queenArrangement[rowForCheck] - currentCol) == currentRow - rowForCheck)){
                return false;
            }
        }
        return true;
    }
    static void solve_9663(int k){
        if(k == queenNum + 1) {
            caseCountForNQueen ++;
        } else {
            for (int col = 1; col <= queenNum; col++){
                if(isAvailableForNQueen(k, col) == true){
                    queenArrangement[k] = col;
                    solve_9663(k + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        input_9663();
        solve_9663(1);
        System.out.println(caseCountForNQueen);
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
