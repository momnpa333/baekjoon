import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String ans="";
        N=Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        for(int i=1;i<=N;i++){
            dq.add(i);
        }

        while(!dq.isEmpty()){
            int item=dq.poll();
            ans+=item+" ";
            if(dq.isEmpty()) break;
            int back=dq.poll();
            dq.add(back);
        }
        System.out.println(ans);

    }
}
