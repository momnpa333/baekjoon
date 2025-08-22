import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] seq;
    static long[] preSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());
        preSum = new long[N + 1];
        seq = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            preSum[i + 1] = preSum[i] + seq[i];
        }

        long S = preSum[N];
        if (S % 4 != 0) {
            System.out.println(0);
            return;
        }

        long q = S / 4;       // S/4
        long h = S / 2;       // S/2
        long tq = 3 * q;      // 3S/4

        long cnt3 = 0;  // prefix == 3S/4 (k 후보 수)
        long cnt2 = 0;  // prefix == S/2 에서 만들 수 있는 (j,k) 쌍 수
        long ans  = 0;  // 정답

        // 마지막 구간이 비면 안 되므로 1..N-1만 사용
        for (int i = N - 1; i >= 1; i--) {
            // 순서 중요: ans -> cnt2 -> cnt3
            if (preSum[i] == q)  ans  += cnt2; // i는 j,k보다 앞서야 함
            if (preSum[i] == h)  cnt2 += cnt3; // j는 k보다 앞서야 함
            if (preSum[i] == tq) cnt3++;       // k 후보 추가
        }

        System.out.println(ans);
    }
}
