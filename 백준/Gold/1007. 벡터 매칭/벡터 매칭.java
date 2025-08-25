import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int N;
    static int[][] dots;
    static double answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T=Integer.parseInt(st.nextToken());
        while(T-->0){
            answer=Double.MAX_VALUE;
            st=new StringTokenizer(br.readLine()," ");
            N=Integer.parseInt(st.nextToken());
            dots=new int[N][2];
            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine()," ");
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                dots[i][0]=a;
                dots[i][1]=b;
            }
            combi(0,-1,new boolean[N]);
            System.out.println(answer);
        }

    }
    static void combi(int depth,int start,boolean[] op){
        int x=0;
        int y=0;
        if(depth==N/2){
            for(int i=0;i<N;i++){
                if(op[i]){
                    x+=dots[i][0];
                    y+=dots[i][1];
                }
                else{
                    x-=dots[i][0];
                    y-=dots[i][1];
                }
            }
            answer=Math.min(answer,Math.sqrt(Math.pow(x,2)+Math.pow(y,2)));
            return;
        }
        for(int i=start+1;i<N;i++){
            op[i]=true;
            combi(depth+1,i,op);
            op[i]=false;
        }
    }
}
