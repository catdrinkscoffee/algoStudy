import java.io.*;
import java.util.*;

public class BOJ_15970 {
    static FastReader scan = new FastReader();
    static int N;
    static int[][] dotList;

    static void input_15970(){
        N = scan.nextInt();
        dotList = new int[N + 1][2];
        int a, b;
        for(int i = 0; i < N; i ++){
            dotList[i][0] = scan.nextInt();
            dotList[i][1] = scan.nextInt();
        }
        dotList[N][0] = dotList[N][1] = -1;

        for(int index = 0; index < N - 1; index++){
            boolean swap = false;
            for (int location = 0; location < N - 1 - index; location++){
                if(dotList[location][0] > dotList[location + 1][0]){
                    int tmp = dotList[location][0];
                    dotList[location][0] = dotList[location + 1][0];
                    dotList[location + 1][0] = tmp;

                    int tmp2 = dotList[location][1];
                    dotList[location][1] = dotList[location + 1][1];
                    dotList[location + 1][1] = tmp2;
                    swap = true;
                }
            }
            if (swap == false) break;
        }

        for(int index = 0; index < N - 1; index++){
            boolean swap = false;
            for (int color = 0; color < N - 1 - index; color++){
                if(dotList[color][1] > dotList[color + 1][1]){
                    int tmp = dotList[color][1];
                    dotList[color][1] = dotList[color + 1][1];
                    dotList[color + 1][1] = tmp;

                    int tmp2 = dotList[color][0];
                    dotList[color][0] = dotList[color + 1][0];
                    dotList[color + 1][0] = tmp2;

                    swap = true;
                }
            }
            if (swap == false) break;
        }
    }

    static void solve_15970(){
        int tmp = 0, before, after, ans = 0;
        for(int index = 1; index < N; index ++) {
            if(dotList[index][1] == dotList[index - 1][1] && dotList[index][1] == dotList[index + 1][1]) {
                before = dotList[index][0] - dotList[index - 1][0]; after = dotList[index + 1][0] - dotList[index][0];

                tmp = (before <= after)? before : after;

                ans += tmp;
            }
            if (dotList[index][1] == dotList[index - 1][1] && dotList[index][1] != dotList[index + 1][1]){
                ans += dotList[index][0] - dotList[index - 1][0];
            }
            if (dotList[index][1] != dotList[index - 1][1] && dotList[index][1] == dotList[index + 1][1]){
                ans += dotList[index + 1][0] - dotList[index][0];
            }
//            System.out.println(ans);
            tmp = 0;
        }
//        if(dotList[N -1][1] == dotList[N - 2][1]) ans += dotList[N -1][0] - dotList[N - 2][0];
        if(dotList[0][1] == dotList[1][1]) ans += dotList[1][0] - dotList[0][0];
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input_15970();
        solve_15970();
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
