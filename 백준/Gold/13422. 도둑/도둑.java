import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int N,M,K;
    static int[] moneys;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        T=Integer.parseInt(st.nextToken());
        while (T-->0){
            st=new StringTokenizer(br.readLine()," ");
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());
            ans=0;
            int total=0;
            moneys=new int[N+M-1];
            st=new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                int money=Integer.parseInt(st.nextToken());
                moneys[i]=money;
            }
            for(int j=0;j<M-1;j++){
                moneys[N+j]=moneys[j];
            }
            for(int i=0;i<M;i++){
                total+=moneys[i];
            }
            if(total<K) ans++;
            if(N==M){
                System.out.println(ans);
                continue;
            }
            for(int i=1;i<N;i++){
                total-=moneys[i-1];
                total+=moneys[i+M-1];
                if(total<K) ans++;
            }
            System.out.println(ans);
        }
    }
}