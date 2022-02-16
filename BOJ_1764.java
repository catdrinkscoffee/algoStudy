import java.io.*;
import java.util.*;

public class BOJ_1764 {
    static FastReader scan = new FastReader();
    static StringBuilder ansSet = new StringBuilder();

    static String[] notSeen, notHeard;
    static int N, M;

    static void input_1764(){
        N = scan.nextInt();
        M = scan.nextInt();

        notHeard = new String[N + 1];
        notSeen = new String[M + 1];

        for(int i = 1; i <= N; i++){
            notHeard[i] = scan.nextLine();
        }
        Arrays.sort(notHeard, 1, N + 1);

        for(int i = 1; i <= M; i++){
            notSeen[i] = scan.nextLine();
        }
        Arrays.sort(notSeen, 1, M + 1);
    }
    static boolean find(String set[], String s, int low, int high){
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
//            System.out.println(s == set[mid]);
            if(set[mid].contains(s)) {
                return true;
            } else if(s.compareTo(set[mid]) < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
    static void solve_1764(){
        int count = 0;
        if(N < M){
            for(int i = 1; i <= N; i++){
                if(find(notSeen, notHeard[i], 1, M)){
                    ansSet.append(notHeard[i].toString()).append('\n');
                    count++;
                }
            }
        } else {
            for(int i = 1; i <= M; i++){
                if(find(notHeard, notSeen[i], 1, M)){
                    ansSet.append(notSeen[i].toString()).append('\n');
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(ansSet.toString());
    }

    public static void main(String[] args) {
        input_1764();
        solve_1764();
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
