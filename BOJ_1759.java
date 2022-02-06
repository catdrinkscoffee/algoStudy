import java.io.*;
import java.util.*;

public class BOJ_1759 {
    static StringBuilder ansSet = new StringBuilder();

    static void input_1759(){
        FastReader scan = new FastReader();
        CFor1759 = scan.nextInt();
        LFor1759 = scan.nextInt();

        alphabetSet = new char[LFor1759 + 1];
        selected = new int[LFor1759 + 1];

        String[] tokens = scan.nextLine().split(" ");
        for(int i = 1; i <= LFor1759; i ++) alphabetSet[i] = tokens[i - 1].charAt(0);
        Arrays.sort(alphabetSet);

        vowels = 0; consonants = 0;
    }

    static int CFor1759, LFor1759, consonants, vowels;
    static char[] alphabetSet;
    static int[] selected;

    static void solve_1759(int k, int count, int selectedSet[]){
        if(k == LFor1759 + 1 || count == CFor1759){
            if(count == CFor1759) {
                for(int i = 1; i <= LFor1759; i++){
                    if(selectedSet[i] == 1) ansSet.append(alphabetSet[i]);
                }
                for (int i = 0; i < ansSet.length(); i++) {
                    switch (ansSet.charAt(i)) {
                        case 'a': vowels++;
                        case 'e': vowels++;
                        case 'i': vowels++;
                        case 'o': vowels++;
                        case 'u': vowels++;
                            break;
                        default:
                            consonants++;
                            break;
                    }
                }
                if(vowels >= 1 && consonants >= 2) {
                    System.out.println(ansSet.toString());
                }

                vowels = 0; consonants = 0;
                ansSet.delete(0, CFor1759);
            }
        } else {
            int[] currSelected = selectedSet.clone();
            currSelected[k] = 1;
            solve_1759(k + 1, count + 1, currSelected);

            currSelected[k] = 0;
            solve_1759(k + 1, count, currSelected);
        }
    }

    public static void main(String[] args) {
        input_1759();
        solve_1759(1, 0, selected);
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
