// 2월 23일

import java.io.*;
import java.util.*;

public class BOJ_16472 {
    static FastReader scan = new FastReader();
    static int N;
    static int[] checkChar;
    static String charSet;
    static void input_16472(){
        N = scan.nextInt();
        charSet = scan.nextLine();
        checkChar = new int[26];
    }

    static void solve_16472(){
        int Len = 0, cnt = 0;
        for(int L = 0, R = 0; R < charSet.length(); R++){
            checkChar[charSet.charAt(R) - 'a']++;
            if(checkChar[charSet.charAt(R) - 'a'] == 1) cnt++;

            while (cnt > N){
                checkChar[charSet.charAt(L) - 'a']--;
                if(checkChar[charSet.charAt(L) - 'a'] == 0) cnt--;
                L++;
            }
            if(Len < R - L + 1) {
                Len = R - L + 1;
            }
        }
        System.out.println(Len);
    }

    public static void main(String[] args) {
        input_16472();
        solve_16472();
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
