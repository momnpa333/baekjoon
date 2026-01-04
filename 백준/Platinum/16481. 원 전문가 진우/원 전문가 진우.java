import java.io.*;
import java.util.*;

public class Main {
    static int R1,R2,R3;
    static float ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        R1=Integer.parseInt(st.nextToken());
        R2=Integer.parseInt(st.nextToken());
        R3=Integer.parseInt(st.nextToken());

        ans= (float) 1 /R1+ (float) 1 /R2+ (float) 1 /R3;
        ans=1/ans;
        System.out.println(ans);

    }
}


