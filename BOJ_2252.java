import java.io.*;
import java.util.*;

public class BOJ_2252 {
    static BOJ_1061.FastReader scan = new BOJ_1061.FastReader();

    static int n, root, erased;
    static ArrayList<Integer>[] child;
    static int[] leaf;

    static void input(){
        n = scan.nextInt();
        child = new ArrayList[n];
        leaf = new int[n];
        for(int i = 0; i < n; i++) child[i] = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int par = scan.nextInt();
            if(par == -1){
                root = i;
                continue;
            }
            child[par].add(i);
        }
        erased = scan.nextInt();
    }

    static void dfs(int x){
        if(child[x].isEmpty()){
            leaf[x] = 1;
        }
        for(int y: child[x]){
            dfs(y);
            leaf[x] += leaf[y];
        }
    }

    static void solve(){
        for(int i = 0; i < n; i++){
            if(child[i].contains(erased)){
                child[i].remove(child[i].indexOf(erased));
            }
        }
        if(root != erased) dfs(root);
        System.out.println(leaf[root]);
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