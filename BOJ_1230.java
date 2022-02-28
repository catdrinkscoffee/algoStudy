import java.io.*;
import java.util.*;

public class BOJ_1230 {
    static FastReader sacn = new FastReader();
    static StringBuilder ans = new StringBuilder();

    static int N, M, V;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static void input_1260(){
        N = sacn.nextInt();
        M = sacn.nextInt();
        V = sacn.nextInt();
        adj = new ArrayList[N + 1];
        for(int i = 0; i<= N; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i< M; i++){
            int x = sacn.nextInt(), y = sacn.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        for(int i = 1; i <= N; i++) Collections.sort(adj[i]);
    }

    static void dfs(int x){
        visit[x] = true;
        ans.append(x).append(' ');
        for(int y: adj[x]){
            if(visit[y]) continue;
            dfs(y);
        }
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visit[start] = true;

        while (!q.isEmpty()){
            int x = q.poll();
            ans.append(x).append(' ');
            for(int y: adj[x]){
                if(visit[y]) continue;
                q.add(y);
                visit[y] = true;
            }
        }
    }

    static void solve_1260(){
        visit = new boolean[N + 1];
        dfs(V);
        ans.append('\n');
        for(int i = 1; i<= N;i ++) visit[i] = false;
        bfs(V);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input_1260();
        solve_1260();
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
