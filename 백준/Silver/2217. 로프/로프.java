import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Integer[] ropes;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        ropes=new Integer[N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            ropes[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ropes,(x1,x2)->{
            return x2-x1;
        });
//        System.out.println(Arrays.toString(ropes));

        for(int i=0;i<N;i++){
            answer=Math.max(answer,ropes[i]*(i+1));
        }
        System.out.println(answer);


    }
}
