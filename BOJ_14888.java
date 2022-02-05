import java.io.*;
import java.util.*;

public class BOJ_14888 {
    public static void input_14888(){
        FastReader scan = new FastReader();
        numOfNum = scan.nextInt();
        numList = new int[numOfNum + 1];
        operatorInput = new int[5];

        for(int i = 1; i <= numOfNum; i++){
            numList[i] = scan.nextInt();
        }
        for(int i = 1; i <= 4; i++){
            operatorInput[i] = scan.nextInt();
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        copiedOperators = operatorInput.clone();
    }

    static int numOfNum, min, max, result;
    static int[] numList, copiedOperators, operatorInput;

    static void solve_14888(int operatorSet[], int result, int  k) {
        if(k == numOfNum + 1){
            // 결과값에 따라 최대, 최소값 갱신. result 초기화
            if(result < min) min = result;
            if(result > max) max = result;
//            for(int i = 1; i <= 4; i ++) System.out.println(copiedOperators[i]);
//            for(int i = 1; i <= 4; i ++) System.out.println(operatorList[i]);
//            System.out.println(operatorList);
        } else {
            int[] operatorList = operatorSet.clone();
            int resultValue = result;
            for(int operatorTurn = 1; operatorTurn <= 4; operatorTurn++) {
                if(operatorList[operatorTurn] == 0) continue;
                else {
                    operatorList[operatorTurn]--;
                    switch (operatorTurn){
                        case 1: resultValue = resultValue + numList[k]; break;
                        case 2: resultValue = resultValue - numList[k]; break;
                        case 3: resultValue = resultValue * numList[k]; break;
                        case 4: resultValue = resultValue / numList[k]; break;
                    }
                }
                solve_14888(operatorList, resultValue, k + 1);
                resultValue = result;
                operatorList = operatorSet.clone();
            }
        }
    }
    public static void main (String[] args){
        input_14888();
        result = numList[1];
        solve_14888(operatorInput, result, 2);

        // 최대값, 최솟값 출력
        System.out.println((int)max);
        System.out.println((int)min);
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
