import java.io.*;
import java.util.*;

public class BOJ_7795 {
    static FastReader scan = new FastReader();
    static StringBuilder ans = new StringBuilder();

    static int N, A, B;
    static int[] AList, BList;

    static void solve_7795(){
        N = scan.nextInt();
        for(int i = 1; i <= N; i++){
            int count;
            A = scan.nextInt();
            B = scan.nextInt();
            AList = new int[A + 1];
            BList = new int[B + 1];

            for(int j = 1; j <= A; j++){
                AList[j] = scan.nextInt();
            }
            for(int j = 1; j <= B; j++){
                BList[j] = scan.nextInt();
            }
            Arrays.sort(BList);
            count = countCase(AList, BList, B);
            ans.append(count).append('\n');
        }
        System.out.println(ans.toString());
    }

    static int binSearch(int key, int[] BList, int left, int right){
        int rul = left - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(BList[mid] < key){
                rul = mid;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return rul;
    }

    static int countCase(int[] AList, int[] BList, int N){
        int tCount = 0;
        for(int i = 1; i <= AList.length - 1; i++){
            int count = binSearch(AList[i], BList, 1, N);
            tCount += count;
        }
        return tCount;
    }

    public static void main(String[] args) {
        solve_7795();
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
