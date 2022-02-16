import java.io.*;
import java.util.*;

public class BOJ_1181 {

    static ArrayList<String> wordList = new ArrayList<String>();
    static FastReader scan = new FastReader();
    static int N;

    static void input_1181(){
        N = scan.nextInt();
        String word;
        for(int i = 0; i < N; i++) {
            word = scan.nextLine();
            if(wordList.contains(word)) continue;
            else {
                wordList.add(word);
            }
        }
        Collections.sort(wordList);

    }

    public static int getLengthOfWord(String word){
        return word.length();
    }

    static void solve_1181(){
        for(int i = 0; i < wordList.size() - 1; i++){
            boolean swap = false;
            for(int j = 0; j < wordList.size() - i - 1; j++){
                if(getLengthOfWord(wordList.get(j)) > getLengthOfWord(wordList.get(j + 1))){
                    Collections.swap(wordList, j, j + 1);
                    swap = true;
                }
            }
            if(swap == false) break;
        }
        for(int i = 0; i < wordList.size(); i++) {
//            System.out.println(getLengthOfWord(wordList.get(i)));
            System.out.println(wordList.get(i));
        }
    }

    public static void main(String[] args) {
        input_1181();
        solve_1181();
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
