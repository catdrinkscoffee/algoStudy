import java.io.*;
import java.util.*;

public class BOJ_2470 {
    static FastReader scan = new FastReader();
    static StringBuilder ansSet = new StringBuilder();
    static int N, concentration = Integer.MAX_VALUE;
    static int[] NList;

    static void input_2470(){
        N = scan.nextInt();
        NList = new int[N + 1];
        for(int i = 1; i <= N; i++) NList[i] = scan.nextInt();
        Arrays.sort(NList, 1, N + 1);
    }

    static void getAns(int key, int[] List, int left, int right){
        int st = List[left];
        int count = Math.abs(List[left] + key);

        while (left <= right){
            int mid = (left + right) / 2;
            if(Math.abs(List[mid] + key) < count){
                count = Math.abs(List[mid] + key);
                st = List[mid];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
//        System.out.print(key);
//        System.out.print(' ');
//        System.out.print(count);
//        System.out.print('\n');
        if(Math.abs(count) < Math.abs(concentration)){
            concentration = count;
            ansSet.delete(0, 2);
            ansSet.append(key).append(' ').append(st);
        }
    }

    static void solve_2470(){
        for(int i = 1; i <= N; i++){
            getAns(NList[i], NList, 1, N);
//            System.out.println(ansSet);
        }
        System.out.println(ansSet);
    }



    public static void main(String[] args) {
        input_2470();
        solve_2470();
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
