import java.io.*;
import java.util.*;

public class BOJ_14502 {
    static FastReader scan = new FastReader();

    static int N, M, safezone_size;
    static boolean[][] visit;
    static StringBuilder[] a;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static class point{
        int x;
        int y;
    }

    static void input_14502(){
        N = scan.nextInt();
        M = scan.nextInt();
        a = new StringBuilder[N];
        for(int i = 0; i < N; i++) a[i] = new StringBuilder(scan.nextLine());
        visit = new boolean[N][M];
    }
    static int cal_size(int c, int b, int w1, int w2, int w3, point[] P, point[] B){
        StringBuilder ac[] = a;
        System.out.print("P[w1].x : ");
        System.out.print(P[w1].x);
        System.out.print("P[w1].y : ");
        System.out.print(P[w1].y);
        System.out.println();

        System.out.print("P[w2].x : ");
        System.out.print(P[w2].x);
        System.out.print("P[w2].y : ");
        System.out.print(P[w2].y);
        System.out.println();

        System.out.print("P[w3].x : ");
        System.out.print(P[w3].x);
        System.out.print("P[w3].y : ");
        System.out.print(P[w3].y);
        System.out.println();
        System.out.println();
//        ac[P[w1].x].setCharAt(2*P[w1].y, '1');
//        ac[P[w2].x].setCharAt(2*P[w2].y, '1');
//        ac[P[w3].x].setCharAt(2*P[w3].y, '1');
//        for(int i = 0; i < B.length; i++){
//
//        }


//        System.out.println();
        return 1;
    }
    static void printAll(){
        StringBuilder ac[] = a;
        for(int x = 0; x < N; x++){
            for(int y = 0; y < M; y++){
                System.out.print(ac[x].charAt(2*y));
            }
            System.out.println();
        }
    }
    static void solve_14502(){
        point P[] = new point[N * M];
        point B[] = new point[N * M];
        for(int i = 0; i < P.length; i++) P[i] = new point();
        for(int i = 0; i < P.length; i++) B[i] = new point();
        int c = 0, b = 0, best_size = 0;
        for(int x = 0; x < N; x++){
            for(int y = 0; y < M; y++){
                if(a[x].charAt(y * 2) == '0') {
                    P[c].x = y; P[c].y = x;
                    c++;
                }
                if(a[x].charAt(y * 2) == '2') {
                    B[b].x = y; B[b].y = x;
                    b++;
                }
            }
        }
        for(int w1 = 0; w1 < c; w1++){
            for(int w2 = 0; w2 < c; w2++){
                if(w1 == w2) continue;
                for(int w3 = 0; w3 < c; w3++){
                    if(w1 == w3 || w2 == w3) continue;
                    int cand_size = cal_size(c, b, w1, w2, w3, P, B);
//                    if(best_size < cand_size) best_size = cand_size;
                }
            }
        }
//        System.out.println(best_size);
    }

    public static void main(String[] args) {
        input_14502();
        solve_14502();
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
