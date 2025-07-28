import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _28293 {
    static double A,B;
    static double answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        A=Double.parseDouble(st.nextToken()); B=Double.parseDouble(st.nextToken());

        answer=B*Math.log10(A);
        System.out.println((long)Math.floor(answer)+1);
    }

}
