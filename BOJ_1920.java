import java.io.*;
import java.util.*;

public class BOJ_1920 {
    static FastReader scan = new FastReader();
    static StringBuilder ansSet = new StringBuilder();
    static int N, M;
    static int[] NSet, MSet;

    static void input_1920(){
        N = scan.nextInt();
        NSet = new int[N + 1];
        for(int i = 1; i <= N; i++) NSet[i] = scan.nextInt();

        M = scan.nextInt();
        MSet = new int[M + 1];
        for(int i = 1; i <= M; i++) MSet[i] = scan.nextInt();

        Arrays.sort(NSet, 1, N + 1);
//        Arrays.sort(MSet, 1, M + 1);
    }

    static int isExist(int arr[], int key){
        int mid;
        int low = 1, high = N;
        while (low <= high) {
            mid = (low + high) / 2;
            if(arr[mid] == key) {
                return 1;
            } else if(arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
    static void solve_1920(){
        for(int i = 1; i <= M; i++){
            ansSet.append(isExist(NSet, MSet[i])).append('\n');
        }
        System.out.println(ansSet);
    }


    public static void main(String[] args) {
        input_1920();
        solve_1920();
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
