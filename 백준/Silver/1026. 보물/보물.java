import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N;
    static int[] A;
    static Integer[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        A=new int[N];
        B=new Integer[N];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            B[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B,Collections.reverseOrder());

        int answer=0;

        for(int i=0;i<N;i++){
            answer+=A[i]*B[i];
        }
        System.out.println(answer);


    }


}
