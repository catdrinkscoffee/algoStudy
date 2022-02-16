import java.io.*;
import java.util.*;

public class BOJ_3273 {
    static FastReader scan = new FastReader();

    static int N, M;
    static int[] NList;

    static void input_3723(){
        N = scan.nextInt();
        NList = new int[N + 1];
        for(int i = 1; i <= N; i++) NList[i] = scan.nextInt();
        Arrays.sort(NList, 1, N + 1);
        M = scan.nextInt();
    }

    static int isExist(int key, int low){
        int mid;
        int high = N;
        while (low <= high) {
            mid = (low + high) / 2;
            if(NList[mid] == key) {
                return 1;
            } else if(NList[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    static void solve_3273(){
        int count = 0;
        for(int i = 1; i <= N; i++){
            if(NList[i] >= M ) break;
            else {
                if(isExist(M - NList[i], i + 1) == 1){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        input_3723();
        solve_3273();
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
