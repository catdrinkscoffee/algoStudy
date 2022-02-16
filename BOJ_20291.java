import java.io.*;
import java.util.*;

public class BOJ_20291 {
    static FastReader scan = new FastReader();
    static StringBuilder ansSet = new StringBuilder();
    static int N;

    static ArrayList<obj> words = new ArrayList<obj>();

    static public class obj implements Comparable<obj>{
        String extension, count;
        public obj(String e){
            this.extension = e;
            this.count = "1";
        }
        public String getExtension(){
            return this.extension;
        }
        public String getCount(){
            return this.count;
        }
        public void countUp(){
            this.count = Integer.toString(Integer.parseInt(this.count) + 1);
        }

        @Override
        public int compareTo(obj other){
            return this.getExtension().compareTo(other.getExtension());
        }
    }
    static void input_20291(){
        N = scan.nextInt();
        String fileName;
        for(int i = 0; i < N; i++){
            fileName = scan.nextLine().split("[.]")[1];
            boolean contains = false;

            if(i == 0) {
                words.add(new obj(fileName));
                continue;
            } else {
                for(int j = 0; j < words.size(); j++){
                    if(words.get(j).getExtension().contains(fileName) == true){
                        words.get(j).countUp();
                        contains = true;
                        break;
                    }
                }
            }
            if(contains == false) words.add(new obj(fileName));
        }

    }

    static void solve_20291(){
        Collections.sort(words);

        for(int i = 0; i < words.size(); i++) {
            ansSet.append(words.get(i).getExtension()).append(' ').append(words.get(i).getCount());
            System.out.println(ansSet);
            ansSet.delete(0, 100);
        }
    }

    public static void main(String[] args) {
        input_20291();
        solve_20291();
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
