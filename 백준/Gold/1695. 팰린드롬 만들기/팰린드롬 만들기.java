import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] seq, rev;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        seq = new int[N + 1];
        rev = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            rev[N - i + 1] = seq[i];
        }

        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int prev = 0; 
            for (int j = 1; j <= N; j++) {
                int temp = dp[j]; 
                if (seq[i] == rev[j]) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }

        int lps = dp[N];
        System.out.println(N - lps);
    }
}
