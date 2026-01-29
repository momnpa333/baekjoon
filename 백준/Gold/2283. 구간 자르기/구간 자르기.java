import java.io.*;
import java.util.*;

public class Main {
    static long[] line;
    static long[] sum;
    static int N,K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        line=new long[1000002];
        sum=new long[1000002];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            line[s+1]+=1;
            line[e+1]-=1;
        }
        for(int i=1;i<=1000001;i++){
            line[i]+=line[i-1];
        }
        for(int i=1;i<=1000001;i++){
            sum[i]=sum[i-1]+line[i-1];
        }
        int l=0; int r=0;
        while(l<=1000000 && r<=1000000){
            long v=calcLength(l,r);
            if(v==K){
                System.out.println(l+" "+r);
                return;
            }
            if(v<K){
                r++;
            }
            if(v>K){
                l++;
            }
        }
        System.out.println(0+" "+0);
    }
    static long calcLength(int s,int e){
        return sum[e+1]-sum[s+1];
    }
}

