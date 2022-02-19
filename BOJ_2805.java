import java.io.*;
import java.util.*;

public class BOJ_2805 {
    static FastReader scan = new FastReader();

    static int N, M;
    static int[] NList;

    static void input_2805(){
        N = scan.nextInt();
        M = scan.nextInt();
        NList = new int[N + 1];
        for(int i = 1; i <= N; i ++) NList[i] = scan.nextInt();
    }

    static boolean determine(int cand){
        long sum = 0;
        for(int i = 1; i <= N; i ++){
            if(NList[i] > cand){
                sum += NList[i] - cand;
            }
        }
        // 1-N 나무를 한 번 잘라보고, 그게 M 보다 큰지 작은지 보여줌
        return sum >= M;
    }

    static void solve_2895(){
        long left = 0, right = 2000000000, ans = 0;
        // 정수 범위 중에 이분 탐색
        while(left <= right){
            int mid = (int)((left + right) / 2);
            if(determine(mid)){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input_2805();
        solve_2895();
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
