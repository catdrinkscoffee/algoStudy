import java.io.*;
import java.util.*;

public class BOJ_10816 {
    static FastReader scan = new FastReader();
    static StringBuilder ansSet = new StringBuilder();

    static int N, M;
    static int[] NList, MList;

    static void input_10816(){
        N = scan.nextInt();
        NList = new int[N + 1];
        for(int i = 1; i <= N; i++) NList[i] = scan.nextInt();
        M = scan.nextInt();
        MList = new int[M + 1];
        for(int i = 1; i <= M; i++) MList[i] = scan.nextInt();

        Arrays.sort(NList, 1 , N +1);
    }

    static void solve_10816(){
        int count = 0;
        for(int i = 1; i <= M; i++){
            count = 0;
            int index1 = isExist(NList, MList[i], 1, N);
            int index2 = isExist1(NList, MList[i], 1, N);
//            if(index > 0){
//                count++;
//                for (int k = index; k < N; k++){
//                    if(NList[k] == NList[k + 1]){
//                        count ++;
//                    } else break;
//                }
//            }
            ansSet.append(index2 - index1).append(' ');
        }

        System.out.println(ansSet);
    }

    static int isExist(int[] arr, int key, int low, int high){
        int ans = high + 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] >= key) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static int isExist1(int[] arr, int key, int low, int high){
        int ans = high + 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] > key) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        input_10816();
        solve_10816();
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
