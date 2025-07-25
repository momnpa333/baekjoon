import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1030 {
    static long s, N, K, R1, R2, C1, C2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s=Long.parseLong(st.nextToken()); N=Long.parseLong(st.nextToken()); K=Long.parseLong(st.nextToken());
        R1=Long.parseLong(st.nextToken()); R2=Long.parseLong(st.nextToken()); C1=Long.parseLong(st.nextToken()); C2=Long.parseLong(st.nextToken());

        for(long i=R1;i<=R2;i++){
            for(long j=C1;j<=C2;j++){
                bw.write(square(s,i,j)+"");
            }
            if(i!=R2)
                bw.write("\n");
        }
        bw.flush();
    }

    static int square(long stage,long r,long c){
        if(stage==0){
            return 0;
        }
        long div = 1;
        for (int i = 0; i < stage - 1; i++) {
            div *= N;
        }
        long curR=r/div;
        long curC=c/div;


        long first=(N-K)/2;
        long last=first+(K-1);

        if(curR>=first && curR<=last && curC>=first && curC<=last){
            return 1;
        }
        else{
            return square(stage-1,r%div,c%div);
        }
    }


}
