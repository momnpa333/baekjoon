import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Long> plusPQ=new PriorityQueue<>();
        PriorityQueue<Long> minusPQ=new PriorityQueue<>(Collections.reverseOrder());

        long T=Long.parseLong(st.nextToken());

        while(T-->0) {
            st=new StringTokenizer(br.readLine());
            long tmp = Long.parseLong(st.nextToken());
            if (tmp > 0) {
                plusPQ.add(tmp);
            } else if (tmp < 0) {
                minusPQ.add(tmp);
            } else {
                long plus = !plusPQ.isEmpty() ? plusPQ.peek() : 0;
                long minus = !minusPQ.isEmpty() ? minusPQ.peek() : 0;
                if (plus == 0 && minus == 0) {
                    bw.write(0 + "\n");
                } else if (plus == 0) {
                    bw.write(minus + "\n");
                    minusPQ.poll();
                } else if (minus == 0) {
                    bw.write(plus + "\n");
                    plusPQ.poll();
                } else {
                    if (Math.abs(minus) <= Math.abs(plus)) {
                        bw.write(minus + "\n");
                        minusPQ.poll();
                    } else {
                        bw.write(plus + "\n");
                        plusPQ.poll();
                    }
                }
            }
        }
        bw.flush();

    }

}
