import java.io.*;
import java.util.*;

public class BOJ_11725 {
    static FastReader scan = new FastReader();
    static StringBuilder ans = new StringBuilder();

    static int n;
    static ArrayList<Integer>[] adj;
    static int[] parent;

    static void input(){
        n = scan.nextInt();
        adj = new ArrayList[n + 1];
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for(int i = 1; i < n; i++){
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }
    static void dfs(int x, int par){
        for(int y: adj[x]){
            if(y == par) continue;
            parent[y] = x;
            dfs(y, x);
        }
    }

    static void solve(){
        dfs(1, -1);
        for(int i = 2; i <=n;i++) ans.append(parent[i]).append('\n');
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        solve();
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
