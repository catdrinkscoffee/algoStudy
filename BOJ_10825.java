import java.io.*;
import java.util.*;

public class BOJ_10825 {
    static FastReader scan = new FastReader();
    static StringBuilder ansSet = new StringBuilder();

    static class Elem implements Comparable<Elem> {

        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Elem other) {
            if (korean != other.korean) return other.korean - korean;
            if (english != other.english) return english - other.english;
            if (math != other.math) return other.math - math;
            return name.compareTo(other.name);
        }
    }

    static int NFor10825;
    static Elem[] grade;

    static void input_10825() {
        NFor10825 = scan.nextInt();
        grade = new Elem[NFor10825];
        for (int i = 0; i < NFor10825; i++) {
            grade[i] = new Elem();
            grade[i].name = scan.next();
            grade[i].korean = scan.nextInt();
            grade[i].english = scan.nextInt();
            grade[i].math = scan.nextInt();
        }
    }

    static void solve_10825() {
        Arrays.sort(grade);
        for (int i = 0; i < NFor10825; i++) {
            ansSet.append(grade[i].name).append('\n');
        }
        System.out.println(ansSet.toString());
    }

    public static void main(String[] args) {
        input_10825();
        solve_10825();
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
